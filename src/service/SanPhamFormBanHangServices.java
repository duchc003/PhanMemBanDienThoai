
package service;

import java.util.List;
import viewmodel.SanPhamFormBanHangViewModel;

public interface SanPhamFormBanHangServices {
    List<SanPhamFormBanHangViewModel> getAll();
     List<SanPhamFormBanHangViewModel> Search(String ma);
}
