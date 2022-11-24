/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConnectDB;
import viewmodel.SanPhamViewModel;
import viewmodel.ThongkeSanPhamViewModel;
import viewmodel.ThongKeDoanhThuViewModel;

public class ThongKeSanPhamRepository {

    public List<ThongkeSanPhamViewModel> all() {
        List<ThongkeSanPhamViewModel> lists = new ArrayList<>();
        String query = " SELECT dbo.SanPham.MaSP, dbo.SanPham.TenSp, dbo.ChiTietSanPham.SoLuong, dbo.ChiTietSanPham.TrangThai\n"
                + "FROM     dbo.ChiTietSanPham INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSanPham.IDSP = dbo.SanPham.ID";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongkeSanPhamViewModel thongKeSanPhamViewModel = new ThongkeSanPhamViewModel();
                thongKeSanPhamViewModel.setMaSp(rs.getString(1));
                thongKeSanPhamViewModel.setTenSP(rs.getString(2));
                thongKeSanPhamViewModel.setSoLuong(rs.getInt(3));
                thongKeSanPhamViewModel.setTrangThai(rs.getString(4));

                lists.add(thongKeSanPhamViewModel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lists;
    }

    public List<ThongKeDoanhThuViewModel> getall() {
        List<ThongKeDoanhThuViewModel> listt = new ArrayList<>();
        String query = "SELECT dbo.HoaDon.MaHD, dbo.HoaDonChiTiet.SoLuong, dbo.ChiTietSanPham.GiaNhap, dbo.ChiTietSanPham.GiaBan, dbo.HoaDonChiTiet.ThanhTien\n"
                + "FROM     dbo.ChiTietSanPham INNER JOIN\n"
                + "                  dbo.HoaDonChiTiet ON dbo.ChiTietSanPham.ID = dbo.HoaDonChiTiet.ID INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.HoaDonChiTiet.IDHoaDon = dbo.HoaDon.ID";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeDoanhThuViewModel thongKedoanhthuViewModel = new ThongKeDoanhThuViewModel();
                thongKedoanhthuViewModel.setMaHD(rs.getString(1));
                thongKedoanhthuViewModel.setSoLuong(rs.getInt(2));
                thongKedoanhthuViewModel.setGiaNhap(rs.getFloat(3));
                thongKedoanhthuViewModel.setGiaBan(rs.getFloat(4));
                thongKedoanhthuViewModel.setDoanhThu(rs.getFloat(5));

                listt.add(thongKedoanhthuViewModel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listt;
    }
}
