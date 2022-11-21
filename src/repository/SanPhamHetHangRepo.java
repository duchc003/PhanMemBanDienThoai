/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import viewmodel.SanPhamHetHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.ConnectDB;

/**
 *
 * @author ASUS
 */
public class SanPhamHetHangRepo {

    public List<SanPhamHetHang> getALL() {
        String query = "SELECT dbo.ChiTietSanPham.ID, dbo.SanPham.MaSP, dbo.SanPham.TenSp, dbo.HangSanPham.TenHangSP, dbo.ChiTietSanPham.SoLuong, dbo.ChiTietSanPham.Ram, dbo.ChiTietSanPham.XuatXu, dbo.ChiTietSanPham.Camera, dbo.ChiTietSanPham.ManHinh, \n"
                + "                  dbo.ChiTietSanPham.BoNho, dbo.ChiTietSanPham.MauSac, dbo.ChiTietSanPham.TrangThai\n"
                + "FROM     dbo.ChiTietSanPham INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSanPham.IDSP = dbo.SanPham.ID INNER JOIN\n"
                + "                  dbo.HangSanPham ON dbo.SanPham.IDHang = dbo.HangSanPham.ID\n"
                + "				  where dbo.ChiTietSanPham.SoLuong like 0";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
//            ps.setObject(1, "%" + soLuong + "%");
            List<SanPhamHetHang> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPhamHetHang(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<SanPhamHetHang> list = new SanPhamHetHangRepo().getALL();
        System.out.println(list.toString());
    }
}
