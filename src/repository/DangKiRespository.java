/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import util.JDBCHelper;
import viewmodel.NhanVienViewmodel;

/**
 *
 * @author Admin
 */
public class DangKiRespository {

    public int addAccount(String taikhoan, String matkhau, String email) {
        int row = 0;
        String sql = "UPDATE NhanVien SET TaiKhoan =? ,MatKhau=?\n"
                + "WHERE Email = ?";
        row = JDBCHelper.executeUpdate(sql, taikhoan, matkhau, email);
        return row;
    }

    public List<NhanVienViewmodel> getEmail(String email) {
        List<NhanVienViewmodel> nv = new ArrayList<>();
        String sql = "SELECT Email FROM NHANVIEN WHERE Email= ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, email);
        try {
            while (rs.next()) {
                nv.add(new NhanVienViewmodel(rs.getString(1)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DangKiRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nv;
    }
}
