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
import viewmodel.HangSPViewmodel;
import java.sql.*;
import util.ConnectDB;

/**
 *
 * @author HieuIT
 */
public class HangSPRepository {

    public List<HangSPViewmodel> getAll() {
        String query = "SELECT [ID]\n"
                + "      ,[MaHangSP]\n"
                + "      ,[TenHangSP]\n"
                + "  FROM [dbo].[HangSanPham]";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HangSPViewmodel> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new HangSPViewmodel(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(HangSPViewmodel h) {
        String query = "INSERT INTO [dbo].[HangSanPham]\n"
                + "           ([MaHangSP]\n"
                + "           ,[TenHangSP])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, h.getMa());
            ps.setObject(2, h.getTen());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean sua(int id, HangSPViewmodel h) {
        String query = "UPDATE [dbo].[HangSanPham]\n"
                + "   SET [MaHangSP] = ?\n"
                + "      ,[TenHangSP] = ?\n"
                + " WHERE ID = ?";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, h.getMa());
            ps.setObject(2, h.getTen());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean xoa(int id) {
        String query = "DELETE FROM [dbo].[HangSanPham]\n"
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

    public static void main(String[] args) {
        new HangSPRepository().getAll().forEach((t) -> System.out.println(t.toString()));
    }
}
