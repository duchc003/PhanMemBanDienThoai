/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.List;
import model.KhachHang;
import repository.KhachHangRespository;
import service.KhachHangServices;
import viewmodel.KhachHangViewModel;

public class KhachHangServicesImpl implements KhachHangServices {

    private KhachHangRespository khachHangRespository = new KhachHangRespository();

    @Override
    public List<KhachHangViewModel> getAll() {
        return khachHangRespository.getAll();
    }

    @Override
    public String addKH(KhachHang kh) {
        int row = 0;
        row = khachHangRespository.addKH(kh);
        if (row > 0) {
            return "Thêm thành công";
        } else {
            return "Thất bại";
        }
    }
    @Override
    public String addKH2(KhachHangViewModel kh) {
        int row = 0;
        row = khachHangRespository.addKH2(kh);
        if (row > 0) {
            return "Thêm thành công";
        } else {
            return "Thất bại";
        }
    }

    @Override
    public String deleteKH(String ma) {
        int row = 0;
        row = khachHangRespository.deleteKH(ma);
        if (row > 0) {
            return "Xóa thành công";
        } else {
            return "Thất bại";
        }
    }

    @Override
    public String updateKH(KhachHang kh) {
        int row = 0;
        row = khachHangRespository.updateKH(kh);
        if (row > 0) {
            return "Sửa thành công";
        } else {
            return "Thất bại";
        }
    }

    @Override
    public List<KhachHangViewModel> searchKH(String ma) {
        return khachHangRespository.searchKH(ma);
    }

    @Override
    public List<KhachHangViewModel> searchSdt(String sdt) {
        return khachHangRespository.searchSdt(sdt);
    }

}
