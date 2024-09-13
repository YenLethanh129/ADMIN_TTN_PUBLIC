package ct07.adminmanagerforttn.app.controller;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ct07.adminmanagerforttn.app.model.DashBoardResponse;
import ct07.adminmanagerforttn.repository.Repository;
// Import the MutableLiveData class
import ct07.adminmanagerforttn.repository.Repository;
import java.util.concurrent.CountDownLatch;
import javax.swing.JOptionPane;

/**
 *1
 * author ThanhYen
 */
public class DashBoardController {

    private final Repository repository;
    
    public DashBoardResponse dashboardReponse = null;

    public DashBoardController() {
        this.repository = new Repository();
    }

    public void getDashBoard(CountDownLatch latch) {
        Call<DashBoardResponse> call = this.repository.getDashBoard();

        call.enqueue(new Callback<DashBoardResponse>() {
            @Override
            public void onResponse(Call<DashBoardResponse> call, Response<DashBoardResponse> response) {
                if (response.isSuccessful()) {
                    dashboardReponse = response.body();
               }
                latch.countDown();
            }

            @Override
            public void onFailure(Call<DashBoardResponse> call, Throwable t) {
                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, "Lỗi kết nối Internet. Vui lòng kiểm tra lại.", "Lỗi", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
                latch.countDown();
            }
        });
    }
}
