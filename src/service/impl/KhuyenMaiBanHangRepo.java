/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.KhuyenMaiFormBanHang;
import service.KhuyenMaiBanHangSr;
import viewmodel.KhuyenMaiBanHang;

/**
 *
 * @author ASUS
 */
public class KhuyenMaiBanHangRepo implements KhuyenMaiBanHangSr{
    private KhuyenMaiFormBanHang impl = new KhuyenMaiFormBanHang();

    @Override
    public List<KhuyenMaiBanHang> getALL(String ma) {
        return impl.giamGiaPhanTram(ma);
    }
}
