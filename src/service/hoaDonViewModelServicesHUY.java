/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.hoaDonViewModelHUY;

/**
 *
 * @author Banh Chung Ran
 */
public interface hoaDonViewModelServicesHUY {

    List<hoaDonViewModelHUY> getAllhoaDonViewModelHUY();

    List<hoaDonViewModelHUY> timKiemHoaDonViewModelHUY(String maHD);

    List<hoaDonViewModelHUY> timKiemCombobox(String trangThai);
    
    List<hoaDonViewModelHUY> timKiemCombobox1(String TenHTTT);
    
    List<hoaDonViewModelHUY> timKiemCombobox2(String TenHTGH);
}
