/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.List;
import model.NhanVien;
import repository.DoiMatKhauRepo;
import repository.NhanVienRepository;
import service.DoiMatKhauService;

/**
 *
 * @author Banh Chung Ran
 */
public class DoiMatKhauServiceImpl implements DoiMatKhauService {

    private final DoiMatKhauRepo nhanVienRepository = new DoiMatKhauRepo();

    @Override
    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.getAllNhanVien();
    }

    @Override
    public String update(String mk, String tk) {
        int update = 0;
        update = nhanVienRepository.update(mk, tk);
        if (update > 0) {
            return "đổi mật khẩu thành công";
        } else {
            return "Đổi mật khẩu thất bại";
        }
    }
}