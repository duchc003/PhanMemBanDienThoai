/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.NhanVien;
import viewmodel.QuenMatKhauModel;

/**
 *
 * @author Admin
 */
public interface QuenMatKhauService {
    List<QuenMatKhauModel> getEmail(String ma);
    String update(String mk,String ma);
}
