/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.NhanVien;
import util.JDBCHelper;

/**
 *
 * @author Admin
 */
public class DangKiRespository {
    public int addAccount(NhanVien nv){
        int row=0;
        String sql ="INSERT INTO NhanVien(Email,TaiKhoan,MatKhau) values(?,?,?)";
        row = JDBCHelper.executeUpdate(sql, nv.getEmail(),nv.getTaiKhoan(),nv.getMatKhau());
        return row;
    }
}
