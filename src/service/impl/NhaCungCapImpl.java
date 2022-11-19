/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.NhaCungCapRepository;
import service.NhaCungCapService;
import viewmodel.NhaCungCapViewModel;

/**
 *
 * @author HieuIT
 */
public class NhaCungCapImpl implements NhaCungCapService {

    private NhaCungCapRepository nhaCungCapRepository = new NhaCungCapRepository();

    @Override
    public List<NhaCungCapViewModel> getAll() {
        return nhaCungCapRepository.getAll();
    }

    @Override
    public String add(NhaCungCapViewModel ncc) {
        boolean add = nhaCungCapRepository.add(ncc);
        if (add) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String xoa(int id) {
        boolean xoa = nhaCungCapRepository.xoa(id);
        if (xoa) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String sua(int id, NhaCungCapViewModel ncc) {
        boolean sua = nhaCungCapRepository.sua(id, ncc);
        if (sua) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }
}
