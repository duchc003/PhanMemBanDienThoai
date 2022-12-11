/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.NhanVien;
import repository.DangKiRespository;
import service.DangKiServices;
import viewmodel.NhanVienViewmodel;


public class DangKiServicesImpl implements DangKiServices{
private DangKiRespository dangki = new DangKiRespository();

    @Override
    public String addAccount(String taikhoan, String matkhau, String email) {
        int row =0;
        row = dangki.addAccount(taikhoan, matkhau, email);
          if(row>0){
            return "\t \tĐăng kí thành công \n"
                    + "Tài khoản và mật khẩu của bạn đã được gửi về email";
        }else{
            return "Đăng kí thất bại";
        }
    }

    @Override
    public List<NhanVienViewmodel> getEmail(String email) {
      return dangki.getEmail(email);
        
        
    }

    
}
