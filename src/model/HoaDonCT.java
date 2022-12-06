/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class HoaDonCT {

    private int id;
    private int idSP;
    private int idHoaDon;
    private int soLuong;
    private long tienThua;
    private long donGia;
    private long tienGiamGia;

    public HoaDonCT() {
    }

    public HoaDonCT(int id, int idSP, int idHoaDon, int soLuong, long tienThua, long donGia, long tienGiamGia) {
        this.id = id;
        this.idSP = idSP;
        this.idHoaDon = idHoaDon;
        this.soLuong = soLuong;
        this.tienThua = tienThua;
        this.donGia = donGia;
        this.tienGiamGia = tienGiamGia;
    }

    public HoaDonCT(int idSP) {
        this.idSP = idSP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public long getTienThua() {
        return tienThua;
    }

    public void setTienThua(long tienThua) {
        this.tienThua = tienThua;
    }

    public long getDonGia() {
        return donGia;
    }

    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }

    public long getTienGiamGia() {
        return tienGiamGia;
    }

    public void setTienGiamGia(long tienGiamGia) {
        this.tienGiamGia = tienGiamGia;
    }

}
