/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.HangSPRepository;
import service.HangSPService;
import viewmodel.HangSPViewmodel;

/**
 *
 * @author HieuIT
 */
public class HangSPImpl implements HangSPService {

    private HangSPRepository HangSPRepository = new HangSPRepository();

    @Override
    public List<HangSPViewmodel> getAll() {
        return HangSPRepository.getAll();
    }

    @Override
    public String add(HangSPViewmodel h) {
        boolean add = HangSPRepository.add(h);
        if (add) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String sua(int id, HangSPViewmodel h) {
        boolean sua = HangSPRepository.sua(id, h);
        if (sua) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

}
