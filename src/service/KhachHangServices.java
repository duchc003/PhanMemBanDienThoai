/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.KhachHang;
import viewmodel.KhachHangViewModel;

/**
 *
 * @author Admin
 */
public interface KhachHangServices {

    List<KhachHangViewModel> getAll();

    String addKH(KhachHang kh);

    String deleteKH(String ma);

    String updateKH(KhachHang kh);

    List<KhachHangViewModel> searchKH(String ma);

    List<KhachHangViewModel> searchSdt(String sdt);

}
