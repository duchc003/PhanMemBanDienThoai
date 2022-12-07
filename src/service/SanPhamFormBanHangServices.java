package service;

import java.util.List;
import model.HangSP;
import viewmodel.SanPhamFormBanHangViewModel;

public interface SanPhamFormBanHangServices {

    List<SanPhamFormBanHangViewModel> getAll();

    List<SanPhamFormBanHangViewModel> Search(String ma);
    
    SanPhamFormBanHangViewModel soLuong(String ma);
    
    String updateSoLuong( SanPhamFormBanHangViewModel sp,int id);
    
}
