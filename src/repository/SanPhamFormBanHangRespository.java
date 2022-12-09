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
        String sql = "SELECT dbo.ChiTietSanPham.ID, dbo.SanPham.MaSP, dbo.SanPham.TenSp, dbo.ChiTietSanPham.SoLuong, dbo.GiamGia.GiamGia, dbo.ChiTietSanPham.GiaBan, dbo.HinhThucKhuyenMai.TenHinhThucKm\n"
                + "FROM     dbo.ChiTietSanPham INNER JOIN\n"
                + "                  dbo.GiamGia ON dbo.ChiTietSanPham.IDKM = dbo.GiamGia.ID INNER JOIN\n"
                + "                  dbo.HinhThucKhuyenMai ON dbo.GiamGia.IDHinhThuc = dbo.HinhThucKhuyenMai.Id INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSanPham.IDSP = dbo.SanPham.ID\n"
                + "			  where ChiTietSanPham.TrangThai = N'Còn Hàng'";
        ResultSet rs = JDBCHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                list.add(new SanPhamFormBanHangViewModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getLong(5),
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
        String sql = "SELECT dbo.ChiTietSanPham.ID,dbo.SanPham.MaSP, dbo.SanPham.TenSp, dbo.ChiTietSanPham.SoLuong, dbo.GiamGia.GiamGia, dbo.ChiTietSanPham.GiaBan, dbo.ChiTietSanPham.XuatXu, dbo.GiamGia.HinhThuc\n"
                + "FROM     dbo.ChiTietSanPham INNER JOIN\n"
                + "                  dbo.GiamGia ON dbo.ChiTietSanPham.IDKM = dbo.GiamGia.ID INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSanPham.IDSP = dbo.SanPham.ID\n"
                + "				  where MaSp like ? and ChiTietSanPham.TrangThai = N'Còn Hàng'";
        ResultSet rs = JDBCHelper.executeQuery(sql, "%" + ma + "%");
        try {
            while (rs.next()) {
                list.add(new SanPhamFormBanHangViewModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getLong(5),
                        rs.getLong(6),
                        rs.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamFormBanHangRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public SanPhamFormBanHangViewModel soLuong(String ma) {
        String sql = "SELECT dbo.ChiTietSanPham.ID,dbo.SanPham.MaSP, dbo.SanPham.TenSp, dbo.ChiTietSanPham.SoLuong, dbo.GiamGia.GiamGia, dbo.ChiTietSanPham.GiaBan, dbo.ChiTietSanPham.XuatXu, dbo.GiamGia.HinhThuc\n"
                + "FROM     dbo.ChiTietSanPham INNER JOIN\n"
                + "                  dbo.GiamGia ON dbo.ChiTietSanPham.IDKM = dbo.GiamGia.ID INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSanPham.IDSP = dbo.SanPham.ID\n"
                + "				  where MaSp = ? and ChiTietSanPham.TrangThai = N'Còn Hàng'";
        ResultSet rs = JDBCHelper.executeQuery(sql, ma);
        try {
            while (rs.next()) {
                return new SanPhamFormBanHangViewModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getLong(5),
                        rs.getLong(6),
                        rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamFormBanHangRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean sua(SanPhamFormBanHangViewModel sp, int id) {
        String query = "UPDATE [dbo].[ChiTietSanPham]\n"
                + "   SET [SoLuong] = ?\n"
                + " WHERE ID = ?";
        int check = 0;
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sp.getSoLuong());
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public static void main(String[] args) {
        System.out.println(new SanPhamFormBanHangRespository().soLuong("SP01").toString());
    }
}
