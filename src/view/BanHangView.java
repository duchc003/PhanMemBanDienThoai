/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.HangSP;
import model.HoaDon;
import model.KhachHang;
import service.HoaDonServices;
import service.SanPhamFormBanHangServices;
import service.impl.HoaDonServicesImpl;
import service.impl.KhachHangCbbImpl;
import service.impl.SanPhamFormBanHangServicesImpl;
import util.Auth;
import viewmodel.GioHangViewModel;
import viewmodel.HoaDonViewModel;
import viewmodel.SanPhamFormBanHangViewModel;

/**
 *
 * @author ASUS
 */
public class BanHangView extends javax.swing.JInternalFrame {

//    private final Dimension ds = new Dimension(250, 150);
//    private final Dimension cs = WebcamResolution.VGA.getSize();
//    private final Webcam wCam = Webcam.getDefault();
//    private final WebcamPanel wCamPanel = new WebcamPanel(wCam, ds, false);
    private DefaultTableModel tblModel1 = new DefaultTableModel();
    private HoaDonServices hoaDonServices = new HoaDonServicesImpl();
    private KhachHangCbbImpl impl = new KhachHangCbbImpl();
    private SanPhamFormBanHangServices sanPhamFormBanHangServices = new SanPhamFormBanHangServicesImpl();
    private DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbm1 = new DefaultComboBoxModel();
    private List<SanPhamFormBanHangViewModel> lst = new ArrayList<>();
    private List<GioHangViewModel> gioHangViewModels = new ArrayList<>();

    public BanHangView() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        if (Auth.user.getTaiKhoan().equalsIgnoreCase("duchcph22577")) {
            lblNhanVien.setText("Hoàng Công Đức");
        }
        if (Auth.user.getTaiKhoan().equalsIgnoreCase("namndph22694")) {
            lblNhanVien.setText("Nguyễn Đức Nam");
        }
        if (Auth.user.getTaiKhoan().equalsIgnoreCase("hieunmph22569")) {
            lblNhanVien.setText("Nguyễn Minh Hiếu");
        }
        if (Auth.user.getTaiKhoan().equalsIgnoreCase("huybqph22581")) {
            lblNhanVien.setText("Bùi Quang Huy");
        }
        if (Auth.user.getTaiKhoan().equalsIgnoreCase("huyhmph22668")) {
            lblNhanVien.setText("Hoàng Minh Huy");
        }
        if (Auth.user.getTaiKhoan().equalsIgnoreCase("duchcph22577")) {
            lblNV.setText("Hoàng Công Đức");
        }
        if (Auth.user.getTaiKhoan().equalsIgnoreCase("namndph22694")) {
            lblNV.setText("Nguyễn Đức Nam");
        }
        if (Auth.user.getTaiKhoan().equalsIgnoreCase("hieunmph22569")) {
            lblNV.setText("Nguyễn Minh Hiếu");
        }
        if (Auth.user.getTaiKhoan().equalsIgnoreCase("huybqph22581")) {
            lblNV.setText("Bùi Quang Huy");
        }
        if (Auth.user.getTaiKhoan().equalsIgnoreCase("huyhmph22668")) {
            lblNV.setText("Hoàng Minh Huy");
        }
//        wCam.setViewSize(cs);
//        wCamPanel.setFillArea(true);
//        lblCamera.setLayout(new FlowLayout());
//        lblCamera.add(wCamPanel);
//        initWebcam();

        loadHoaDon();
        lst = sanPhamFormBanHangServices.getAll();
        loadSanPham(lst);
        cbbTenHang(sanPhamFormBanHangServices.getTenHangSPs());
        cbbTenKhachHang(impl.getALL());
        KhachHang kh = impl.getOne(cbbKhachHang.getSelectedItem().toString());
        lblIdKH.setText(String.valueOf(kh.getId()));

    }

//    private void initWebcam() {
//        Thread t = new Thread() {
//            @Override
//            public void run() {
//                wCamPanel.start();
//            }
//        };
//        t.setDaemon(true);
//        t.start();
//    }
    private void cbbTenHang(List<HangSP> list) {
        cbbTenHang.setModel(dcbm);
        for (HangSP hangSP : list) {
            dcbm.addElement(hangSP.getTen());
        }
    }

    private void cbbTenKhachHang(List<KhachHang> list) {
        cbbKhachHang.setModel(dcbm1);
        for (KhachHang khachHang : list) {
            dcbm1.addElement(khachHang.getHoVaTen());
        }
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblCamera = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        cbbKhachHang = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        txtNgayTao = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        txtKhachHang = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        lblIdKH = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        lblNV = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jTextField10 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        cbbTenHang = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã Hóa Đơn", "Ngày Tạo", "Trạng Thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 450, 130));

        jButton1.setBackground(new java.awt.Color(102, 255, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/invoice.png"))); // NOI18N
        jButton1.setText("Tạo hóa Đơn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, 40));

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("Hóa Đơn");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 500, 220));

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "Tên", "Số Lượng ", "Thành Tiên"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblGioHang);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 700, 140));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 740, 160));

        jPanel4.setBackground(new java.awt.Color(0, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCamera.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout lblCameraLayout = new javax.swing.GroupLayout(lblCamera);
        lblCamera.setLayout(lblCameraLayout);
        lblCameraLayout.setHorizontalGroup(
            lblCameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        lblCameraLayout.setVerticalGroup(
            lblCameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel4.add(lblCamera, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 250, 150));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Quét mã sản phẩm");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 270, 180));

        jPanel6.setBackground(new java.awt.Color(0, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setForeground(new java.awt.Color(51, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Hãng SP", "Giá Bán", "Xuất Xứ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 700, 200));

        jButton6.setBackground(new java.awt.Color(102, 255, 102));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        jButton6.setText("Thêm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));

        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });
        jPanel6.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 310, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Tìm kiếm");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 740, 270));

        jPanel8.setBackground(new java.awt.Color(0, 204, 255));

        jPanel9.setBackground(new java.awt.Color(0, 204, 255));
        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbbKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKhachHangActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 255, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        jButton3.setText("Thêm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã Hóa Đơn");

        txtMaHD.setEnabled(false);

        jLabel8.setText("Ngày Tạo");

        jLabel9.setText("Giảm giá %");

        jLabel10.setText("Tiền khách");

        jLabel13.setText("Tiền Thừa");

        jTextField1.setEnabled(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        jLabel14.setText("Ghi Chú");

        jButton5.setBackground(new java.awt.Color(102, 255, 102));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/multiply.png"))); // NOI18N
        jButton5.setText("Hủy đơn");

        jComboBox3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền Mặt", "Chuyển Khoản", "Quẹt khẻ", "Quét Mã" }));

        jButton4.setBackground(new java.awt.Color(102, 255, 102));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pay.png"))); // NOI18N
        jButton4.setText("Thanh Toán");

        txtNgayTao.setEnabled(false);

        jLabel11.setText("Tổng Tiền");

        jTextField12.setEnabled(false);

        txtKhachHang.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtKhachHangCaretUpdate(evt);
            }
        });

        jLabel16.setText("Tìm Khách");

        jLabel12.setText("Tên Nhân Viên:");

        lblNhanVien.setText("jLabel18");

        lblIdKH.setText("jLabel22");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                    .addComponent(lblNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgayTao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(70, 70, 70))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblIdKH, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblNhanVien))
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblIdKH))
                    .addComponent(jButton3))
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(33, 33, 33)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(31, 31, 31)
                .addComponent(jButton4)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Tại quầy", jPanel8);

        jPanel7.setBackground(new java.awt.Color(0, 204, 255));
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 150, 39));

        jButton2.setBackground(new java.awt.Color(102, 255, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/multiply.png"))); // NOI18N
        jButton2.setText("Hủy Đơn");
        jPanel7.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 640, 153, -1));

        jButton7.setBackground(new java.awt.Color(102, 255, 102));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Ecommerce-Delivery-icon.png"))); // NOI18N
        jButton7.setText("Giao Hàng");
        jPanel7.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 700, 163, -1));

        jLabel25.setText("Tên Nhân Viên");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 23, 92, -1));

        lblNV.setText("jLabel24");
        jPanel7.add(lblNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 23, 260, -1));

        jLabel2.setText("Mã Hóa Đơn");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, -1, -1));
        jPanel7.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 62, 215, -1));

        jLabel3.setText("Ngày Tạo");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 117, -1, -1));
        jPanel7.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 215, -1));

        jLabel4.setText("Ngày Tạo");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 171, -1, -1));
        jPanel7.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 168, 215, -1));

        jLabel6.setText("Tên Khách Hàng");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 218, -1, -1));
        jPanel7.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 215, 215, -1));

        jLabel15.setText("Số Điện thoại");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 268, -1, -1));
        jPanel7.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 215, -1));

        jLabel17.setText("Địa Chỉ");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel18.setText("Tổng Tiền");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));
        jPanel7.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 215, -1));

        jLabel19.setText("Giảm Giá %");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel7.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 215, -1));

        jLabel20.setText("Tiền khách cần trả");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));
        jPanel7.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 215, -1));

        jLabel21.setText("Ghi Chú");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane6.setViewportView(jTextArea3);

        jPanel7.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, 220, 70));
        jPanel7.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 265, 215, -1));

        jTabbedPane1.addTab("ShipCode", jPanel7);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 440, 790));

        jButton9.setBackground(new java.awt.Color(102, 255, 102));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trash.png"))); // NOI18N
        jButton9.setText("Xóa");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, -1, -1));

        cbbTenHang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbTenHangItemStateChanged(evt);
            }
        });
        jPanel1.add(cbbTenHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 490, 160, -1));

        jLabel22.setBackground(new java.awt.Color(0, 0, 0));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("Sản Phẩm");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, -1, -1));

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("Giỏ Hàng");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new KhachHangJframe().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int row = tblHoaDon.getSelectedRow();
        txtMaHD.setText(tblHoaDon.getValueAt(row, 1).toString());
        txtNgayTao.setText(tblHoaDon.getValueAt(row, 2).toString());
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int row = tblGioHang.getSelectedRow();
        gioHangViewModels.remove(row);
        loadGioHang();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        DefaultTableModel tblModelGH = new DefaultTableModel();
        tblModelGH = (DefaultTableModel) tblGioHang.getModel();
        tblModelGH.setRowCount(0);
        int row = tblSanPham.getSelectedRow();
        String choice = JOptionPane.showInputDialog("Nhập vào số lượng : ", "0");

        if (Integer.parseInt(choice) == 0) {
            loadGioHang();
            return;
        }
        if (Integer.parseInt(choice) > Integer.parseInt(tblSanPham.getValueAt(row, 3).toString())) {
            JOptionPane.showMessageDialog(this, "Đã nhập quá số lượng sản phẩm có trong kho !"
                    + "\n \tVui lòng chọn lại");
            loadGioHang();
            return;

        }
        //Giảm số lượng sản phẩm được chọn

        String ma = tblSanPham.getValueAt(row, 1).toString();
        String ten = tblSanPham.getValueAt(row, 2).toString();
        double dongia = Double.parseDouble(tblSanPham.getValueAt(row, 5).toString());

        GioHangViewModel gh = new GioHangViewModel();
        gh.setMa(ma);
        gh.setTen(ten);
        gh.setDonGia(dongia);
        gh.setSoLuong(Integer.parseInt(choice));

        for (GioHangViewModel gioHangViewModel : gioHangViewModels) {
            if (tblSanPham.getValueAt(row, 1).toString().equals(gioHangViewModel.getMa())) {
                int soluong = gioHangViewModel.getSoLuong() + Integer.parseInt(choice);
                gioHangViewModel.setSoLuong(soluong);
                loadGioHang();
                return;
            }
        }
        gioHangViewModels.add(gh);
        loadGioHang();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cbbTenHangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbTenHangItemStateChanged
        String tenHagString = (String) cbbTenHang.getSelectedItem();
        List<SanPhamFormBanHangViewModel> list = sanPhamFormBanHangServices.searchTenHang(lst, tenHagString);
        loadSanPham(list);
    }//GEN-LAST:event_cbbTenHangItemStateChanged

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        searchByMa();
    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addHoaDon();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblSanPhamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSanPhamMouseEntered

    private void cbbKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKhachHangActionPerformed
        KhachHang kh = impl.getOne(cbbKhachHang.getSelectedItem().toString());
        lblIdKH.setText(String.valueOf(kh.getId()));
    }//GEN-LAST:event_cbbKhachHangActionPerformed

    private void txtKhachHangCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtKhachHangCaretUpdate
        String sdt = txtKhachHang.getText();
        List<KhachHang> list = new ArrayList<>();
        list = impl.getSeach(sdt, list);
        cbbTenKhachHang(list);
    }//GEN-LAST:event_txtKhachHangCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbKhachHang;
    private javax.swing.JComboBox<String> cbbTenHang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel lblCamera;
    private javax.swing.JLabel lblIdKH;
    private javax.swing.JLabel lblNV;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtKhachHang;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    private void loadSanPham(List<SanPhamFormBanHangViewModel> lst) {
        tblModel1 = (DefaultTableModel) tblSanPham.getModel();
        tblModel1.setRowCount(0);
        int i = 1;
        for (SanPhamFormBanHangViewModel spp : lst) {
            tblModel1.addRow(new Object[]{
                i++,
                spp.getMaSp(),
                spp.getTenSp(),
                spp.getSoLuong(),
                spp.getHang(),
                spp.getGiaBan(),
                spp.getXuatXu()
            });
        }
    }

    private void searchByMa() {
        DefaultTableModel tblModel2 = new DefaultTableModel();
        tblModel2 = (DefaultTableModel) tblSanPham.getModel();
        tblModel2.setRowCount(0);
        List<SanPhamFormBanHangViewModel> sp = sanPhamFormBanHangServices.Search(txtTimKiem.getText());
        int i = 1;
        for (SanPhamFormBanHangViewModel spp : sp) {
            tblModel2.addRow(new Object[]{
                i++,
                spp.getMaSp(),
                spp.getTenSp(),
                spp.getSoLuong(),
                spp.getHang(),
                spp.getGiaBan(),
                spp.getXuatXu()
            });
        }
    }

    private void loadGioHang() {
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel = (DefaultTableModel) tblGioHang.getModel();
        tblModel.setRowCount(0);
        int j = 0;
        List<GioHangViewModel> gh = gioHangViewModels;
        for (int i = 0; i < gh.size(); i++) {
            tblModel.addRow(new Object[]{
                j++,
                gh.get(i).getMa(),
                gh.get(i).getTen(),
                gh.get(i).getSoLuong(),
                gh.get(i).getDonGia(),
                gh.get(i).thanhTien()
            });

        }
    }

    private void addHoaDon() {
        HoaDon hoaDon = new HoaDon();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String dateTT = df.format(date);
        Random rd = new Random();

        hoaDon.setMaHD("HD" + rd.nextInt(999999));
        hoaDon.setNgayTao(dateTT);
        hoaDon.setTrangThai("Chờ Thanh Toán");

        JOptionPane.showMessageDialog(this, hoaDonServices.addHoaDon(hoaDon));
        loadHoaDon();
    }

    private void loadHoaDon() {
        List<HoaDonViewModel> list = hoaDonServices.getAll();
        DefaultTableModel tblModel = new DefaultTableModel();

        tblModel = (DefaultTableModel) tblHoaDon.getModel();
        tblModel.setRowCount(0);

        int i = 1;
        for (HoaDonViewModel hd : list) {
            tblModel.addRow(new Object[]{
                i++,
                hd.getMaHD(),
                hd.getNgayTao(),
                hd.getTrangThai()
            });
        }
    }
}
