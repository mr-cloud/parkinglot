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
    
}
