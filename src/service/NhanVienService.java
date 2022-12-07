/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.HinhThucGiaoHang;
import model.HinhThucThanhToan;
import model.KhachHang;
import model.NhanVien;
import viewmodel.NhanVienViewmodel;

/**
 *
 * @author HieuIT
 */
public interface NhanVienService {

    List<NhanVienViewmodel> getAll();

    String add(NhanVienViewmodel nv);

    List<NhanVienViewmodel> getOne(String maNV, String hoVaTen, String sdt);

    String sua(String maNV, NhanVienViewmodel nv);

    ArrayList<NhanVien> getIDNhanVien(String id);

    ArrayList<KhachHang> getIDKhachHang(String id);

    ArrayList<HinhThucGiaoHang> getIDGiaoHang();

    ArrayList<HinhThucThanhToan> getIDThanhToan();

    ArrayList<NhanVienViewmodel> checkMa(String maNV);

}
