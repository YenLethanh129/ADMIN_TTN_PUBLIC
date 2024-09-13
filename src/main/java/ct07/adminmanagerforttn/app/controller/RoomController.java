package ct07.adminmanagerforttn.app.controller;

import ct07.adminmanagerforttn.app.Main;
import ct07.adminmanagerforttn.app.model.DashBoardResponse;
import ct07.adminmanagerforttn.app.model.Room;
import ct07.adminmanagerforttn.app.model.RoomResponse;
import ct07.adminmanagerforttn.app.view.form.RoomDetailForm;
import ct07.adminmanagerforttn.app.view.form.RoomForm;
import ct07.adminmanagerforttn.repository.Repository;
import java.util.concurrent.CountDownLatch;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
* @author CT07N0161 VoThiBichTuyen CT07N0162 LeThanhYen
 */
public class RoomController {
    
    private final Repository repository;
    private final Main main;
    
    public RoomResponse roomResponse = null;

    public RoomController() {
        this.repository = new Repository();
        this.main = Main.getInstance();
    }
    
    public void getRoomPending(CountDownLatch latch) {
        Call<RoomResponse> call = this.repository.getRoomPending();

        call.enqueue(new Callback<RoomResponse>() {
            @Override
            public void onResponse(Call<RoomResponse> call, Response<RoomResponse> response) {
                if (response.isSuccessful()) {
                    roomResponse = response.body();
               }
                latch.countDown();
            }

            @Override
            public void onFailure(Call<RoomResponse> call, Throwable t) {
                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, "Lỗi kết nối Internet. Vui lòng kiểm tra lại.", "Lỗi", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
                latch.countDown();
            }
        });
    }
    
    public void getRoom(CountDownLatch latch) {
        Call<RoomResponse> call = this.repository.getRoom();

        call.enqueue(new Callback<RoomResponse>() {
            @Override
            public void onResponse(Call<RoomResponse> call, Response<RoomResponse> response) {
                if (response.isSuccessful()) {
                    roomResponse = response.body();
               }
                latch.countDown();
            }

            @Override
            public void onFailure(Call<RoomResponse> call, Throwable t) {
                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, "Lỗi kết nối Internet. Vui lòng kiểm tra lại.", "Lỗi", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
                latch.countDown();
            }
        });
    }
    
    public void updateRoom(Room room) {
        Call<String> call = this.repository.updateRoom(room);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    System.out.println("Cập nhật phòng thành công");
                } else {
                    System.out.println("Cập nhật phòng thất bại: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println("Lỗi: " + t.getMessage());
            }
    });
}
    
    public void setRoomDetailForm(JComponent com, int id){
        if (roomResponse != null) {
            for (int i = 0; i < roomResponse.size(); i++){
                if (roomResponse.get(i).getId() == id){
                    main.setForm(new RoomDetailForm(com, roomResponse.get(i)));
                }
            }
        }
    }
    
    public void setForm(JComponent com){
        main.setForm(com);
    }
}
