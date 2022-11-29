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
import model.KhuyenMai;
import util.ConnectDB;
import util.JDBCHelper;
import viewmodel.KhuyenMaiViewModel;

/**
 *
 * @author Banh Chung Ran
 */
public class khuyenMaiRepository {

    public List<KhuyenMaiViewModel> getAllKhuyenMaiViewModel() {
        List<KhuyenMaiViewModel> listKMViewModel = new ArrayList<>();
        String sql = "select * from KhuyenMai";
        ResultSet rs = JDBCHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                listKMViewModel.add(new KhuyenMaiViewModel(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getFloat(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(khuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKMViewModel;
    }

    public List<KhuyenMaiViewModel> timKiemKhuyenMai(String maKM) {
        List<KhuyenMaiViewModel> listKMV = new ArrayList<>();
        String sql = "select ID, MaKM,ten,NgayBD,NgayKT,GiamGia,HinhThuc,TrangThai,Mota from KhuyenMai where MaKM like ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, "%" + maKM + "%");
        try {
            while (rs.next()) {
                listKMV.add(new KhuyenMaiViewModel(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getFloat(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(khuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKMV;
    }

    public int addKhuyenMai(KhuyenMaiViewModel km) {
        int row = 0;
        String sql = "insert into KhuyenMai(MaKM,ten,NgayBD,NgayKT,GiamGia,HinhThuc,TrangThai,Mota) values(?,?,?,?,?,?,?,?)";
        row = JDBCHelper.executeUpdate(sql,
                km.getMaKM(),
                km.getTen(),
                km.getNgayBD(),
                km.getNgayKT(),
                km.getGiamGia(),
                km.getHinhThuc(),
                km.getTrangThai(),
                km.getMoTa());
        return row;
    }

    public int updateKhuyenmai(KhuyenMaiViewModel km, String maKM) {
        int row = 0;
        String sql = "UPDATE KhuyenMai\n"
                + "SET ten =?, NgayBD = ?, NgayKT =?,GiamGia =?,HinhThuc=?,TrangThai =?,Mota =?\n"
                + "WHERE MaKM = ?";
        row = JDBCHelper.executeUpdate(sql, km.getTen(), km.getNgayBD(), km.getNgayKT(), km.getGiamGia(), km.getHinhThuc(), km.getTrangThai(), km.getMoTa(), km.getMaKM());
        return row;
    }

    public KhuyenMaiViewModel getOne(int hinhThuc) {
        String query = "select * from KhuyenMai where HinhThuc = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, hinhThuc);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new KhuyenMaiViewModel(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getFloat(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<KhuyenMaiViewModel> giamGia() {
        String query = "select * from KhuyenMai";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<KhuyenMaiViewModel> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhuyenMaiViewModel(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getFloat(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        KhuyenMaiViewModel km = new khuyenMaiRepository().getOne(1);
        System.out.println(km.toString());
    }
}
