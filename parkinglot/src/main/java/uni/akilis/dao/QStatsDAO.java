package uni.akilis.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Leo
 *
 */
public interface QStatsDAO {

    /**
     * 
     * @param tableName
     * @return Records in Json format.
     */
    List<Map<String,Object>> getTableRecords(String tableName);
    
    /**
     * 
     * @param tableName
     * @return fields and Records in Json format.
     */
    String getTable(String tableName);
    
    /**
     * Find the categories of the column.
     * @param tableName
     * @param colName
     * @return
     */
    String getColumnCategories(String tableName, String colName);

    /**
     * 
     * @param reqParams Json string.
     * @return Records in Json format.
     */
    String getTableRecordsServerSide(String reqParams);

    /**
     * Do some statistics on a table.
     * @param tableName
     * @param colName X axis
     * @param metric Y axis (Count/avg/std/sum)
     * @param groupBy Whether it can apply group by clause.
     * @param timeCol Column for time span.
     * @param period Not null iff. timeCol is not null.
     * @return Json string with {"xAxis":[], "series":[]}
     */
    String doStats(String tableName, String colName, String metric, boolean groupBy, String timeCol, String period);
    
}
