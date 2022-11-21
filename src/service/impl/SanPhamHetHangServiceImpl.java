/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.SanPhamHetHangRepo;
import service.SanPhamHetHangService;
import viewmodel.SanPhamHetHang;

/**
 *
 * @author ASUS
 */
public class SanPhamHetHangServiceImpl implements SanPhamHetHangService{

    private SanPhamHetHangRepo impl = new SanPhamHetHangRepo();
    
    @Override
    public List<SanPhamHetHang> getALL() {
        return impl.getALL();
    }

    @Override
    public List<SanPhamHetHang> getALL(List<SanPhamHetHang> list, String id) {
        list = impl.search(id);
        return list;
    }

    @Override
    public String update(SanPhamHetHang sp, int ma) {
        boolean update = impl.updateSanPham(sp, ma);
        if (update) {
            return "Khôi Phục Sản Phẩm thành công";
        } else {
            return "Khôi phục thất bại";
        }
    }
    
}
