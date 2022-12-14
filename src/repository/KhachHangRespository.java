package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KhachHang;
import util.JDBCHelper;
import viewmodel.KhachHangViewModel;

public class KhachHangRespository {

    public List<KhachHangViewModel> getAll() {
        List<KhachHangViewModel> khachHangViewModels = new ArrayList<>();
        String sql = " SELECT MaKH,HoVaTen,SoDienThoai,NgaySinh,DiaChi,GioiTinh,MoTa from KhachHang";
        ResultSet rs = JDBCHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                khachHangViewModels.add(new KhachHangViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khachHangViewModels;
    }

    public int addKH(KhachHang kh) {
        int row = 0;
        String sql = "INSERT INTO KhachHang(MaKH,HoVaTen,GioiTinh,NgaySinh,SoDienThoai,DiaChi,MoTa) VALUES(?,?,?,?,?,?,?)";
        row = JDBCHelper.executeUpdate(sql, kh.getMa(), kh.getHoVaTen(), kh.getGioiTinh(), kh.getNgaySinh(), kh.getSoDienThoai(), kh.getDiaChi(), kh.getMoTa());
        return row;
    }

    public int addKH2(KhachHangViewModel kh) {
        int row = 0;
        String sql = "INSERT INTO KhachHang(MaKH,HoVaTen,GioiTinh,NgaySinh,SoDienThoai,DiaChi,MoTa) VALUES(?,?,?,?,?,?,?)";
        row = JDBCHelper.executeUpdate(sql, kh.getMa(), kh.getHoVaTen(), kh.getGioiTinh(), kh.getNgaySinh(), kh.getSoDienThoai(), kh.getDiaChi(), kh.getMoTa());
        return row;
    }

    public int addKhachHangGiao(KhachHangViewModel kh) {
        int row = 0;
        String sql = "INSERT INTO [dbo].[KhachHang]\n"
                + "           ([MaKH]\n"
                + "           ,[HoVaTen]\n"
                + "           ,[SoDienThoai]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[DiaChi]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[MoTa])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        row = JDBCHelper.executeUpdate(sql,kh.getMa(),kh.getHoVaTen(), kh.getSoDienThoai(),kh.getNgaySinh() ,kh.getDiaChi(),kh.getGioiTinh(),kh.getMoTa());
        return row;
    }

    public int deleteKH(String ma) {
        int row = 0;
        String sql = "DELETE KHACHHANG WHERE MaKH = ?";
        row = JDBCHelper.executeUpdate(sql, ma);
        return row;
    }

    public int updateKH(KhachHang kh) {
        int row = 0;
        String sql = "UPDATE KhachHang SET HoVaTen =? ,SoDienThoai=?, NgaySinh=?,DiaChi=?,GioiTinh=?,MoTa=?\n"
                + "WHERE MaKH = ?";
        row = JDBCHelper.executeUpdate(sql, kh.getHoVaTen(), kh.getSoDienThoai(), kh.getNgaySinh(), kh.getDiaChi(), kh.getGioiTinh(), kh.getMoTa(), kh.getMa());
        return row;
    }

    public List<KhachHangViewModel> searchKH(String ma) {
        List<KhachHangViewModel> khachHangViewModels = new ArrayList<>();
        String sql = " SELECT MaKH,HoVaTen,SoDienThoai,NgaySinh,DiaChi,GioiTinh,MoTa from KhachHang where  maKH = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, ma);
        try {
            while (rs.next()) {
                khachHangViewModels.add(new KhachHangViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khachHangViewModels;
    }

    public List<KhachHangViewModel> searchKH(String sdt, String ma) {
        List<KhachHangViewModel> khachHangViewModels = new ArrayList<>();
        String sql = " SELECT MaKH,HoVaTen,SoDienThoai,NgaySinh,DiaChi,GioiTinh,MoTa from KhachHang where SoDienThoai = ? or maKH = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, sdt, ma);
        try {
            while (rs.next()) {
                khachHangViewModels.add(new KhachHangViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khachHangViewModels;
    }

    public List<KhachHangViewModel> searchSdt(String sdt) {
        List<KhachHangViewModel> khachHangViewModels = new ArrayList<>();
        String sql = " SELECT MaKH,HoVaTen,SoDienThoai,NgaySinh,DiaChi,GioiTinh,MoTa from KhachHang where SoDienThoai = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, sdt);
        try {
            while (rs.next()) {
                khachHangViewModels.add(new KhachHangViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khachHangViewModels;
    }

    public List<KhachHangViewModel> id(String ma) {
        List<KhachHangViewModel> khachHangViewModels = new ArrayList<>();
        String sql = " SELECT [ID]\n"
                + "  FROM [dbo].[KhachHang]\n"
                + "  where HoVaTen = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, ma);
        try {
            while (rs.next()) {
                khachHangViewModels.add(new KhachHangViewModel(rs.getInt(1)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khachHangViewModels;
    }

    public static void main(String[] args) {
        System.out.println(new KhachHangRespository().id("KH01"));
    }
}
