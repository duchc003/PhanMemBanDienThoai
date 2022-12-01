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
        return tk.HetHang();
    }

    @Override
    public List<SanPham> SoSanPhamDangKinhDoanh() {
        return tk.SoSanPhamDangKinhDoanh();
    }

    @Override
    public List<HoaDon> thongKe() {
        return tk.thongKeCot();
    }

    @Override
    public List<HoaDon> TongDoanhThuNam() {
        return tk.TongDoanhThuNam();
    }

    @Override
    public List<HoaDon> tonDonHang() {
        return tk.tonDonHangTaiQuay();
    }

    @Override
    public List<HoaDon> tonDonGiao() {
        return tk.tonDonGiao();
    }

    @Override
    public List<HoaDon> tonDonHuy() {
        return tk.tongDonHuy();
    }

    @Override
    public List<HoaDon> tonDonGiaoHuy() {
        return tk.tongDonHuyGiaoHang();
    }

    @Override
    public List<HoaDon> tonDonGiaoThanhCong() {
        return tk.tongDonGiaoThanhCong();
    }

    @Override
    public List<HoaDon> tonDonThanhCong() {
        return tk.tongDonThanhCong();
    }

    @Override
    public List<Integer> selectDoanhThuTheoThang1() {
        return tk.selectDoanhThuTheoThang1();
    }

    @Override
    public List<Integer> selectDoanhThuTheoThang2() {
        return tk.selectDoanhThuTheoThang2();
    }

    @Override
    public List<Integer> selectDoanhThuTheoThang3() {
        return tk.selectDoanhThuTheoThang3();
    }

    @Override
    public List<Integer> selectDoanhThuTheoThang4() {
        return tk.selectDoanhThuTheoThang4();
    }

    @Override
    public List<Integer> selectDoanhThuTheoThang5() {
        return tk.selectDoanhThuTheoThang5();
    }

    @Override
    public List<Integer> selectDoanhThuTheoThang6() {
        return tk.selectDoanhThuTheoThang6();
    }

    @Override
    public List<Integer> selectDoanhThuTheoThang7() {
        return tk.selectDoanhThuTheoThang7();
    }

    @Override
    public List<Integer> selectDoanhThuTheoThang8() {
        return tk.selectDoanhThuTheoThang8();
    }

    @Override
    public List<Integer> selectDoanhThuTheoThang9() {
        return tk.selectDoanhThuTheoThang9();
    }

    @Override
    public List<Integer> selectDoanhThuTheoThang10() {
        return tk.selectDoanhThuTheoThang10();
    }

    @Override
    public List<Integer> selectDoanhThuTheoThang11() {
        return tk.selectDoanhThuTheoThang11();
    }

    @Override
    public List<Integer> selectDoanhThuTheoThang12() {
        return tk.selectDoanhThuTheoThang12();
    }

    @Override
    public List<Integer> selectTongHoaDonTheoThang1() {
        return tk.selectTongHoaDonTheoThang1();
    }

    @Override
    public List<Integer> selectTongHoaDonTheoThang2() {
        return tk.selectTongHoaDonTheoThang2();
    }

    @Override
    public List<Integer> selectTongHoaDonTheoThang3() {
        return tk.selectTongHoaDonTheoThang3();
    }

    @Override
    public List<Integer> selectTongHoaDonTheoThang4() {
        return tk.selectTongHoaDonTheoThang4();
    }

    @Override
    public List<Integer> selectTongHoaDonTheoThang5() {
        return tk.selectTongHoaDonTheoThang5();
    }

    @Override
    public List<Integer> selectTongHoaDonTheoThang6() {
        return tk.selectTongHoaDonTheoThang6();
    }

    @Override
    public List<Integer> selectTongHoaDonTheoThang7() {
        return tk.selectTongHoaDonTheoThang7();
    }

    @Override
    public List<Integer> selectTongHoaDonTheoThang8() {
        return tk.selectTongHoaDonTheoThang8();
    }

    @Override
    public List<Integer> selectTongHoaDonTheoThang9() {
        return tk.selectTongHoaDonTheoThang9();
    }

    @Override
    public List<Integer> selectTongHoaDonTheoThang10() {
        return tk.selectTongHoaDonTheoThang10();
    }

    @Override
    public List<Integer> selectTongHoaDonTheoThang11() {
        return tk.selectTongHoaDonTheoThang11();
    }

    @Override
    public List<Integer> selectTongHoaDonTheoThang12() {
        return tk.selectTongHoaDonTheoThang12();
    }

    @Override
    public List<Integer> selectTongHoaDonThanhCongTheoThang1() {
        return tk.selectTongHoaDonThanhCongTheoThang1();
    }

    @Override
    public List<Integer> selectTongHoaDonThanhCongTheoThang2() {
        return tk.selectTongHoaDonThanhCongTheoThang2();
    }

    @Override
    public List<Integer> selectTongHoaDonThanhCongTheoThang3() {
        return tk.selectTongHoaDonThanhCongTheoThang3();
    }

    @Override
    public List<Integer> selectTongHoaDonThanhCongTheoThang4() {
        return tk.selectTongHoaDonThanhCongTheoThang4();
    }

    @Override
    public List<Integer> selectTongHoaDonThanhCongTheoThang5() {
        return tk.selectTongHoaDonThanhCongTheoThang5();
    }

    @Override
    public List<Integer> selectTongHoaDonThanhCongTheoThang6() {
        return tk.selectTongHoaDonThanhCongTheoThang6();
    }

    @Override
    public List<Integer> selectTongHoaDonThanhCongTheoThang7() {
        return tk.selectTongHoaDonThanhCongTheoThang7();
    }

    @Override
    public List<Integer> selectTongHoaDonThanhCongTheoThang8() {
        return tk.selectTongHoaDonThanhCongTheoThang8();
    }

    @Override
    public List<Integer> selectTongHoaDonThanhCongTheoThang9() {
        return tk.selectTongHoaDonThanhCongTheoThang9();
    }

    @Override
    public List<Integer> selectTongHoaDonThanhCongTheoThang10() {
        return tk.selectTongHoaDonThanhCongTheoThang10();
    }

    @Override
    public List<Integer> selectTongHoaDonThanhCongTheoThang11() {
        return tk.selectTongHoaDonThanhCongTheoThang11();
    }

    @Override
    public List<Integer> selectTongHoaDonThanhCongTheoThang12() {
        return tk.selectTongHoaDonThanhCongTheoThang12();
    }

    @Override
    public List<Integer> selectTongHoaDonHuyTheoThang1() {
        return tk.selectTongHoaDonHuyTheoThang1();
    }

    @Override
    public List<Integer> selectTongHoaDonHuyTheoThang2() {
        return tk.selectTongHoaDonHuyTheoThang2();
    }

    @Override
    public List<Integer> selectTongHoaDonHuyTheoThang3() {
        return tk.selectTongHoaDonHuyTheoThang3();
    }

    @Override
    public List<Integer> selectTongHoaDonHuyTheoThang4() {
        return tk.selectTongHoaDonHuyTheoThang4();
    }

    @Override
    public List<Integer> selectTongHoaDonHuyTheoThang5() {
        return tk.selectTongHoaDonHuyTheoThang5();
    }

    @Override
    public List<Integer> selectTongHoaDonHuyTheoThang6() {
        return tk.selectTongHoaDonHuyTheoThang6();
    }

    @Override
    public List<Integer> selectTongHoaDonHuyTheoThang7() {
        return tk.selectTongHoaDonHuyTheoThang7();
    }

    @Override
    public List<Integer> selectTongHoaDonHuyTheoThang8() {
        return tk.selectTongHoaDonHuyTheoThang8();
    }

    @Override
    public List<Integer> selectTongHoaDonHuyTheoThang9() {
        return tk.selectTongHoaDonHuyTheoThang9();
    }

    @Override
    public List<Integer> selectTongHoaDonHuyTheoThang10() {
        return tk.selectTongHoaDonHuyTheoThang10();
    }

    @Override
    public List<Integer> selectTongHoaDonHuyTheoThang11() {
        return tk.selectTongHoaDonHuyTheoThang11();
    }

    @Override
    public List<Integer> selectTongHoaDonHuyTheoThang12() {
        return tk.selectTongHoaDonHuyTheoThang12();
    }

}
