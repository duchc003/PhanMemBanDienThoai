package service;

import java.util.ArrayList;
import java.util.List;
import model.HangSP;
import model.HinhThucKhuyenMai;
import model.KhuyenMai;
import model.NhaCungCap;
import model.SanPham;
import viewmodel.KhuyenMaiViewModel;
import viewmodel.SanPhamViewModel;

public interface SanPhamService {

    public ArrayList<SanPhamViewModel> getAll();

    public List<HangSP> getID();

    public List<KhuyenMaiViewModel> getIDKm();

    public String addSP(SanPham SP);

    public String updateSP(int ma, SanPham sp);

    List<HinhThucKhuyenMai> getALLHT();

    HangSP getOneHang(String hang);
    
    KhuyenMaiViewModel getOneKm(String ten);
    
    NhaCungCap getOneNCC(String ten);
    
    SanPham getOneSP(String ten);
}
