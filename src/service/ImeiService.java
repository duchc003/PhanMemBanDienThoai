/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Imei;

/**
 *
 * @author ASUS
 */
public interface ImeiService {

    List<Imei> getALL();

    String maTrung(String ma);

    List<String> getList();
    
    List<String> getListXoa();
    
    void setListXoa(List<String> listXoa);
}