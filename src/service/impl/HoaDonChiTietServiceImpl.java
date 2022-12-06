/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.List;
import repository.HoaDonChiTietRepository;
import service.HoaDonChiTietService;
import viewmodel.ChiTietHoaDonView;

/**
 *
 * @author ASUS
 */
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService{

    private HoaDonChiTietRepository impl = new HoaDonChiTietRepository();
    
    @Override
    public List<ChiTietHoaDonView> getAllCt(int id) {
        return impl.getAllHoaDonChiTiet(id);
    }
    
}
