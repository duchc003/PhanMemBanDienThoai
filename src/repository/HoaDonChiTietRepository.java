/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import model.HoaDon;
import util.ConnectDB;
import util.JDBCHelper;
import viewmodel.ChiTietHoaDonView;
import viewmodel.ChiTietSPView;
import viewmodel.HoaDonViewModel;

/**
 *
 * @author ASUS
 */
public class HoaDonChiTietRepository {

    public List<ChiTietHoaDonView> getAllHoaDonChiTiet(int id) {
        String sql = "SELECT dbo.HoaDonChiTiet.ID, dbo.HoaDon.MaHD, dbo.SanPham.TenSp, dbo.HoaDonChiTiet.SoLuong, dbo.HoaDonChiTiet.TienThua, dbo.HoaDonChiTiet.DonGia, dbo.HoaDonChiTiet.TienGiamGia\n"
                + "FROM     dbo.HoaDon INNER JOIN\n"
                + "                  dbo.HoaDonChiTiet ON dbo.HoaDon.ID = dbo.HoaDonChiTiet.IDHoaDon INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.HoaDonChiTiet.IDSP = dbo.SanPham.ID\n"
                + "				  where HoaDon.ID =  ?";
        List<ChiTietHoaDonView> listhdct = new ArrayList<>();
        ResultSet rs = JDBCHelper.executeQuery(sql, id);
        try {
            while (rs.next()) {
                listhdct.add(new ChiTietHoaDonView(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getLong(5),
                        rs.getLong(6),
                        rs.getLong(7)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();;
        }
        return listhdct;
    }
}
