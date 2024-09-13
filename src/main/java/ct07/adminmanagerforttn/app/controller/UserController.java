package ct07.adminmanagerforttn.app.controller;

import ct07.adminmanagerforttn.app.Main;
import ct07.adminmanagerforttn.app.model.RoomResponse;
import ct07.adminmanagerforttn.app.model.User;
import ct07.adminmanagerforttn.app.model.UserResponse;
import ct07.adminmanagerforttn.app.view.form.UserDetailForm;
import ct07.adminmanagerforttn.app.view.form.UserForm;
import ct07.adminmanagerforttn.repository.Repository;
import java.util.concurrent.CountDownLatch;
import javax.swing.JOptionPane;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
* @author CT07N0161 VoThiBichTuyen CT07N0162 LeThanhYen
 */
public class UserController {
    
    private final Repository repository;
    private final Main main;
    
    public UserResponse userResponse = null;

    public UserController() {
        main = Main.getInstance();
        repository = new Repository();
    }

    public void getUser(CountDownLatch latch) {
        Call<UserResponse> call = this.repository.getUser();

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    userResponse = response.body();
               }
                latch.countDown();
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, "Lỗi kết nối Internet. Vui lòng kiểm tra lại.", "Lỗi", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
                latch.countDown();
            }
        });
    }
    
    public void login(CountDownLatch latch, String username, String password) {
        Call<UserResponse> call = this.repository.login(username, password);

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    userResponse = response.body();
               }
                latch.countDown();
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, "Lỗi kết nối Internet. Vui lòng kiểm tra lại.", "Lỗi", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
                latch.countDown();
            }
        });
    }
    
    public void setUserDetailForm(int id){
        if (userResponse != null) {
            for (int i = 0; i < userResponse.size(); i++){
                if (userResponse.get(i).getId() == id){
                    main.setForm(new UserDetailForm(userResponse.get(i)));
                }
            }
        }
    }
    
    public void updateUser(User user) {
        Call<String> call = this.repository.updateUser(user);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    System.out.println("Cập nhật user thành công");
                } else {
                    System.out.println("Cập nhật user thất bại: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println("Lỗi: " + t.getMessage());
            }
        });
    }
    
    public void setForm(){
        main.setForm(new UserForm());
    }
}
