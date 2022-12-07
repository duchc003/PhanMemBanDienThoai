package view;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.HangSP;
import model.HinhThucGiaoHang;
import model.HinhThucThanhToan;
import model.HoaDon;
import model.HoaDonCT;
import model.KhachHang;
import model.NhanVien;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import service.HoaDonServices;
import service.SanPhamFormBanHangServices;
import service.impl.HoaDonServicesImpl;
import service.impl.KhachHangCbbImpl;
import service.impl.KhachHangServicesImpl;
import service.impl.NhanVienImpl;
import service.impl.SanPhamFormBanHangServicesImpl;
import service.impl.hoaDonViewModelServicesImplHUY;
import service.impl.khuyenMaiServicesImpl;
import util.Auth;
import util.MsgBox;
import util.XMoney;
import viewmodel.GioHangViewModel;
import viewmodel.HoaDonViewModel;
import viewmodel.KhachHangViewModel;
import viewmodel.KhuyenMaiBanHang;
import viewmodel.KhuyenMaiViewModel;
import viewmodel.SanPhamFormBanHangViewModel;
import viewmodel.hoaDonViewModelHUY;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.FlowLayout;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import viewmodel.SanPhamViewModel;

public class BanHangView extends javax.swing.JInternalFrame {

    private DefaultTableModel dtmGiohang = new DefaultTableModel();
    private final Dimension ds = new Dimension(250, 150);
    private final Dimension cs = WebcamResolution.VGA.getSize();
    private final Webcam wCam = Webcam.getDefault();
    private final WebcamPanel wCamPanel = new WebcamPanel(wCam, ds, false);
    private DefaultTableModel dtbHoaDon = new DefaultTableModel();
    private DefaultTableModel dtmSanPham = new DefaultTableModel();
    private HoaDonServices hoaDonServices = new HoaDonServicesImpl();
    private KhachHangCbbImpl impl = new KhachHangCbbImpl();
    private SanPhamFormBanHangServices sanPhamFormBanHangServices = new SanPhamFormBanHangServicesImpl();
    private khuyenMaiServicesImpl impl1 = new khuyenMaiServicesImpl();
    private DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbm1 = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbm3 = new DefaultComboBoxModel();
    private List<SanPhamFormBanHangViewModel> lst = new ArrayList<>();
    private List<GioHangViewModel> gioHangViewModels = new ArrayList<>();
    private double v1 = 1000000000;
    private DecimalFormat df = new DecimalFormat("#");
    private List<HoaDonViewModel> list = new java.util.ArrayList<>();
    private service.impl.KhuyenMaiBanHangRepo km1 = new service.impl.KhuyenMaiBanHangRepo();
    private NhanVienImpl nvImpl = new NhanVienImpl();
    private hoaDonViewModelServicesImplHUY hoaViewModelServicesImplHUY = new hoaDonViewModelServicesImplHUY();
    private KhachHangServicesImpl kmImpl = new KhachHangServicesImpl();

    public BanHangView() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
//        wCam.setViewSize(cs);
        wCamPanel.setFillArea(true);
        lblCamera.setLayout(new FlowLayout());
        lblCamera.add(wCamPanel);
        initWebcam();
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
        dtmSanPham = (DefaultTableModel) tblSanPham.getModel();
        tblHoaDon.setModel(dtbHoaDon);
        dtbHoaDon.setColumnIdentifiers(new Object[]{"ID", "Mã Hóa Đơn", "Ngày Tạo", "Trạng Thái"});
        lst = sanPhamFormBanHangServices.getAll();
        loadSanPham(lst);
        List<HoaDonViewModel> hd = hoaDonServices.getALlhoaDon();
        loadTableHoaDon(hd);
    }
    int row = 0;

    private void initWebcam() {
        Thread t = new Thread() {
            @Override
            public void run() {
                wCamPanel.start();
            }
        };
        t.setDaemon(true);
        t.start();
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
        jLabel23 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblCamera = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        bill = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        btnHuyDon = new javax.swing.JButton();
        cbbHTTT = new javax.swing.JComboBox<>();
        btnThanhToan = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblMaKh = new javax.swing.JLabel();
        lblTenKh = new javax.swing.JLabel();
        btnChonKhach = new javax.swing.JButton();
        btnChonKhach1 = new javax.swing.JButton();
        lblTongTien = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lblGiamGia = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        lblMaHoaDon = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lblTienKhachCanTra = new javax.swing.JLabel();
        btnTaoHoaDon = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        btnGiaoHang = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        lblNV = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        txtSDT = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        lblHoaDonGiao = new javax.swing.JLabel();
        lblGiamGiaGiao = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblTongTienCanTra = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        btnHoaDonShip = new javax.swing.JButton();
        lblTongTienGiao = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTenKh = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnXoa1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 450, 160));

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("Hóa Đơn Chờ");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 500, 220));

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Số Lượng ", "Đơn Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
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

        btnThem.setBackground(new java.awt.Color(102, 255, 102));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel6.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));

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

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng", "Giảm Giá", "Đơn Giá", "Xuất Xứ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Long.class, java.lang.Long.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblSanPham);

        jPanel6.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 700, 180));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 740, 270));

        jPanel8.setBackground(new java.awt.Color(0, 204, 255));

        jPanel9.setBackground(new java.awt.Color(0, 204, 255));
        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setText("Mã Hóa Đơn");

        txtTienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachDuaCaretUpdate(evt);
            }
        });
        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        jLabel9.setText("Giảm giá");

        jLabel10.setText("Tiền khách");

        jLabel13.setText("Tiền Thừa");

        bill.setColumns(20);
        bill.setRows(5);
        jScrollPane4.setViewportView(bill);

        jLabel14.setText("Ghi Chú");

        btnHuyDon.setBackground(new java.awt.Color(102, 255, 102));
        btnHuyDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuyDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/multiply.png"))); // NOI18N
        btnHuyDon.setText("Hủy đơn");
        btnHuyDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyDonActionPerformed(evt);
            }
        });

        cbbHTTT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbHTTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền Mặt", "Chuyển Khoản", "Quẹt khẻ", "Quét Mã" }));

        btnThanhToan.setBackground(new java.awt.Color(102, 255, 102));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pay.png"))); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel11.setText("Tổng Tiền");

        jLabel12.setText("Tên Nhân Viên:");

        lblNhanVien.setText("jLabel18");

        jPanel5.setBackground(new java.awt.Color(0, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Mã Khách Hàng:");

        jLabel16.setText("Tên Khách Hàng:");

        lblMaKh.setText("...");

        lblTenKh.setText("...");

        btnChonKhach.setBackground(new java.awt.Color(51, 255, 51));
        btnChonKhach.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnChonKhach.setText("Chọn");
        btnChonKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonKhachActionPerformed(evt);
            }
        });

        btnChonKhach1.setBackground(new java.awt.Color(51, 255, 51));
        btnChonKhach1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnChonKhach1.setText("Hiện Thị");
        btnChonKhach1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonKhach1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel16))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaKh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTenKh, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnChonKhach1)
                    .addComponent(btnChonKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblMaKh)
                    .addComponent(btnChonKhach))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblTenKh)
                    .addComponent(btnChonKhach1))
                .addGap(14, 14, 14))
        );

        lblTongTien.setText("0");

        jLabel30.setText("VND");

        lblTienThua.setText("0");

        jLabel32.setText("VND");

        lblGiamGia.setText("0");

        jLabel34.setText("VND");

        lblMaHoaDon.setText("null");

        jLabel28.setText("Tiền Khách Cần Trả");

        jLabel35.setText("VND");

        lblTienKhachCanTra.setText("0");

        btnTaoHoaDon.setBackground(new java.awt.Color(51, 255, 51));
        btnTaoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTaoHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/invoice.png"))); // NOI18N
        btnTaoHoaDon.setText("Tạo hóa Đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(cbbHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHuyDon, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTaoHoaDon))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11))
                                        .addGap(57, 57, 57))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblGiamGia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel34)
                                            .addComponent(jLabel30)))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(lblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel32))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addComponent(lblTienKhachCanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel35)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel28)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel12)
                                .addGap(38, 38, 38)
                                .addComponent(lblNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblNhanVien))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblTongTien)
                    .addComponent(jLabel30))
                .addGap(44, 44, 44)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblGiamGia)
                    .addComponent(jLabel34))
                .addGap(32, 32, 32)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel3)
                    .addComponent(jLabel35)
                    .addComponent(lblTienKhachCanTra))
                .addGap(26, 26, 26)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblTienThua)
                    .addComponent(jLabel32))
                .addGap(36, 36, 36)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyDon))
                .addGap(31, 31, 31)
                .addComponent(btnThanhToan)
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
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 640, 153, -1));

        btnGiaoHang.setBackground(new java.awt.Color(102, 255, 102));
        btnGiaoHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGiaoHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Ecommerce-Delivery-icon.png"))); // NOI18N
        btnGiaoHang.setText("Giao Hàng");
        btnGiaoHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaoHangActionPerformed(evt);
            }
        });
        jPanel7.add(btnGiaoHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 700, 163, -1));

        jLabel25.setText("Tên Nhân Viên");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 23, 92, -1));

        lblNV.setText("jLabel24");
        jPanel7.add(lblNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 210, -1));

        jLabel2.setText("Mã Hóa Đơn");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, -1, -1));

        jLabel15.setText("Số Điện thoại");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel17.setText("Địa Chỉ");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel18.setText("Tổng Tiền");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        jLabel19.setText("Giảm Giá ");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        jLabel20.setText("Tiền khách cần trả");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        jLabel21.setText("Ghi Chú");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, -1));

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane6.setViewportView(txtGhiChu);

        jPanel7.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, 220, 70));
        jPanel7.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 215, -1));

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane5.setViewportView(txtDiaChi);

        jPanel7.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 236, 210, 90));

        lblHoaDonGiao.setText("null");
        jPanel7.add(lblHoaDonGiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 100, -1));

        lblGiamGiaGiao.setText("0");
        jPanel7.add(lblGiamGiaGiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 70, -1));

        jLabel26.setText("VND");
        jPanel7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, -1, -1));

        lblTongTienCanTra.setText("0");
        jPanel7.add(lblTongTienCanTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 80, -1));

        jLabel37.setText("VND");
        jPanel7.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, -1, -1));

        btnHoaDonShip.setBackground(new java.awt.Color(0, 255, 51));
        btnHoaDonShip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/invoice.png"))); // NOI18N
        btnHoaDonShip.setText("Tạo Hóa Đơn");
        btnHoaDonShip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonShipActionPerformed(evt);
            }
        });
        jPanel7.add(btnHoaDonShip, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

        lblTongTienGiao.setText("0");
        jPanel7.add(lblTongTienGiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 80, -1));

        jLabel27.setText("VND");
        jPanel7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, -1, -1));

        jLabel8.setText("Tên Khách Hàng");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        jPanel7.add(txtTenKh, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 215, -1));

        jTabbedPane1.addTab("ShipCode", jPanel7);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 440, 790));

        btnXoa.setBackground(new java.awt.Color(102, 255, 102));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trash.png"))); // NOI18N
        btnXoa.setText("Xóa ALL");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, -1, -1));

        jLabel22.setBackground(new java.awt.Color(0, 0, 0));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("Sản Phẩm");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, -1, -1));

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("Giỏ Hàng");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        btnXoa1.setBackground(new java.awt.Color(102, 255, 102));
        btnXoa1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trash.png"))); // NOI18N
        btnXoa1.setText("Xóa");
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, 100, -1));

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

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
//        int row = tblHoaDon.getSelectedRow();
//        lblMaHD.setText(tblHoaDon.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa tất cả sản phẩm không ?");
        if (choice == JOptionPane.YES_OPTION) {
            gioHangViewModels.removeAll(gioHangViewModels);
            loadGioHang();
            addhoaDonChiTiet();
            capNhatSoLuongXoaSP();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        DefaultTableModel tblModelGH = new DefaultTableModel();
        tblModelGH = (DefaultTableModel) tblGioHang.getModel();
        tblModelGH.setRowCount(0);
        int row = tblSanPham.getSelectedRow();
        int row1 = tblHoaDon.getSelectedRow();
        if (row1 < 0) {
            MsgBox.alert(this, "Vui lòng chọn hóa đơn chờ\nNếu chưa có vui lòng tạo!");
        } else if (row < 0) {
            MsgBox.alert(this, "Vui lòng chọn sản phẩm trên table!");
        } else {

            String choice = JOptionPane.showInputDialog("Nhập vào số lượng : ", "0");

            if (Integer.parseInt(choice) == 0) {
                loadGioHang();
                return;
            }
            if (Integer.parseInt(choice) > Integer.parseInt(tblSanPham.getValueAt(row, 2).toString())) {
                JOptionPane.showMessageDialog(this, "Đã nhập quá số lượng sản phẩm có trong kho !"
                        + "\n \tVui lòng chọn lại");
                loadGioHang();
                return;
            }
            //Giảm số lượng sản phẩm được chọn
            tblSanPham.setValueAt(Integer.parseInt(tblSanPham.getValueAt(row, 2).toString()) - Integer.parseInt(choice), row, 2);
            String ma = tblSanPham.getValueAt(row, 0).toString();
            String ten = tblSanPham.getValueAt(row, 1).toString();
            long dongia = Long.parseLong(tblSanPham.getValueAt(row, 4).toString());

            GioHangViewModel gh = new GioHangViewModel();
            gh.setMa(ma);
            gh.setTen(ten);
            gh.setDonGia(dongia);
            gh.setSoLuong(Integer.parseInt(choice));

            SanPhamFormBanHangViewModel s = sanPhamFormBanHangServices.soLuong((String) tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 0));
            int soLuong = s.getSoLuong() - Integer.parseInt(choice);
            SanPhamFormBanHangViewModel sp = new SanPhamFormBanHangViewModel();
            sp.setSoLuong(soLuong);
            sanPhamFormBanHangServices.updateSoLuong(sp, s.getId());
            for (GioHangViewModel gioHangViewModel : gioHangViewModels) {
                if (tblSanPham.getValueAt(row, 0).toString().equals(gioHangViewModel.getMa())) {
                    int soluong = gioHangViewModel.getSoLuong() + Integer.parseInt(choice);
                    gioHangViewModel.setSoLuong(soluong);
                    loadGioHang();
                    return;
                }
            }
            gioHangViewModels.add(gh);
            loadGioHang();
            loadTien();
            capNhapTienKhachPhaiTra();
            addhoaDonChiTiet();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        searchByMa();
    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        addHoaDon();
        update();
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked

    }//GEN-LAST:event_tblGioHangMouseClicked

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate

    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

    private void btnHuyDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyDonActionPerformed
        List<HoaDonViewModel> hds = hoaDonServices.getALlhoaDon();
        int index = tblHoaDon.getSelectedRow();
        HoaDonViewModel hoaDon = hds.get(index);
        JOptionPane.showMessageDialog(this, hoaDonServices.huyDon(hoaDon.getId()));
        List<HoaDonViewModel> hd = hoaDonServices.getALlhoaDon();
        loadTableHoaDon(hd);
    }//GEN-LAST:event_btnHuyDonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int id = list.get(tblHoaDon.getSelectedRow()).getId();
        JOptionPane.showMessageDialog(this, hoaDonServices.huyDonShip(id));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnChonKhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonKhachActionPerformed
        KhachHangJframe hangJframe = new view.KhachHangJframe();
        hangJframe.setVisible(true);
    }//GEN-LAST:event_btnChonKhachActionPerformed

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        capNhatTienThuaTraKhach();
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void btnChonKhach1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonKhach1ActionPerformed
        showTTKH();
    }//GEN-LAST:event_btnChonKhach1ActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        try {
            if (lblMaHoaDon.getText().equals("Vui lòng tạo!")) {
                MsgBox.alert(this, "Vui lòng chọn hóa đơn trước khi nhấn thanh toán");
                return;
            } else if (tblGioHang.getRowCount() == 0) {
                MsgBox.alert(this, "Vui lòng chọn sản phẩm trước khi nhấn thanh toán");
                return;
            } else {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                long millis = System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);
                String dateTT = df.format(date);
                List<HoaDonViewModel> hds = hoaDonServices.getALlhoaDon();
                List<hoaDonViewModelHUY> list = hoaViewModelServicesImplHUY.getAllhoaDonViewModelHUY();
                int index = tblHoaDon.getSelectedRow();
                for (int i = 0; i < list.size(); i++) {
                    lblMaHoaDon.setText("HD" + i);
                }
                HoaDonViewModel hoaDon = hds.get(index);
                hoaDon.setMaHdString(lblMaHoaDon.getText());
                hoaDon.setNgayThanhToan(dateTT);
                long tienKhach = XMoney.loaiBoDauCham(lblTienKhachCanTra.getText());
                long tongTien = XMoney.loaiBoDauCham(lblTongTien.getText());
                hoaDon.setTienKhachCanTra(tienKhach);
                hoaDon.setTongTien(tongTien);
                hoaDon.setTrangThai("Đã Thanh Toán");

                long thanhToan = XMoney.loaiBoDauCham(lblTienKhachCanTra.getText());
                long tienKhachDua = XMoney.loaiBoDauCham(txtTienKhachDua.getText().trim());

                if (MsgBox.confirm(this, "Bạn chắc chắn muốn thanh toán hóa đơn này chứ?")) {
                    if (tienKhachDua < thanhToan) {
                        MsgBox.alert(this, "Số tiền khách đưa không đủ để thanh toán");
                        txtTienKhachDua.setBackground(Color.red);
                        return;
                    } else {
                        HoaDonCT ct = new HoaDonCT();
                        ct.setTienThua(XMoney.loaiBoDauCham(lblTienThua.getText()));
                        hoaDonServices.updateHoaDonTienThua(ct, hoaDon.getId());
                        txtTienKhachDua.setBackground(Color.white);
                        MsgBox.alert(this, hoaDonServices.updateHoaDonThanhToan(hoaDon, hoaDon.getId()));
                        xuatHoaDon();
                        lamMoi();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Thanh toán thất bại");
        }
        
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnHoaDonShipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonShipActionPerformed
        addHoaDonShip();
    }//GEN-LAST:event_btnHoaDonShipActionPerformed

    private void btnGiaoHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaoHangActionPerformed
        if (txtDiaChi.getText().isEmpty() || txtGhiChu.getText().isEmpty() || txtTenKh.getText().isEmpty() || txtSDT.getText().isEmpty()) {
            MsgBox.alert(this, "Không Được Để Trống");
        }
        try {
            if (lblMaHoaDon.getText().equals("Vui lòng tạo!")) {
                MsgBox.alert(this, "Vui lòng chọn hóa đơn trước khi nhấn thanh toán");
                return;
            } else if (tblGioHang.getRowCount() == 0) {
                MsgBox.alert(this, "Vui lòng chọn sản phẩm trước khi nhấn thanh toán");
                return;
            } else {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                long millis = System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);
                String dateTT = df.format(date);
                KhachHangViewModel kh = new KhachHangViewModel();
                kh.setHoVaTen(txtTenKh.getText());
                kh.setSoDienThoai(txtSDT.getText());
                kh.setDiaChi(txtDiaChi.getText());
                kmImpl.addKhachHang(kh);
                List<KhachHangViewModel> lisst = new ArrayList<>();
                lisst = kmImpl.id(kh.getHoVaTen());
                List<HoaDonViewModel> hd = hoaDonServices.getALlhoaDon();
                int index = tblHoaDon.getSelectedRow();
                for (int i = 0; i < hd.size(); i++) {
                    lblHoaDonGiao.setText("HD" + i);
                }
                HoaDonViewModel hoaDon = hd.get(index);
                for (int i = 0; i < lisst.size(); i++) {
                    hoaDon.setGetIDKhachHang(lisst.get(i).getId());
                    hoaDon.setMaHdString(lblHoaDonGiao.getText());
                    hoaDon.setNgayGiaohang(dateTT);
                    hoaDon.setTienKhachCanTra(XMoney.loaiBoDauCham(lblTongTienCanTra.getText()));
                    hoaDon.setTongTien(XMoney.loaiBoDauCham(lblTongTienGiao.getText()));
                    hoaDon.setSdt(txtSDT.getText());
                    hoaDon.setTrangThai("Đang Giao Hàng");

                }

                if (MsgBox.confirm(this, "Bạn chắc chắn muốn Giao Hàng hóa đơn này chứ?")) {
                    MsgBox.alert(this, hoaDonServices.updateHoaDonGiaoHang(hoaDon, hoaDon.getId()));
                    xuatHoaDonGiao();
                    loadTableHoaDon(hd);
                    lamMoi();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Thanh toán thất bại");
        }
    }//GEN-LAST:event_btnGiaoHangActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
        int row = tblGioHang.getSelectedRow();
        String soluong = JOptionPane.showInputDialog("Nhập số lượng", "0");
        if (Integer.parseInt(soluong) > Integer.parseInt(tblGioHang.getValueAt(row, 2).toString())) {
            JOptionPane.showMessageDialog(this, "Bạn đã nhập quá số lượng\n Vui lòng nhập lại");
            return;
        } else if (Integer.parseInt(tblGioHang.getValueAt(row, 2).toString()) == Integer.parseInt(soluong)) {
            gioHangViewModels.remove(row);
            loadGioHang();
        } else {
            String ma = tblSanPham.getValueAt(row, 0).toString();
            String ten = tblSanPham.getValueAt(row, 1).toString();
            long dongia = Long.parseLong(tblSanPham.getValueAt(row, 4).toString());

            GioHangViewModel gh = new GioHangViewModel();
            gh.setMa(ma);
            gh.setTen(ten);
            gh.setDonGia(dongia);
            gh.setSoLuong(Integer.parseInt(tblGioHang.getValueAt(row, 2).toString()) - Integer.parseInt(soluong));

            gioHangViewModels.set(row, gh);
            loadGioHang();
            loadTien();
            SanPhamFormBanHangViewModel sp = new SanPhamFormBanHangViewModel();
            SanPhamFormBanHangViewModel s = sanPhamFormBanHangServices.soLuong((String) tblGioHang.getValueAt(tblGioHang.getSelectedRow(), 0));
            int soLuongMoi = (s.getSoLuong() + Integer.parseInt(soluong));
            int id = s.getId();
            sp.setSoLuong(soLuongMoi);
            sanPhamFormBanHangServices.updateSoLuong(sp, id);
            loadSanPham(lst);
            addhoaDonChiTiet();
        }
    }//GEN-LAST:event_btnXoa1ActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSanPhamMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bill;
    private javax.swing.JButton btnChonKhach;
    private javax.swing.JButton btnChonKhach1;
    private javax.swing.JButton btnGiaoHang;
    private javax.swing.JButton btnHoaDonShip;
    private javax.swing.JButton btnHuyDon;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoa1;
    private javax.swing.JComboBox<String> cbbHTTT;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel lblCamera;
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblGiamGiaGiao;
    private javax.swing.JLabel lblHoaDonGiao;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblMaKh;
    private javax.swing.JLabel lblNV;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblTenKh;
    private javax.swing.JLabel lblTienKhachCanTra;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTongTienCanTra;
    private javax.swing.JLabel lblTongTienGiao;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKh;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    public void showTTKH() {
        if (!KhachHangJframe.maKH.equals("KH01")) {
            lblMaKh.setText(KhachHangJframe.maKH);
            lblMaKh.setForeground(Color.black);
            lblTenKh.setText(KhachHangJframe.tenKH);
            lblTenKh.setForeground(Color.black);
        } else {
            lblMaKh.setText(KhachHangJframe.maKH);
            lblMaKh.setForeground(Color.red);
            lblTenKh.setText(KhachHangJframe.tenKH);
            lblTenKh.setForeground(Color.red);
        }
        KhachHangJframe.maKH = null;
        KhachHangJframe.tenKH = null;
        util.MsgBox.alert(this, "Hiện Thị thành công!");

        List<HoaDonViewModel> hds = hoaDonServices.getALlhoaDon();
        List<KhachHang> list = nvImpl.getIDKhachHang(lblTenKh.getText());
        for (int i = 0; i < list.size(); i++) {
            int id = list.get(i).getId();
            HoaDon hd = new HoaDon();
            hd.setIdKhachHang(id);
            for (int j = 0; j < hds.size(); j++) {
                hoaDonServices.updateIDKhachHang(hd, hds.get(j).getId());
            }

        }
    }

    private void loadSanPham(List<SanPhamFormBanHangViewModel> lst) {
        dtmSanPham.setRowCount(0);
        int i = 1;
        for (SanPhamFormBanHangViewModel spp : lst) {
            if (spp.getSoLuong() > 0) {
                dtmSanPham.addRow(spp.toDataRow());
            }
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
                spp.getGiamGia(),
                spp.getGiaBan(),
                spp.getXuatXu()
            });
        }
    }

    private void loadGioHang() {

        dtmGiohang = (DefaultTableModel) tblGioHang.getModel();
        dtmGiohang.setRowCount(0);
        List<GioHangViewModel> gh = gioHangViewModels;
        for (viewmodel.GioHangViewModel gioHangViewModel : gh) {
            dtmGiohang.addRow(gioHangViewModel.toDataRow());
        }

    }

    private void addHoaDon() {
        HoaDonViewModel hoaDon = new HoaDonViewModel();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String dateTT = df.format(date);

        hoaDon.setMaHdString("...");
        hoaDon.setNgayTao(dateTT);
        hoaDon.setTienKhachCanTra(Long.parseLong(lblTienKhachCanTra.getText()));
        hoaDon.setTongTien(Long.parseLong(lblTongTien.getText()));
        hoaDon.setTrangThai("Chờ Thanh Toán");

        JOptionPane.showMessageDialog(this, hoaDonServices.addHoaDon(hoaDon));
        List<HoaDonViewModel> hds = hoaDonServices.getALlhoaDon();
        loadTableHoaDon(hds);
    }

    private void addHoaDonShip() {
        HoaDonViewModel hoaDon = new HoaDonViewModel();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String dateTT = df.format(date);

        hoaDon.setMaHdString("...");
        hoaDon.setNgayTao(dateTT);
        hoaDon.setTienKhachCanTra(Long.parseLong(lblTienKhachCanTra.getText()));
        hoaDon.setTongTien(Long.parseLong(lblTongTien.getText()));
        hoaDon.setTrangThai("Chờ Giao Hàng");

        JOptionPane.showMessageDialog(this, hoaDonServices.addHoaDon(hoaDon));

        List<HoaDonViewModel> hds = hoaDonServices.getALlhoaDon();
        loadTableHoaDon(hds);
        // update id nhân viên vào hóa đơn
        List<NhanVien> list = nvImpl.getIDNhanVien(lblNV.getText());
        for (int i = 0; i < list.size(); i++) {
            int id = list.get(i).getId();
            HoaDon hd = new HoaDon();
            hd.setIdNhanVien(id);
            for (int j = 0; j < hds.size(); j++) {
                hoaDonServices.updateIDNhanVien(hd, hds.get(j).getId());
            }
        }
        // update id hình thức giao hàng vào hóa đơn
        List<HinhThucGiaoHang> gh = nvImpl.getIDGiaoHang();
        for (int i = 0; i < gh.size(); i++) {
            int idGh = gh.get(i).getId();
            HoaDon hdGh = new HoaDon();
            hdGh.setIdHinhThucGH(idGh);
            for (int j = 0; j < hds.size(); j++) {
                hoaDonServices.updateIDGiaoHang(hdGh, hds.get(j).getId());
            }
        }
        // update id hình thức thanh toán vào hóa đơn
        List<HinhThucThanhToan> listTT = nvImpl.getIDThanhToan();
        for (int i = 0; i < listTT.size(); i++) {
            int idTT = listTT.get(i).getId();
            HoaDon hdTT = new HoaDon();
            hdTT.setIdHinhThucTT(idTT);
            for (int j = 0; j < hds.size(); j++) {
                hoaDonServices.updateIDThanhToan(hdTT, hds.get(j).getId());
            }
        }
    }

    private void loadTableHoaDon(List<HoaDonViewModel> hd) {
        dtbHoaDon.setRowCount(0);
        for (HoaDonViewModel hoaDonViewModel : hd) {
            dtbHoaDon.addRow(hoaDonViewModel.toDataRow());
        }
    }

    private void loadTien() {
        long tongTien = 0;
        long tien = 0;
        long giamGia = 0;
        for (int i = 0; i < tblGioHang.getRowCount(); i++) {
            tien = Long.valueOf(tblGioHang.getValueAt(i, 3).toString());
            long soLuong = (int) tblGioHang.getValueAt(i, 2);
            tongTien += (soLuong * tien);
            KhuyenMaiBanHang km = km1.getALL(tblGioHang.getValueAt(i, 0).toString());
            if (km == null) {
                giamGia += 0;
            } else {
                if (km.getHinhThucString().equalsIgnoreCase("Giảm Giá %")) {
                    float giaTriKM = km.getGiamGia();
                    giaTriKM = giaTriKM / 100;
                    float giatriGiam = giaTriKM * soLuong;
                    giamGia += (tien * giatriGiam);
                } else {
                    giamGia += (km.getGiamGia() * soLuong);
                }
            }
        }
        lblTongTienGiao.setText(util.XMoney.themDauCham(tongTien));
        lblTongTien.setText(util.XMoney.themDauCham(tongTien));
        lblGiamGia.setText(util.XMoney.themDauCham(giamGia));
        lblGiamGiaGiao.setText(util.XMoney.themDauCham(giamGia));
    }

    public void capNhatTienThuaTraKhach() {
        if (txtTienKhachDua.getText().trim().equals("")) {
            lblTienThua.setText("0");
            return;
        } else {
            try {
                long tienKhachDuaFormated = util.XMoney.loaiBoDauCham(txtTienKhachDua.getText().trim());
                txtTienKhachDua.setText(util.XMoney.themDauCham(tienKhachDuaFormated));

                long thanhToan = util.XMoney.loaiBoDauCham(lblTienKhachCanTra.getText());
                long tienKhachDua = util.XMoney.loaiBoDauCham(txtTienKhachDua.getText().trim());
                long tienThuTraKhach = tienKhachDua - thanhToan;
                lblTienThua.setText(util.XMoney.themDauCham(tienThuTraKhach));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void capNhapTienKhachPhaiTra() {
        long thanhToan = util.XMoney.loaiBoDauCham(lblTongTien.getText());
        long giamGia = util.XMoney.loaiBoDauCham(lblGiamGia.getText().trim());
        long tienKhachCanTra = thanhToan - giamGia;
        lblTienKhachCanTra.setText(util.XMoney.themDauCham(tienKhachCanTra));

        long thanhToanGiaohang = util.XMoney.loaiBoDauCham(lblTongTienGiao.getText());
        long giamGiaGiaohang = util.XMoney.loaiBoDauCham(lblGiamGiaGiao.getText().trim());
        long tienKhachCanTraGiao = thanhToanGiaohang - giamGiaGiaohang;
        lblTongTienCanTra.setText(util.XMoney.themDauCham(tienKhachCanTraGiao));
    }

    public void lamMoi() {
        dtbHoaDon.setRowCount(0);
        lblMaHoaDon.setText("null");
        lblTongTien.setText("0");
        lblGiamGia.setText("0");
        lblTienKhachCanTra.setText("0");
        txtTienKhachDua.setText("0");
        lblMaKh.setText("");
        lblTenKh.setText("");
        lblTienThua.setText("");
        bill.setText("");
        dtmGiohang.setRowCount(0);
        txtTenKh.setText("");
        txtSDT.setText("");
        txtDiaChi.setText("");
        lblTongTienGiao.setText("0");
        lblGiamGiaGiao.setText("0");
        lblTienKhachCanTra.setText("0");
        txtGhiChu.setText("");
    }

    private void update() {
        List<HoaDonViewModel> hds = hoaDonServices.getALlhoaDon();
        // update id nhân viên vào hóa đơn
        List<NhanVien> list = nvImpl.getIDNhanVien(lblNhanVien.getText());
        for (int i = 0; i < list.size(); i++) {
            int id = list.get(i).getId();
            HoaDon hd = new HoaDon();
            hd.setIdNhanVien(id);
            for (int j = 0; j < hds.size(); j++) {
                hoaDonServices.updateIDNhanVien(hd, hds.get(j).getId());
            }
        }
        // update id hình thức giao hàng vào hóa đơn
        List<HinhThucGiaoHang> gh = nvImpl.getIDGiaoHang();
        for (int i = 0; i < gh.size(); i++) {
            int idGh = gh.get(i).getId();
            HoaDon hdGh = new HoaDon();
            hdGh.setIdHinhThucGH(idGh);
            for (int j = 0; j < hds.size(); j++) {
                hoaDonServices.updateIDGiaoHang(hdGh, hds.get(j).getId());
            }
        }
        // update id hình thức thanh toán vào hóa đơn
        List<HinhThucThanhToan> listTT = nvImpl.getIDThanhToan();
        for (int i = 0; i < listTT.size(); i++) {
            int idTT = listTT.get(i).getId();
            HoaDon hdTT = new HoaDon();
            hdTT.setIdHinhThucTT(idTT);
            for (int j = 0; j < hds.size(); j++) {
                hoaDonServices.updateIDThanhToan(hdTT, hds.get(j).getId());
            }
        }

    }

    private void addhoaDonChiTiet() {
        List<HoaDonViewModel> hds = hoaDonServices.getALlhoaDon();
        HoaDonCT ct = hoaDonServices.getIDSP(tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 0).toString());
        HoaDonCT hdCt = new HoaDonCT();
        for (int i = 0; i < tblGioHang.getRowCount(); i++) {
            hdCt.setSoLuong((int) tblGioHang.getValueAt(i, 2));
        }
        hdCt.setIdSP(ct.getIdSP());
        hdCt.setIdHoaDon(hds.get(tblHoaDon.getSelectedRow()).getId());
        hdCt.setTienThua(XMoney.loaiBoDauCham(lblTienThua.getText()));
        hdCt.setDonGia((long) tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 4));
        hdCt.setTienGiamGia(XMoney.loaiBoDauCham(lblTienKhachCanTra.getText()));
        hoaDonServices.addHoaDonCT(hdCt);
    }

    public void capNhatSoLuongXoaSP() {
        SanPhamFormBanHangViewModel sp = new SanPhamFormBanHangViewModel();
        for (int i = 0; i < tblGioHang.getRowCount(); i++) {
            SanPhamFormBanHangViewModel s = sanPhamFormBanHangServices.soLuong((String) tblGioHang.getValueAt(i, 0));
            int soLuongMoi = (s.getSoLuong() + Integer.parseInt(tblGioHang.getValueAt(i, 2) + ""));
            int id = s.getId();
            sp.setSoLuong(soLuongMoi);
            sanPhamFormBanHangServices.updateSoLuong(sp, id);
        }
        loadSanPham(lst);
    }

    public void xuatHoaDon() {
        try {
            XWPFDocument document = new XWPFDocument();
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\ASUS\\OneDrive\\Documents\\PhanMemBanDienThoai\\XuatHoaDon" + lblMaHoaDon.getText() + ".docx"));

            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            run.setText("SmartPhonePoly");
            run.setFontSize(20);
            run.setBold(true);

            XWPFParagraph paragraph2 = document.createParagraph();
            XWPFRun run2 = paragraph2.createRun();
            paragraph2.setAlignment(ParagraphAlignment.CENTER);
            run2.setText("ĐC: Phố Trịnh Văn Bô, Xuân Phương, Nam Từ Liêm, Hà Nội");

            XWPFParagraph paragraph3 = document.createParagraph();
            XWPFRun run3 = paragraph3.createRun();
            paragraph3.setAlignment(ParagraphAlignment.CENTER);
            run3.setText("ĐT: 0971066455");
            run3.setTextPosition(50);

            XWPFParagraph paragraph4 = document.createParagraph();
            XWPFRun run4 = paragraph4.createRun();
            paragraph4.setAlignment(ParagraphAlignment.CENTER);
            run4.setText("HÓA ĐƠN BÁN HÀNG");
            run4.setFontSize(30);
            run4.setBold(true);

            XWPFParagraph paragraph6 = document.createParagraph();
            XWPFRun run6 = paragraph6.createRun();
            run6.setText("Khách hàng: " + lblTenKh.getText());

            XWPFParagraph paragraph9 = document.createParagraph();
            XWPFRun run9 = paragraph9.createRun();
            run9.setText("Ngày lập: " + tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 2).toString());
            run9.setTextPosition(20);

            XWPFTable table = document.createTable(tblGioHang.getRowCount() + 2, 5);
            table.setWidth("100%");

            XWPFTableRow row = table.getRow(0);
            XWPFParagraph paragraph10 = row.getCell(0).addParagraph();
            paragraph10.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run10 = paragraph10.createRun();
            run10.setText("Mã sản phẩm");
            run10.setBold(true);
            run10.setTextPosition(20);

            XWPFTableRow row2 = table.getRow(0);
            XWPFParagraph paragraph11 = row.getCell(1).addParagraph();
            paragraph11.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run11 = paragraph11.createRun();
            run11.setText("Tên sản phẩm");
            run11.setBold(true);
            run11.setTextPosition(20);

            XWPFTableRow row3 = table.getRow(0);
            XWPFParagraph paragraph12 = row.getCell(2).addParagraph();
            paragraph12.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run12 = paragraph12.createRun();
            run12.setText("Số lượng");
            run12.setBold(true);
            run12.setTextPosition(20);

            XWPFTableRow row4 = table.getRow(0);
            XWPFParagraph paragraph13 = row.getCell(3).addParagraph();
            paragraph13.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run13 = paragraph13.createRun();
            run13.setText("Đơn giá");
            run13.setBold(true);
            run13.setTextPosition(20);

            XWPFTableRow row5 = table.getRow(0);
            XWPFParagraph paragraph14 = row.getCell(4).addParagraph();
            paragraph14.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run14 = paragraph14.createRun();
            run14.setText("Thành tiền");
            run14.setBold(true);
            run14.setTextPosition(20);

            for (int i = 0; i < tblGioHang.getRowCount(); i++) {
                table.getRow(i + 1).getCell(0).setText(tblGioHang.getValueAt(i, 0).toString());
                table.getRow(i + 1).getCell(1).setText(tblGioHang.getValueAt(i, 1).toString());
                table.getRow(i + 1).getCell(2).setText(tblGioHang.getValueAt(i, 2).toString());
                table.getRow(i + 1).getCell(3).setText(XMoney.themDauCham((long) tblGioHang.getValueAt(i, 3)));
                table.getRow(i + 1).getCell(4).setText(XMoney.themDauCham(XMoney.loaiBoVND(tblGioHang.getValueAt(i, 3) + "") * Integer.parseInt(tblGioHang.getValueAt(i, 2) + "")) + " VNĐ");
            }

            int tongSL = 0;
            for (int i = 0; i < tblGioHang.getRowCount(); i++) {
                tongSL += Integer.parseInt(tblGioHang.getValueAt(i, 2) + "");
            }

            table.getRow(tblGioHang.getRowCount() + 1).getCell(0).setText("TỔNG");
            table.getRow(tblGioHang.getRowCount() + 1).getCell(1).setText("");
            table.getRow(tblGioHang.getRowCount() + 1).getCell(2).setText(tongSL + "");
            table.getRow(tblGioHang.getRowCount() + 1).getCell(3).setText("");
            table.getRow(tblGioHang.getRowCount() + 1).getCell(4).setText(lblTienKhachCanTra.getText() + " VNĐ");

            XWPFParagraph paragraph22 = document.createParagraph();
            paragraph22.setAlignment(ParagraphAlignment.LEFT);

            XWPFParagraph paragraph21 = document.createParagraph();
            paragraph21.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun run21 = paragraph21.createRun();
            run21.setText("GIẢM GIÁ: " + lblGiamGia.getText() + " VNĐ");
            run21.setBold(true);

            XWPFParagraph paragraph15 = document.createParagraph();
            paragraph15.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun run20 = paragraph15.createRun();
            run20.setText("TỔNG TIỀN THANH TOÁN: " + lblTienKhachCanTra.getText() + " VNĐ");
            run20.setBold(true);

            XWPFParagraph paragraph24 = document.createParagraph();
            paragraph24.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun run24 = paragraph24.createRun();
            run24.setText(cbbHTTT.getSelectedItem() + ": " + txtTienKhachDua.getText() + " VNĐ");

            XWPFParagraph paragraph25 = document.createParagraph();
            paragraph25.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun run25 = paragraph25.createRun();
            run25.setText("Tiền trả lại: " + lblTienThua.getText() + " VNĐ");

            XWPFParagraph paragraph23 = document.createParagraph();
            paragraph23.setAlignment(ParagraphAlignment.RIGHT);
            XWPFRun run23 = paragraph23.createRun();
            run23.setText("------------------------------------------------------------------------------------------------------------------------------------------");

            XWPFParagraph paragraph16 = document.createParagraph();
            paragraph16.setAlignment(ParagraphAlignment.RIGHT);
            XWPFRun run16 = paragraph16.createRun();
            run16.setText("Người lập hóa đơn");
            run16.setBold(true);
            run16.setFontSize(15);

            XWPFParagraph paragraph17 = document.createParagraph();
            paragraph17.setAlignment(ParagraphAlignment.RIGHT);
            XWPFRun run17 = paragraph17.createRun();
            run17.setText(lblNV.getText());
            run17.setTextPosition(80);

            XWPFParagraph paragraph18 = document.createParagraph();
            paragraph18.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run18 = paragraph18.createRun();
            run18.setText("Cảm ơn quý khách đã mua hàng!");

            XWPFParagraph paragraph19 = document.createParagraph();
            paragraph19.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run19 = paragraph19.createRun();
            run19.setText("Hẹn gặp lại!");

            document.write(out);
            out.close();
            document.close();

            System.out.println("Thành công");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
     public void xuatHoaDonGiao() {
        try {
            XWPFDocument document = new XWPFDocument();
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\ASUS\\OneDrive\\Documents\\PhanMemBanDienThoai\\XuatHoaDon" + lblMaHoaDon.getText() + ".docx"));

            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            run.setText("SmartPhonePoly");
            run.setFontSize(20);
            run.setBold(true);

            XWPFParagraph paragraph2 = document.createParagraph();
            XWPFRun run2 = paragraph2.createRun();
            paragraph2.setAlignment(ParagraphAlignment.CENTER);
            run2.setText("ĐC: Phố Trịnh Văn Bô, Xuân Phương, Nam Từ Liêm, Hà Nội");

            XWPFParagraph paragraph3 = document.createParagraph();
            XWPFRun run3 = paragraph3.createRun();
            paragraph3.setAlignment(ParagraphAlignment.CENTER);
            run3.setText("ĐT: 0971066455");
            run3.setTextPosition(50);

            XWPFParagraph paragraph4 = document.createParagraph();
            XWPFRun run4 = paragraph4.createRun();
            paragraph4.setAlignment(ParagraphAlignment.CENTER);
            run4.setText("HÓA ĐƠN BÁN HÀNG");
            run4.setFontSize(30);
            run4.setBold(true);

            XWPFParagraph paragraph6 = document.createParagraph();
            XWPFRun run6 = paragraph6.createRun();
            run6.setText("Khách hàng: " + txtTenKh.getText());
            
            XWPFParagraph paragraph7 = document.createParagraph();
            XWPFRun run7 = paragraph6.createRun();
            run6.setText("SDT Khách Hàng: " + txtSDT.getText());

            XWPFParagraph paragraph9 = document.createParagraph();
            XWPFRun run9 = paragraph9.createRun();
            run9.setText("Ngày lập: " + tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 2).toString());
            run9.setTextPosition(20);

            XWPFTable table = document.createTable(tblGioHang.getRowCount() + 2, 5);
            table.setWidth("100%");

            XWPFTableRow row = table.getRow(0);
            XWPFParagraph paragraph10 = row.getCell(0).addParagraph();
            paragraph10.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run10 = paragraph10.createRun();
            run10.setText("Mã sản phẩm");
            run10.setBold(true);
            run10.setTextPosition(20);

            XWPFTableRow row2 = table.getRow(0);
            XWPFParagraph paragraph11 = row.getCell(1).addParagraph();
            paragraph11.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run11 = paragraph11.createRun();
            run11.setText("Tên sản phẩm");
            run11.setBold(true);
            run11.setTextPosition(20);

            XWPFTableRow row3 = table.getRow(0);
            XWPFParagraph paragraph12 = row.getCell(2).addParagraph();
            paragraph12.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run12 = paragraph12.createRun();
            run12.setText("Số lượng");
            run12.setBold(true);
            run12.setTextPosition(20);

            XWPFTableRow row4 = table.getRow(0);
            XWPFParagraph paragraph13 = row.getCell(3).addParagraph();
            paragraph13.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run13 = paragraph13.createRun();
            run13.setText("Đơn giá");
            run13.setBold(true);
            run13.setTextPosition(20);

            XWPFTableRow row5 = table.getRow(0);
            XWPFParagraph paragraph14 = row.getCell(4).addParagraph();
            paragraph14.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run14 = paragraph14.createRun();
            run14.setText("Thành tiền");
            run14.setBold(true);
            run14.setTextPosition(20);

            for (int i = 0; i < tblGioHang.getRowCount(); i++) {
                table.getRow(i + 1).getCell(0).setText(tblGioHang.getValueAt(i, 0).toString());
                table.getRow(i + 1).getCell(1).setText(tblGioHang.getValueAt(i, 1).toString());
                table.getRow(i + 1).getCell(2).setText(tblGioHang.getValueAt(i, 2).toString());
                table.getRow(i + 1).getCell(3).setText(XMoney.themDauCham((long) tblGioHang.getValueAt(i, 3)));
                table.getRow(i + 1).getCell(4).setText(XMoney.themDauCham(XMoney.loaiBoVND(tblGioHang.getValueAt(i, 3) + "") * Integer.parseInt(tblGioHang.getValueAt(i, 2) + "")) + " VNĐ");
            }

            int tongSL = 0;
            for (int i = 0; i < tblGioHang.getRowCount(); i++) {
                tongSL += Integer.parseInt(tblGioHang.getValueAt(i, 2) + "");
            }

            table.getRow(tblGioHang.getRowCount() + 1).getCell(0).setText("TỔNG");
            table.getRow(tblGioHang.getRowCount() + 1).getCell(1).setText("");
            table.getRow(tblGioHang.getRowCount() + 1).getCell(2).setText(tongSL + "");
            table.getRow(tblGioHang.getRowCount() + 1).getCell(3).setText("");
            table.getRow(tblGioHang.getRowCount() + 1).getCell(4).setText(lblTongTienCanTra.getText() + " VNĐ");

            XWPFParagraph paragraph22 = document.createParagraph();
            paragraph22.setAlignment(ParagraphAlignment.LEFT);

            XWPFParagraph paragraph21 = document.createParagraph();
            paragraph21.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun run21 = paragraph21.createRun();
            run21.setText("GIẢM GIÁ: " + lblGiamGiaGiao.getText() + " VNĐ");
            run21.setBold(true);

            XWPFParagraph paragraph15 = document.createParagraph();
            paragraph15.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun run20 = paragraph15.createRun();
            run20.setText("TỔNG TIỀN THANH TOÁN: " + lblTongTienCanTra.getText() + " VNĐ");
            run20.setBold(true);

            XWPFParagraph paragraph24 = document.createParagraph();
            paragraph24.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun run24 = paragraph24.createRun();
            run24.setText(cbbHTTT.getSelectedItem() + ": " + lblTongTienCanTra.getText() + " VNĐ");
            

            XWPFParagraph paragraph23 = document.createParagraph();
            paragraph23.setAlignment(ParagraphAlignment.RIGHT);
            XWPFRun run23 = paragraph23.createRun();
            run23.setText("------------------------------------------------------------------------------------------------------------------------------------------");

            XWPFParagraph paragraph16 = document.createParagraph();
            paragraph16.setAlignment(ParagraphAlignment.RIGHT);
            XWPFRun run16 = paragraph16.createRun();
            run16.setText("Người lập hóa đơn");
            run16.setBold(true);
            run16.setFontSize(15);

            XWPFParagraph paragraph17 = document.createParagraph();
            paragraph17.setAlignment(ParagraphAlignment.RIGHT);
            XWPFRun run17 = paragraph17.createRun();
            run17.setText(lblNV.getText());
            run17.setTextPosition(80);

            XWPFParagraph paragraph18 = document.createParagraph();
            paragraph18.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run18 = paragraph18.createRun();
            run18.setText("Cảm ơn quý khách đã mua hàng!");

            XWPFParagraph paragraph19 = document.createParagraph();
            paragraph19.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run19 = paragraph19.createRun();
            run19.setText("Hẹn gặp lại!");

            document.write(out);
            out.close();
            document.close();

            System.out.println("Thành công");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
