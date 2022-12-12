/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.ChiTietSP;
import model.HoaDon;
import model.SanPham;
import viewmodel.SanPhamViewModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import service.ThongKeSPservice;
import service.impl.SanPhamImpl;
import service.impl.ThongKeImpl;
import util.MsgBox;
import viewmodel.ThongKeDoanhThuViewModel;
import viewmodel.ThongkeSanPhamViewModel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;
import util.XMoney;

/**
 *
 * @author ASUS
 */
public class ThongKeView extends javax.swing.JInternalFrame {

    private DefaultTableModel dtmSanPham = new DefaultTableModel();
    private DefaultTableModel dtmDoanhThu = new DefaultTableModel();
    private ThongKeImpl tk = new ThongKeImpl();
    private List<ThongkeSanPhamViewModel> listt = new ArrayList<>();
    private List<ThongKeDoanhThuViewModel> listtt = new ArrayList<>();
    private DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbm1 = new DefaultComboBoxModel();

    public ThongKeView() {
        initComponents();
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        rdoTatCa.setSelected(true);
        tblDoanhThu.setModel(dtmDoanhThu);
        tblSanPham.setModel(dtmSanPham);
        Object[] tkSP = {"Mã Sản Phẩm", "Tên Sản Phẩm", "Sô Lượng", "Trạng Thái"};
        Object[] tkDT = {"Mã Hóa Đơn", "Số Lượng", "Giá Nhập", "Giá Bán", "Doanh Thu"};
        dtmSanPham.setColumnIdentifiers(tkSP);
        dtmDoanhThu.setColumnIdentifiers(tkDT);
        listt = tk.getAllThongKeViewModel();
        listtt = tk.getAll();
        showDataTable(listt);
        showDataTable2(listtt);
        lblConHang(tk.ConHang());
        lblHetHang(tk.HetHang());
        lblTongSoHang(tk.SoSanPhamDangKinhDoanh());
        lblTongDoanhThuNam(tk.TongDoanhThuNam());
        thongKeCot();
        DonHang(tk.tonDonHang());
        donGiao(tk.tonDonGiao());
        pannelThang.hide();
        pannelNam.hide();
    }

    private void showDataTable(List<ThongkeSanPhamViewModel> lists) {
        dtmSanPham.setRowCount(0);
        for (ThongkeSanPhamViewModel list : lists) {
            dtmSanPham.addRow(list.toDatarow());
        }
    }

    private void showDataTable2(List<ThongKeDoanhThuViewModel> listt) {
        dtmDoanhThu.setRowCount(0);
        for (ThongKeDoanhThuViewModel thongKeDoanhThuViewModel : listt) {
            dtmDoanhThu.addRow(thongKeDoanhThuViewModel.toDatarow());
        }
    }

    private void lblConHang(List<ChiTietSP> listt) {
        for (ChiTietSP chiTietSP : listt) {
            lblConHang.setText(String.valueOf(chiTietSP.getTrangThai()));
        }
    }

    private void lblHetHang(List<ChiTietSP> listt) {
        for (ChiTietSP chiTietSP : listt) {
            lblHetHang.setText(String.valueOf(chiTietSP.getTrangThai()));

        }
    }

    private void lblTongSoHang(List<SanPham> listt) {
        for (SanPham sanPham : listt) {
            lblTongSanPham.setText(String.valueOf(sanPham.getId()));
        }
    }

    private void lblTongDoanhThuNam(List<HoaDon> listt) {
        for (HoaDon hoaDon : listt) {
            lblTongDoanhThuNam.setText(String.valueOf(XMoney.themDauCham(hoaDon.getTongTien())));
        }
    }
    
    private void DonHang(List<HoaDon> listt) {
        for (HoaDon hoaDon : listt) {
            lblDonHang.setText(String.valueOf(hoaDon.getMaHD()));
        }
    }
    
    private void donGiao(List<HoaDon> listt) {
        for (HoaDon hoaDon : listt) {
            lblDonGiao.setText(String.valueOf(hoaDon.getMaHD()));
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        lblTongSanPham = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        lblConHang = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        lblHetHang = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnSanPham = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblDonGiao = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblTongDoanhThuNam = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        panelLineChart = new javax.swing.JPanel();
        btnDoanhThu = new javax.swing.JButton();
        rdoTatCa = new javax.swing.JRadioButton();
        rdoThang = new javax.swing.JRadioButton();
        rdoNam = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblDonHang = new javax.swing.JLabel();
        pannelThang = new javax.swing.JPanel();
        cbbTheoThang = new javax.swing.JComboBox<>();
        pannelNam = new javax.swing.JPanel();
        cbbTheoNam = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1319, 800));

        jPanel8.setBackground(new java.awt.Color(0, 204, 255));

        jPanel10.setBackground(new java.awt.Color(0, 204, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setPreferredSize(new java.awt.Dimension(220, 220));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel35.setText("Tổng Số Sản Phẩm Đang Kinh Doanh");

        lblTongSanPham.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblTongSanPham.setText("0");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel35))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(lblTongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel35)
                .addGap(28, 28, 28)
                .addComponent(lblTongSanPham)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(0, 204, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setPreferredSize(new java.awt.Dimension(220, 220));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setText("Tổng Số Sản Phẩm Đang Còn Hàng");

        lblConHang.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblConHang.setText("0");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblConHang, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel36)
                .addGap(36, 36, 36)
                .addComponent(lblConHang)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(0, 204, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setPreferredSize(new java.awt.Dimension(220, 220));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel37.setText("Tổng Số Sản Phẩm Đang Hết Hàng");

        lblHetHang.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblHetHang.setText("0");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHetHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel37)
                .addGap(28, 28, 28)
                .addComponent(lblHetHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(0, 204, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
        jScrollPane2.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnSanPham.setBackground(new java.awt.Color(51, 255, 51));
        btnSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/export.png"))); // NOI18N
        btnSanPham.setText("Xuất Thống Kê Sản Phẩm");
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSanPham)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                .addGap(64, 64, 64)
                .addComponent(btnSanPham)
                .addGap(44, 44, 44)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Sản Phẩm", jPanel8);

        jPanel9.setBackground(new java.awt.Color(0, 204, 255));

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(222, 220));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tổng đơn Giao");

        lblDonGiao.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblDonGiao.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblDonGiao, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDonGiao, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel5.setPreferredSize(new java.awt.Dimension(220, 220));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Tổng doanh thu năm");

        jLabel28.setText("Tiền :");

        lblTongDoanhThuNam.setText("0");

        jLabel8.setText("VND");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTongDoanhThuNam, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(38, 38, 38))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel10)
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(lblTongDoanhThuNam)
                    .addComponent(jLabel8))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDoanhThu);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bảng", jPanel6);

        jPanel7.setBackground(new java.awt.Color(0, 204, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panelLineChart.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1224, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(25, Short.MAX_VALUE)
                    .addComponent(panelLineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 1178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelLineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Cột", jPanel7);

        btnDoanhThu.setBackground(new java.awt.Color(51, 255, 51));
        btnDoanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/export.png"))); // NOI18N
        btnDoanhThu.setText("Xuất Thống Kê Doanh Thu");
        btnDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoanhThuActionPerformed(evt);
            }
        });

        rdoTatCa.setBackground(new java.awt.Color(0, 204, 255));
        buttonGroup1.add(rdoTatCa);
        rdoTatCa.setText("Tất Cả");
        rdoTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTatCaActionPerformed(evt);
            }
        });

        rdoThang.setBackground(new java.awt.Color(0, 204, 255));
        buttonGroup1.add(rdoThang);
        rdoThang.setText("Tháng");
        rdoThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoThangActionPerformed(evt);
            }
        });

        rdoNam.setBackground(new java.awt.Color(0, 204, 255));
        buttonGroup1.add(rdoNam);
        rdoNam.setText("Năm");
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNamActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setPreferredSize(new java.awt.Dimension(222, 220));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Tổng Đơn Hàng Tại Quầy");

        lblDonHang.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblDonHang.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(lblDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        cbbTheoThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" }));
        cbbTheoThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTheoThangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pannelThangLayout = new javax.swing.GroupLayout(pannelThang);
        pannelThang.setLayout(pannelThangLayout);
        pannelThangLayout.setHorizontalGroup(
            pannelThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbbTheoThang, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pannelThangLayout.setVerticalGroup(
            pannelThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelThangLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbbTheoThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cbbTheoNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020", "2021", "2022" }));
        cbbTheoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTheoNamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pannelNamLayout = new javax.swing.GroupLayout(pannelNam);
        pannelNam.setLayout(pannelNamLayout);
        pannelNamLayout.setHorizontalGroup(
            pannelNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelNamLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbbTheoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pannelNamLayout.setVerticalGroup(
            pannelNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelNamLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbbTheoNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(rdoTatCa)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(266, 266, 266)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rdoThang)
                                            .addComponent(rdoNam))
                                        .addGap(56, 56, 56)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(pannelNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(pannelThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(762, 762, 762)
                                        .addComponent(btnDoanhThu)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(51, 51, 51))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(73, 73, 73)
                .addComponent(rdoTatCa)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(btnDoanhThu))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoThang)
                            .addComponent(pannelThang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoNam)
                            .addComponent(pannelNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Doanh Thu", jPanel9);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1329, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        xuatExcelSp();
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoanhThuActionPerformed
        xuatExcelDt();
    }//GEN-LAST:event_btnDoanhThuActionPerformed

    private void rdoThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoThangActionPerformed
        pannelThang.show();
        pannelNam.hide();
    }//GEN-LAST:event_rdoThangActionPerformed

    private void rdoTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTatCaActionPerformed
        pannelThang.hide();
        pannelNam.hide();
        showDataTable2(listtt);
        lblTongDoanhThuNam(tk.TongDoanhThuNam());
        DonHang(tk.tonDonHang());
        donGiao(tk.tonDonGiao());
    }//GEN-LAST:event_rdoTatCaActionPerformed

    private void rdoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNamActionPerformed
        pannelThang.hide();
        pannelNam.show();
    }//GEN-LAST:event_rdoNamActionPerformed

    private void cbbTheoThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTheoThangActionPerformed
        try {
            if (cbbTheoThang.getSelectedIndex() == 0) {
                List<Integer> donHuy = tk.selectTongHoaDonTheoThang1();
                for (Integer dt : donHuy) {
                    lblDonHang.setText(XMoney.themDauCham(dt));
                }
                List<Integer> donGiao = tk.selectTongHoaDonGiaoTheoThang1();
                for (Integer kh : donGiao) {
                    lblDonGiao.setText(kh.toString());
                }
                List<Integer> tongDoanhThuNam = tk.selectDoanhThuTheoThang1();
                for (Integer kh : tongDoanhThuNam) {
                    lblTongDoanhThuNam.setText(kh.toString());
                }
            } else if (cbbTheoThang.getSelectedIndex() == 1) {
                List<Integer> donHuy = tk.selectTongHoaDonTheoThang2();
                for (Integer dt : donHuy) {
                    lblDonHang.setText(XMoney.themDauCham(dt));
                }
                List<Integer> donGiao = tk.selectTongHoaDonGiaoTheoThang2();
                for (Integer kh : donGiao) {
                    lblDonGiao.setText(kh.toString());
                }
                List<Integer> tongDoanhThuNam = tk.selectDoanhThuTheoThang2();
                for (Integer kh : tongDoanhThuNam) {
                    lblTongDoanhThuNam.setText(kh.toString());
                }
            } if (cbbTheoThang.getSelectedIndex() == 2) {
                List<Integer> donHuy = tk.selectTongHoaDonTheoThang3();
                for (Integer dt : donHuy) {
                    lblDonHang.setText(XMoney.themDauCham(dt));
                }
                List<Integer> donGiao = tk.selectTongHoaDonGiaoTheoThang3();
                for (Integer kh : donGiao) {
                    lblDonGiao.setText(kh.toString());
                }
                List<Integer> tongDoanhThuNam = tk.selectDoanhThuTheoThang3();
                for (Integer kh : tongDoanhThuNam) {
                    lblTongDoanhThuNam.setText(kh.toString());
                }
            } if (cbbTheoThang.getSelectedIndex() == 3) {
                List<Integer> donHuy = tk.selectTongHoaDonTheoThang4();
                for (Integer dt : donHuy) {
                    lblDonHang.setText(XMoney.themDauCham(dt));
                }
                List<Integer> donGiao = tk.selectTongHoaDonGiaoTheoThang4();
                for (Integer kh : donGiao) {
                    lblDonGiao.setText(kh.toString());
                }

                List<Integer> tongDoanhThuNam = tk.selectDoanhThuTheoThang4();
                for (Integer kh : tongDoanhThuNam) {
                    lblTongDoanhThuNam.setText(kh.toString());
                }
            } if (cbbTheoThang.getSelectedIndex() == 4) {
                List<Integer> donHuy = tk.selectTongHoaDonTheoThang5();
                for (Integer dt : donHuy) {
                    lblDonHang.setText(XMoney.themDauCham(dt));
                }
                List<Integer> donGiao = tk.selectTongHoaDonGiaoTheoThang5();
                for (Integer kh : donGiao) {
                    lblDonGiao.setText(kh.toString());
                }
                List<Integer> tongDoanhThuNam = tk.selectDoanhThuTheoThang5();
                for (Integer kh : tongDoanhThuNam) {
                    lblTongDoanhThuNam.setText(kh.toString());
                }
            } if (cbbTheoThang.getSelectedIndex() == 5) {
                List<Integer> donHuy = tk.selectTongHoaDonTheoThang6();
                for (Integer dt : donHuy) {
                    lblDonHang.setText(XMoney.themDauCham(dt));
                }
                List<Integer> donGiao = tk.selectTongHoaDonGiaoTheoThang6();
                for (Integer kh : donGiao) {
                    lblDonGiao.setText(kh.toString());
                }
                List<Integer> tongDoanhThuNam = tk.selectDoanhThuTheoThang6();
                for (Integer kh : tongDoanhThuNam) {
                    lblTongDoanhThuNam.setText(kh.toString());
                }
            } if (cbbTheoThang.getSelectedIndex() == 6) {
                List<Integer> donHuy = tk.selectTongHoaDonTheoThang7();
                for (Integer dt : donHuy) {
                    lblDonHang.setText(XMoney.themDauCham(dt));
                }
                List<Integer> donGiao = tk.selectTongHoaDonGiaoTheoThang7();
                for (Integer kh : donGiao) {
                    lblDonGiao.setText(kh.toString());
                }
                List<Integer> tongDoanhThuNam = tk.selectDoanhThuTheoThang7();
                for (Integer kh : tongDoanhThuNam) {
                    lblTongDoanhThuNam.setText(kh.toString());
                }
            } if (cbbTheoThang.getSelectedIndex() == 7) {
                List<Integer> donHuy = tk.selectTongHoaDonTheoThang8();
                for (Integer dt : donHuy) {
                    lblDonHang.setText(XMoney.themDauCham(dt));
                }
                List<Integer> donGiao = tk.selectTongHoaDonGiaoTheoThang8();
                for (Integer kh : donGiao) {
                    lblDonGiao.setText(kh.toString());
                }
                List<Integer> tongDoanhThuNam = tk.selectDoanhThuTheoThang8();
                for (Integer kh : tongDoanhThuNam) {
                    lblTongDoanhThuNam.setText(kh.toString());
                }
            } if (cbbTheoThang.getSelectedIndex() == 8) {
                List<Integer> donHuy = tk.selectTongHoaDonTheoThang9();
                for (Integer dt : donHuy) {
                    lblDonHang.setText(XMoney.themDauCham(dt));
                }
                List<Integer> donGiao = tk.selectTongHoaDonGiaoTheoThang9();
                for (Integer kh : donGiao) {
                    lblDonGiao.setText(kh.toString());
                }
                List<Integer> tongDoanhThuNam = tk.selectDoanhThuTheoThang9();
                for (Integer kh : tongDoanhThuNam) {
                    lblTongDoanhThuNam.setText(kh.toString());
                }
            } if (cbbTheoThang.getSelectedIndex() == 9) {
                List<Integer> donHuy = tk.selectTongHoaDonTheoThang10();
                for (Integer dt : donHuy) {
                    lblDonHang.setText(XMoney.themDauCham(dt));
                }
                List<Integer> donGiao = tk.selectTongHoaDonGiaoTheoThang10();
                for (Integer kh : donGiao) {
                    lblDonGiao.setText(kh.toString());
                }
                List<Integer> tongDoanhThuNam = tk.selectDoanhThuTheoThang10();
                for (Integer kh : tongDoanhThuNam) {
                    lblTongDoanhThuNam.setText(kh.toString());
                }
            } if (cbbTheoThang.getSelectedIndex() == 10) {
                List<Integer> donHuy = tk.selectTongHoaDonTheoThang11();
                for (Integer dt : donHuy) {
                    lblDonHang.setText(XMoney.themDauCham(dt));
                }
                List<Integer> donGiao = tk.selectTongHoaDonGiaoTheoThang11();
                for (Integer kh : donGiao) {
                    lblDonGiao.setText(kh.toString());
                }
                List<Integer> tongDoanhThuNam = tk.selectDoanhThuTheoThang11();
                for (Integer kh : tongDoanhThuNam) {
                    lblTongDoanhThuNam.setText(kh.toString());
                }
            } if (cbbTheoThang.getSelectedIndex() == 11) {
                List<Integer> donHuy = tk.selectTongHoaDonTheoThang12();
                for (Integer dt : donHuy) {
                    lblDonHang.setText(XMoney.themDauCham(dt));
                }
                List<Integer> donGiao = tk.selectTongHoaDonGiaoTheoThang12();
                for (Integer kh : donGiao) {
                    lblDonGiao.setText(kh.toString());
                }
                List<Integer> tongDoanhThuNam = tk.selectDoanhThuTheoThang12();
                for (Integer kh : tongDoanhThuNam) {
                    lblTongDoanhThuNam.setText(kh.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbbTheoThangActionPerformed

    private void cbbTheoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTheoNamActionPerformed
         try {
            if (cbbTheoNam.getSelectedIndex() == 0) {
                List<Integer> doanhThu = tk.selectDoanhThuTheoNam2018();
                for (Integer dt : doanhThu) {
                    lblTongDoanhThuNam.setText(XMoney.themDauCham(dt));
                }
                List<Integer> hoaDon = tk.selectTongHoaDonGiaoTheoNam2018();
                for (Integer hd : hoaDon) {
                    lblDonGiao.setText(hd.toString());
                }
                List<Integer> hoaDonHuy = tk.selectTongHoaDonTheoNam2018();
                for (Integer hdHuy : hoaDonHuy) {
                    lblDonHang.setText(hdHuy.toString());
                }
            } else if (cbbTheoNam.getSelectedIndex() == 1) {
                List<Integer> doanhThu = tk.selectDoanhThuTheoNam2019();
                for (Integer dt : doanhThu) {
                    lblTongDoanhThuNam.setText(XMoney.themDauCham(dt));
                }
                List<Integer> hoaDon = tk.selectTongHoaDonGiaoTheoNam2019();
                for (Integer hd : hoaDon) {
                    lblDonGiao.setText(hd.toString());
                }
                List<Integer> hoaDonHuy = tk.selectTongHoaDonTheoNam2019();
                for (Integer hdHuy : hoaDonHuy) {
                    lblDonHang.setText(hdHuy.toString());
                }
            } else if (cbbTheoNam.getSelectedIndex() == 2) {
                List<Integer> doanhThu = tk.selectDoanhThuTheoNam2020();
                for (Integer dt : doanhThu) {
                    lblTongDoanhThuNam.setText(XMoney.themDauCham(dt));
                }
                List<Integer> hoaDon = tk.selectTongHoaDonGiaoTheoNam2020();
                for (Integer hd : hoaDon) {
                    lblDonGiao.setText(hd.toString());
                }
                List<Integer> hoaDonHuy = tk.selectTongHoaDonTheoNam2020();
                for (Integer hdHuy : hoaDonHuy) {
                    lblDonHang.setText(hdHuy.toString());
                }
            }else if (cbbTheoNam.getSelectedIndex() == 3) {
                List<Integer> doanhThu = tk.selectDoanhThuTheoNam2021();
                for (Integer dt : doanhThu) {
                    lblTongDoanhThuNam.setText(XMoney.themDauCham(dt));
                }
                List<Integer> hoaDon = tk.selectTongHoaDonGiaoTheoNam2021();
                for (Integer hd : hoaDon) {
                    lblDonGiao.setText(hd.toString());
                }
                List<Integer> hoaDonHuy = tk.selectTongHoaDonTheoNam2021();
                for (Integer hdHuy : hoaDonHuy) {
                    lblDonHang.setText(hdHuy.toString());
                }
            }else if (cbbTheoNam.getSelectedIndex() == 4) {
                List<Integer> doanhThu = tk.selectDoanhThuTheoNam2022();
                for (Integer dt : doanhThu) {
                    lblTongDoanhThuNam.setText(XMoney.themDauCham(dt));
                }
                List<Integer> hoaDon = tk.selectTongHoaDonGiaoTheoNam2022();
                for (Integer hd : hoaDon) {
                    lblDonGiao.setText(hd.toString());
                }
                List<Integer> hoaDonHuy = tk.selectTongHoaDonTheoNam2022();
                for (Integer hdHuy : hoaDonHuy) {
                    lblDonHang.setText(hdHuy.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbbTheoNamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoanhThu;
    private javax.swing.JButton btnSanPham;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbTheoNam;
    private javax.swing.JComboBox<String> cbbTheoThang;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblConHang;
    private javax.swing.JLabel lblDonGiao;
    private javax.swing.JLabel lblDonHang;
    private javax.swing.JLabel lblHetHang;
    private javax.swing.JLabel lblTongDoanhThuNam;
    private javax.swing.JLabel lblTongSanPham;
    private javax.swing.JPanel panelLineChart;
    private javax.swing.JPanel pannelNam;
    private javax.swing.JPanel pannelThang;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoTatCa;
    private javax.swing.JRadioButton rdoThang;
    private javax.swing.JTable tblDoanhThu;
    private javax.swing.JTable tblSanPham;
    // End of variables declaration//GEN-END:variables

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    private void xuatExcelSp() {
        DefaultTableModel model = (DefaultTableModel) this.tblSanPham.getModel();
        JFileChooser jfc = new JFileChooser("documents");
        int result = jfc.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File newFile = jfc.getSelectedFile();
                newFile = new File(newFile.toString() + ".xlsx");
                XSSFWorkbook xwb = new XSSFWorkbook();
                XSSFSheet Diemsheep = xwb.createSheet("Thống kê Sản Phẩm");
                XSSFRow row = Diemsheep.createRow((short) 0);
                XSSFCell h;
                for (int i = 0; i < model.getColumnCount(); i++) {
                    h = row.createCell((short) i);
                    h.setCellValue(model.getColumnName(i));
                }

                XSSFRow row1;
                XSSFCell a1;
                for (int i = 0; i < model.getRowCount(); i++) {
                    row1 = Diemsheep.createRow((short) i + 1);
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        a1 = row1.createCell((short) j);
                        a1.setCellValue(model.getValueAt(i, j).toString());
                    }
                }
                FileOutputStream file = new FileOutputStream(newFile.getAbsoluteFile().getPath());
                xwb.write(file);
                xwb.close();
                file.close();
                MsgBox.alert(this, "Xuất tệp thành công");
                openFile(newFile.toString());
            } catch (Exception e) {
                MsgBox.alert(this, "Xuất tệp thất bại");
            }
        }
    }

    private void xuatExcelDt() {
        DefaultTableModel model = (DefaultTableModel) this.tblDoanhThu.getModel();
        JFileChooser jfc = new JFileChooser("documents");
        int result = jfc.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File newFile = jfc.getSelectedFile();
                newFile = new File(newFile.toString() + ".xlsx");
                XSSFWorkbook xwb = new XSSFWorkbook();
                XSSFSheet Diemsheep = xwb.createSheet("Thống kê Doanh Thu");
                XSSFRow row = Diemsheep.createRow((short) 0);
                XSSFCell h;
                for (int i = 0; i < model.getColumnCount(); i++) {
                    h = row.createCell((short) i);
                    h.setCellValue(model.getColumnName(i));
                }

                XSSFRow row1;
                XSSFCell a1;
                for (int i = 0; i < model.getRowCount(); i++) {
                    row1 = Diemsheep.createRow((short) i + 1);
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        a1 = row1.createCell((short) j);
                        a1.setCellValue(model.getValueAt(i, j).toString());
                    }
                }
                FileOutputStream file = new FileOutputStream(newFile.getAbsoluteFile().getPath());
                xwb.write(file);
                xwb.close();
                file.close();
                MsgBox.alert(this, "Xuất tệp thành công");
                openFile(newFile.toString());
            } catch (Exception e) {
                MsgBox.alert(this, "Xuất tệp thất bại");
            }
        }
    }

    private void thongKeCot() {
        List<HoaDon> list = tk.thongKe();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (list != null) {
            for (HoaDon hoaDon : list) {
                dataset.setValue(hoaDon.getTongTien(), "Tổng Doanh Thu", hoaDon.getNgayTao());
            }
        }
        JFreeChart linechart = ChartFactory.createLineChart("Thống kê doanh thu", "Năm", "Tổng Doanh Thu",
                dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
        // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204, 0, 51);
        lineRenderer.setSeriesPaint(0, lineChartColor);
        ChartPanel sd = new ChartPanel(linechart);
        panelLineChart.removeAll();
        panelLineChart.add(sd, BorderLayout.CENTER);
        panelLineChart.validate();
    }

}
