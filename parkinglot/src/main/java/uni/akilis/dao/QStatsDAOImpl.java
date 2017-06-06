package uni.akilis.dao;

import static org.jooq.impl.DSL.*;

import static uni.akilis.jooq.generated.Tables.*;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jooq.Comparator;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Operator;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.SelectQuery;
import org.jooq.impl.DSL;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import uni.akilis.helper.LoggerX;

public class QStatsDAOImpl implements QStatsDAO{
    String userName = "root";
    String password = "14641";
    String url = "jdbc:mysql://localhost:3306/pldb";

    DSLContext create;
    Connection conn;


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

}
