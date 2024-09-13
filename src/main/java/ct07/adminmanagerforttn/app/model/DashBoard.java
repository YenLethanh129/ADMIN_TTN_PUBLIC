package ct07.adminmanagerforttn.app.model;

/**
 *
* @author CT07N0161 VoThiBichTuyen CT07N0162 LeThanhYen
 */

public class DashBoard {

    public DashBoard(long room_id, long author_id, String upload_time, String title, StatusType status) {
        this.room_id = room_id;
        this.author_id = author_id;
        this.upload_time = upload_time;
        this.title = title;
        this.status = status;
    }
    
    public DashBoard(){
    }

    public long getRoomId() {
        return room_id;
    }

    public void setRoomId(long room_id) {
        this.room_id = room_id;
    }

    public long getAuthorId() {
        return author_id;
    }

    public void setAuthorId(long author_id) {
        this.author_id = author_id;
    }

    public String getUploadTime() {
        return upload_time;
    }

    public void setUploadTime(String upload_time) {
        this.upload_time = upload_time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }
    
    private long room_id;
    private long author_id;
    private String upload_time;
    private String title;
    private StatusType status;

    @Override
    public String toString() {
        return "DashBoard{" +
                "room_id=" + room_id +
                ", author_id=" + author_id +
                ", update_time=" + upload_time +
                ", title='" + title + '\'' +
                ", status=" + status +
                '}';
    }
}
