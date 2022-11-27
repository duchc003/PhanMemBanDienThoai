/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.ChiTietSP;
import model.SanPham;
import viewmodel.ThongkeSanPhamViewModel;
import viewmodel.ThongKeDoanhThuViewModel;

/**
 *
 * @author ADMIN
 */
public interface ThongKeSPservice {

    List<ThongkeSanPhamViewModel> getAllThongKeViewModel();

    List<ThongKeDoanhThuViewModel> getAll();
    
    List<ChiTietSP> ConHang();

    List<ChiTietSP> HetHang();

    List<SanPham> SoSanPhamDangKinhDoanh();


}
