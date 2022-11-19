
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.HangSP;
import model.KhuyenMai;
import model.PhuKien;
import model.SanPham;
import repository.SanPhamRepository;
import service.SanPhamService;
import viewmodel.SanPhamViewModel;
public class SanPhamImpl implements SanPhamService {

    SanPhamRepository SP = new SanPhamRepository();
    SanPham sanPham = new SanPham();
    
    @Override
    public ArrayList<SanPhamViewModel> getAll() {
        return SP.all();
    }

    @Override
    public String addSP(SanPham SP) {
        boolean add = this.SP.add(SP);

        if (sanPham.getMaIMEI() == null) {
        return "không được để trống";
        }

        if (sanPham.getTen() == null) {
        return "không được để trống";
        }
        
        if (add) {
            return "Thanh cong";
        } else {
            return "That bai";
        }
    }

    @Override
    public String deleteSP(String ma) {
        boolean delete = SP.delete(ma);
        if (delete) {
            return "Thanh cong";
        } else {
            return "That bai";
        }
    }



    @Override
    public SanPham getOne(String maSP) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HangSP> getID() {
        return SP.getALLHang();
    }

    @Override
    public List<KhuyenMai> getKM() {
        return SP.getALLKM();
    }

    @Override
    public List<PhuKien> getPK() {
        return SP.getALLPK();
    }

    @Override
    public String updateSP(SanPham SP, int ma) {
         boolean update = this.SP.update(SP, ma);
        if(update){
            return "Update thanh cong";
        }else{
            return "Update that bai";
        }
    }
}
