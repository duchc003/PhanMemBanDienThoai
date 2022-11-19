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
import viewmodel.NhaCungCapViewModel;

/**
 *
 * @author HieuIT
 */
public class NhaCungCapRepository {

    public List<NhaCungCapViewModel> getAll() {
        String query = "SELECT [ID]\n"
                + "      ,[MaNCC]\n"
                + "      ,[TenNCC]\n"
                + "  FROM [dbo].[NhaCungCap]";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<NhaCungCapViewModel> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new NhaCungCapViewModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(NhaCungCapViewModel ncc) {
        String query = "INSERT INTO [dbo].[NhaCungCap]\n"
                + "           ([MaNCC]\n"
                + "           ,[TenNCC])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ncc.getMa());
            ps.setObject(2, ncc.getTen());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean sua(int id, NhaCungCapViewModel ncc) {
        String query = "UPDATE [dbo].[NhaCungCap]\n"
                + "   SET [MaNCC] = ?\n"
                + "      ,[TenNCC] = ?\n"
                + " WHERE ID = ?";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ncc.getMa());
            ps.setObject(2, ncc.getTen());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean xoa(int id) {
        String query = "DELETE FROM [dbo].[NhaCungCap]\n"
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
