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
        String sql = "SELECT dbo.SanPham.MaSP, dbo.SanPham.TenSp, dbo.ChiTietSanPham.SoLuong, dbo.GiamGia.GiamGia, dbo.ChiTietSanPham.GiaBan, dbo.ChiTietSanPham.XuatXu, dbo.GiamGia.HinhThuc\n"
                + "FROM     dbo.ChiTietSanPham INNER JOIN\n"
                + "                  dbo.GiamGia ON dbo.ChiTietSanPham.IDKM = dbo.GiamGia.ID INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSanPham.IDSP = dbo.SanPham.ID\n"
                + "				  where ChiTietSanPham.TrangThai = 1";
        ResultSet rs = JDBCHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                list.add(new SanPhamFormBanHangViewModel(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getLong(4),
                        rs.getLong(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public List<SanPhamFormBanHangViewModel> Search(String ma) {
        List<SanPhamFormBanHangViewModel> list = new ArrayList<>();
        String sql = "SELECT dbo.SanPham.MaSP, dbo.SanPham.TenSp, dbo.ChiTietSanPham.SoLuong, dbo.GiamGia.GiamGia, dbo.ChiTietSanPham.GiaBan, dbo.ChiTietSanPham.XuatXu\n"
                + "FROM     dbo.ChiTietSanPham INNER JOIN\n"
                + "                  dbo.GiamGia ON dbo.ChiTietSanPham.IDKM = dbo.GiamGia.ID INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSanPham.IDSP = dbo.SanPham.ID\n"
                + "				  where MaSp like ? and ChiTietSanPham.TrangThai = 1";
        ResultSet rs = JDBCHelper.executeQuery(sql, "%" + ma + "%");
        try {
            while (rs.next()) {
                list.add(new SanPhamFormBanHangViewModel(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getLong(4),
                        rs.getLong(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamFormBanHangRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void main(String[] args) {
        System.out.println(new SanPhamFormBanHangRespository().getAll().toString());
    }
}
