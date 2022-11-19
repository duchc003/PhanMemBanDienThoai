/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.PhuKienRepository;
import viewmodel.PhuKienViewmodel;
import service.PhuKienService;

/**
 *
 * @author HieuIT
 */
public class PhuKienImpl implements PhuKienService {

    private PhuKienRepository PhuKienRepository = new PhuKienRepository();

    @Override
    public List<PhuKienViewmodel> getAll() {
        return PhuKienRepository.getAll();
    }

    @Override
    public String add(PhuKienViewmodel pk) {
        boolean add = PhuKienRepository.add(pk);
        if (add) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String xoa(int id) {
        boolean xoa = PhuKienRepository.xoa(id);
        if (xoa) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String sua(int id, PhuKienViewmodel pk) {
        boolean sua = PhuKienRepository.sua(id, pk);
        if (sua) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

}
