/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author ASUS
 */
public class KhuyenMaiBanHang {

    private String maSP;
    private String tenSP;
    private int soLuong;
    private String maKmString;
    private String tenKM;
    private String ngayBd;
    private String ngayKT;
    private long giamGia;
    private String hinhThucString;
    private String trangThai;

    public KhuyenMaiBanHang() {
    }

    public KhuyenMaiBanHang(String maSP, String tenSP, int soLuong, String maKmString, String tenKM, String ngayBd, String ngayKT, long giamGia, String hinhThucString, String trangThai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.maKmString = maKmString;
        this.tenKM = tenKM;
        this.ngayBd = ngayBd;
        this.ngayKT = ngayKT;
        this.giamGia = giamGia;
        this.hinhThucString = hinhThucString;
        this.trangThai = trangThai;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaKmString() {
        return maKmString;
    }

    public void setMaKmString(String maKmString) {
        this.maKmString = maKmString;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public String getNgayBd() {
        return ngayBd;
    }

    public void setNgayBd(String ngayBd) {
        this.ngayBd = ngayBd;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }

    public long getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(long giamGia) {
        this.giamGia = giamGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getHinhThucString() {
        return hinhThucString;
    }

    public void setHinhThucString(String hinhThucString) {
        this.hinhThucString = hinhThucString;
    }

    @Override
    public String toString() {
        return "KhuyenMaiBanHang{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", soLuong=" + soLuong + ", maKmString=" + maKmString + ", tenKM=" + tenKM + ", ngayBd=" + ngayBd + ", ngayKT=" + ngayKT + ", giamGia=" + giamGia + ", hinhThucString=" + hinhThucString + ", trangThai=" + trangThai + '}';
    }

}
