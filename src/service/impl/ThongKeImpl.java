/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.ChiTietSP;
import model.SanPham;
import service.ThongKeSPservice;
import viewmodel.ThongkeSanPhamViewModel;
import repository.ThongKeSanPhamRepository;
import viewmodel.ThongKeDoanhThuViewModel;

/**
 *
 * @author ADMIN
 */
public class ThongKeImpl implements ThongKeSPservice {

    private ThongKeSanPhamRepository tk = new ThongKeSanPhamRepository();

    @Override
    public List<ThongkeSanPhamViewModel> getAllThongKeViewModel() {
        return tk.all();
    }

    @Override
    public List<ThongKeDoanhThuViewModel> getAll() {
        return tk.getall();
    }
<<<<<<< HEAD

    @Override
    public List<ChiTietSP> ConHang() {
        return tk.ConHang();
=======
     @Override
    public List<ChiTietSP> ConHang() {
     return tk.ConHang();
>>>>>>> eb81af44dfb6b1faef8dc836a0df4ea1481436ae
    }

    @Override
    public List<ChiTietSP> HetHang() {
<<<<<<< HEAD
        return tk.HetHang();
=======
       return tk.HetHang();
>>>>>>> eb81af44dfb6b1faef8dc836a0df4ea1481436ae
    }

    @Override
    public List<SanPham> SoSanPhamDangKinhDoanh() {
<<<<<<< HEAD
        return tk.SoSanPhamDangKinhDoanh();
    }

=======
   return tk.SoSanPhamDangKinhDoanh();
    }
>>>>>>> eb81af44dfb6b1faef8dc836a0df4ea1481436ae
}
