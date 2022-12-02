/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import service.KhachHangServices;
import service.impl.KhachHangServicesImpl;
import util.DateUtil;
import viewmodel.KhachHangViewModel;

/**
 *
 * @author ASUS
 */
public class KhachHangView extends javax.swing.JInternalFrame {

//    private KhachHangServices khachHangServices = new KhachHangServicesImpl();
    List<KhachHangViewModel> lists = new ArrayList<>();
    private DateUtil ut = new DateUtil();
    private String pattern = "yyyy/MM/dd";
    private SimpleDateFormat formatter = new SimpleDateFormat(pattern);

    public KhachHangView() {
        initComponents();
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
//        loadData();
    }

//    private void loadData() {
//        DefaultTableModel tblModel = new DefaultTableModel();
//        tblModel = (DefaultTableModel) tblKhachHang.getModel();
//        tblModel.setRowCount(0);
//        lists = khachHangServices.getAll();
//        for (KhachHangViewModel kh : lists) {
//            tblModel.addRow(new Object[]{
//                kh.getMa(),
//                kh.getHoVaTen(),
//                kh.getGioiTinh(),
//                kh.getNgaySinh(),
//                kh.getSoDienThoai(),
//                kh.getDiaChi(),
//                kh.getMoTa()
//            });
//        }
//
//    }

    private boolean validateForm() {
        if (txtMaKH.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã ");
            return false;
        }
        if (txtTen.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên ");
            return false;
        }
        if (txtNgaySinh.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày sinh ");
            return false;
        }
        if (txtSoDT.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại ");
            return false;
        }
        if (txtDiaChi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số địa chỉ");
            return false;
        }
        if (rdoNam.isSelected() == false && rdoNu.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn giới tính");
            return false;
        }

        return true;
    }

    private void clearForm() {
        txtMaKH.setText("");
        txtTen.setText("");
        txtDiaChi.setText("");
        txtSoDT.setText("");
        txtGhiChu.setText("");
        txtNgaySinh.setText("");
        lblngaysinh.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        txtMaKH = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        txtDiaChi = new javax.swing.JTextField();
        txtSoDT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        lblngaysinh = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        lblsdt = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1281, 805));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên ", "Giới tính", "Ngày Sinh", "Số Điện Thoại", "Địa Chỉ", "Mô tả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 1241, 327));
        jPanel1.add(txtMaKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 199, -1));

        txtNgaySinh.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNgaySinhCaretUpdate(evt);
            }
        });
        jPanel1.add(txtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 640, 199, -1));
        jPanel1.add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, 199, -1));

        buttonGroup1.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        jPanel1.add(rdoNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 720, -1, -1));

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");
        jPanel1.add(rdoNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 720, -1, -1));
        jPanel1.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 510, 230, -1));

        txtSoDT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSoDTCaretUpdate(evt);
            }
        });
        jPanel1.add(txtSoDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 580, 230, -1));

        jLabel1.setText("Tìm Kiếm");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, -1, -1));

        jLabel2.setText("Tên KH");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 580, -1, -1));

        jLabel3.setText("Ngày Sinh");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 650, -1, -1));

        jLabel4.setText("Địa Chỉ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 510, -1, -1));

        jLabel5.setText("Số điện thoại");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 580, -1, -1));

        jLabel6.setText("Ghi Chú");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 650, -1, -1));

        jLabel7.setText("Giới Tính");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 720, -1, -1));

        btnSearch.setBackground(new java.awt.Color(51, 255, 51));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/magnifying-glass.png"))); // NOI18N
        btnSearch.setText("Tìm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 420, 100, -1));

        btnSua.setBackground(new java.awt.Color(51, 255, 51));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/system-update.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 580, 93, -1));

        btnClear.setBackground(new java.awt.Color(51, 255, 51));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dust.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 660, -1, -1));

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane2.setViewportView(txtGhiChu);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 640, -1, -1));

        lblngaysinh.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblngaysinh.setForeground(new java.awt.Color(0, 255, 153));
        jPanel1.add(lblngaysinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 670, 300, 20));
        jPanel1.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 610, -1));

        jLabel8.setText("Mã KH");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, -1, -1));

        btnThem.setBackground(new java.awt.Color(51, 255, 51));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 500, -1, -1));

        lblsdt.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblsdt.setForeground(new java.awt.Color(0, 255, 153));
        jPanel1.add(lblsdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 610, 300, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1355, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int luachon = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không?");
        if (luachon == JOptionPane.YES_OPTION) {
            KhachHang kh = new KhachHang();
            kh.setMa(txtMaKH.getText());
            kh.setHoVaTen(txtTen.getText());
            if (rdoNam.isSelected()) {
                kh.setGioiTinh("nam");
            } else {
                kh.setGioiTinh("nữ");
            }
            kh.setNgaySinh(txtNgaySinh.getText());
            kh.setSoDienThoai(txtSoDT.getText());
            kh.setDiaChi(txtDiaChi.getText());
            kh.setMoTa(txtGhiChu.getText());
//            JOptionPane.showMessageDialog(this, khachHangServices.updateKH(kh));
//            loadData();
            clearForm();
        }
        if (luachon == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "đã hủy");
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtNgaySinhCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNgaySinhCaretUpdate
        Pattern p2 = Pattern.compile("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$");//Năm bắt đầu từ 1900 đến dưới 3000-tháng từ 1 đến 12 -ngày từ 1 đến 31
        if (p2.matcher(txtNgaySinh.getText()).find() == false) {
            lblngaysinh.setText("Không hợp lệ !");
            lblngaysinh.setForeground(Color.red);
        } else {
            lblngaysinh.setText("OK");
            lblngaysinh.setForeground(Color.GREEN);
        }
        if (txtNgaySinh.getText().isEmpty()) {
            lblngaysinh.setText("");
        }
    }//GEN-LAST:event_txtNgaySinhCaretUpdate

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
//        String ma = txtTimKiem.getText();
//        lists = khachHangServices.searchKH(ma);
//        String sdt = txtTimKiem.getText();
//        lists = khachHangServices.searchSdt(sdt);
//        DefaultTableModel tblModel = new DefaultTableModel();
//        tblModel = (DefaultTableModel) tblKhachHang.getModel();
//        tblModel.setRowCount(0);
//        for (KhachHangViewModel kh : lists) {
//            tblModel.addRow(new Object[]{
//                kh.getMa(),
//                kh.getHoVaTen(),
//                kh.getGioiTinh(),
//                kh.getNgaySinh(),
//                kh.getSoDienThoai(),
//                kh.getDiaChi(),
//                kh.getMoTa()
//            });
//        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        int row = tblKhachHang.getSelectedRow();
        txtMaKH.setText(tblKhachHang.getValueAt(row, 0).toString());
        txtTen.setText(tblKhachHang.getValueAt(row, 1).toString());
        if (tblKhachHang.getValueAt(row, 2).toString().equalsIgnoreCase("nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        txtNgaySinh.setText(tblKhachHang.getValueAt(row, 3).toString());
        txtSoDT.setText(tblKhachHang.getValueAt(row, 4).toString());
        txtDiaChi.setText(tblKhachHang.getValueAt(row, 5).toString());
        txtGhiChu.setText(tblKhachHang.getValueAt(row, 6).toString());
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
//           //regex matkhau ^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$
//        if (validateForm() == true) {
//            //validate ngaysinh
//            Pattern p2 = Pattern.compile("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$");//Năm bắt đầu từ 1900 đến dưới 3000-tháng từ 1 đến 12 -ngày từ 1 đến 31
//            if (p2.matcher(txtNgaySinh.getText()).find() == false) {
//                JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày sinh hợp lệ\n Định dạng yyyy/MM/dd \n Năm(1900-2999)\n Tháng (1-12) \n Ngày (1-31)");
//                return;
//            }
//               Pattern p = Pattern.compile("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$");
//         if(p.matcher(txtSoDT.getText()).find()==false){
//            
//           JOptionPane.showMessageDialog(this, "Số điện thoại phải là số và có đúng 10 chữ số \n Nếu đầu khác 0 thì còn 9 số");
//          return;
//         }
//    
//            KhachHang kh = new KhachHang();
//            kh.setMa(txtMaKH.getText());
//            kh.setHoVaTen(txtTen.getText());
//            if (rdoNam.isSelected()) {
//                kh.setGioiTinh("Nam");
//            } else {
//                kh.setGioiTinh("Nữ");
//            }
//            kh.setNgaySinh(txtNgaySinh.getText());
//            kh.setSoDienThoai(txtSoDT.getText());
//            kh.setDiaChi(txtDiaChi.getText());
//            kh.setMoTa(txtGhiChu.getText());
//            
//            JOptionPane.showMessageDialog(this, khachHangServices.addKH(kh));
//            loadData();
//            
//            clearForm();
//        } else {
//            return;
//        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtSoDTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSoDTCaretUpdate
        
         Pattern p = Pattern.compile("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$");
         if(p.matcher(txtSoDT.getText()).find()==false){
            
             lblsdt.setText("sai định dạng!");
             lblsdt.setForeground(Color.red);
             
          
         }else{
             lblsdt.setText("");
         }
    }//GEN-LAST:event_txtSoDTCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblngaysinh;
    private javax.swing.JLabel lblsdt;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
