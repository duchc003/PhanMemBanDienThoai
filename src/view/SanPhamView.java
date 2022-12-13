package view;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.ChiTietSP;
import model.HangSP;
import model.HinhThucKhuyenMai;
import model.Imei;
import model.KhuyenMai;
import model.NhaCungCap;
import model.SanPham;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.HangSPService;
import service.NhaCungCapService;
import service.impl.ChiTietSpImpl;
import service.impl.HangSPImpl;
import service.impl.ImeiServiceImpl;
import service.impl.NhaCungCapImpl;
import service.impl.SanPhamHetHangServiceImpl;
import service.impl.SanPhamImpl;
import util.MsgBox;
import viewmodel.ChiTietSPView;
import viewmodel.HangSPViewmodel;
import viewmodel.NhaCungCapViewModel;
import viewmodel.SanPhamHetHang;
import viewmodel.SanPhamViewModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import viewmodel.KhuyenMaiViewModel;

/**
 *
 * @author ASUS
 */
public class SanPhamView extends javax.swing.JInternalFrame {

    private List<SanPhamHetHang> spHetHang = new ArrayList<>();
    private List<SanPhamViewModel> Spview = new ArrayList<>();
    private List<HangSPViewmodel> lists = new ArrayList<>();
    private List<SanPham> listSp = new ArrayList<>();
    private ImeiServiceImpl imeiImpl = new ImeiServiceImpl();
    private List<NhaCungCap> listNCC = new ArrayList<>();
    private List<NhaCungCapViewModel> listncc = new ArrayList<>();
    private List<ChiTietSPView> listCt = new ArrayList<>();
    private SanPhamHetHangServiceImpl implHetHang = new SanPhamHetHangServiceImpl();
    private HangSPService hsps = new HangSPImpl();
    private SanPhamImpl SP = new SanPhamImpl();
    private NhaCungCapService nccs = new NhaCungCapImpl();
    private DefaultTableModel dtmHangSP = new DefaultTableModel();
    private DefaultTableModel dtmNcc = new DefaultTableModel();
    private DefaultTableModel dtmPk = new DefaultTableModel();
    private DefaultTableModel dtmCT = new DefaultTableModel();
    private DefaultTableModel dtmIMei = new DefaultTableModel();
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultTableModel dtmHetHang = new DefaultTableModel();
    private DefaultComboBoxModel box11 = new DefaultComboBoxModel();
    private DefaultComboBoxModel box22 = new DefaultComboBoxModel();
    private DefaultComboBoxModel box1 = new DefaultComboBoxModel();
    private DefaultComboBoxModel box2 = new DefaultComboBoxModel();
    private DefaultComboBoxModel box3 = new DefaultComboBoxModel();
    private ChiTietSpImpl impl = new ChiTietSpImpl();
    String duongDanAnh = "";
    int row = -1;

    public SanPhamView() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //1 hãng
        tblHangSP.setModel(dtmHangSP);
        Object[] tieuDe = {"ID", "Mã Hãng", "Tên Hãng"};
        dtmHangSP.setColumnIdentifiers(tieuDe);
        lists = hsps.getAll();
        hienThiTable(lists);

        //3 nhà cung cấp
        tblNhaCungCap.setModel(dtmNcc);
        Object[] tieuDeNcc = {"ID", "Mã Nhà Cung Cấp", "Tên nhà cung cấp", "Số điện thoại"};
        dtmNcc.setColumnIdentifiers(tieuDeNcc);
        listncc = nccs.getAll();
        hienThiTableNcc(listncc);
        //4 chi tiết sp
        tblCt1.setModel(dtmCT);
        dtmCT.setColumnIdentifiers(new Object[]{"Id", "Sản Phẩm", "Nhà Cung Cấp", "Khuến mãi", "Số Lượng", "Ram", "Xuất Xứ", "Camera", "Màn Hình", "Bộ Nhớ", "Màu Sắc", "Giá Nhập", "Giá Bán", "Image", "BarCode", "Trạng Thái", "Mô tả"});
        listCt = impl.getALL();
        fillCt(listCt);
        //5 sản phẩm
        tblSanPham.setModel(dtm);
        Object[] SanPham = {"ID", "ID Hãng", "Mã SP", "Tên SP"};
        dtm.setColumnIdentifiers(SanPham);
        showDataTable(SP.getAll());
        // cbb chitietsp
        cbbNCC.setModel(box11);
        getID(impl.getALLSP());
        cbbSanPham.setModel(box22);
        getIDNCC(impl.getALLNCC());
        //cbb sản phẩm
        cbbHang.setModel(box3);
        cbbHang(SP.getID());
        cbbKm.setModel(box2);
        cbbKM(SP.getALLHT());

        tblHetHang.setModel(dtmHetHang);
        dtmHetHang.setColumnIdentifiers(new Object[]{"ID", "Mã", "Tên Sản Phẩm", "Số Lượng", "Ram", "Xuất Xứ", "Camera", "Màn Hình", "Bộ Nhớ", "Màu Sắc", "Trạng Thái"});
        spHetHang = implHetHang.getALL();
        showTTableHetHang(spHetHang);
        tblTable.setModel(dtmIMei);
        dtmIMei.setRowCount(0);
        dtmIMei.setColumnIdentifiers(new Object[]{"Imei"});

    }

    private void cbbKM(List<HinhThucKhuyenMai> list) {
        for (HinhThucKhuyenMai khuyenMai : list) {
            box2.addElement(khuyenMai.getTen());
        }
    }

    private void showTTableHetHang(List<SanPhamHetHang> list) {
        dtmHetHang.setRowCount(0);
        for (SanPhamHetHang sanPhamHetHang : list) {
            dtmHetHang.addRow(sanPhamHetHang.toDataRow());
        }
    }

    private void showDataTable(List<SanPhamViewModel> lists) {
        dtm.setRowCount(0);
        for (SanPhamViewModel sv : lists) {
            dtm.addRow(sv.todataRow());
        }
    }

    private void cbbHang(List<HangSP> list) {
        for (HangSP hangSP : list) {
            box3.addElement(hangSP.getId());
        }
    }

    private void getID(List<SanPham> list) {
        for (SanPham sanPham : list) {
            box22.addElement(sanPham.getTen());
        }
    }

    private void getIDNCC(List<NhaCungCap> list) {
        for (NhaCungCap nhaCungCap : list) {
            box11.addElement(nhaCungCap.getTen());
        }
    }

    private void fillCt(List<ChiTietSPView> listChiTietSPViews) {
        dtmCT.setRowCount(0);
        for (ChiTietSPView listChiTietSPView : listChiTietSPViews) {
            dtmCT.addRow(listChiTietSPView.toDataRow());
        }
    }

    private void hienThiTable(List<HangSPViewmodel> list) {
        dtmHangSP.setRowCount(0);
        for (HangSPViewmodel x : list) {
            dtmHangSP.addRow(x.toRowData());
        }
    }

    private void fillData(int index) {
        HangSPViewmodel h = lists.get(index);
        txtMaHangSp.setText(h.getMa());
        txtTenHangSp.setText(h.getTen());
        txtIdHangSp.setText(h.getId() + "");
    }

    private void clear() {
        txtIdHangSp.setText("");
        txtMaHangSp.setText("");
        txtTenHangSp.setText("");
    }

    public HangSPViewmodel add() {
        String ma = txtMaHangSp.getText();
        String ten = txtTenHangSp.getText();
        HangSPViewmodel h = new HangSPViewmodel(ma, ten);
        return h;
    }

    //3
    private void hienThiTableNcc(List<NhaCungCapViewModel> list2) {
        dtmNcc.setRowCount(0);
        for (NhaCungCapViewModel x : list2) {
            dtmNcc.addRow(x.toRowDataNcc());
        }
    }

    private void fillDataNcc(int index) {
        NhaCungCapViewModel h = listncc.get(index);
        txtMaNhaCungCap.setText(h.getMa());
        txtTenNhaCungCap.setText(h.getTen());
        txtIdNhaCungCap.setText(h.getId() + "");
        txtSDT.setText(h.getSdt());
    }

    private void clearNcc() {
        txtIdNhaCungCap.setText("");
        txtMaNhaCungCap.setText("");
        txtTenNhaCungCap.setText("");
    }

    public NhaCungCapViewModel addNcc() {
        String ma = txtMaNhaCungCap.getText();
        String ten = txtTenNhaCungCap.getText();
        String sdt = txtSDT.getText();
        NhaCungCapViewModel ncc = new NhaCungCapViewModel(ma, ten, sdt);
        return ncc;
    }

    private void setData(int index) {
        NhaCungCap ncc = impl.getOneNCCID((int) tblCt1.getValueAt(tblCt1.getSelectedRow(), 2));
        SanPham sp = impl.getOneSPID((int) tblCt1.getValueAt(tblCt1.getSelectedRow(), 1));
        List<Imei> imei = imeiImpl.getALLID(sp.getId());
        for (Imei imei1 : imei) {
            dtmIMei.addRow(new Object[] {imei1.getMaImei()});
        }
        ChiTietSPView ct = listCt.get(index);
        txtID.setText(String.valueOf(ct.getId()));
        cbbSanPham.setSelectedItem(sp.getTen());
        cbbNCC.setSelectedItem(ncc.getTen());
        txtSoLuong.setText(String.valueOf(ct.getSoLuong()));
        cbbRam.setSelectedItem(ct.getRam());
        cbbCamera.setSelectedItem(ct.getCamera());
        cbbManHinh.setSelectedItem(ct.getManHinh());
        txtGiaBan.setText(String.valueOf(ct.getGiaBan()));
        cbbMauSac.setSelectedItem(ct.getMauSac());
        txtGiaNhap.setText(String.valueOf(ct.getGiaNhap()));
        txtBarCode.setText(ct.getBarcode());
        cbbXuatXu.setSelectedItem(ct.getXuatXu());
        cbbBoNho.setSelectedItem(ct.getBoNho());
        txtMoTa.setText(ct.getMoTa());
        lblAnh.setIcon(reSizeImage(String.valueOf(listCt.get(index).getImage())));
    }

    private ChiTietSP getDataSp() {
        NhaCungCap ncc = SP.getOneNCC((String) cbbNCC.getSelectedItem());
        KhuyenMaiViewModel km = SP.getOneKm((String) cbbKm.getSelectedItem());
        SanPham sp = SP.getOneSP((String) cbbSanPham.getSelectedItem());
        String imgName = duongDanAnh;
        return new ChiTietSP(
                sp.getId(),
                ncc.getId(),
                km.getId(),
                Integer.parseInt(txtSoLuong.getText()),
                (String) cbbRam.getSelectedItem(),
                (String) cbbXuatXu.getSelectedItem(),
                (String) cbbCamera.getSelectedItem(),
                (String) cbbManHinh.getSelectedItem(),
                (String) cbbBoNho.getSelectedItem(),
                (String) cbbMauSac.getSelectedItem(),
                Float.parseFloat(txtGiaNhap.getText()),
                Float.parseFloat(txtGiaBan.getText()),
                imgName,
                txtBarCode.getText(),
                "Còn Hàng",
                txtMoTa.getText());
    }

    private void fillDataa(int index) {
        SanPhamViewModel nv = SP.getAll().get(index);
        txtIDSanPHam.setText(String.valueOf(nv.getId()));
        txtMASANPHAM.setText(nv.getMa());
        txtTENSANPHAM.setText(nv.getTen());
        cbbHang.setSelectedItem(nv.getIdHang());
    }

    private SanPham getDataSanPham() {
        return new SanPham(
                (int) cbbHang.getSelectedItem(),
                txtMASANPHAM.getText(),
                txtTENSANPHAM.getText());
    }

    private SanPham getDataSanPhamUD() {
        return new SanPham(
                txtMASANPHAM.getText(),
                txtTENSANPHAM.getText());
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        txtMASANPHAM = new javax.swing.JTextField();
        txtIDSanPHam = new javax.swing.JTextField();
        txtTENSANPHAM = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbbHang = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        txtMaHangSp = new javax.swing.JTextField();
        txtIdHangSp = new javax.swing.JTextField();
        txtTenHangSp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHangSP = new javax.swing.JTable();
        btnClear = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        txtMaNhaCungCap = new javax.swing.JTextField();
        txtIdNhaCungCap = new javax.swing.JTextField();
        txtTenNhaCungCap = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblNhaCungCap = new javax.swing.JTable();
        jButton16 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        cbbNCC = new javax.swing.JComboBox<>();
        cbbSanPham = new javax.swing.JComboBox<>();
        txtGiaNhap = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cbbXuatXu = new javax.swing.JComboBox<>();
        cbbMauSac = new javax.swing.JComboBox<>();
        cbbManHinh = new javax.swing.JComboBox<>();
        cbbRam = new javax.swing.JComboBox<>();
        cbbBoNho = new javax.swing.JComboBox<>();
        cbbCamera = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblTable = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        btnThemCt = new javax.swing.JButton();
        btnSuaCt = new javax.swing.JButton();
        btnXoaCt = new javax.swing.JButton();
        btnClearCt = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        txtBarCode = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        cbbKm = new javax.swing.JComboBox<>();
        btnEx = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblCt1 = new javax.swing.JTable();
        txtMoTa = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnKhoiPhuc = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblHetHang = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1370, 800));

        txtIDSanPHam.setEnabled(false);

        jLabel1.setText("Id Sản phẩm");

        jLabel2.setText("Mã Sản Phẩm");

        jLabel3.setText("Tên Sản Phẩm");

        cbbHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setBackground(new java.awt.Color(51, 255, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 255, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/system-update.png"))); // NOI18N
        jButton3.setText("Sửa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(0, 204, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jButton2.setBackground(new java.awt.Color(51, 255, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dust.png"))); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("ID hãng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMASANPHAM, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTENSANPHAM, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtIDSanPHam, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(jLabel5)))
                        .addGap(43, 43, 43)
                        .addComponent(cbbHang, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(0, 205, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIDSanPHam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addComponent(jLabel5)
                        .addComponent(cbbHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtMASANPHAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTENSANPHAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jButton3)
                        .addGap(58, 58, 58)
                        .addComponent(jButton2)))
                .addGap(126, 126, 126)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sản Phẩm", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));

        jPanel9.setBackground(new java.awt.Color(0, 204, 255));

        txtIdHangSp.setEnabled(false);

        jLabel7.setText("Id Hãng Sản phẩm");

        jLabel8.setText("Mã hãng Sản Phẩm");

        jLabel9.setText("Tên Sản Phẩm");

        btnThem.setBackground(new java.awt.Color(51, 255, 51));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(51, 255, 51));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/system-update.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(0, 204, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblHangSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblHangSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHangSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHangSP);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnClear.setBackground(new java.awt.Color(51, 255, 51));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dust.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaHangSp, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdHangSp, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenHangSp, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(477, 477, 477)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 89, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtIdHangSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem))
                .addGap(70, 70, 70)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMaHangSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenHangSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btnClear)))
                .addGap(81, 81, 81)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1373, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 779, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Hãng", jPanel3);

        jPanel16.setBackground(new java.awt.Color(0, 204, 255));

        txtIdNhaCungCap.setEnabled(false);

        jLabel13.setText("Id nhà cung cấp");

        jLabel14.setText("Mã nhà cung cấp");

        jLabel15.setText("Tên nhà cung cấp");

        jButton13.setBackground(new java.awt.Color(51, 255, 51));
        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        jButton13.setText("Thêm");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(51, 255, 51));
        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/system-update.png"))); // NOI18N
        jButton14.setText("Sửa");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jPanel17.setBackground(new java.awt.Color(0, 204, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblNhaCungCap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhaCungCapMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblNhaCungCap);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jButton16.setBackground(new java.awt.Color(51, 255, 51));
        jButton16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dust.png"))); // NOI18N
        jButton16.setText("Clear");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel31.setText("Số Điện Thoại");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 86, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel31))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(402, 402, 402)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtIdNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtMaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButton14)))
                .addGap(37, 37, 37)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTenNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jButton16)
                .addGap(11, 11, 11)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1376, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 779, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 780, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1376, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 1376, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 779, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nhà Cung Cấp", jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 204, 255));

        txtID.setEnabled(false);

        jLabel17.setText("ID");

        jLabel18.setText("Sản Phẩm");

        jLabel19.setText("Nhà Cung Cấp");

        jLabel21.setText("Giá Nhập");

        jLabel22.setText("Giá bán");

        cbbXuatXu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Việt Nam", "Trung Quốc", "Nhật Bản", "Mỹ", "Singapore" }));

        cbbMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trắng", "Đỏ", "Đen", "Tím", "Xanh", " " }));

        cbbManHinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2 inch", "3 inch", "4 inch", "6 inch", "8 inch", "10 inch", "12 inch", "14 inch" }));

        cbbRam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2G", "4G", "6G", "8G", "16G", "32G", " " }));

        cbbBoNho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8GB", "16GB", "32GB", "125GB", "250GB" }));

        cbbCamera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 Mắt", "2 Mắt", "3 Mắt", "4 Mắt" }));

        jLabel23.setText("Màu sác");

        jLabel24.setText("Màn hình");

        jLabel25.setText("Xuát xứ");

        jLabel26.setText("Ram");

        jLabel27.setText("Bộ nhớ");

        jLabel28.setText("Camere");

        jPanel18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAnhMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel29.setText("Mô tả");

        tblTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblTable);

        jLabel30.setText("Ảnh");

        btnThemCt.setBackground(new java.awt.Color(51, 255, 51));
        btnThemCt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThemCt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnThemCt.setText("Thêm");
        btnThemCt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCtActionPerformed(evt);
            }
        });

        btnSuaCt.setBackground(new java.awt.Color(51, 255, 51));
        btnSuaCt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSuaCt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/system-update.png"))); // NOI18N
        btnSuaCt.setText("Sửa");
        btnSuaCt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCtActionPerformed(evt);
            }
        });

        btnXoaCt.setBackground(new java.awt.Color(51, 255, 51));
        btnXoaCt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoaCt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/export.png"))); // NOI18N
        btnXoaCt.setText("Xuất");
        btnXoaCt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCtActionPerformed(evt);
            }
        });

        btnClearCt.setBackground(new java.awt.Color(51, 255, 51));
        btnClearCt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClearCt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dust.png"))); // NOI18N
        btnClearCt.setText("Clear");
        btnClearCt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearCtActionPerformed(evt);
            }
        });

        jLabel32.setText("Barcode");

        jLabel34.setText("ID Khuyến Mãi");

        btnEx.setBackground(new java.awt.Color(51, 255, 51));
        btnEx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/share.png"))); // NOI18N
        btnEx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExActionPerformed(evt);
            }
        });

        jLabel4.setText("SL");

        txtSoLuong.setEditable(false);
        txtSoLuong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSoLuong.setForeground(new java.awt.Color(25, 29, 74));
        txtSoLuong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        tblCt1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCt1MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblCt1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel32)
                    .addComponent(jLabel34)
                    .addComponent(jLabel29))
                .addGap(70, 70, 70)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbNCC, javax.swing.GroupLayout.Alignment.LEADING, 0, 185, Short.MAX_VALUE)
                    .addComponent(cbbSanPham, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtID, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBarCode)
                    .addComponent(cbbKm, 0, 185, Short.MAX_VALUE)
                    .addComponent(txtMoTa))
                .addGap(77, 77, 77)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel23))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbbXuatXu, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(57, 57, 57)
                                .addComponent(cbbBoNho, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(70, 70, 70)
                                .addComponent(cbbRam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(44, 44, 44)
                                .addComponent(cbbManHinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoLuong)
                                    .addComponent(cbbCamera, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(39, 39, 39)
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSuaCt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThemCt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaCt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClearCt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnEx)))
                .addGap(106, 106, 106))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btnEx, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(50, 50, 50)))
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btnThemCt)
                                .addGap(45, 45, 45)
                                .addComponent(btnSuaCt)
                                .addGap(45, 45, 45)
                                .addComponent(btnClearCt)
                                .addGap(49, 49, 49)
                                .addComponent(btnXoaCt)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)
                                    .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel30))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(cbbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25)
                                    .addComponent(cbbXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(cbbNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24)
                                    .addComponent(cbbManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel34)
                                    .addComponent(cbbKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26)
                                    .addComponent(cbbRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27)
                                    .addComponent(cbbBoNho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel28)
                                        .addComponent(cbbCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel32))
                                        .addGap(43, 43, 43)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel29)
                                            .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)))))
                        .addGap(325, 325, 325))))
        );

        jTabbedPane1.addTab("Chi Tiết Sản Phẩm", jPanel6);

        jPanel7.setBackground(new java.awt.Color(0, 204, 255));

        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });

        jLabel16.setText("Tìm kiếm");

        btnKhoiPhuc.setBackground(new java.awt.Color(51, 255, 51));
        btnKhoiPhuc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKhoiPhuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/curve-arrow.png"))); // NOI18N
        btnKhoiPhuc.setText("Khôi Phục");
        btnKhoiPhuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoiPhucActionPerformed(evt);
            }
        });

        tblHetHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblHetHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHetHangMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblHetHang);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(38, 38, 38)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 953, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKhoiPhuc))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(btnKhoiPhuc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jTabbedPane1.addTab("Sản Phẩm Hết Hàng", jPanel7);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1370, 810));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblHetHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHetHangMouseClicked

    }//GEN-LAST:event_tblHetHangMouseClicked

    private void btnKhoiPhucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoiPhucActionPerformed
        int index = tblHetHang.getSelectedRow();
        if (index < 0) {
            MsgBox.alert(this, "Vui lòng chọn 1 dòng trên table");
        } else {
            SanPhamHetHang sp = spHetHang.get(index);
            int id = sp.getId();
            String soLuong = JOptionPane.showInputDialog("Số Lượng", "0");
            SanPhamHetHang spUpdate = new SanPhamHetHang(Integer.parseInt(soLuong), "Còn Hàng");
            MsgBox.alert(this, implHetHang.update(spUpdate, id));
            spHetHang = implHetHang.getALL();
            showTTableHetHang(spHetHang);
        }
    }//GEN-LAST:event_btnKhoiPhucActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        String ma = txtTimKiem.getText();
        List<SanPhamHetHang> listHetHang = implHetHang.getALL(spHetHang, ma);
        showTTableHetHang(listHetHang);
    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void btnClearCtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearCtActionPerformed
        txtBarCode.setText("");
        txtID.setText("");
        txtGiaBan.setText("");
        txtGiaNhap.setText("");
        txtSoLuong.setText("");
        cbbXuatXu.setSelectedItem("");
        cbbBoNho.setSelectedItem("");
        cbbMauSac.setSelectedItem("");
        cbbRam.setSelectedItem("");
        cbbSanPham.setSelectedItem("");
        txtMoTa.setText("");
        cbbCamera.setSelectedItem("");
        cbbManHinh.setSelectedItem("");
        cbbNCC.setSelectedItem("");
    }//GEN-LAST:event_btnClearCtActionPerformed

    private void btnSuaCtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCtActionPerformed
        if (tblCt1.getSelectedRow() < 0) {
            MsgBox.alert(this, "Vui lòng chọn 1 dòng trên table");
        } else {
            int id = Integer.parseInt(txtID.getText());
            MsgBox.alert(this, impl.update(id, getDataSp()));
            listCt = impl.getALL();
            fillCt(listCt);
            Imei imei = new Imei();;
            for (int i = 0; i < tblTable.getRowCount(); i++) {
                SanPham sp = SP.getOneSP((String) cbbSanPham.getSelectedItem());
                imei.setMaImei(tblTable.getValueAt(i, 0).toString());
                imei.setTrangThai("Còn Hàng");
                imei.setIdSanPham(sp.getId());
                imeiImpl.add(imei);
            }
            txtBarCode.setText("");
            txtID.setText("");
            txtGiaBan.setText("");
            txtGiaNhap.setText("");
            txtSoLuong.setText("");
            cbbXuatXu.setSelectedItem("");
            cbbBoNho.setSelectedItem("");
            cbbMauSac.setSelectedItem("");
            cbbRam.setSelectedItem("");
            cbbSanPham.setSelectedItem("");
            txtMoTa.setText("");
            cbbCamera.setSelectedItem("");
            cbbManHinh.setSelectedItem("");
            cbbNCC.setSelectedItem("");
        }

    }//GEN-LAST:event_btnSuaCtActionPerformed

    private void btnThemCtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCtActionPerformed
        if (txtGiaNhap.getText().isEmpty()) {
            MsgBox.alert(this, "Giá Nhập không được để trống");
        } else if (txtGiaBan.getText().isEmpty()) {
            MsgBox.alert(this, "Giá bán không được để trống");
        } else if (txtBarCode.getText().isEmpty()) {
            MsgBox.alert(this, "Barcode không được để trống");
        } else if (txtMoTa.getText().isEmpty()) {
            MsgBox.alert(this, "Mô tả không được để trống");
        } else if (lblAnh.getText().isEmpty()) {
            MsgBox.alert(this, "Vui Lòng chọn ảnh");
        } else {
            MsgBox.alert(this, impl.add(getDataSp()));
            listCt = impl.getALL();
            fillCt(listCt);
            Imei imei = new Imei();;
            for (int i = 0; i < tblTable.getRowCount(); i++) {
                SanPham sp = SP.getOneSP((String) cbbSanPham.getSelectedItem());
                imei.setMaImei(tblTable.getValueAt(i, 0).toString());
                imei.setTrangThai("Còn Hàng");
                imei.setIdSanPham(sp.getId());
                imeiImpl.add(imei);
            }
            txtBarCode.setText("");
            txtID.setText("");
            txtGiaBan.setText("");
            txtGiaNhap.setText("");
            txtSoLuong.setText("");
            cbbXuatXu.setSelectedItem("");
            cbbBoNho.setSelectedItem("");
            cbbMauSac.setSelectedItem("");
            cbbRam.setSelectedItem("");
            cbbSanPham.setSelectedItem("");
            txtMoTa.setText("");
            cbbCamera.setSelectedItem("");
            cbbManHinh.setSelectedItem("");
            cbbNCC.setSelectedItem("");
        }
    }//GEN-LAST:event_btnThemCtActionPerformed

    private void lblAnhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMousePressed

    }//GEN-LAST:event_lblAnhMousePressed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        clearNcc();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void tblNhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhaCungCapMouseClicked
        fillDataNcc(tblNhaCungCap.getSelectedRow());
    }//GEN-LAST:event_tblNhaCungCapMouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        int row = tblNhaCungCap.getSelectedRow();
        if (row < 0) {
            MsgBox.alert(this, "Vui Lòng chọn 1 dòng trên table");
        } else {
            int id = Integer.parseInt(txtIdNhaCungCap.getText());
            JOptionPane.showMessageDialog(this, nccs.sua(id, addNcc()));
            listncc = nccs.getAll();
            hienThiTableNcc(listncc);
            clearNcc();
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (txtMaNhaCungCap.getText().isEmpty()) {
            MsgBox.alert(this, "Không được để trống mã nhà cung cấp ");
        } else if (txtTenNhaCungCap.getText().isEmpty()) {
            MsgBox.alert(this, "Không được để trống tên nhà cung cấp ");
        } else if (txtSDT.getText().isEmpty()) {
            MsgBox.alert(this, "Không được để trống sdt nhà cung cấp ");
        } else {
            JOptionPane.showMessageDialog(this, nccs.add(addNcc()));
            listncc = nccs.getAll();
            hienThiTableNcc(listncc);
            clearNcc();
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void tblHangSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHangSPMouseClicked
        fillData(tblHangSP.getSelectedRow());
    }//GEN-LAST:event_tblHangSPMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = tblHangSP.getSelectedRow();
        if (row < 0) {
            MsgBox.alert(this, "Vui Lòng chọn 1 dòng trên table");
        } else {
            int id = Integer.parseInt(txtIdHangSp.getText());
            JOptionPane.showMessageDialog(this, hsps.sua(id, add()));
            lists = hsps.getAll();
            hienThiTable(lists);
            clear();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (txtMaHangSp.getText().isEmpty()) {
            MsgBox.alert(this, "Không được để trống mã hãng sản phẩm ");
        } else if (txtTenHangSp.getText().isEmpty()) {
            MsgBox.alert(this, "Không được để trống tên hãng sản phẩm ");
        } else {
            JOptionPane.showMessageDialog(this, hsps.add(add()));
            lists = hsps.getAll();
            hienThiTable(lists);
            clear();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtIDSanPHam.setText("");
        txtMASANPHAM.setText("");
        txtTENSANPHAM.setText("");
        cbbHang.setSelectedItem(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        fillDataa(tblSanPham.getSelectedRow());
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = tblSanPham.getSelectedRow();
        if (row < 0) {
            MsgBox.alert(this, "Vui Lòng chọn 1 dòng trên table");
        } else {
            int id = Integer.parseInt(txtIDSanPHam.getText());
            JOptionPane.showMessageDialog(this, SP.updateSP(id, getDataSanPham()));
            showDataTable(SP.getAll());
            txtIDSanPHam.setText("");
            txtMASANPHAM.setText("");
            txtTENSANPHAM.setText("");
            cbbHang.setSelectedItem(null);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtMASANPHAM.getText().isEmpty()) {
            MsgBox.alert(this, "Không được để trống mã sản phẩm ");
        } else if (txtTENSANPHAM.getText().isEmpty()) {
            MsgBox.alert(this, "Không được để trống tên sản phẩm ");
        } else {
            JOptionPane.showMessageDialog(this, SP.addSP(getDataSanPham()));
            Spview = SP.getAll();
            showDataTable(Spview);
            txtIDSanPHam.setText("");
            txtMASANPHAM.setText("");
            txtTENSANPHAM.setText("");
            cbbHang.setSelectedItem(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnXoaCtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCtActionPerformed

    }//GEN-LAST:event_btnXoaCtActionPerformed

    private void lblAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseClicked
        try {
            JFileChooser fileChooser = new JFileChooser("C:\\Users\\ASUS\\OneDrive\\Documents\\PhanMemBanDienThoai\\anh");
            fileChooser.setDialogTitle("Mở File");
            fileChooser.showOpenDialog(null);
            File f = fileChooser.getSelectedFile();
            duongDanAnh = f.getAbsolutePath();
            if (duongDanAnh != null) {
                lblAnh.setIcon(reSizeImage(duongDanAnh));
                System.out.println(duongDanAnh);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chưa Chọn ảnh");
        }
    }//GEN-LAST:event_lblAnhMouseClicked

    private void btnExActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExActionPerformed
        importExcelToJtableJava();
    }//GEN-LAST:event_btnExActionPerformed

    private void tblCt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCt1MouseClicked
        int index = tblCt1.getSelectedRow();
        setData(index);
    }//GEN-LAST:event_tblCt1MouseClicked

    private void tblTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTableMouseClicked

    }//GEN-LAST:event_tblTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClearCt;
    private javax.swing.JButton btnEx;
    private javax.swing.JButton btnKhoiPhuc;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaCt;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemCt;
    private javax.swing.JButton btnXoaCt;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbBoNho;
    private javax.swing.JComboBox<String> cbbCamera;
    private javax.swing.JComboBox<String> cbbHang;
    private javax.swing.JComboBox<String> cbbKm;
    private javax.swing.JComboBox<String> cbbManHinh;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbNCC;
    private javax.swing.JComboBox<String> cbbRam;
    private javax.swing.JComboBox<String> cbbSanPham;
    private javax.swing.JComboBox<String> cbbXuatXu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JTable tblCt1;
    private javax.swing.JTable tblHangSP;
    private javax.swing.JTable tblHetHang;
    private javax.swing.JTable tblNhaCungCap;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblTable;
    private javax.swing.JTextField txtBarCode;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDSanPHam;
    private javax.swing.JTextField txtIdHangSp;
    private javax.swing.JTextField txtIdNhaCungCap;
    private javax.swing.JTextField txtMASANPHAM;
    private javax.swing.JTextField txtMaHangSp;
    private javax.swing.JTextField txtMaNhaCungCap;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSDT;
    public static javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTENSANPHAM;
    private javax.swing.JTextField txtTenHangSp;
    private javax.swing.JTextField txtTenNhaCungCap;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    private ImageIcon reSizeImage(String imagePart) {
        ImageIcon imageIcon = new ImageIcon(imagePart);
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image1 = new ImageIcon(newImage);
        return image1;
    }

    public void importExcelToJtableJava() {
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelImportToJTable = null;
        String defaultCurrentDirectoryPath = "C:\\Users\\Authentic\\Desktop";
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
        excelFileChooser.setDialogTitle("Select Excel File");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showOpenDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                excelFile = excelFileChooser.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelImportToJTable = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);

                for (int row = 0; row < excelSheet.getLastRowNum(); row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);
                    XSSFCell excelLineNum = excelRow.getCell(0);
                    dtmIMei.addRow(new Object[]{excelLineNum});
                    txtSoLuong.setText(String.valueOf(tblTable.getRowCount()));
                }
                JOptionPane.showMessageDialog(null, "Imported Successfully !!.....");
            } catch (IOException iOException) {
                JOptionPane.showMessageDialog(null, iOException.getMessage());
            } finally {
                try {
                    if (excelFIS != null) {
                        excelFIS.close();
                    }
                    if (excelBIS != null) {
                        excelBIS.close();
                    }
                    if (excelImportToJTable != null) {
                        excelImportToJTable.close();
                    }
                } catch (IOException iOException) {
                    JOptionPane.showMessageDialog(null, iOException.getMessage());
                }
            }
        }
    }
}
