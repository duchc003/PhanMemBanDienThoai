package service;


import java.util.ArrayList;
import java.util.List;
import model.HangSP;
import model.KhuyenMai;
import model.SanPham;
import viewmodel.SanPhamViewModel;
public interface SanPhamService {
    
   public ArrayList<SanPhamViewModel> getAll();
    
   public List<HangSP> getID();
   
   public List<KhuyenMai> getIDKm();
    
   public String addSP(SanPham SP);
    
   public String updateSP(SanPham SP, int ma);
    
   public SanPham getOne(String maSP);
}
