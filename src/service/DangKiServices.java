/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.NhanVien;
import viewmodel.NhanVienViewmodel;

public interface DangKiServices {
    String addAccount(String taikhoan,String matkhau,String email);
    List<NhanVienViewmodel> getEmail(String email);
}
