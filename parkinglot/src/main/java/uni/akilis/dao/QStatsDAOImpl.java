package uni.akilis.dao;

import static org.jooq.impl.DSL.*;

import static uni.akilis.jooq.generated.Tables.*;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jooq.Comparator;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Operator;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.SelectQuery;
import org.jooq.impl.DSL;
import org.jooq.util.mysql.MySQLDataType;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import uni.akilis.helper.LoggerX;
/**
 *
 * @author Leo
 *
 */
public class QStatsDAOImpl implements QStatsDAO{
    String userName = "root";
    String password = "14641";
    String url = "jdbc:mysql://localhost:3306/pldb";

    DSLContext create;
    Connection conn;

    public static final String TAG = QStatsDAOImpl.class.getName(); 
    public QStatsDAOImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, userName, password);
            create = using(conn, SQLDialect.MYSQL);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Map<String,Object>> getTableRecords(String tableName) {
        LoggerX.println("Get table: " + tableName);
        return this.create.select().from(table(tableName)).fetch().intoMaps();
    }


    @Override
    public String getTable(String tableName) {
        LoggerX.println("Get table: " + tableName);        
        return this.create.select().from(table(tableName)).fetch().formatJSON();
    }


    @Override
    public String getColumnCategories(String tableName, String colName) {
        return this.create.selectDistinct(field(colName)).from(table(tableName))
            .where(field(colName).isNotNull())
            .fetch()
            .formatJSON();
    }


    @Override
    public String getTableRecordsServerSide(String reqParams) {
        JsonObject req = new JsonParser().parse(reqParams).getAsJsonObject();
        String tableName = req.get("tableName").getAsString();
        boolean confirmDownloadTag = req.get("confirmDownloadTag").getAsBoolean();
        int start = req.get("start").getAsInt();
        int length = req.get("length").getAsInt();
        int draw = req.get("draw").getAsInt();
        JsonObject rst = new JsonObject();
        rst.addProperty("draw", draw);

        SelectQuery<Record> selectQuery = create.selectQuery(table(tableName));
        rst.addProperty("recordsTotal", this.create.fetchCount(selectQuery));

        Condition condi;
        for (Entry<String, JsonElement> cond: req.get("conditions").getAsJsonObject().entrySet()) {
            String colName = cond.getKey();
            if (colName.startsWith("iTime")) {
                colName = "iTime";
            }
            else if (cond.getKey().startsWith("oTime")) {
                colName = "oTime";
            }
            else if (cond.getKey().startsWith("time")) {
                colName = "time";
            }
            else
                ;
            JsonArray expr = cond.getValue().getAsJsonArray();
            if ("".equals(expr.get(2).getAsString())) {
                continue;
            }
            Object val = null;
            if ("spaceId".equalsIgnoreCase(colName)
                    || "status".equalsIgnoreCase(colName)
                    || "step".equalsIgnoreCase(colName)) {
                val = expr.get(2).getAsInt();
            }
            else{
                val = expr.get(2).getAsString();
            }
            String op = expr.get(1).getAsString();
            if ("LIKE".equalsIgnoreCase(op)) {
                val = "%" + val + "%";
            }
            condi=DSL.field(colName).compare(Comparator.valueOf(op),val);                
            selectQuery.addConditions(Operator.valueOf(expr.get(0).getAsString()),condi);
        }
        rst.addProperty("recordsFiltered", this.create.fetchCount(selectQuery));
        JsonObject jsonTable;
        if (!confirmDownloadTag) {
            selectQuery.addLimit(start, length);
        }
        jsonTable = new JsonParser().parse(selectQuery.fetch().formatJSON()).getAsJsonObject();
        rst.add("data", jsonTable.get("records").getAsJsonArray());
        return rst.toString();
    }


    @Override
    public String doStats(String tableName, String colName, String metric, boolean groupBy, String timeCol,
            String period) {
        JsonObject rst = new JsonObject();
        // From clause.
        SelectQuery<Record> selectQuery = create.selectQuery(table(tableName));
        // Where clause.
        if (timeCol != null && !timeCol.isEmpty()) {
            Condition condi;
            if ("daily".equalsIgnoreCase(period)) {
                condi = DSL.field(timeCol).between(DSL.currentDate().sub(1),
                        DSL.currentDate());
            }
            else if ("weekly".equalsIgnoreCase(period)) {
                condi = DSL.field(timeCol).between(DSL.currentDate().sub(7),
                        DSL.currentDate());
            }
            else if ("monthly".equalsIgnoreCase(period)) {
                condi = DSL.field(timeCol).between(DSL.currentDate().sub(30),
                        DSL.currentDate());
            }
            else {
                LoggerX.println(TAG, "Report on daily as priod is null.");
                condi = DSL.field(timeCol).between(DSL.currentDate().sub(1),
                        DSL.currentDate());
            }
            selectQuery.addConditions(Operator.AND, condi);
        }
        // Group by clause.
        if (groupBy) {
            selectQuery.addGroupBy(field(colName));
            selectQuery.addSelect(field(colName).as("xAxis"));
        }
        // Select clause.
        if ("count".equalsIgnoreCase(metric)) {
            selectQuery.addSelect(count().as("series"));
        }
        else if ("avg".equalsIgnoreCase(metric)){
            selectQuery.addSelect(avg(field(colName).cast(MySQLDataType.DOUBLE)).as("series"));
        }
        else if ("var".equalsIgnoreCase(metric)){
            selectQuery.addSelect(varPop(field(colName).cast(MySQLDataType.DOUBLE)).as("series"));
        }
        else if ("sum".equalsIgnoreCase(metric)) {
            selectQuery.addSelect(sum(field(colName).cast(MySQLDataType.DOUBLE)).as("series"));
        }
        else {
            LoggerX.println(TAG, "Unsupported metric: " + metric + ", use count function!");
            selectQuery.addSelect(count().as("series"));            
        }
        LoggerX.println(TAG, "SQL: " + selectQuery.getSQL());
        selectQuery.addSelect(field(colName));
        
        // Execute sql.
        JsonArray xAxis = new JsonArray();
        JsonArray series = new JsonArray();
        Result<Record> records = selectQuery.fetch();
        LoggerX.println(TAG, "Recodrs:\n" + records.formatJSON());
        for (Record r: records) {
            if (groupBy) {
                xAxis.add(new JsonPrimitive(r.get("xAxis") == null? "null": r.get("xAxis").toString()));                
            }
            series.add(new JsonPrimitive(Double.parseDouble(r.get("series").toString())));
        }
        if (!groupBy) {
            xAxis.add(new JsonPrimitive(colName));
        }
        rst.add("xAxis", xAxis);
        rst.add("series", series);
        LoggerX.println(TAG, "Stats result:\n" + rst.toString());
        return rst.toString();
    }

}
