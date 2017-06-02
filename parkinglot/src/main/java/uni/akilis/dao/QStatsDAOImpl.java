package uni.akilis.dao;

import static org.jooq.impl.DSL.using;

import static uni.akilis.jooq.generated.Tables.*;
import static org.jooq.impl.DSL.*;

import java.sql.*;
import java.util.List;
import java.util.Map;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;

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

}
