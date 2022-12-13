/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.ChiTietSP;
import model.Imei;
import model.NhaCungCap;
import model.SanPham;
import viewmodel.ChiTietSPView;
import viewmodel.SanPhamFormBanHangViewModel;

/**
 *
 * @author ASUS
 */
public interface ChiTietSpService {

    List<ChiTietSPView> getALL();
    
    List<SanPham> getALLSP();
    
    List<NhaCungCap> getALLNCC();
    
    String add(ChiTietSP sp);
    
    String update(int id,ChiTietSP sp);
    
    SanPhamFormBanHangViewModel getBarcode(String bar);
    
    List<Imei> getALLID(int id);
    
    NhaCungCap getOneNCCID(int id);
    
    SanPham getOneSPID(int id);
}
