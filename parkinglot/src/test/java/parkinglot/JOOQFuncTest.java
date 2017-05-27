package parkinglot;

import static org.jooq.impl.DSL.using;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import uni.akilis.helper.LoggerX;
import uni.akilis.jooq.generated.Pldb;

public class JOOQFuncTest {
    String userName = "root";
    String password = "14641";
    String url = "jdbc:mysql://localhost:3306/pldb";

    DSLContext create;
    
    @Before
    public void setUp() throws Exception{
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            create = using(conn, SQLDialect.MYSQL);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @After
    public void tearDown() throws Exception{
        create.close();
    }
    //@Ignore
    @Test
    public void testMetadata(){
        LoggerX.println("Tables:");
        for (Table<?> table : Pldb.PLDB.getTables()) {
            LoggerX.println("Name: " + table.getName());
            LoggerX.println("Fileds:");
            for (Field<?> field : table.fields()) {
                LoggerX.println("Name: " + field.getName() + ", type: " + field.getDataType().getTypeName());
            }
            LoggerX.println();
        }
        assertTrue(Pldb.PLDB.getTables().size() > 0);
    }
}
