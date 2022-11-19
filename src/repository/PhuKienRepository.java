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
import viewmodel.PhuKienViewmodel;

/**
 *
 * @author HieuIT
 */
public class PhuKienRepository {

    public List<PhuKienViewmodel> getAll() {
        String query = "SELECT [ID]\n"
                + "      ,[MaPhuKien]\n"
                + "      ,[TenPhuKien]\n"
                + "  FROM [dbo].[PhuKien]";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<PhuKienViewmodel> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new PhuKienViewmodel(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(PhuKienViewmodel pk) {
        String query = "INSERT INTO [dbo].[PhuKien]\n"
                + "           ([MaPhuKien]\n"
                + "           ,[TenPhuKien])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, pk.getMa());
            ps.setObject(2, pk.getTen());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean sua(int id, PhuKienViewmodel pk) {
        String query = "UPDATE [dbo].[PhuKien]\n"
                + "   SET [MaPhuKien] = ?\n"
                + "      ,[TenPhuKien] = ?\n"
                + " WHERE ID = ?";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, pk.getMa());
            ps.setObject(2, pk.getTen());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean xoa(int id) {
        String query = "DELETE FROM [dbo].[PhuKien]\n"
                + "      WHERE ID = ?";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
}
