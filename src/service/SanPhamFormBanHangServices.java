package service;

import java.util.List;
import model.HangSP;
import viewmodel.SanPhamFormBanHangViewModel;

public interface SanPhamFormBanHangServices {

    List<SanPhamFormBanHangViewModel> getAll();

    List<SanPhamFormBanHangViewModel> Search(String ma);
    
    List<HangSP> getTenHangSPs();
    
    List<SanPhamFormBanHangViewModel> searchTenHang(List<SanPhamFormBanHangViewModel> lis,String ma);
}
