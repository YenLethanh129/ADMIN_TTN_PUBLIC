package ct07.adminmanagerforttn.repository;

import ct07.adminmanagerforttn.api.RetrofitInstance;
import ct07.adminmanagerforttn.app.model.DashBoardResponse;
import ct07.adminmanagerforttn.app.model.Room;
import ct07.adminmanagerforttn.app.model.RoomResponse;
import ct07.adminmanagerforttn.app.model.User;
import ct07.adminmanagerforttn.app.model.UserResponse;
import retrofit2.Call;

/**
 *
* @author CT07N0161 VoThiBichTuyen CT07N0162 LeThanhYen
 */
public class Repository {

    /**
     * Get the dashboard data
     * @return 
     */
    public Call<DashBoardResponse> getDashBoard(){
        return RetrofitInstance.getApi().getDashBoard();
    }
    
    public Call<RoomResponse> getRoomPending() {
        return RetrofitInstance.getApi().getRoomPending();
    }
    
    public Call<RoomResponse> getRoom() {
        return RetrofitInstance.getApi().getRoom();
    }
    
    public Call<UserResponse> getUser() {
        return RetrofitInstance.getApi().getUser();
    }
    
    public Call<String> updateRoom(Room room) {
        return RetrofitInstance.getApi().updateRoom(room.getId(), room.getTitle(), room.getDescription(), room.getArea(), room.getPrice(), room.getInterior(), room.getDeposits(), room.getStatus().toString());
    }
    
    public Call<String> updateUser(User user) {
        return RetrofitInstance.getApi().updateUser(user.getId(), user.getUsername(), user.getPassword(), user.getPhoneNumber(), user.getStatus().toString());
    }
    
    public Call<UserResponse> login(String username, String password) {
        return RetrofitInstance.getApi().login(username, password);
    }
}
