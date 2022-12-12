/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.HoaDonCT;
import model.imeiDaBan;
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

    hoaDonViewModelHUY timhoaDon(int TenHTGH);

    List<imeiDaBan> selectID(int ma);

    HoaDonCT selectIDHD(int ma);

    List<hoaDonViewModelHUY> getAllHoaDonTienMat();

    List<hoaDonViewModelHUY> getAllHoaDonChuyenKhoan();

    List<hoaDonViewModelHUY> getAllHoaDonQuetThe();

    List<hoaDonViewModelHUY> getAllHoaDonQuetMa();

    List<hoaDonViewModelHUY> getAllHoaDonTaiQuay();

    List<hoaDonViewModelHUY> getAllHoaDonKhac();
}
