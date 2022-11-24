/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import service.ThongKeSPservice;
import viewmodel.ThongkeSanPhamViewModel;
import repository.ThongKeSanPhamRepository;
import viewmodel.ThongKeDoanhThuViewModel;
/**
 *
 * @author ADMIN
 */
public class ThongKeImpl implements ThongKeSPservice{
     private  ThongKeSanPhamRepository tk = new ThongKeSanPhamRepository();
    @Override
    public List<ThongkeSanPhamViewModel> getAllThongKeViewModel() {
          return tk.all();
    }

    @Override
    public List<ThongKeDoanhThuViewModel> getAll() {
        return tk.getall();
    }
    
}
