/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.ChiTietSP;
import model.NhaCungCap;
import model.SanPham;
import viewmodel.ChiTietSPView;

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
    
    String delete(int id);
}
