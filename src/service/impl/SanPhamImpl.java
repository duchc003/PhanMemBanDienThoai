package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.HangSP;
import model.HinhThucKhuyenMai;
import model.KhuyenMai;
import model.NhaCungCap;
import model.SanPham;
import repository.ChiTietSanPhamRepo;
import repository.SanPhamRepository;
import service.SanPhamService;
import viewmodel.KhuyenMaiViewModel;
import viewmodel.SanPhamViewModel;

public class SanPhamImpl implements SanPhamService {

    SanPhamRepository SP = new SanPhamRepository();
    
    private ChiTietSanPhamRepo impl = new ChiTietSanPhamRepo();

    @Override
    public ArrayList<SanPhamViewModel> getAll() {
        return SP.all();
    }

    @Override
    public String addSP(SanPham SP) {
        boolean add = this.SP.add(SP);
        if (add) {
            return "Thanh cong";
        } else {
            return "That bai";
        }
    }

    @Override
    public List<HangSP> getID() {
        return SP.getALLHang();
    }

    @Override
    public String updateSP(SanPham SP, int ma) {
        boolean update = this.SP.update(SP, ma);
        if (update) {
            return "Update thanh cong";
        } else {
            return "Update that bai";
        }
    }

    @Override
    public List<KhuyenMaiViewModel> getIDKm() {
        return SP.getALLKM();
    }

    @Override
    public List<HinhThucKhuyenMai> getALLHT() {
        return SP.getALLHT();
    }

    @Override
    public HangSP getOneHang(String hang) {
        return SP.getOneHang(hang);
    }

    @Override
    public KhuyenMaiViewModel getOneKm(String ten) {
        return impl.getOneKm(ten);
    }

    @Override
    public NhaCungCap getOneNCC(String ten) {
        return impl.getOneNCC(ten);
    }

    @Override
    public SanPham getOneSP(String ten) {
        return impl.getOneSP(ten);
    }
}
