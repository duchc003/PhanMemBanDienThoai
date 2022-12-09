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

}
