/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.List;
import model.HoaDon;
import model.Imei;
import model.SanPham;
import model.imeiDaBan;
import repository.ImeiRepository;
import service.ImeiService;
import viewmodel.HoaDonViewModel;

/**
 *
 * @author ASUS
 */
public class ImeiServiceImpl implements ImeiService {

    private ImeiRepository impl = new ImeiRepository();

    @Override
    public List<Imei> getALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String add(Imei imei) {
        boolean add = impl.add(imei);
        if (add) {
            return "";
        } else {
            return "";
        }
    }

    @Override
    public String addImei(imeiDaBan imei) {
        boolean add = impl.addImei(imei);
        if (add) {
            return "";
        } else {
            return "";
        }
    }

    @Override
    public List<Imei> getALLID(int id) {
        return impl.getALLID(id);
    }

    @Override
    public SanPham getOneID(String id) {
        return impl.getOneID(id);
    }

    @Override
    public HoaDonViewModel getOneIDHoaDon(int id) {
        return impl.getOneIDHoaDon(id);
    }

    @Override
    public HoaDon getOneIDHD(int id) {
        return impl.getOneIDHD(id);
    }

    @Override
    public String delete(int id) {
        boolean delete = impl.delete(id);
        if (delete) {
            return "";
        } else {
            return "";
        }
    }

}
