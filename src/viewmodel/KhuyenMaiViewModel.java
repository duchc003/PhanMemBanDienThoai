/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.Date;

/**
 *
 * @author Banh Chung Ran
 */
public class KhuyenMaiViewModel {

    private int id;
    private String maKM;
    private String ten;
    private String tenHinhThuc;
    private String ngayBD;
    private String ngayKT;
    private float giamGia;
    private String trangThai;
    private String moTa;

    public KhuyenMaiViewModel() {
    }

    public KhuyenMaiViewModel(int id, String maKM, String ten, String tenHinhThuc, String ngayBD, String ngayKT, float giamGia, String trangThai, String moTa) {
        this.id = id;
        this.maKM = maKM;
        this.ten = ten;
        this.tenHinhThuc = tenHinhThuc;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.giamGia = giamGia;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }

    public float getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(float giamGia) {
        this.giamGia = giamGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTenHinhThuc() {
        return tenHinhThuc;
    }

    public void setTenHinhThuc(String tenHinhThuc) {
        this.tenHinhThuc = tenHinhThuc;
    }


}
