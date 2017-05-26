package uni.akilis.app;

//For convenience, always static import your generated tables and jOOQ functions to decrease verbosity:
import static uni.akilis.jooq.generated.Tables.*;
import static org.jooq.impl.DSL.*;

import java.sql.*;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;

public class Main {
 public static void main(String[] args) {
     String userName = "root";
     String password = "14641";
     String url = "jdbc:mysql://localhost:3306/pldb";

     // Connection is the only JDBC resource that we need
     // PreparedStatement and ResultSet are handled by jOOQ, internally
     try (Connection conn = DriverManager.getConnection(url, userName, password)) {
         DSLContext create = using(conn, SQLDialect.MYSQL);
         Result<Record> result = create.select().from(AUTHOR).fetch();
         System.out.println("Before inserted:");
         for (Record r : result) {
             Integer id = r.getValue(AUTHOR.ID);
             String firstName = r.getValue(AUTHOR.FIRST_NAME);
             String lastName = r.getValue(AUTHOR.LAST_NAME);

             System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName);
         }
         int rst = create.insertInto(table(AUTHOR.getName()), field(AUTHOR.ID), field(AUTHOR.FIRST_NAME), field(AUTHOR.LAST_NAME))
                 .values(result.size()+1, "50Man", "Zhang")
                 .execute();
         if (rst != 1) {
             System.out.println("Inserted failed!");
         }
         result = create.select().from(AUTHOR).fetch();
         System.out.println("After inserted:");
         for (Record r : result) {
             Integer id = r.getValue(AUTHOR.ID);
             String firstName = r.getValue(AUTHOR.FIRST_NAME);
             String lastName = r.getValue(AUTHOR.LAST_NAME);

             System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName);
         }
     } 

     // For the sake of this tutorial, let's keep exception handling simple
     catch (Exception e) {
         e.printStackTrace();
     }
 }
}