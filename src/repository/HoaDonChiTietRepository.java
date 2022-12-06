/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.JDBCHelper;
import viewmodel.ChiTietHoaDonView;

/**
 *
 * @author ASUS
 */
public class HoaDonChiTietRepository {

    public List<ChiTietHoaDonView> getAllHoaDonChiTiet(int id) {
        String sql = "select MaHD ,TenSp,SoLuong,DonGia,TienThua,TienGiamGia from  HoaDonChiTiet join SanPham \n"
                + "on SanPham.ID = HoaDonChiTiet.IDSP join HoaDon \n"
                + "on HoaDon.ID = HoaDonChiTiet.IDHoaDon\n"
                + "where HoaDon.ID =  ?";
        List<ChiTietHoaDonView> listhdct = new ArrayList<>();
        ResultSet rs = JDBCHelper.executeQuery(sql, id);
        try {
            while (rs.next()) {
                listhdct.add(new ChiTietHoaDonView(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getLong(4),
                        rs.getLong(5),
                        rs.getLong(6)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();;
        }
        return listhdct;
    }

    public static void main(String[] args) {
        System.out.println(new HoaDonChiTietRepository().getAllHoaDonChiTiet(60).toString());
    }
}
