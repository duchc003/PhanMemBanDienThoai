/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import service.impl.hoaDonViewModelServicesImplHUY;
import viewmodel.hoaDonViewModelHUY;

/**
 *
 * @author ASUS
 */
public class HoaDonView extends javax.swing.JInternalFrame {

    /**
     * Creates new form HoaDonView
     */
    private final hoaDonViewModelServicesImplHUY hoaViewModelServicesImplHUY = new hoaDonViewModelServicesImplHUY();
    public HoaDonView() {
        initComponents();
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        loadtable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_timKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Tìm Kiếm");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        txt_timKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timKiemCaretUpdate(evt);
            }
        });
        jPanel1.add(txt_timKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 940, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "MaHD", "Tên Khách Hàng", "Số lượng", "Thành Tiền", "tên  HTTT", "Tên HTGH", "Trạng Thái"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 330, 1270, 460));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "                        ", "Tại Quầy", "Khác" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 150, 180, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "                                ", "Đã Thanh Toán", "Đã Hủy", "Chờ Thanh Toán" }));
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 180, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "                                  ", "Tiền Mặt", "Quẹt Thẻ", "Chuyển Khoản", "Quét Mã" }));
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 180, -1));

        jButton1.setBackground(new java.awt.Color(51, 255, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/export.png"))); // NOI18N
        jButton1.setText("Xuất");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 270, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_timKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timKiemCaretUpdate
        if (txt_timKiem.getText().equalsIgnoreCase("")) {
            return;
        }
        String maHD = txt_timKiem.getText();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        List<hoaDonViewModelHUY> list = hoaViewModelServicesImplHUY.timKiemHoaDonViewModelHUY(maHD);
         for (hoaDonViewModelHUY hd : list) {
        model.addRow(new Object[]{
             hd.getMaHD(),
            hd.getHoVaTen(),
            hd.getSoLuong(),
            hd.getThanhTien(),
            hd.getTenHTTT(),
            hd.getTenHTGH(),
            hd.getTrangThai()
                        
        });
         }
    }//GEN-LAST:event_txt_timKiemCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables


private void loadtable(){
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);
    List<hoaDonViewModelHUY> list = hoaViewModelServicesImplHUY.getAllhoaDonViewModelHUY();
    for (hoaDonViewModelHUY hd : list) {
        model.addRow(new Object[]{
             hd.getMaHD(),
            hd.getHoVaTen(),
            hd.getSoLuong(),
            hd.getThanhTien(),
            hd.getTenHTTT(),
            hd.getTenHTGH(),
            hd.getTrangThai()
                        
        });
    }
            
            
}
}
