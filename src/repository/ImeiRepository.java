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
import model.ChiTietSP;
import model.Imei;
import util.ConnectDB;
import util.JDBCHelper;

/**
 *
 * @author ASUS
 */
public class ImeiRepository {

    public List<Imei> getALL() {
        String query = "SELECT [Id]\n"
                + "      ,[MaImei]\n"
                + "      ,[TrangThai]\n"
                + "      ,[IDSanPham]\n"
                + "  FROM [dbo].[Imei]";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            List<Imei> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Imei(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(Imei imei) {
        String query = "INSERT INTO [dbo].[Imei]\n"
                + "           ([MaImei]\n"
                + "           ,[TrangThai]\n"
                + "           ,[IDSanPham])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        int check = 0;
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, imei.getMaImei());
            ps.setObject(2, imei.getTrangThai());
            ps.setObject(3, imei.getIdSanPham());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
}
