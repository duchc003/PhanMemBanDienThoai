/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.ChiTietSP;
import model.HoaDon;
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

    List<HoaDon> thongKe();

    List<ChiTietSP> ConHang();

    List<ChiTietSP> HetHang();

    List<SanPham> SoSanPhamDangKinhDoanh();

    List<HoaDon> TongDoanhThuNam();

    List<HoaDon> tonDonHang();

    List<HoaDon> tonDonGiao();

    List<Integer> selectDoanhThuTheoThang1();

    List<Integer> selectDoanhThuTheoThang2();

    List<Integer> selectDoanhThuTheoThang3();

    List<Integer> selectDoanhThuTheoThang4();

    List<Integer> selectDoanhThuTheoThang5();

    List<Integer> selectDoanhThuTheoThang6();

    List<Integer> selectDoanhThuTheoThang7();

    List<Integer> selectDoanhThuTheoThang8();

    List<Integer> selectDoanhThuTheoThang9();

    List<Integer> selectDoanhThuTheoThang10();

    List<Integer> selectDoanhThuTheoThang11();

    List<Integer> selectDoanhThuTheoThang12();

    List<Integer> selectTongHoaDonTheoThang1();

    List<Integer> selectTongHoaDonTheoThang2();

    List<Integer> selectTongHoaDonTheoThang3();

    List<Integer> selectTongHoaDonTheoThang4();

    List<Integer> selectTongHoaDonTheoThang5();

    List<Integer> selectTongHoaDonTheoThang6();

    List<Integer> selectTongHoaDonTheoThang7();

    List<Integer> selectTongHoaDonTheoThang8();

    List<Integer> selectTongHoaDonTheoThang9();

    List<Integer> selectTongHoaDonTheoThang10();

    List<Integer> selectTongHoaDonTheoThang11();

    List<Integer> selectTongHoaDonTheoThang12();
    
    List<Integer> selectTongHoaDonGiaoTheoThang1();
    
    List<Integer> selectTongHoaDonGiaoTheoThang2();
    
    List<Integer> selectTongHoaDonGiaoTheoThang3();
    
    List<Integer> selectTongHoaDonGiaoTheoThang4();
    
    List<Integer> selectTongHoaDonGiaoTheoThang5();
    
    List<Integer> selectTongHoaDonGiaoTheoThang6();
    
    List<Integer> selectTongHoaDonGiaoTheoThang7();
    
    List<Integer> selectTongHoaDonGiaoTheoThang8();
    
    List<Integer> selectTongHoaDonGiaoTheoThang9();
    
    List<Integer> selectTongHoaDonGiaoTheoThang10();
    
    List<Integer> selectTongHoaDonGiaoTheoThang11();
    
    List<Integer> selectTongHoaDonGiaoTheoThang12();
    
    List<Integer> selectDoanhThuTheoNam2018();
    
    List<Integer> selectDoanhThuTheoNam2019();
    
    List<Integer> selectDoanhThuTheoNam2020();
    
    List<Integer> selectDoanhThuTheoNam2021();
    
    List<Integer> selectDoanhThuTheoNam2022();
    
    List<Integer> selectTongHoaDonGiaoTheoNam2018();
    
    List<Integer> selectTongHoaDonGiaoTheoNam2019();
    
    List<Integer> selectTongHoaDonGiaoTheoNam2020();
    
    List<Integer> selectTongHoaDonGiaoTheoNam2021();
    
    List<Integer> selectTongHoaDonGiaoTheoNam2022();
    
    List<Integer> selectTongHoaDonTheoNam2018();
    
    List<Integer> selectTongHoaDonTheoNam2019();
    
    List<Integer> selectTongHoaDonTheoNam2020();
    
    List<Integer> selectTongHoaDonTheoNam2021();
    
    List<Integer> selectTongHoaDonTheoNam2022();
}
