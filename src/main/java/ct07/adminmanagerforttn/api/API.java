package ct07.adminmanagerforttn.api;

/**
 *
* @author CT07N0161 VoThiBichTuyen CT07N0162 LeThanhYen
 */
import ct07.adminmanagerforttn.app.model.DashBoardResponse;
import ct07.adminmanagerforttn.app.model.Room;
import ct07.adminmanagerforttn.app.model.RoomResponse;
import ct07.adminmanagerforttn.app.model.User;
import ct07.adminmanagerforttn.app.model.UserResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface API {

    // Room
    @GET("admin/dashboard")
    Call<DashBoardResponse> getDashBoard(

    );
    
    @GET("admin/roomPending")
    Call<RoomResponse> getRoomPending();
    
    @GET("admin/room")
    Call<RoomResponse> getRoom();
    
    @GET("admin/user")
    Call<UserResponse> getUser();
//
//    @FormUrlEncoded
//    @POST("rooms/add")
//    Call<AddResponse> addRoom(
//        @Field("title") String title,
//        @Field("author") int author,
//        @Field("address_id") int address_id,
//        @Field("description") String description,
//        @Field("area") int area,
//        @Field("price") int price,
//        @Field("interior") boolean interior,
//        @Field("deposits") int deposits
//    );
    
    @FormUrlEncoded
    @POST("rooms/update")
    Call<String> updateRoom(
        @Field("id") int id,
        @Field("title") String title,
        @Field("description") String description,
        @Field("area") int area,
        @Field("price") int price,
        @Field("interior") int interior,
        @Field("deposits") int deposits,
        @Field("status") String status
    );
    
    @FormUrlEncoded
    @POST("users/update")
    Call<String> updateUser(
        @Field("id") int id,
        @Field("username") String username,
        @Field("password") String password,
        @Field("phone_number") String phone_number,
        @Field("status") String status
    );
    
    @FormUrlEncoded
    @POST("admin/login")
    Call<UserResponse> login(
        @Field("username") String username,
        @Field("password") String password
    );
}

