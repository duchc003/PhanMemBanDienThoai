/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.NhanVien;
import repository.DangNhapRepository;
import service.DangNhapService;

/**
 *
 * @author ASUS
 */
public class DangNhapServiceImpl implements DangNhapService{

    private DangNhapRepository impl = new DangNhapRepository();

    @Override
    public NhanVien getOne(String taiKhoan, String matKhau) {
        return impl.getOne(taiKhoan, matKhau);
    }  
    
}
