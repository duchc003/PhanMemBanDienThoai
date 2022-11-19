/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import model.NhanVien;
import util.ConnectDB;
import util.JDBCHelper;

/**
 *
 * @author ASUS
 */
public class DoiMatKhauRepo {

    public List<NhanVien> getAllNhanVien(){
        List<NhanVien> listNV = new ArrayList<>();
        String sql = "select * from NhanVien";
        ResultSet rs = JDBCHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                listNV.add(new NhanVien(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6),
                        rs.getString(7), rs.getString(8),rs.getString(9), rs.getBoolean(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return listNV;
    }
    public int update(String mk, String tk){
        int row =0;
        String sql ="update NhanVien set MatKhau = ? where TaiKhoan =  ?";
        row = JDBCHelper.executeUpdate(sql, mk,tk);
        return row;
        
    }
}
