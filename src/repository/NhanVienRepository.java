/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import viewmodel.NhanVienViewmodel;
import java.sql.*;
import java.util.ArrayList;
import util.ConnectDB;

/**
 *
 * @author HieuIT
 */
public class NhanVienRepository {

    public List<NhanVienViewmodel> getAll() {
        String query = "SELECT [MaNV]\n"
                + "      ,[HoVaTen]\n"
                + "      ,[DiaChi]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[SDT]\n"
                + "      ,[Email]\n"
                + "  FROM [dbo].[NhanVien]";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<NhanVienViewmodel> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new NhanVienViewmodel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(NhanVienViewmodel nv) {
        String query = "INSERT INTO [dbo].[NhanVien]\n"
                + "           ([MaNV]\n"
                + "           ,[HoVaTen]\n"
                + "           ,[DiaChi]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[SDT]\n"
                + "           ,[Email])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getHoVaTen());
            ps.setObject(3, nv.getDiaChi());
            ps.setObject(4, nv.getGioiTinh());
            ps.setObject(5, nv.getSdt());
            ps.setObject(6, nv.getEmail());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean xoa(String maNV) {
        String query = "DELETE FROM [dbo].[NhanVien]\n"
                + "      WHERE [MaNV] = ?";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maNV);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public ArrayList<NhanVienViewmodel> getOne(String maNV) {
        ArrayList< NhanVienViewmodel> listkh = new ArrayList<>();
        String query = "SELECT [MaNV]\n"
                + "      ,[HoVaTen]\n"
                + "      ,[DiaChi]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[SDT]\n"
                + "      ,[Email]\n"
                + "  FROM [dbo].[NhanVien] where MaNV = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienViewmodel nv = new NhanVienViewmodel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                listkh.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listkh;
    }

    public boolean sua(String maNV, NhanVienViewmodel nv) {
        String query = "UPDATE [dbo].[NhanVien]\n"
                + "   SET [MaNV] = ?\n"
                + "      ,[HoVaTen] = ?\n"
                + "      ,[DiaChi] = ?\n"
                + "      ,[GioiTinh] = ?\n"
                + "      ,[SDT] = ?\n"
                + "      ,[Email] = ?\n"
                + " WHERE MaNV = ?";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getHoVaTen());
            ps.setObject(3, nv.getDiaChi());
            ps.setObject(4, nv.getGioiTinh());
            ps.setObject(5, nv.getSdt());
            ps.setObject(6, nv.getEmail());
            ps.setObject(7, maNV);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
}
