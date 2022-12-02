package repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HangSP;
import util.ConnectDB;
import util.JDBCHelper;
import viewmodel.SanPhamFormBanHangViewModel;

public class SanPhamFormBanHangRespository {

    public List<SanPhamFormBanHangViewModel> getAll() {
        List<SanPhamFormBanHangViewModel> list = new ArrayList<>();
        String sql = "SELECT dbo.SanPham.MaSP, dbo.SanPham.TenSp, dbo.ChiTietSanPham.SoLuong, dbo.KhuyenMai.GiamGia, dbo.HangSanPham.MaHangSP, dbo.ChiTietSanPham.GiaBan, dbo.ChiTietSanPham.XuatXu\n"
                + "FROM     dbo.ChiTietSanPham INNER JOIN\n"
                + "                  dbo.HangSanPham ON dbo.ChiTietSanPham.ID = dbo.HangSanPham.ID INNER JOIN\n"
                + "                  dbo.KhuyenMai ON dbo.ChiTietSanPham.ID = dbo.KhuyenMai.ID INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSanPham.ID = dbo.SanPham.ID";
        ResultSet rs = JDBCHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                list.add(new SanPhamFormBanHangViewModel(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getLong(6),
                        rs.getString(7)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<SanPhamFormBanHangViewModel> Search(String ma) {
        List<SanPhamFormBanHangViewModel> list = new ArrayList<>();
        String sql = "SELECT MaSP,TenSp,ChiTietSanPham.SoLuong,HangSanPham.TenHangSP,ChiTietSanPham.GiaBan,ChiTietSanPham.XuatXu \n"
                + "FROM ChiTietSanPham join SanPham on ChiTietSanPham.IDSP =  SanPham.ID join HangSanPham on SanPham.IDHang = HangSanPham.ID \n"
                + "where MaSp like ? and ChiTietSanPham.TrangThai = 1";
        ResultSet rs = JDBCHelper.executeQuery(sql, "%" + ma + "%");
        try {
            while (rs.next()) {
                list.add(new SanPhamFormBanHangViewModel(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getLong(5),
                        rs.getString(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamFormBanHangRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<HangSP> getALLHang() {
        String query = "select * from HangSanPham";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<HangSP> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HangSP(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SanPhamFormBanHangViewModel> searchHangSPs(String tenHang) {
        String query = "SELECT MaSP,TenSp,ChiTietSanPham.SoLuong,HangSanPham.TenHangSP,ChiTietSanPham.GiaBan,ChiTietSanPham.XuatXu FROM ChiTietSanPham join SanPham\n"
                + "on ChiTietSanPham.IDSP =  SanPham.ID\n"
                + "join HangSanPham\n"
                + "on SanPham.IDHang = HangSanPham.ID\n"
                + "where HangSanPham.TenHangSP like ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, "%" + tenHang + "%");
            List<SanPhamFormBanHangViewModel> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPhamFormBanHangViewModel(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getLong(5),
                        rs.getString(6)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new SanPhamFormBanHangRespository().getAll().toString());
    }
}
