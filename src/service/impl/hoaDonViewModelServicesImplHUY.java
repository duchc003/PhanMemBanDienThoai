/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.hoaDonViewModelRepositoryHUY;
import service.hoaDonViewModelServicesHUY;
import viewmodel.hoaDonViewModelHUY;

/**
 *
 * @author Banh Chung Ran
 */
public class hoaDonViewModelServicesImplHUY implements hoaDonViewModelServicesHUY{
    private  hoaDonViewModelRepositoryHUY hoaDonViewModelRepositoryHUY = new hoaDonViewModelRepositoryHUY();

    @Override
    public List<hoaDonViewModelHUY> getAllhoaDonViewModelHUY() {
        return hoaDonViewModelRepositoryHUY.getAllHoaDonViewModel();
    }

    @Override
    public List<hoaDonViewModelHUY> timKiemHoaDonViewModelHUY(String maHD) {
       return hoaDonViewModelRepositoryHUY.timKiemHoaDonViewModel(maHD);
    }

    @Override
    public List<hoaDonViewModelHUY> timKiemCombobox(String trangThai) {
        return hoaDonViewModelRepositoryHUY.timKiemCombobox(trangThai);
    }

    @Override
    public List<hoaDonViewModelHUY> timKiemCombobox1(String TenHTTT) {
        return hoaDonViewModelRepositoryHUY.timKiemCombobox1(TenHTTT);
        
    }

    @Override
    public List<hoaDonViewModelHUY> timKiemCombobox2(String TenHTGH) {
        return hoaDonViewModelRepositoryHUY.timKiemCombobox2(TenHTGH);
    }
   
}
