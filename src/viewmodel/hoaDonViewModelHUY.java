/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author Banh Chung Ran
 */
public class hoaDonViewModelHUY {
    private String maHD;
    private String hoVaTen;
    private int soLuong;
    private Double thanhTien;
    private String tenHTTT;
    private String tenHTGH;
    private String trangThai;

    public hoaDonViewModelHUY() {
    }

    public hoaDonViewModelHUY(String maHD, String hoVaTen, int soLuong, Double thanhTien, String tenHTTT, String tenHTGH, String trangThai) {
        this.maHD = maHD;
        this.hoVaTen = hoVaTen;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.tenHTTT = tenHTTT;
        this.tenHTGH = tenHTGH;
        this.trangThai = trangThai;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getTenHTTT() {
        return tenHTTT;
    }

    public void setTenHTTT(String tenHTTT) {
        this.tenHTTT = tenHTTT;
    }

    public String getTenHTGH() {
        return tenHTGH;
    }

    public void setTenHTGH(String tenHTGH) {
        this.tenHTGH = tenHTGH;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
