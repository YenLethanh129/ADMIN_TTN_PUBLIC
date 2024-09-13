package ct07.adminmanagerforttn.app.view.form;

import ct07.adminmanagerforttn.app.controller.DashBoardController;
import ct07.adminmanagerforttn.app.controller.RoomController;
import ct07.adminmanagerforttn.app.controller.UserController;
import ct07.adminmanagerforttn.app.model.CardModel;
import ct07.adminmanagerforttn.app.model.DashBoard;
import ct07.adminmanagerforttn.app.model.Room;
import ct07.adminmanagerforttn.app.model.StatusType;
import ct07.adminmanagerforttn.app.model.User;
import ct07.adminmanagerforttn.app.view.menu.ScrollBar;
import java.awt.Color;
import java.util.concurrent.CountDownLatch;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
* @author CT07N0161 VoThiBichTuyen CT07N0162 LeThanhYen
 */
public class HomeForm extends javax.swing.JPanel {
    
    private DashBoardController dashBoardController;
    private RoomController roomPendingController;
    private RoomController roomController;
    private UserController userController;

    public HomeForm() {
        initComponents();
        //  add row table
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
    
        // Đổ dữ liệu ra table
        setDashBoard();
        setCardRoom();
        setCardRoomPending();
        setCardUser();
    }
    
    private void setDashBoard(){
        CountDownLatch latch = new CountDownLatch(1);
        this.dashBoardController = new DashBoardController();
        this.dashBoardController.getDashBoard(latch);

        try {
            latch.await();
            if (this.dashBoardController.dashboardReponse != null && !this.dashBoardController.dashboardReponse.isEmpty()) {
                for (int i = 0; i < this.dashBoardController.dashboardReponse.size(); i++) {
                    DashBoard dashBoard = this.dashBoardController.dashboardReponse.get(i);
                    table.addRow(new Object[]{dashBoard.getTitle(), dashBoard.getUploadTime(), dashBoard.getRoomId(), dashBoard.getAuthorId() , dashBoard.getStatus()});
                }
            }
        } catch (InterruptedException e) {
            // Hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(this, "Lỗi kết nối Internet. Vui lòng kiểm tra lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void setCardRoomPending(){
        CountDownLatch latch = new CountDownLatch(1);
        this.roomPendingController = new RoomController();
        roomPendingController.getRoomPending(latch);

        try {
            latch.await();
            if (this.roomPendingController.roomResponse != null && !this.roomPendingController.roomResponse.isEmpty()) {
                cardRoomPending.setData(new CardModel(new ImageIcon(getClass().getResource("/ct07/adminmanagerforttn/app/view/icon/5.png")), "Phòng chờ duyệt", String.valueOf(this.roomPendingController.roomResponse.size()), ""));
            }
        } catch (InterruptedException e) {
            // Hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(this, "Lỗi kết nối Internet. Vui lòng kiểm tra lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        
    }
    
    private void setCardRoom(){
        CountDownLatch latch = new CountDownLatch(1);
        this.roomController = new RoomController();
        roomController.getRoom(latch);

        try {
            latch.await();
            if (this.roomController.roomResponse != null && !this.roomController.roomResponse.isEmpty()) {
                cardRoomAppoved.setData(new CardModel(new ImageIcon(getClass().getResource("/ct07/adminmanagerforttn/app/view/icon/5.png")), "Phòng trọ", String.valueOf(this.roomController.roomResponse.size()), ""));
            }
        } catch (InterruptedException e) {
            // Hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(this, "Lỗi kết nối Internet. Vui lòng kiểm tra lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        
    }
    
    private void setCardUser(){
        CountDownLatch latch = new CountDownLatch(1);
        this.userController = new UserController();
        userController.getUser(latch);

        try {
            latch.await();
            if (this.userController.userResponse != null && !this.userController.userResponse.isEmpty()) {
                cardUserApprove.setData(new CardModel(new ImageIcon(getClass().getResource("/ct07/adminmanagerforttn/app/view/icon/8.png")), "Người dùng", String.valueOf(this.userController.userResponse.size()), ""));
            }
        } catch (InterruptedException e) {
            // Hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(this, "Lỗi kết nối Internet. Vui lòng kiểm tra lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        cardRoomPending = new ct07.adminmanagerforttn.app.view.menu.Card();
        cardRoomAppoved = new ct07.adminmanagerforttn.app.view.menu.Card();
        cardUserApprove = new ct07.adminmanagerforttn.app.view.menu.Card();
        panelBorder1 = new ct07.adminmanagerforttn.app.view.menu.PanelBordel();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new ct07.adminmanagerforttn.app.view.menu.Table();

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        cardRoomPending.setColor1(new java.awt.Color(8, 131, 149));
        cardRoomPending.setColor2(new java.awt.Color(55, 183, 195));
        panel.add(cardRoomPending);

        cardRoomAppoved.setColor1(new java.awt.Color(119, 118, 179));
        cardRoomAppoved.setColor2(new java.awt.Color(155, 134, 189));
        panel.add(cardRoomAppoved);

        cardUserApprove.setColor1(new java.awt.Color(6, 208, 1));
        cardUserApprove.setColor2(new java.awt.Color(155, 236, 0));
        panel.add(cardUserApprove);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Bảng thống kê chung");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tiêu đề", "Thời gian đăng", "ID Phòng", "ID Người đăng", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(table);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTable)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 536, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ct07.adminmanagerforttn.app.view.menu.Card cardRoomAppoved;
    private ct07.adminmanagerforttn.app.view.menu.Card cardRoomPending;
    private ct07.adminmanagerforttn.app.view.menu.Card cardUserApprove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane panel;
    private ct07.adminmanagerforttn.app.view.menu.PanelBordel panelBorder1;
    private javax.swing.JScrollPane spTable;
    private ct07.adminmanagerforttn.app.view.menu.Table table;
    // End of variables declaration//GEN-END:variables
}
