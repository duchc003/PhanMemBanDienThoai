/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.JDBCHelper;
import viewmodel.HoaDonViewModel;
import viewmodel.hoaDonViewModelHUY;

/**
 *
 * @author Banh Chung Ran
 */
public class hoaDonViewModelRepositoryHUY {

    public List<hoaDonViewModelHUY> getAllHoaDonViewModel() {
        List<hoaDonViewModelHUY> listHD = new ArrayList<>();
        String sql = "SELECT dbo.HoaDon.MaHD, dbo.NhanVien.HoVaTen, dbo.KhachHang.HoVaTen AS Expr1, dbo.HoaDonChiTiet.SoLuong, dbo.HoaDon.TongTien, dbo.HinhThucThanhToan.TenHTTT, dbo.HinhThucGiaoHang.TenHTGH, dbo.HoaDon.TrangThai\n"
                + "FROM     dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                  dbo.HinhThucThanhToan ON dbo.HinhThucGiaoHang.ID = dbo.HinhThucThanhToan.ID INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH AND dbo.HinhThucThanhToan.ID = dbo.HoaDon.IDHinhTTT INNER JOIN\n"
                + "                  dbo.HoaDonChiTiet ON dbo.HoaDon.ID = dbo.HoaDonChiTiet.IDHoaDon INNER JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.IDKhachHang = dbo.KhachHang.ID INNER JOIN\n"
                + "                  dbo.NhanVien ON dbo.HoaDon.IDNhanVien = dbo.NhanVien.ID";
        ResultSet rs = JDBCHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                listHD.add(new hoaDonViewModelHUY(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getLong(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listHD;
    }

    public List<hoaDonViewModelHUY> timKiemHoaDonViewModel(String maHD) {
        List<hoaDonViewModelHUY> timKiem = new ArrayList<>();
        String sql = "SELECT dbo.HoaDon.MaHD, dbo.NhanVien.HoVaTen, dbo.KhachHang.HoVaTen AS Expr1, dbo.HoaDonChiTiet.SoLuong, dbo.HoaDon.TongTien, dbo.HinhThucThanhToan.TenHTTT, dbo.HinhThucGiaoHang.TenHTGH, dbo.HoaDon.TrangThai\n"
                + "FROM     dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                  dbo.HinhThucThanhToan ON dbo.HinhThucGiaoHang.ID = dbo.HinhThucThanhToan.ID INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH AND dbo.HinhThucThanhToan.ID = dbo.HoaDon.IDHinhTTT INNER JOIN\n"
                + "                  dbo.HoaDonChiTiet ON dbo.HoaDon.ID = dbo.HoaDonChiTiet.IDHoaDon INNER JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.IDKhachHang = dbo.KhachHang.ID INNER JOIN\n"
                + "                  dbo.NhanVien ON dbo.HoaDon.IDNhanVien = dbo.NhanVien.ID\n"
                + "				  where dbo.HoaDon.MaHD = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, maHD);
        try {
            while (rs.next()) {
                timKiem.add(new hoaDonViewModelHUY(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getLong(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }

        return timKiem;
    }

    public List<hoaDonViewModelHUY> timKiemCombobox(String trangThai) {
        List<hoaDonViewModelHUY> listtimKiem = new ArrayList<>();
        String sql = "SELECT dbo.HoaDon.MaHD, dbo.NhanVien.HoVaTen, dbo.KhachHang.HoVaTen AS Expr1, dbo.HoaDonChiTiet.SoLuong, dbo.HoaDon.TongTien, dbo.HinhThucThanhToan.TenHTTT, dbo.HinhThucGiaoHang.TenHTGH, dbo.HoaDon.TrangThai\n"
                + "FROM     dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                  dbo.HinhThucThanhToan ON dbo.HinhThucGiaoHang.ID = dbo.HinhThucThanhToan.ID INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH AND dbo.HinhThucThanhToan.ID = dbo.HoaDon.IDHinhTTT INNER JOIN\n"
                + "                  dbo.HoaDonChiTiet ON dbo.HoaDon.ID = dbo.HoaDonChiTiet.IDHoaDon INNER JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.IDKhachHang = dbo.KhachHang.ID INNER JOIN\n"
                + "                  dbo.NhanVien ON dbo.HoaDon.IDNhanVien = dbo.NhanVien.ID\n"
                + "				  where dbo.HoaDon.TrangThai = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, trangThai);
        try {
            while (rs.next()) {
                listtimKiem.add(new hoaDonViewModelHUY(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getLong(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listtimKiem;
    }

    public List<hoaDonViewModelHUY> timKiemCombobox1(String TenHTTT) {
        List<hoaDonViewModelHUY> listtimKiem = new ArrayList<>();
        String sql = "SELECT dbo.HoaDon.MaHD, dbo.NhanVien.HoVaTen, dbo.KhachHang.HoVaTen AS Expr1, dbo.HoaDonChiTiet.SoLuong, dbo.HoaDon.TongTien, dbo.HinhThucThanhToan.TenHTTT, dbo.HinhThucGiaoHang.TenHTGH, dbo.HoaDon.TrangThai\n"
                + "FROM     dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                  dbo.HinhThucThanhToan ON dbo.HinhThucGiaoHang.ID = dbo.HinhThucThanhToan.ID INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH AND dbo.HinhThucThanhToan.ID = dbo.HoaDon.IDHinhTTT INNER JOIN\n"
                + "                  dbo.HoaDonChiTiet ON dbo.HoaDon.ID = dbo.HoaDonChiTiet.IDHoaDon INNER JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.IDKhachHang = dbo.KhachHang.ID INNER JOIN\n"
                + "                  dbo.NhanVien ON dbo.HoaDon.IDNhanVien = dbo.NhanVien.ID\n"
                + "				  where dbo.HinhThucThanhToan.TenHTTT = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, TenHTTT);
        try {
            while (rs.next()) {
                listtimKiem.add(new hoaDonViewModelHUY(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getLong(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listtimKiem;
    }

    public List<hoaDonViewModelHUY> timKiemCombobox2(String TenHTGH) {
        List<hoaDonViewModelHUY> listtimKiem = new ArrayList<>();
        String sql = "SELECT dbo.HoaDon.MaHD, dbo.NhanVien.HoVaTen, dbo.KhachHang.HoVaTen AS Expr1, dbo.HoaDonChiTiet.SoLuong, dbo.HoaDon.TongTien, dbo.HinhThucThanhToan.TenHTTT, dbo.HinhThucGiaoHang.TenHTGH, dbo.HoaDon.TrangThai\n"
                + "FROM     dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                  dbo.HinhThucThanhToan ON dbo.HinhThucGiaoHang.ID = dbo.HinhThucThanhToan.ID INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH AND dbo.HinhThucThanhToan.ID = dbo.HoaDon.IDHinhTTT INNER JOIN\n"
                + "                  dbo.HoaDonChiTiet ON dbo.HoaDon.ID = dbo.HoaDonChiTiet.IDHoaDon INNER JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.IDKhachHang = dbo.KhachHang.ID INNER JOIN\n"
                + "                  dbo.NhanVien ON dbo.HoaDon.IDNhanVien = dbo.NhanVien.ID\n"
                + "				  where dbo.HinhThucThanhToan.TenHTGH = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, TenHTGH);
        try {
            while (rs.next()) {
                listtimKiem.add(new hoaDonViewModelHUY(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getLong(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listtimKiem;
    }

}
