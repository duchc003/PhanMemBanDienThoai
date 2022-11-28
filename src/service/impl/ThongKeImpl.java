/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.ChiTietSP;
import model.HoaDon;
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

    @Override
    public List<ChiTietSP> ConHang() {
        return tk.ConHang();
    }

    @Override
    public List<ChiTietSP> HetHang() {
        return  tk.HetHang();
    }

    @Override
    public List<SanPham> SoSanPhamDangKinhDoanh() {
        return tk.SoSanPhamDangKinhDoanh();
    }

    @Override
    public List<HoaDon> thongKe() {
        return tk.thongKeCot();
    }

}
