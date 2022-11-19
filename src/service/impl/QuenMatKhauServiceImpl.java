/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.List;
import repository.QuenMatKhauRepo;
import viewmodel.QuenMatKhauModel;
import service.QuenMatKhauService;

/**
 *
 * @author Admin
 */
public class QuenMatKhauServiceImpl implements QuenMatKhauService {

    private QuenMatKhauRepo quenMatKhauRespository = new QuenMatKhauRepo();

    @Override
    public List<QuenMatKhauModel> getEmail(String ma) {
        return quenMatKhauRespository.getEmail(ma);
    }

    @Override
    public String update(String mk, String ma) {
        int row = 0;
        row = quenMatKhauRespository.updatePassWord(mk, ma);
        if (row > 0) {
            return " Đổi mật khẩu thành công";
        } else {
            return "Thất Bại";
        }
    }

}
