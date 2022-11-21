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
    
//    @Override
//    public List<SanPhamHetHang> getALL() {
//        return impl.getALL();
//    }

    @Override
    public List<SanPhamHetHang> getALL(List<SanPhamHetHang> list, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SanPhamHetHang> getALL() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
