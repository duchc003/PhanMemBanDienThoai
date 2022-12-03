package viewmodel;

import util.XMoney;

public class GioHangViewModel {

    private String ma;
    private String ten;
    private int soLuong;
    private long donGia;
    private long thanhTien;

    public GioHangViewModel() {
    }

    public GioHangViewModel(String ma, String ten, int soLuong, long donGia, long thanhTien) {
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    public double thanhTien() {
        return donGia * soLuong;
    }

    public long getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(long thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Object[] toDataRow() {
        return new Object[]{ma,ten,soLuong,donGia,thanhTien};
    }
}
