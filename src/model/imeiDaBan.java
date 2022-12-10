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
public class imeiDaBan {
    private int id;
    private String ma;
    private String trangThai;
    private int idHoaDon;

    public imeiDaBan() {
    }

    public imeiDaBan(int id, String ma, String trangThai, int idHoaDon) {
        this.id = id;
        this.ma = ma;
        this.trangThai = trangThai;
        this.idHoaDon = idHoaDon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    @Override
    public String toString() {
        return "imeiDaBan{" + "id=" + id + ", ma=" + ma + ", trangThai=" + trangThai + ", idHoaDon=" + idHoaDon + '}';
    }
}
