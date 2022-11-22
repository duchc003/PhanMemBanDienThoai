/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author HieuIT
 */
public class TraHangViewmodel {

    private String maHD;
    private String tenKH;
    private int soLuong;
    private String ngayThanhToan;
    private float thanhTien;

    public TraHangViewmodel() {
    }

    public TraHangViewmodel(String maHD, String tenKH, int soLuong, String ngayThanhToan, float thanhTien) {
        this.maHD = maHD;
        this.tenKH = tenKH;
        this.soLuong = soLuong;
        this.ngayThanhToan = ngayThanhToan;
        this.thanhTien = thanhTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "TraHangViewmodel{" + "maHD=" + maHD + ", tenKH=" + tenKH + ", soLuong=" + soLuong + ", ngayThanhToan=" + ngayThanhToan + ", thanhTien=" + thanhTien + '}';
    }

    public Object[] toRowData() {
        return new Object[]{maHD, tenKH, soLuong, ngayThanhToan, thanhTien};
    }
}
