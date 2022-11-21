/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.SanPhamHetHang;

/**
 *
 * @author ASUS
 */
public interface SanPhamHetHangService {

    List<SanPhamHetHang> getALL();

    List<SanPhamHetHang> getALL(List<SanPhamHetHang> list, String id);
    
    String update(SanPhamHetHang sp,int ma);
}
