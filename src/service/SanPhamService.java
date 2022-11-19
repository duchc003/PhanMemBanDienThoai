package service;


import java.util.ArrayList;
import java.util.List;
import model.HangSP;
import model.KhuyenMai;
import model.PhuKien;
import model.SanPham;
import viewmodel.SanPhamViewModel;
public interface SanPhamService {
    
   public ArrayList<SanPhamViewModel> getAll();
    
   public List<HangSP> getID();
    
   public List<KhuyenMai> getKM();
    
   public List<PhuKien> getPK();
    
   public String addSP(SanPham SP);
    
   public String deleteSP(String ma );
    
   public String updateSP(SanPham SP, int ma);
    
   public SanPham getOne(String maSP);
}
