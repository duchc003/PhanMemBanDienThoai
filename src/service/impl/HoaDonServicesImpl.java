/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.HoaDon;
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
    public String addHoaDon(HoaDon hoaDon) {
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

}
