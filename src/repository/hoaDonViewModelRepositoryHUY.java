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
        String sql = "select HoaDon.MaHD,KhachHang.HoVaTen,HoaDonChiTiet.SoLuong,HoaDonChiTiet.ThanhTien,TenHTTT,TenHTGH,TrangThai from\n"
                + "HoaDon join KhachHang on KhachHang.ID = HoaDon.ID join HinhThucGiaoHang on HinhThucGiaoHang.ID = HoaDon.IDHinhTGH join HinhThucThanhToan on HinhThucThanhToan.ID = HoaDon.IDHinhTTT join HoaDonChiTiet \n"
                + "on HoaDon.ID = HoaDonChiTiet.IDHoaDon join SanPham on SanPham.ID = HoaDonChiTiet.IDSP";
        ResultSet rs = JDBCHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                listHD.add(new hoaDonViewModelHUY(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listHD;
    }

    public List<hoaDonViewModelHUY> timKiemHoaDonViewModel(String maHD) {
        List<hoaDonViewModelHUY> timKiem = new ArrayList<>();
        String sql = "select HoaDon.MaHD,KhachHang.HoVaTen,HoaDonChiTiet.SoLuong,HoaDonChiTiet.ThanhTien,TenHTTT,TenHTGH,TrangThai from\n"
                + "HoaDon join KhachHang on KhachHang.ID = HoaDon.ID join HinhThucGiaoHang on HinhThucGiaoHang.ID = HoaDon.IDHinhTGH join HinhThucThanhToan on HinhThucThanhToan.ID = HoaDon.IDHinhTTT join HoaDonChiTiet \n"
                + "on HoaDon.ID = HoaDonChiTiet.IDHoaDon join SanPham on SanPham.ID = HoaDonChiTiet.IDSP\n"
                + "where MaHD = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, maHD);
        try {
            while (rs.next()) {
                timKiem.add(new hoaDonViewModelHUY(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }

        return timKiem;
    }
    public List<hoaDonViewModelHUY> timKiemCombobox(String trangThai){
        List<hoaDonViewModelHUY> listtimKiem = new ArrayList<>();
        String sql ="select HoaDon.MaHD,KhachHang.HoVaTen,HoaDonChiTiet.SoLuong,HoaDonChiTiet.ThanhTien,TenHTTT,TenHTGH,TrangThai from\n"
                + "HoaDon join KhachHang on KhachHang.ID = HoaDon.ID join HinhThucGiaoHang on HinhThucGiaoHang.ID = HoaDon.IDHinhTGH join HinhThucThanhToan on HinhThucThanhToan.ID = HoaDon.IDHinhTTT join HoaDonChiTiet \n"
                + "on HoaDon.ID = HoaDonChiTiet.IDHoaDon join SanPham on SanPham.ID = HoaDonChiTiet.IDSP\n"
                + "where TrangThai = ?";
        ResultSet rs= JDBCHelper.executeQuery(sql, trangThai);
        try {
            while (rs.next()) {
                listtimKiem.add(new hoaDonViewModelHUY(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
           
            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listtimKiem;
    }
     public List<hoaDonViewModelHUY> timKiemCombobox1(String TenHTTT){
        List<hoaDonViewModelHUY> listtimKiem = new ArrayList<>();
        String sql ="select HoaDon.MaHD,KhachHang.HoVaTen,HoaDonChiTiet.SoLuong,HoaDonChiTiet.ThanhTien,TenHTTT,TenHTGH,TrangThai from\n"
                + "HoaDon join KhachHang on KhachHang.ID = HoaDon.ID join HinhThucGiaoHang on HinhThucGiaoHang.ID = HoaDon.IDHinhTGH join HinhThucThanhToan on HinhThucThanhToan.ID = HoaDon.IDHinhTTT join HoaDonChiTiet \n"
                + "on HoaDon.ID = HoaDonChiTiet.IDHoaDon join SanPham on SanPham.ID = HoaDonChiTiet.IDSP\n"
                + "where TenHTTT = ?";
        ResultSet rs= JDBCHelper.executeQuery(sql, TenHTTT);
        try {
            while (rs.next()) {
                listtimKiem.add(new hoaDonViewModelHUY(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
           
            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listtimKiem;
    }
    
       public List<hoaDonViewModelHUY> timKiemCombobox2(String TenHTGH){
        List<hoaDonViewModelHUY> listtimKiem = new ArrayList<>();
        String sql ="select HoaDon.MaHD,KhachHang.HoVaTen,HoaDonChiTiet.SoLuong,HoaDonChiTiet.ThanhTien,TenHTTT,TenHTGH,TrangThai from\n"
                + "HoaDon join KhachHang on KhachHang.ID = HoaDon.ID join HinhThucGiaoHang on HinhThucGiaoHang.ID = HoaDon.IDHinhTGH join HinhThucThanhToan on HinhThucThanhToan.ID = HoaDon.IDHinhTTT join HoaDonChiTiet \n"
                + "on HoaDon.ID = HoaDonChiTiet.IDHoaDon join SanPham on SanPham.ID = HoaDonChiTiet.IDSP\n"
                + "where TenHTTT = ?";
        ResultSet rs= JDBCHelper.executeQuery(sql, TenHTGH);
        try {
            while (rs.next()) {
                listtimKiem.add(new hoaDonViewModelHUY(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
           
            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listtimKiem;
    }
}
