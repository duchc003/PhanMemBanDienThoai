/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public class Imei {

    private int id;
    private int maImei;
    private String trangThai;
    private int idSanPham;

    public Imei() {
    }

    public Imei(int id, int maImei, String trangThai, int idSanPham) {
        this.id = id;
        this.maImei = maImei;
        this.trangThai = trangThai;
        this.idSanPham = idSanPham;
    }

    public Imei(int maImei) {
        this.maImei = maImei;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaImei() {
        return maImei;
    }

    public void setMaImei(int maImei) {
        this.maImei = maImei;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

}
