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
import viewmodel.KhuyenMaiBanHang;

/**
 *
 * @author ASUS
 */
public class KhuyenMaiFormBanHang {

    public List<KhuyenMaiBanHang> giamGiaPhanTram(String ma) {
        String query = "SELECT dbo.SanPham.MaSP, dbo.SanPham.TenSp, dbo.ChiTietSanPham.SoLuong, dbo.GiamGia.MaKM, dbo.GiamGia.Ten, dbo.GiamGia.NgayBD, dbo.GiamGia.NgayKT, dbo.GiamGia.GiamGia, dbo.GiamGia.HinhThuc, dbo.GiamGia.TrangThai\n"
                + "FROM     dbo.ChiTietSanPham INNER JOIN\n"
                + "                  dbo.GiamGia ON dbo.ChiTietSanPham.IDKM = dbo.GiamGia.ID INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSanPham.IDSP = dbo.SanPham.ID\n"
                + "				  where dbo.GiamGia.TrangThai = N'Hoạt Động' and dbo.SanPham.MaSP like ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, "%" + ma + "%");
            List<KhuyenMaiBanHang> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhuyenMaiBanHang(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getLong(8),
                        rs.getString(9),
                        rs.getString(10)));
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new KhuyenMaiFormBanHang().giamGiaPhanTram("SP02").toString());
    }
}
