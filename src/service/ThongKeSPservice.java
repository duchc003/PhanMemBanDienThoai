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

    List<HoaDon> tonDonHuy();

    List<HoaDon> tonDonGiaoHuy();

    List<HoaDon> tonDonGiaoThanhCong();

    List<HoaDon> tonDonThanhCong();

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

    List<Integer> selectTongHoaDonThanhCongTheoThang1();

    List<Integer> selectTongHoaDonThanhCongTheoThang2();

    List<Integer> selectTongHoaDonThanhCongTheoThang3();

    List<Integer> selectTongHoaDonThanhCongTheoThang4();

    List<Integer> selectTongHoaDonThanhCongTheoThang5();

    List<Integer> selectTongHoaDonThanhCongTheoThang6();

    List<Integer> selectTongHoaDonThanhCongTheoThang7();

    List<Integer> selectTongHoaDonThanhCongTheoThang8();

    List<Integer> selectTongHoaDonThanhCongTheoThang9();

    List<Integer> selectTongHoaDonThanhCongTheoThang10();

    List<Integer> selectTongHoaDonThanhCongTheoThang11();

    List<Integer> selectTongHoaDonThanhCongTheoThang12();

    List<Integer> selectTongHoaDonHuyTheoThang1();

    List<Integer> selectTongHoaDonHuyTheoThang2();

    List<Integer> selectTongHoaDonHuyTheoThang3();

    List<Integer> selectTongHoaDonHuyTheoThang4();

    List<Integer> selectTongHoaDonHuyTheoThang5();

    List<Integer> selectTongHoaDonHuyTheoThang6();

    List<Integer> selectTongHoaDonHuyTheoThang7();

    List<Integer> selectTongHoaDonHuyTheoThang8();

    List<Integer> selectTongHoaDonHuyTheoThang9();

    List<Integer> selectTongHoaDonHuyTheoThang10();

    List<Integer> selectTongHoaDonHuyTheoThang11();

    List<Integer> selectTongHoaDonHuyTheoThang12();
}
