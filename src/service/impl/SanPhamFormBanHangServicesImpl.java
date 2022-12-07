/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.HangSP;
import repository.SanPhamFormBanHangRespository;
import service.SanPhamFormBanHangServices;
import viewmodel.SanPhamFormBanHangViewModel;

/**
 *
 * @author Admin
 */
public class SanPhamFormBanHangServicesImpl implements SanPhamFormBanHangServices {

    private SanPhamFormBanHangRespository sanPhamFormBanHangRespository = new SanPhamFormBanHangRespository();

    @Override
    public List<SanPhamFormBanHangViewModel> getAll() {
        return sanPhamFormBanHangRespository.getAll();
    }

    @Override
    public List<SanPhamFormBanHangViewModel> Search(String ma) {
        return sanPhamFormBanHangRespository.Search(ma);
    }

    @Override
    public SanPhamFormBanHangViewModel soLuong(String ma) {
        return sanPhamFormBanHangRespository.soLuong(ma);
    }

    @Override
    public String updateSoLuong(SanPhamFormBanHangViewModel sp,int id) {
        boolean update = sanPhamFormBanHangRespository.sua(sp, id);
        if (update) {
            return "";
        } else {
            return "";
        }
    }

}
