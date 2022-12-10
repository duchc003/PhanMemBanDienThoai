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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HangSP;
import model.HinhThucKhuyenMai;
import model.KhuyenMai;
import util.ConnectDB;
import util.JDBCHelper;
import viewmodel.KhuyenMaiBanHang;
import viewmodel.KhuyenMaiViewModel;

/**
 *
 * @author Banh Chung Ran
 */
public class khuyenMaiRepository {

    public List<KhuyenMaiViewModel> getAllKhuyenMaiViewModel() {
        List<KhuyenMaiViewModel> listKMViewModel = new ArrayList<>();
        String sql = "SELECT dbo.GiamGia.ID,dbo.HinhThucKhuyenMai.TenHinhThucKm,dbo.GiamGia.MaKM, dbo.GiamGia.Ten, dbo.GiamGia.NgayBD, dbo.GiamGia.NgayKT, dbo.GiamGia.GiamGia, dbo.GiamGia.TrangThai, \n"
                + "                  dbo.GiamGia.Mota\n"
                + "FROM     dbo.GiamGia INNER JOIN\n"
                + "                  dbo.HinhThucKhuyenMai ON dbo.GiamGia.IDHinhThuc = dbo.HinhThucKhuyenMai.Id";
        ResultSet rs = JDBCHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                listKMViewModel.add(new KhuyenMaiViewModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getLong(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(khuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKMViewModel;
    }

    public HinhThucKhuyenMai timKiemId(String maKM) {
        String sql = "select * from HinhThucKhuyenMai where TenHinhThucKm = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, maKM);
        try {
            while (rs.next()) {
                return new HinhThucKhuyenMai(
                        rs.getInt(1),
                        rs.getString(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(khuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<KhuyenMaiViewModel> timKiemKhuyenMai(String maKM) {
        List<KhuyenMaiViewModel> listKMV = new ArrayList<>();
        String sql = "select ID, MaKM,ten,NgayBD,NgayKT,GiamGia,HinhThuc,TrangThai,Mota from GiamGia where MaKM like ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, "%" + maKM + "%");
        try {
            while (rs.next()) {
                listKMV.add(new KhuyenMaiViewModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(7),
                        rs.getLong(6),
                        rs.getString(8),
                        rs.getString(9)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(khuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKMV;
    }

    public int addKhuyenMai(KhuyenMaiViewModel km) {
        int row = 0;
        String sql = "INSERT INTO [dbo].[GiamGia]\n"
                + "           ([IDHinhThuc]\n"
                + "           ,[MaKM]\n"
                + "           ,[Ten]\n"
                + "           ,[NgayBD]\n"
                + "           ,[NgayKT]\n"
                + "           ,[GiamGia]\n"
                + "           ,[TrangThai]\n"
                + "           ,[Mota])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        row = JDBCHelper.executeUpdate(sql,
                km.getTenHinhThuc(),
                km.getMaKM(),
                km.getTen(),
                km.getNgayBD(),
                km.getNgayKT(),
                km.getGiamGia(),
                km.getTrangThai(),
                km.getMoTa());
        return row;
    }

    public int updateKhuyenmai(KhuyenMaiViewModel km, int maKM) {
        int row = 0;
        String sql = "UPDATE [dbo].[GiamGia]\n"
                + "   SET [IDHinhThuc] = ?\n"
                + "      ,[MaKM] = ?\n"
                + "      ,[Ten] = ?\n"
                + "      ,[NgayBD] =?\n"
                + "      ,[NgayKT] = ?\n"
                + "      ,[GiamGia] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + "      ,[Mota] = ?\n"
                + " WHERE id = ?";
        row = JDBCHelper.executeUpdate(sql, km.getTenHinhThuc(), km.getMaKM(), km.getTen(), km.getNgayBD(), km.getNgayKT(), km.getGiamGia(), km.getTrangThai(), km.getMoTa(), maKM);
        return row;
    }

    public KhuyenMaiViewModel getOne(String hinhThuc) {
        String query = "select * from GiamGia where HinhThuc = ?";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, hinhThuc);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new KhuyenMaiViewModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(7),
                        rs.getLong(6),
                        rs.getString(8),
                        rs.getString(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<KhuyenMaiViewModel> giamGia() {
        String query = "select * from GiamGia";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            List<KhuyenMaiViewModel> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhuyenMaiViewModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(7),
                        rs.getLong(6),
                        rs.getString(8),
                        rs.getString(9)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new khuyenMaiRepository().getAllKhuyenMaiViewModel().toString());
    }
}
