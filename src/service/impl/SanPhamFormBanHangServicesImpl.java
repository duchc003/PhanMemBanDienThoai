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
public class SanPhamFormBanHangServicesImpl implements SanPhamFormBanHangServices{
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
    public List<HangSP> getTenHangSPs() {
        return sanPhamFormBanHangRespository.getALLHang();
    }

    @Override
    public List<SanPhamFormBanHangViewModel> searchTenHang(List<SanPhamFormBanHangViewModel> lst, String ma) {
        lst = sanPhamFormBanHangRespository.searchHangSPs(ma);
        return lst;
    }
    
}
