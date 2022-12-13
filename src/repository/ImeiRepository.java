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
import model.HoaDon;
import model.HoaDonCT;
import model.Imei;
import model.SanPham;
import model.imeiDaBan;
import util.ConnectDB;
import util.JDBCHelper;
import viewmodel.HoaDonViewModel;

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

    public boolean addImei(imeiDaBan imei) {
        String query = "INSERT INTO [dbo].[ImeiDaBan]\n"
                + "           ([MaImei]\n"
                + "           ,[TrangThai]\n"
                + "           ,[IDHOaDon])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        int check = 0;
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, imei.getMa());
            ps.setObject(2, imei.getTrangThai());
            ps.setObject(3, imei.getIdHoaDon());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public List<Imei> getALLID(int id) {
        String query = "select * from Imei where IDSanPham = ?";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, id);
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
    
    public List<Imei> getALL(int id) {
        String query = "select * from Imei where IDSanPham = ?";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, id);
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

    public Imei getOne() {
        String query = "SELECT [Id]\n"
                + "      ,[MaImei]\n"
                + "      ,[TrangThai]\n"
                + "      ,[IDSanPham]\n"
                + "  FROM [dbo].[Imei]";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Imei(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SanPham getOneID(String id) {
        String query = "select id from sanPham where MaSP = ? ";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new SanPham(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public HoaDonViewModel getOneIDHoaDon(int id) {
        String query = "select id from HoaDon where ID = ?";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new HoaDonViewModel(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public HoaDon getOneIDHD(int id) {
        String query = "select id from HoaDon where ID = ?";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                new HoaDon(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean delete(int id) {
        String query = "DELETE FROM [dbo].[Imei]\n"
                + "      WHERE IDSanPham = ?";
        int check = 0;
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public static void main(String[] args) {
        System.out.println(new ImeiRepository().getALLID(4).toString());
    }

}
