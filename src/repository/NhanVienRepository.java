/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import viewmodel.NhanVienViewmodel;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HinhThucGiaoHang;
import model.HinhThucThanhToan;
import model.KhachHang;
import model.NhanVien;
import util.ConnectDB;
import util.JDBCHelper;

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
                + "      ,[VaiTro]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[NhanVien]";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<NhanVienViewmodel> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new NhanVienViewmodel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getInt(8)));
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
                + "           ,[Email]\n"
                + "           ,[VaiTro]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getHoVaTen());
            ps.setObject(3, nv.getDiaChi());
            ps.setObject(4, nv.getGioiTinh());
            ps.setObject(5, nv.getSdt());
            ps.setObject(6, nv.getEmail());
            ps.setObject(7, nv.isVaiTro());
            ps.setObject(8, nv.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public ArrayList<NhanVienViewmodel> checkMa(String maNV) {
        ArrayList< NhanVienViewmodel> listkh = new ArrayList<>();
        String query = "SELECT [MaNV]\n"
                + "      ,[HoVaTen]\n"
                + "      ,[DiaChi]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[SDT]\n"
                + "      ,[Email]\n"
                + "      ,[VaiTro]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[NhanVien] where MaNV = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienViewmodel nv = new NhanVienViewmodel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getInt(8));
                listkh.add(nv);
                return listkh;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<NhanVienViewmodel> getOne(String maNV, String hoVaTen, String sdt) {
        List< NhanVienViewmodel> NhanVienViewmodels = new ArrayList<>();
        String sql = "SELECT [MaNV]\n"
                + "      ,[HoVaTen]\n"
                + "      ,[DiaChi]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[SDT]\n"
                + "      ,[Email]\n"
                + "      ,[VaiTro]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[NhanVien] where MaNV = ? or HoVaTen = ? or SDT = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, maNV, hoVaTen, sdt);
        try {
            while (rs.next()) {
                NhanVienViewmodels.add(new NhanVienViewmodel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getInt(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NhanVienViewmodels;
    }

    public boolean sua(String maNV, NhanVienViewmodel nv) {
        String query = "UPDATE [dbo].[NhanVien]\n"
                + "   SET [MaNV] = ?\n"
                + "      ,[HoVaTen] = ?\n"
                + "      ,[DiaChi] = ?\n"
                + "      ,[GioiTinh] = ?\n"
                + "      ,[SDT] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[VaiTro] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE MaNV = ?";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getHoVaTen());
            ps.setObject(3, nv.getDiaChi());
            ps.setObject(4, nv.getGioiTinh());
            ps.setObject(5, nv.getSdt());
            ps.setObject(6, nv.getEmail());
            ps.setObject(7, nv.isVaiTro());
            ps.setObject(8, nv.getTrangThai());
            ps.setObject(9, maNV);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public ArrayList<NhanVien> getIDNhanVien(String Id) {
        ArrayList<NhanVien> listkh = new ArrayList<>();
        String query = "select Id from NHANVIEN where HoVaTen =  ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, Id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getInt(1));
                listkh.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listkh;
    }

    public ArrayList<KhachHang> getIDKhachHang(String Id) {
        ArrayList<KhachHang> listkh = new ArrayList<>();
        String query = "select Id from KhachHang where HoVaTen =  ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, Id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang nv = new KhachHang(rs.getInt(1));
                listkh.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listkh;
    }

    public ArrayList<HinhThucGiaoHang> getIDGiaoHang() {
        ArrayList<HinhThucGiaoHang> listkh = new ArrayList<>();
        String query = "select id from HinhThucGiaoHang where TenHTGH = N'Tại Quầy'";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HinhThucGiaoHang nv = new HinhThucGiaoHang(rs.getInt(1));
                listkh.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listkh;
    }

    public ArrayList<HinhThucThanhToan> getIDThanhToan() {
        ArrayList<HinhThucThanhToan> listkh = new ArrayList<>();
        String query = "select id from HinhThucThanhToan where TenHTTT = N'Tiền Mặt'";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HinhThucThanhToan nv = new HinhThucThanhToan(rs.getInt(1));
                listkh.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listkh;
    }

    public static void main(String[] args) {
    }
}
