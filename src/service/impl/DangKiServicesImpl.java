/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import model.NhanVien;
import repository.DangKiRespository;
import service.DangKiServices;


public class DangKiServicesImpl implements DangKiServices{
private DangKiRespository dangki = new DangKiRespository();
    @Override
    public String addAccount(NhanVien nv) {
        int row =0;
        row = dangki.addAccount(nv);
        if(row>0){
            return "Đăng kí thành công \n"
                    + "Tài khoản và mật khẩu của bạn đã được gửi về email";
        }else{
            return "Đăng kí thất bại";
        }
    }
    
}
