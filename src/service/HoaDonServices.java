/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.HoaDon;
import model.HoaDonCT;
import viewmodel.HoaDonViewModel;
import viewmodel.hoaDonViewModelHUY;

/**
 *
 * @author Admin
 */
public interface HoaDonServices {

    String addHoaDon(HoaDonViewModel hoaDon);

    String addHoaDonCT(HoaDonCT hoaDon);

    String huyDon(int id);

    String huyDonShip(int id);

    List<HoaDonViewModel> getALlhoaDon();
    
    List<hoaDonViewModelHUY> getALlhoaDonID();

    String updateIDNhanVien(HoaDon hd, int id);

    String updateIDKhachHang(HoaDon hd, int id);

    String updateIDThanhToan(HoaDon hd, int id);

    String updateIDGiaoHang(HoaDon hd, int id);
    
    String updateHoaDonGiaoHang(HoaDonViewModel hd, int id);

    String updateHoaDon(HoaDon hd, int id);

    String updateHoaDonThanhToan(HoaDonViewModel hd, int id);

    String updateHoaDonCTThanhToan(HoaDon hd, int id);
}
