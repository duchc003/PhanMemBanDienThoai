/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.List;
import model.HinhThucKhuyenMai;
import model.KhuyenMai;
import repository.khuyenMaiRepository;
import service.khuyenMaiServices;
import viewmodel.KhuyenMaiViewModel;

/**
 *
 * @author Banh Chung Ran
 */
public class khuyenMaiServicesImpl implements khuyenMaiServices {

    private final khuyenMaiRepository KhuyenMaiViewModelReprository = new khuyenMaiRepository();

    @Override
    public List<KhuyenMaiViewModel> getAllKhuyenMaiViewModel() {
        return KhuyenMaiViewModelReprository.getAllKhuyenMaiViewModel();
    }

    @Override
    public List<KhuyenMaiViewModel> timKiemViewModel(String maKM) {
        return KhuyenMaiViewModelReprository.timKiemKhuyenMai(maKM);
    }

    @Override
    public String addKhuyenMai(KhuyenMaiViewModel km) {
        int addkhuyenMai = KhuyenMaiViewModelReprository.addKhuyenMai(km);
        if (addkhuyenMai > 0) {
            return "Thêm thành công!";

        } else {
            return "Thêm thất bại !";
        }
    }

    @Override
    public String updateKhuyenmai(KhuyenMaiViewModel km, int maKM) {
        int update = KhuyenMaiViewModelReprository.updateKhuyenmai(km, maKM);
        if (update > 0) {
            return "Update thành công ";

        } else {
            return "Update thất bại ";
        }
    }

    @Override
    public KhuyenMaiViewModel getOne(String hinhThai) {
        return KhuyenMaiViewModelReprository.getOne(hinhThai);
    }

    @Override
    public HinhThucKhuyenMai timKiemId(String maKM) {
        return KhuyenMaiViewModelReprository.timKiemId(maKM);
    }

}
