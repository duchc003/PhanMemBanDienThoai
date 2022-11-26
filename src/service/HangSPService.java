/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.HangSPViewmodel;

/**
 *
 * @author HieuIT
 */
public interface HangSPService {

    List<HangSPViewmodel> getAll();

    String add(HangSPViewmodel h);

    String sua(int id, HangSPViewmodel h);
}
