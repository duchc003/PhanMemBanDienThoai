/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.PhuKienViewmodel;

/**
 *
 * @author HieuIT
 */
public interface PhuKienService {
    List<PhuKienViewmodel> getAll();

    String add(PhuKienViewmodel pk);

    String xoa(int id);

    String sua(int id, PhuKienViewmodel pk);
}
