/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.NhaCungCapViewModel;

/**
 *
 * @author HieuIT
 */
public interface NhaCungCapService {
    List<NhaCungCapViewModel> getAll();

    String add(NhaCungCapViewModel ncc);

    String sua(int id, NhaCungCapViewModel ncc);
}
