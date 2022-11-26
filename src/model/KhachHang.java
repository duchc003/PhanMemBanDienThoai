/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class KhachHang {
    
    private int id;
    private String ma;
    private String hoVaTen;
    private String soDienThoai;
    private String ngaySinh;
    private String diaChi;
    private String gioiTinh;
    private String moTa;

    public KhachHang() {
    }

    public KhachHang(int id, String ma, String hoVaTen, String soDienThoai, String ngaySinh, String diaChi, String gioiTinh, String moTa) {
        this.id = id;
        this.ma = ma;
        this.hoVaTen = hoVaTen;
        this.soDienThoai = soDienThoai;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.moTa = moTa;
    }
       public KhachHang(String ma, String hoVaTen, String soDienThoai, String ngaySinh, String diaChi, String gioiTinh, String moTa) {
        this.ma = ma;
        this.hoVaTen = hoVaTen;
        this.soDienThoai = soDienThoai;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.moTa = moTa;
    }

    public KhachHang(int id, String hoVaTen) {
        this.id = id;
        this.hoVaTen = hoVaTen;
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

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
}
