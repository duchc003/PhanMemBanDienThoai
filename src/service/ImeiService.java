/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.HoaDon;
import model.Imei;
import model.SanPham;
import model.imeiDaBan;
import viewmodel.HoaDonViewModel;

/**
 *
 * @author ASUS
 */
public interface ImeiService {

    List<Imei> getALL();
    
    String add(Imei imei);
    
    String addImei(imeiDaBan imei) ;
    
    List<Imei> getALLID(int id);
    
    SanPham getOneID(String id);
    
    HoaDonViewModel getOneIDHoaDon(int id);
    
    HoaDon getOneIDHD(int id);
    
    String delete(int id);

}
