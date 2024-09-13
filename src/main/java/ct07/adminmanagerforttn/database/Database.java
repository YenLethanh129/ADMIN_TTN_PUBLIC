package ct07.adminmanagerforttn.database;

/**
 *
* @author CT07N0161 VoThiBichTuyen CT07N0162 LeThanhYen
 */
public class Database {
    
    private String sql;
    
    public String getDashBoard() {
        sql = "SELECT ROOMS.id as room_id, author as author_id, ROOMS.status, title, upload_time FROM ROOMS ORDER BY upload_time DESC";
        return sql;
    }
}
