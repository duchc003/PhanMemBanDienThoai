/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.KhachHang;

/**
 *
 * @author ASUS
 */
public interface KhachHangCbbService {

    List<KhachHang> getALL();

    KhachHang getOne(String hoVaTen);

    List<KhachHang> getSeach(String sdt, List<KhachHang> list);
}