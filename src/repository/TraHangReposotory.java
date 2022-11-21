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
import viewmodel.TraHangViewmodel;

/**
 *
 * @author HieuIT
 */
public class TraHangReposotory {

    public List<TraHangViewmodel> getAll() {
        String query = "SELECT        dbo.HoaDon.MaHD, dbo.KhachHang.HoVaTen, dbo.HoaDonChiTiet.SoLuong, dbo.HoaDon.NgayThanhToan, dbo.HoaDonChiTiet.ThanhTien\n"
                + "FROM            dbo.HoaDon INNER JOIN\n"
                + "                         dbo.HoaDonChiTiet ON dbo.HoaDon.ID = dbo.HoaDonChiTiet.IDHoaDon INNER JOIN\n"
                + "                         dbo.KhachHang ON dbo.HoaDon.IDKhachHang = dbo.KhachHang.ID";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(query);){
            ResultSet rs = ps.executeQuery();
            List<TraHangViewmodel> list = new ArrayList<>();
            while (rs.next()) {                
                list.add(new TraHangViewmodel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getFloat(5)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
