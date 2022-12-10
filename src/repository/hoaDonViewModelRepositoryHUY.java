/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDonCT;
import model.Imei;
import model.imeiDaBan;
import util.ConnectDB;
import util.JDBCHelper;
import viewmodel.HoaDonViewModel;
import viewmodel.KhuyenMaiBanHang;
import viewmodel.hoaDonViewModelHUY;

/**
 *
 * @author Banh Chung Ran
 */
public class hoaDonViewModelRepositoryHUY {

    public List<hoaDonViewModelHUY> getAllHoaDonViewModel() {
        List<hoaDonViewModelHUY> listHD = new ArrayList<>();
        String sql = "SELECT dbo.HoaDon.ID,dbo.HoaDon.MaHD, dbo.NhanVien.HoVaTen, dbo.KhachHang.HoVaTen AS Expr1, dbo.HoaDon.NgayTao, dbo.HoaDon.NgayThanhToan, dbo.HoaDon.TongTien, dbo.HinhThucThanhToan.TenHTTT, dbo.HinhThucGiaoHang.TenHTGH, \n"
                + "                  dbo.HoaDon.TrangThai\n"
                + "FROM     dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                  dbo.HinhThucThanhToan ON dbo.HinhThucGiaoHang.ID = dbo.HinhThucThanhToan.ID INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH AND dbo.HinhThucThanhToan.ID = dbo.HoaDon.IDHinhTTT INNER JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.IDKhachHang = dbo.KhachHang.ID INNER JOIN\n"
                + "                  dbo.NhanVien ON dbo.HoaDon.IDNhanVien = dbo.NhanVien.ID";
        ResultSet rs = JDBCHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                listHD.add(new hoaDonViewModelHUY(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getLong(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listHD;
    }

    public List<hoaDonViewModelHUY> timKiemHoaDonViewModel(String maHD) {
        List<hoaDonViewModelHUY> timKiem = new ArrayList<>();
        String sql = "SELECT dbo.HoaDon.ID,dbo.HoaDon.MaHD, dbo.NhanVien.HoVaTen, dbo.KhachHang.HoVaTen AS Expr1, dbo.HoaDon.NgayTao, dbo.HoaDon.NgayThanhToan, dbo.HoaDon.TongTien, dbo.HinhThucThanhToan.TenHTTT, dbo.HinhThucGiaoHang.TenHTGH, \n"
                + "                  dbo.HoaDon.TrangThai\n"
                + "FROM     dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                  dbo.HinhThucThanhToan ON dbo.HinhThucGiaoHang.ID = dbo.HinhThucThanhToan.ID INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH AND dbo.HinhThucThanhToan.ID = dbo.HoaDon.IDHinhTTT INNER JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.IDKhachHang = dbo.KhachHang.ID INNER JOIN\n"
                + "                  dbo.NhanVien ON dbo.HoaDon.IDNhanVien = dbo.NhanVien.ID\n"
                + "				  where dbo.HoaDon.MaHD = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, maHD);
        try {
            while (rs.next()) {
                timKiem.add(new hoaDonViewModelHUY(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getLong(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }

        return timKiem;
    }

    public List<hoaDonViewModelHUY> timKiemCombobox(String trangThai) {
        List<hoaDonViewModelHUY> listtimKiem = new ArrayList<>();
        String sql = "SELECT dbo.HoaDon.ID,dbo.HoaDon.MaHD, dbo.NhanVien.HoVaTen, dbo.KhachHang.HoVaTen AS Expr1, dbo.HoaDon.NgayTao, dbo.HoaDon.NgayThanhToan, dbo.HoaDon.TongTien, dbo.HinhThucThanhToan.TenHTTT, dbo.HinhThucGiaoHang.TenHTGH, \n"
                + "                  dbo.HoaDon.TrangThai\n"
                + "FROM     dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                  dbo.HinhThucThanhToan ON dbo.HinhThucGiaoHang.ID = dbo.HinhThucThanhToan.ID INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH AND dbo.HinhThucThanhToan.ID = dbo.HoaDon.IDHinhTTT INNER JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.IDKhachHang = dbo.KhachHang.ID INNER JOIN\n"
                + "                  dbo.NhanVien ON dbo.HoaDon.IDNhanVien = dbo.NhanVien.ID\n"
                + "				  where dbo.HoaDon.TrangThai = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, trangThai);
        try {
            while (rs.next()) {
                listtimKiem.add(new hoaDonViewModelHUY(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getLong(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listtimKiem;
    }

    public List<hoaDonViewModelHUY> timKiemCombobox1(String TenHTTT) {
        List<hoaDonViewModelHUY> listtimKiem = new ArrayList<>();
        String sql = "SELECT dbo.HoaDon.ID,dbo.HoaDon.MaHD, dbo.NhanVien.HoVaTen, dbo.KhachHang.HoVaTen AS Expr1, dbo.HoaDon.NgayTao, dbo.HoaDon.NgayThanhToan, dbo.HoaDon.TongTien, dbo.HinhThucThanhToan.TenHTTT, dbo.HinhThucGiaoHang.TenHTGH, \n"
                + "                  dbo.HoaDon.TrangThai\n"
                + "FROM     dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                  dbo.HinhThucThanhToan ON dbo.HinhThucGiaoHang.ID = dbo.HinhThucThanhToan.ID INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH AND dbo.HinhThucThanhToan.ID = dbo.HoaDon.IDHinhTTT INNER JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.IDKhachHang = dbo.KhachHang.ID INNER JOIN\n"
                + "                  dbo.NhanVien ON dbo.HoaDon.IDNhanVien = dbo.NhanVien.ID\n"
                + "				  where dbo.HinhThucThanhToan.TenHTTT = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, TenHTTT);
        try {
            while (rs.next()) {
                listtimKiem.add(new hoaDonViewModelHUY(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getLong(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listtimKiem;
    }

    public List<hoaDonViewModelHUY> timKiemCombobox2(String TenHTGH) {
        List<hoaDonViewModelHUY> listtimKiem = new ArrayList<>();
        String sql = "SELECT dbo.HoaDon.ID,dbo.HoaDon.MaHD, dbo.NhanVien.HoVaTen, dbo.KhachHang.HoVaTen AS Expr1, dbo.HoaDon.NgayTao, dbo.HoaDon.NgayThanhToan, dbo.HoaDon.TongTien, dbo.HinhThucThanhToan.TenHTTT, dbo.HinhThucGiaoHang.TenHTGH, \n"
                + "                  dbo.HoaDon.TrangThai\n"
                + "FROM     dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                  dbo.HinhThucThanhToan ON dbo.HinhThucGiaoHang.ID = dbo.HinhThucThanhToan.ID INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH AND dbo.HinhThucThanhToan.ID = dbo.HoaDon.IDHinhTTT INNER JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.IDKhachHang = dbo.KhachHang.ID INNER JOIN\n"
                + "                  dbo.NhanVien ON dbo.HoaDon.IDNhanVien = dbo.NhanVien.ID\n"
                + "				  where dbo.HinhThucThanhToan.TenHTGH = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, TenHTGH);
        try {
            while (rs.next()) {
                listtimKiem.add(new hoaDonViewModelHUY(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getLong(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listtimKiem;
    }

    public hoaDonViewModelHUY select(int ma) {
        String query = "SELECT dbo.HoaDon.ID,dbo.HoaDon.MaHD, dbo.NhanVien.HoVaTen, dbo.KhachHang.HoVaTen AS Expr1, dbo.HoaDon.NgayTao, dbo.HoaDon.NgayThanhToan, dbo.HoaDon.TongTien, dbo.HinhThucThanhToan.TenHTTT, dbo.HinhThucGiaoHang.TenHTGH, \n"
                + "                  dbo.HoaDon.TrangThai\n"
                + "FROM     dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                  dbo.HinhThucThanhToan ON dbo.HinhThucGiaoHang.ID = dbo.HinhThucThanhToan.ID INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH AND dbo.HinhThucThanhToan.ID = dbo.HoaDon.IDHinhTTT INNER JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.IDKhachHang = dbo.KhachHang.ID INNER JOIN\n"
                + "                  dbo.NhanVien ON dbo.HoaDon.IDNhanVien = dbo.NhanVien.ID\n"
                + "				  where dbo.HoaDon.ID = ?";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new hoaDonViewModelHUY(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getLong(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<imeiDaBan> selectID(int ma) {
        String query = "select * from ImeiDaBan where IDHOaDon = ?";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ma);
            List<imeiDaBan> imei = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                imei.add(new imeiDaBan(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }
            return imei;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public HoaDonCT selectIDHD(int ma) {
        String query = "select * from HoaDonChiTiet where ID = ?";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new HoaDonCT(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getLong(5),
                        rs.getLong(6),
                        rs.getLong(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    

    public static void main(String[] args) {
        System.out.println(new hoaDonViewModelRepositoryHUY().selectID(1).toString());
    }
}
