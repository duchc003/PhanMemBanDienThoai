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
import model.ChiTietSP;
import model.NhaCungCap;
import model.SanPham;
import util.ConnectDB;
import viewmodel.ChiTietSPView;

/**
 *
 * @author ASUS
 */
public class ChiTietSanPhamRepo {

    public List<ChiTietSPView> getALL() {
        String query = "SELECT [ID]\n"
                + "      ,[IDSP]\n"
                + "      ,[IDNCC]\n"
                + "      ,[SoLuong]\n"
                + "      ,[Ram]\n"
                + "      ,[XuatXu]\n"
                + "      ,[Camera]\n"
                + "      ,[ManHinh]\n"
                + "      ,[BoNho]\n"
                + "      ,[MauSac]\n"
                + "      ,[GiaNhap]\n"
                + "      ,[GiaBan]\n"
                + "      ,[Image]\n"
                + "      ,[Barcode]\n"
                + "      ,[TrangThai]\n"
                + "      ,[MoTa]\n"
                + "  FROM [dbo].[ChiTietSanPham]\n"
                + "  where TrangThai = '1'";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<ChiTietSPView> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ChiTietSPView(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getFloat(11),
                        rs.getFloat(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(15),
                        rs.getString(16)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SanPham> getIDSP() {
        String query = "select * from SanPham";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<SanPham> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<NhaCungCap> getIDNCC() {
        String query = "select * from NhaCungCap";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<NhaCungCap> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new NhaCungCap(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(ChiTietSP sp) {
        String query = "INSERT INTO [dbo].[ChiTietSanPham]\n"
                + "           ([IDSP]\n"
                + "           ,[IDNCC]\n"
                + "           ,[SoLuong]\n"
                + "           ,[Ram]\n"
                + "           ,[XuatXu]\n"
                + "           ,[Camera]\n"
                + "           ,[ManHinh]\n"
                + "           ,[BoNho]\n"
                + "           ,[MauSac]\n"
                + "           ,[GiaNhap]\n"
                + "           ,[GiaBan]\n"
                + "           ,[Image]\n"
                + "           ,[Barcode]\n"
                + "           ,[TrangThai]\n"
                + "           ,[MoTa])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sp.getIdSP());
            ps.setObject(2, sp.getNhaCungCap());
            ps.setObject(3, sp.getSoLuong());
            ps.setObject(4, sp.getRam());
            ps.setObject(5, sp.getXuatXu());
            ps.setObject(6, sp.getCamera());
            ps.setObject(7, sp.getManHinh());
            ps.setObject(8, sp.getBoNho());
            ps.setObject(9, sp.getMauSac());
            ps.setObject(10, sp.getGiaNhap());
            ps.setObject(11, sp.getGiaBan());
            ps.setObject(12, sp.getImage());
            ps.setObject(13, sp.getBarcodde());
            ps.setObject(14, sp.getTrangThai());
            ps.setObject(15, sp.getMoTa());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean update(int id, ChiTietSP sp) {
        String query = "UPDATE [dbo].[ChiTietSanPham]\n"
                + "   SET [SoLuong] = ?\n"
                + "      ,[Ram] = ?\n"
                + "      ,[XuatXu] = ?\n"
                + "      ,[Camera] = ?\n"
                + "      ,[ManHinh] = ?\n"
                + "      ,[BoNho] = ?\n"
                + "      ,[MauSac] = ?\n"
                + "      ,[GiaNhap] = ?\n"
                + "      ,[GiaBan] = ?\n"
                + "      ,[Image] = ?\n"
                + "      ,[Barcode] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + "      ,[MoTa] = ?\n"
                + " WHERE ID = ?";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sp.getSoLuong());
            ps.setObject(2, sp.getRam());
            ps.setObject(3, sp.getXuatXu());
            ps.setObject(4, sp.getCamera());
            ps.setObject(5, sp.getManHinh());
            ps.setObject(6, sp.getBoNho());
            ps.setObject(7, sp.getMauSac());
            ps.setObject(8, sp.getGiaNhap());
            ps.setObject(9, sp.getGiaBan());
            ps.setObject(10, sp.getImage());
            ps.setObject(11, sp.getBarcodde());
            ps.setObject(12, sp.getTrangThai());
            ps.setObject(13, sp.getMoTa());
            ps.setObject(14, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public static void main(String[] args) {
        System.out.println(new ChiTietSanPhamRepo().getALL());
    }
}
