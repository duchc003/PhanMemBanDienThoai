/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.HoaDon;
import model.HoaDonCT;
import repository.HoaDonRespository;
import service.HoaDonServices;
import viewmodel.HoaDonViewModel;

/**
 *
 * @author Admin
 */
public class HoaDonServicesImpl implements HoaDonServices {

    private HoaDonRespository hoaDonRespository = new HoaDonRespository();

    @Override
    public String addHoaDon(HoaDonViewModel hoaDon) {
        int row = 0;
        row = hoaDonRespository.addHoaDon(hoaDon);
        if (row > 0) {
            return "Thành công";
        } else {
            return "Thất Bại";
        }
    }

    @Override
    public String huyDon(int id) {
        boolean huyDon = hoaDonRespository.huyDon(id);
        if (huyDon) {
            return "Đã hủy";
        } else {
            return "Hóa đơn này không được hủy";
        }
    }

    @Override
    public String huyDonShip(int id) {
        boolean huyDonShip = hoaDonRespository.huyDonShip(id);
        if (huyDonShip) {
            return "Đã hủy";
        } else {
            return "Lỗi";
        }
    }

    @Override
    public List<HoaDonViewModel> getALlhoaDon() {
        return hoaDonRespository.getAllHoaDon();
    }

    @Override
    public String updateIDNhanVien(HoaDon hd, int id) {
        boolean update = hoaDonRespository.updateIDNhanVien(hd, id);
        if (update) {
            return "";
        } else {
            return "";
        }
    }

    @Override
    public String updateIDKhachHang(HoaDon hd, int id) {
        boolean update = hoaDonRespository.updateIDKhachHang(hd, id);
        if (update) {
            return "";
        } else {
            return "";
        }
    }

    @Override
    public String updateIDThanhToan(HoaDon hd, int id) {
        boolean update = hoaDonRespository.updateIDHTTT(hd, id);
        if (update) {
            return "";
        } else {
            return "";
        }
    }

    @Override
    public String updateIDGiaoHang(HoaDon hd, int id) {
        boolean update = hoaDonRespository.updateIDHTGH(hd, id);
        if (update) {
            return "";
        } else {
            return "";
        }
    }

    @Override
    public String updateHoaDon(HoaDon hd, int id) {
        boolean update = hoaDonRespository.updateHoaDon(hd, id);
        if (update) {
            return "";
        } else {
            return "";
        }
    }

    @Override
    public String addHoaDonCT(HoaDonCT hoaDon) {
        int row = 0;
        row = hoaDonRespository.addHoaDonCT(hoaDon);
        if (row > 0) {
            return "Thành công";
        } else {
            return "Thất Bại";
        }
    }

}
