package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.JDBCHelper;
import viewmodel.SanPhamFormBanHangViewModel;

public class SanPhamFormBanHangRespository {

    public List<SanPhamFormBanHangViewModel> getAll() {
        List<SanPhamFormBanHangViewModel> list = new ArrayList<>();
        String sql = "SELECT MaSP,TenSp,ChiTietSanPham.SoLuong,HangSanPham.TenHangSP,ChiTietSanPham.GiaBan,ChiTietSanPham.XuatXu FROM ChiTietSanPham join SanPham \n"
                + "on ChiTietSanPham.IDSP =  SanPham.ID \n"
                + "join HangSanPham \n"
                + "on SanPham.IDHang = HangSanPham.ID";
        ResultSet rs = JDBCHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                list.add(new SanPhamFormBanHangViewModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getDouble(5), rs.getString(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamFormBanHangRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<SanPhamFormBanHangViewModel> Search(String ma) {
        List<SanPhamFormBanHangViewModel> list = new ArrayList<>();
        String sql = "SELECT MaSP,TenSp,ChiTietSanPham.SoLuong,HangSanPham.TenHangSP,ChiTietSanPham.GiaBan,ChiTietSanPham.XuatXu FROM ChiTietSanPham join SanPham \n"
                + "on ChiTietSanPham.IDSP =  SanPham.ID \n"
                + "join HangSanPham \n"
                + "on SanPham.IDHang = HangSanPham.ID where MaSp like ?";
        ResultSet rs = JDBCHelper.executeQuery(sql,"%"+ma+"%");
        try {
            while (rs.next()) {
                list.add(new SanPhamFormBanHangViewModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getDouble(5), rs.getString(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamFormBanHangRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}