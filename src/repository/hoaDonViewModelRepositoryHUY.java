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
import viewmodel.hoaDonViewModelHUY;

/**
 *
 * @author Banh Chung Ran
 */
public class hoaDonViewModelRepositoryHUY {

    public List<hoaDonViewModelHUY> getAllHoaDonViewModel() {
        List<hoaDonViewModelHUY> listHD = new ArrayList<>();
        String sql = "select MaHD,NhanVien.HoVaTen,KhachHang.HoVaTen,SoLuong,TongTien,TenHTTT,TenHTGH,HoaDon.TrangThai from HoaDon join HoaDonChiTiet \n"
                + "on HoaDonChiTiet.ID = HoaDon.ID join KhachHang \n"
                + "on KhachHang.ID = HoaDon.IDKhachHang join NhanVien \n"
                + "on NhanVien.ID = HoaDon.IDNhanVien join HinhThucGiaoHang \n"
                + "on HinhThucGiaoHang.ID = HoaDon.IDHinhTGH join HinhThucThanhToan \n"
                + "on HinhThucThanhToan.ID = HoaDon.IDHinhTTT ";
        ResultSet rs = JDBCHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                listHD.add(new hoaDonViewModelHUY(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listHD;
    }

    public List<hoaDonViewModelHUY> timKiemHoaDonViewModel(String maHD) {
        List<hoaDonViewModelHUY> timKiem = new ArrayList<>();
        String sql = "select MaHD,NhanVien.HoVaTen,KhachHang.HoVaTen,SoLuong,TongTien,TenHTTT,TenHTGH,HoaDon.TrangThai from HoaDon join HoaDonChiTiet \n"
                + "on HoaDonChiTiet.ID = HoaDon.ID join KhachHang \n"
                + "on KhachHang.ID = HoaDon.IDKhachHang join NhanVien \n"
                + "on NhanVien.ID = HoaDon.IDNhanVien join HinhThucGiaoHang \n"
                + "on HinhThucGiaoHang.ID = HoaDon.IDHinhTGH join HinhThucThanhToan \n"
                + "on HinhThucThanhToan.ID = HoaDon.IDHinhTTT \n"
                + "where MaHD = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, maHD);
        try {
            while (rs.next()) {
               timKiem.add(new hoaDonViewModelHUY(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }

        return timKiem;
    }

    public List<hoaDonViewModelHUY> timKiemCombobox(String trangThai) {
        List<hoaDonViewModelHUY> listtimKiem = new ArrayList<>();
        String sql = "select MaHD,NhanVien.HoVaTen,KhachHang.HoVaTen,SoLuong,TongTien,TenHTTT,TenHTGH,HoaDon.TrangThai from HoaDon join HoaDonChiTiet \n"
                + "on HoaDonChiTiet.ID = HoaDon.ID join KhachHang \n"
                + "on KhachHang.ID = HoaDon.IDKhachHang join NhanVien \n"
                + "on NhanVien.ID = HoaDon.IDNhanVien join HinhThucGiaoHang \n"
                + "on HinhThucGiaoHang.ID = HoaDon.IDHinhTGH join HinhThucThanhToan \n"
                + "on HinhThucThanhToan.ID = HoaDon.IDHinhTTT \n"
                + "where HoaDon.TrangThai = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, trangThai);
        try {
            while (rs.next()) {
                listtimKiem.add(new hoaDonViewModelHUY(
                       rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listtimKiem;
    }

    public List<hoaDonViewModelHUY> timKiemCombobox1(String TenHTTT) {
        List<hoaDonViewModelHUY> listtimKiem = new ArrayList<>();
        String sql = "select MaHD,NhanVien.HoVaTen,KhachHang.HoVaTen,SoLuong,TongTien,TenHTTT,TenHTGH,HoaDon.TrangThai from HoaDon join HoaDonChiTiet \n"
                + "on HoaDonChiTiet.ID = HoaDon.ID join KhachHang \n"
                + "on KhachHang.ID = HoaDon.IDKhachHang join NhanVien \n"
                + "on NhanVien.ID = HoaDon.IDNhanVien join HinhThucGiaoHang \n"
                + "on HinhThucGiaoHang.ID = HoaDon.IDHinhTGH join HinhThucThanhToan \n"
                + "on HinhThucThanhToan.ID = HoaDon.IDHinhTTT \n"
                + "where TenHTTT = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, TenHTTT);
        try {
            while (rs.next()) {
                listtimKiem.add(new hoaDonViewModelHUY(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listtimKiem;
    }

    public List<hoaDonViewModelHUY> timKiemCombobox2(String TenHTGH) {
        List<hoaDonViewModelHUY> listtimKiem = new ArrayList<>();
        String sql = "select MaHD,NhanVien.HoVaTen,KhachHang.HoVaTen,SoLuong,TongTien,TenHTTT,TenHTGH,HoaDon.TrangThai from HoaDon join HoaDonChiTiet \n"
                + "on HoaDonChiTiet.ID = HoaDon.ID join KhachHang \n"
                + "on KhachHang.ID = HoaDon.IDKhachHang join NhanVien \n"
                + "on NhanVien.ID = HoaDon.IDNhanVien join HinhThucGiaoHang \n"
                + "on HinhThucGiaoHang.ID = HoaDon.IDHinhTGH join HinhThucThanhToan \n"
                + "on HinhThucThanhToan.ID = HoaDon.IDHinhTTT \n"
                + "where TenHTGH = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, TenHTGH);
        try {
            while (rs.next()) {
                listtimKiem.add(new hoaDonViewModelHUY(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listtimKiem;
    }
}
