/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import viewmodel.NhanVienViewmodel;

/**
 *
 * @author HieuIT
 */
public interface NhanVienService {
    List<NhanVienViewmodel> getAll();

    String add(NhanVienViewmodel nv);

    ArrayList<NhanVienViewmodel> getOne(String maNV);
    
    ArrayList<NhanVienViewmodel> getOneTen(String hoVaten);
    
    ArrayList<NhanVienViewmodel> getOneSdt(String sdt);

    String sua(String maNV, NhanVienViewmodel nv);
}
