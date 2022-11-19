/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.List;
import model.KhuyenMai;
import repository.khuyenMaiRepository;
import service.khuyenMaiServices;
import viewmodel.KhuyenMaiViewModel;

/**
 *
 * @author Banh Chung Ran
 */
public class khuyenMaiServicesImpl implements khuyenMaiServices {

    private khuyenMaiRepository khuyenMaiRepository = new khuyenMaiRepository();

    @Override
    public List<KhuyenMai> getAllKhuyenMai() {
        return khuyenMaiRepository.getAllKhuyenMai();
    }

    @Override
    public String addKhuyenMai(KhuyenMai km) {
        int addkhuyenMai = khuyenMaiRepository.addKhuyenMai(km);
        if (addkhuyenMai > 0) {
            return "Thêm thành công!";

        } else {
            return "Thêm thất bại !";
        }
    }

    @Override
    public String deleteKhuyenMai(String maKM) {
        int deleteKhuyenmai = khuyenMaiRepository.deleteKhuyenMai(maKM);
        if (deleteKhuyenmai > 0) {
            return "Xóa thành công";

        } else {
            return "Xóa không thành công";
        }
    }

    @Override
    public String updateKhuyenmai(KhuyenMai km, String maKM) {
        int update = khuyenMaiRepository.updateKhuyenmai(km, maKM);
        if (update > 0) {
            return "Update thành công !";
        } else {
            return "Update Thất Bại !";
        }
    }

    @Override
    public List<KhuyenMaiViewModel> getAllKhuyenMaiViewModel() {
        return khuyenMaiRepository.getAllKhuyenMaiViewModel();
    }

    @Override
    public List<KhuyenMaiViewModel> timKiemViewModel(String maKM) {
        return khuyenMaiRepository.timKiemKhuyenMai(maKM);
    }

}
