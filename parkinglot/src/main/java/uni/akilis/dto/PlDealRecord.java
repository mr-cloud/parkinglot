package uni.akilis.dto;


/**
 * 处理记录值对象
 * @author Nathon
 *
 */
public class PlDealRecord {
    private int id;             //记录号
    private String time;        //处理时间
    private String type;        //处理类型
    private String description; //处理描述
    private String opName;      //操作员姓名
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getOpName() {
        return opName;
    }
    public void setOpName(String opName) {
        this.opName = opName;
    }
}
