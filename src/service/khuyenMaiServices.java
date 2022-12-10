/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.HinhThucKhuyenMai;
import model.KhuyenMai;
import viewmodel.KhuyenMaiViewModel;

/**
 *
 * @author Banh Chung Ran
 */
public interface khuyenMaiServices {

    List<KhuyenMaiViewModel> getAllKhuyenMaiViewModel();

    List<KhuyenMaiViewModel> timKiemViewModel(String maKM);

    String addKhuyenMai(KhuyenMaiViewModel km);

    String updateKhuyenmai(KhuyenMaiViewModel km, int maKM);
    
    KhuyenMaiViewModel getOne(String hinhThai);
    
    HinhThucKhuyenMai timKiemId(String maKM);

}
