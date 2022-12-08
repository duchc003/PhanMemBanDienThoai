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
    private String maImei;
    private String trangThai;
    private int idSanPham;

    public Imei() {
    }

    public Imei(int id, String maImei, String trangThai, int idSanPham) {
        this.id = id;
        this.maImei = maImei;
        this.trangThai = trangThai;
        this.idSanPham = idSanPham;
    }

    public Imei(String maImei) {
        this.maImei = maImei;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaImei() {
        return maImei;
    }

    public void setMaImei(String maImei) {
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
