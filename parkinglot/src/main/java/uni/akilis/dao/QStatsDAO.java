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
    
}
