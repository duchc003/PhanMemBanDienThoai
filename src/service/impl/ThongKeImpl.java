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
    public List<Integer> selectTongHoaDonGiaoTheoThang1() {
        return tk.selectTongHoaDonGiaoTheoThang1();
    }

    @Override
    public List<Integer> selectTongHoaDonGiaoTheoThang2() {
        return tk.selectTongHoaDonGiaoTheoThang2();
    }

    @Override
    public List<Integer> selectTongHoaDonGiaoTheoThang3() {
        return tk.selectTongHoaDonGiaoTheoThang3();
    }

    @Override
    public List<Integer> selectTongHoaDonGiaoTheoThang4() {
        return tk.selectTongHoaDonGiaoTheoThang4();
    }

    @Override
    public List<Integer> selectTongHoaDonGiaoTheoThang5() {
        return tk.selectTongHoaDonGiaoTheoThang5();
    }

    @Override
    public List<Integer> selectTongHoaDonGiaoTheoThang6() {
        return tk.selectTongHoaDonGiaoTheoThang6();
    }

    @Override
    public List<Integer> selectTongHoaDonGiaoTheoThang7() {
        return tk.selectTongHoaDonGiaoTheoThang7();
    }

    @Override
    public List<Integer> selectTongHoaDonGiaoTheoThang8() {
        return tk.selectTongHoaDonGiaoTheoThang8();
    }

    @Override
    public List<Integer> selectTongHoaDonGiaoTheoThang9() {
        return tk.selectTongHoaDonGiaoTheoThang9();
    }

    @Override
    public List<Integer> selectTongHoaDonGiaoTheoThang10() {
        return tk.selectTongHoaDonGiaoTheoThang10();
    }

    @Override
    public List<Integer> selectTongHoaDonGiaoTheoThang11() {
        return tk.selectTongHoaDonGiaoTheoThang11();
    }

    @Override
    public List<Integer> selectTongHoaDonGiaoTheoThang12() {
        return tk.selectTongHoaDonGiaoTheoThang12();
    }

    @Override
    public List<Integer> selectDoanhThuTheoNam2018() {
        return tk.selectDoanhThuTheoNam2018();
    }

    @Override
    public List<Integer> selectDoanhThuTheoNam2019() {
        return tk.selectDoanhThuTheoNam2019();
    }

    @Override
    public List<Integer> selectDoanhThuTheoNam2020() {
        return tk.selectDoanhThuTheoNam2020();
    }

    @Override
    public List<Integer> selectDoanhThuTheoNam2021() {
        return tk.selectDoanhThuTheoNam2021();
    }

    @Override
    public List<Integer> selectDoanhThuTheoNam2022() {
        return tk.selectDoanhThuTheoNam2022();
    }

    @Override
    public List<Integer> selectTongHoaDonGiaoTheoNam2018() {
        return tk.selectTongHoaDonGiaoTheoNam2018();
    }

    @Override
    public List<Integer> selectTongHoaDonGiaoTheoNam2019() {
        return tk.selectTongHoaDonGiaoTheoNam2019();
    }

    @Override
    public List<Integer> selectTongHoaDonGiaoTheoNam2020() {
        return tk.selectTongHoaDonGiaoTheoNam2020();
    }

    @Override
    public List<Integer> selectTongHoaDonGiaoTheoNam2021() {
        return tk.selectTongHoaDonGiaoTheoNam2021();
    }

    @Override
    public List<Integer> selectTongHoaDonGiaoTheoNam2022() {
        return tk.selectTongHoaDonGiaoTheoNam2022();
    }

    @Override
    public List<Integer> selectTongHoaDonTheoNam2018() {
        return tk.selectTongHoaDonTheoNam2018();
    }

    @Override
    public List<Integer> selectTongHoaDonTheoNam2019() {
        return tk.selectTongHoaDonTheoNam2019();
    }

    @Override
    public List<Integer> selectTongHoaDonTheoNam2020() {
        return tk.selectTongHoaDonTheoNam2020();
    }

    @Override
    public List<Integer> selectTongHoaDonTheoNam2021() {
        return tk.selectTongHoaDonTheoNam2021();
    }

    @Override
    public List<Integer> selectTongHoaDonTheoNam2022() {
        return tk.selectTongHoaDonTheoNam2022();
    }

}
