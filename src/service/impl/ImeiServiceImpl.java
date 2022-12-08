/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.List;
import model.Imei;
import repository.ImeiRepository;
import service.ImeiService;

/**
 *
 * @author ASUS
 */
public class ImeiServiceImpl implements ImeiService {

    public static List<String> list;
    public static List<String> listXoa;
    private ImeiRepository impl = new ImeiRepository();

    @Override
    public List<Imei> getALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String maTrung(String ma) {
        String check = impl.maTrung(ma);
        if (check != null) {
            return null;
        }
        return null;
    }

    @Override
    public List<String> getList() {
        return list;
    }
    
    public void setList(List<String> list) {
        ImeiServiceImpl.list = list;
    }
    
    public List<String> getListXoa() {
        return listXoa;
    }

    public void setListXoa(List<String> listXoa) {
        ImeiServiceImpl.listXoa = listXoa;
    }

}
