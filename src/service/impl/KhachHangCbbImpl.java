/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.KhachHang;
import repository.KhachHangViewCbbRepo;
import service.KhachHangCbbService;

/**
 *
 * @author ASUS
 */
public class KhachHangCbbImpl implements KhachHangCbbService{

    private KhachHangViewCbbRepo impl = new KhachHangViewCbbRepo();
    
    @Override
    public List<KhachHang> getALL() {
        return impl.getALL();
    }

    @Override
    public KhachHang getOne(String hoVaTen) {
        return impl.getOne(hoVaTen);
    }

    @Override
    public List<KhachHang> getSeach(String sdt, List<KhachHang> list) {
        list = impl.getTenKh(sdt);
        return list;
    }
    
}
