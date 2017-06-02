package parkinglot;

import static org.jooq.impl.DSL.using;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import uni.akilis.helper.LoggerX;
import uni.akilis.jooq.generated.Pldb;
import static uni.akilis.jooq.generated.Tables.*;

public class JOOQFuncTest {
    String userName = "root";
    String password = "14641";
    String url = "jdbc:mysql://localhost:3306/pldb";

    DSLContext create;
    Connection conn;
    @Before
    public void setUp() throws Exception{
        try {
            conn = DriverManager.getConnection(url, userName, password);
            create = using(conn, SQLDialect.MYSQL);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @After
    public void tearDown() throws Exception{
        //create.close();
    }
//    @Ignore
    @Test
    public void testMetadata(){
        LoggerX.println("Tables:");
        for (Table<?> table : Pldb.PLDB.getTables()) {
            LoggerX.println("Name: " + table.getName());
            if ("pldealrecord".equalsIgnoreCase(table.getName())) {
                LoggerX.println("Fileds:");
                for (Field<?> field : table.fields()) {
                    LoggerX.println("Name: " + field.getName() + ", type: " + field.getDataType().getTypeName());
                }
                LoggerX.println();               
            }
 
        }
        assertTrue(Pldb.PLDB.getTables().size() > 0);
    }
    @Test
    public void testGetTableRecords(){
        Result<Record> result = create.select().from(PLDEALRECORD).fetch();
        LoggerX.println("size: " + result.size());
        String jsonTable = result.formatJSON();
        LoggerX.println("records: \n" + jsonTable);
    }
}
