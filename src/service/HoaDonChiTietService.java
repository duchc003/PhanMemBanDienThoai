/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import viewmodel.ChiTietHoaDonView;

/**
 *
 * @author ASUS
 */
public interface HoaDonChiTietService {

    List<ChiTietHoaDonView> getAllCt(int id);
}
