/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

/**
 *
 * @author ASUS
 */
public class ChiTietHoaDonView {

    private int id;
    private String maHD;
    private String tenSP;
    private int soLuong;
    private long donGia;
    private long tienThua;
    private long TienGiamGia;

    public ChiTietHoaDonView() {
    }

    public ChiTietHoaDonView(int id, String maHD, String tenSP, int soLuong, long donGia, long tienThua, long TienGiamGia) {
        this.id = id;
        this.maHD = maHD;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tienThua = tienThua;
        this.TienGiamGia = TienGiamGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
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

    public long getDonGia() {
        return donGia;
    }

    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }

    public long getTienThua() {
        return tienThua;
    }

    public void setTienThua(long tienThua) {
        this.tienThua = tienThua;
    }

    public long getTienGiamGia() {
        return TienGiamGia;
    }

    public void setTienGiamGia(long TienGiamGia) {
        this.TienGiamGia = TienGiamGia;
    }

    public Object[] toDataRow() {
        return new Object[]{maHD, tenSP, soLuong, donGia, tienThua, TienGiamGia};
    }

    @Override
    public String toString() {
        return "ChiTietHoaDonView{" + "maHD=" + maHD + ", tenSP=" + tenSP + ", soLuong=" + soLuong + ", donGia=" + donGia + ", tienThua=" + tienThua + ", TienGiamGia=" + TienGiamGia + '}';
    }
}