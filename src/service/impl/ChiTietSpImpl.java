/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.ChiTietSP;
import model.NhaCungCap;
import model.SanPham;
import repository.ChiTietSanPhamRepo;
import service.ChiTietSpService;
import viewmodel.ChiTietSPView;

/**
 *
 * @author ASUS
 */
public class ChiTietSpImpl implements ChiTietSpService {

    private ChiTietSanPhamRepo impl = new ChiTietSanPhamRepo();

    @Override
    public List<ChiTietSPView> getALL() {
        return impl.getALL();
    }

    @Override
    public String add(ChiTietSP sp) {
        boolean add = impl.add(sp);
        if (add) {
            return "add thành công";
        } else {
            return "add thất bại";
        }
    }

    @Override
    public String update(int id, ChiTietSP sp) {
        boolean update = impl.update(id, sp);
        if (update) {
            return "update thành công";
        } else {
            return "update thất bại";
        }
    }

    @Override
    public List<SanPham> getALLSP() {
        return impl.getIDSP();
    }

    @Override
    public List<NhaCungCap> getALLNCC() {
        return impl.getIDNCC();
    }

}
