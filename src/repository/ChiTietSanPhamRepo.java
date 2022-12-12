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
import viewmodel.KhuyenMaiViewModel;

/**
 *
 * @author ASUS
 */
public class ChiTietSanPhamRepo {

    public List<ChiTietSPView> getALL() {
        String query = "SELECT [ID]\n"
                + "      ,[IDSP]\n"
                + "      ,[IDNCC]\n"
                + "      ,[IDKM]\n"
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
                + "  where TrangThai = N'Còn Hàng'";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            List<ChiTietSPView> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ChiTietSPView(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getLong(12),
                        rs.getLong(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16),
                        rs.getString(17)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SanPham> getIDSP() {
        String query = "select * from SanPham";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            List<SanPham> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ChiTietSP getBarcode(String bar) {
        String query = "SELECT dbo.SanPham.MaSP, dbo.SanPham.TenSp, dbo.ChiTietSanPham.SoLuong, dbo.ChiTietSanPham.GiaNhap\n"
                + "FROM     dbo.ChiTietSanPham INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSanPham.IDSP = dbo.SanPham.ID\n"
                + "				  where Barcode = ?";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, bar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSP sp = new ChiTietSP();
                sp.setBarcodde(rs.getString(1));
                sp.setBoNho(rs.getString(2));
                sp.setSoLuong(rs.getInt(3));
                sp.setGiaNhap(rs.getLong(4));
                return sp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SanPham getOneSP(String ten) {
        String query = "select * from SanPham where tenSP = ?";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new SanPham(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public KhuyenMaiViewModel getOneKm(String ten) {
        String query = "SELECT dbo.GiamGia.ID, dbo.GiamGia.MaKM, dbo.GiamGia.Ten, dbo.HinhThucKhuyenMai.TenHinhThucKm, dbo.GiamGia.NgayBD, dbo.GiamGia.NgayKT, dbo.GiamGia.GiamGia, dbo.GiamGia.TrangThai, \n"
                + "                  dbo.GiamGia.Mota\n"
                + "FROM     dbo.GiamGia INNER JOIN\n"
                + "                  dbo.HinhThucKhuyenMai ON dbo.GiamGia.IDHinhThuc = dbo.HinhThucKhuyenMai.Id\n"
                + "				  where dbo.HinhThucKhuyenMai.TenHinhThucKm = ?";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new KhuyenMaiViewModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getLong(7),
                        rs.getString(8),
                        rs.getString(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<NhaCungCap> getIDNCC() {
        String query = "select * from NhaCungCap";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
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

    public NhaCungCap getOneNCC(String ten) {
        String query = "select * from NhaCungCap where tenNCC = ?";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new NhaCungCap(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(ChiTietSP sp) {
        String query = "INSERT INTO [dbo].[ChiTietSanPham]\n"
                + "           ([IDSP]\n"
                + "           ,[IDNCC]\n"
                + "           ,[IDKM]\n"
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
                + "           (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sp.getIdSP());
            ps.setObject(2, sp.getNhaCungCap());
            ps.setObject(3, sp.getIdKm());
            ps.setObject(4, sp.getSoLuong());
            ps.setObject(5, sp.getRam());
            ps.setObject(6, sp.getXuatXu());
            ps.setObject(7, sp.getCamera());
            ps.setObject(8, sp.getManHinh());
            ps.setObject(9, sp.getBoNho());
            ps.setObject(10, sp.getMauSac());
            ps.setObject(11, sp.getGiaNhap());
            ps.setObject(12, sp.getGiaBan());
            ps.setObject(13, sp.getImage());
            ps.setObject(14, sp.getBarcodde());
            ps.setObject(15, sp.getTrangThai());
            ps.setObject(16, sp.getMoTa());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean update(int id, ChiTietSP sp) {
        String query = "UPDATE [dbo].[ChiTietSanPham]\n"
                + "   SET [IDSP] = ?\n"
                + "      ,[IDNCC] = ?\n"
                + "      ,[IDKM] = ?\n"
                + "      ,[SoLuong] = ?\n"
                + "      ,[Ram] = ?\n"
                + "      ,[XuatXu] = ?\n"
                + "      ,[Camera] = ?\n"
                + "      ,[ManHinh] = ?\n"
                + "      ,[BoNho] = ?\n"
                + "      ,[MauSac] = ?\n"
                + "      ,[GiaNhap] =?\n"
                + "      ,[GiaBan] = ?\n"
                + "      ,[Image] = ?\n"
                + "      ,[Barcode] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + "      ,[MoTa] = ?\n"
                + " WHERE id =?";
        int check = 0;
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sp.getIdSP());
            ps.setObject(2, sp.getNhaCungCap());
            ps.setObject(3, sp.getIdKm());
            ps.setObject(4, sp.getSoLuong());
            ps.setObject(5, sp.getRam());
            ps.setObject(6, sp.getXuatXu());
            ps.setObject(7, sp.getCamera());
            ps.setObject(8, sp.getManHinh());
            ps.setObject(9, sp.getBoNho());
            ps.setObject(10, sp.getMauSac());
            ps.setObject(11, sp.getGiaNhap());
            ps.setObject(12, sp.getGiaBan());
            ps.setObject(13, sp.getImage());
            ps.setObject(14, sp.getBarcodde());
            ps.setObject(15, sp.getTrangThai());
            ps.setObject(16, sp.getMoTa());
            ps.setObject(17, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public static void main(String[] args) {
        System.out.println(new ChiTietSanPhamRepo().getBarcode("1234567890111"));
    }
}
