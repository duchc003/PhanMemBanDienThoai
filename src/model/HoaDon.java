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
public class HoaDon {

    private int id;
    private int idKhachHang;
    private int idNhanVien;
    private int idHinhThucTT;
    private int idHinhThucGH;
    private String maHD;
    private String ngayTao;
    private String ngayThanhToan;
    private String ngayNhanHang;
    private String ngayGiaoHang;
    private String ngayKhachNhanhang;
    private String thoiGianBaohanh;
    private double tongTien;
    private String hanTra;
    private String ngayTra;
    private String trangThai;
    private String moTa;

    public HoaDon() {
    }

    public HoaDon(String trangThai) {
        this.trangThai = trangThai;
    }

    public HoaDon(int id, int idKhachHang, int idNhanVien, int idHinhThucTT, int idHinhThucGH, String maHD, String ngayTao, String ngayThanhToan, String ngayNhanHang, String ngayGiaoHang, String ngayKhachNhanhang, String thoiGianBaohanh, double tongTien, String hanTra, String ngayTra, String trangThai, String moTa) {
        this.id = id;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.idHinhThucTT = idHinhThucTT;
        this.idHinhThucGH = idHinhThucGH;
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayNhanHang = ngayNhanHang;
        this.ngayGiaoHang = ngayGiaoHang;
        this.ngayKhachNhanhang = ngayKhachNhanhang;
        this.thoiGianBaohanh = thoiGianBaohanh;
        this.tongTien = tongTien;
        this.hanTra = hanTra;
        this.ngayTra = ngayTra;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }

    public HoaDon(String ngayTao, double tongTien) {
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public int getIdHinhThucTT() {
        return idHinhThucTT;
    }

    public void setIdHinhThucTT(int idHinhThucTT) {
        this.idHinhThucTT = idHinhThucTT;
    }

    public int getIdHinhThucGH() {
        return idHinhThucGH;
    }

    public void setIdHinhThucGH(int idHinhThucGH) {
        this.idHinhThucGH = idHinhThucGH;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getNgayNhanHang() {
        return ngayNhanHang;
    }

    public void setNgayNhanHang(String ngayNhanHang) {
        this.ngayNhanHang = ngayNhanHang;
    }

    public String getNgayGiaoHang() {
        return ngayGiaoHang;
    }

    public void setNgayGiaoHang(String ngayGiaoHang) {
        this.ngayGiaoHang = ngayGiaoHang;
    }

    public String getNgayKhachNhanhang() {
        return ngayKhachNhanhang;
    }

    public void setNgayKhachNhanhang(String ngayKhachNhanhang) {
        this.ngayKhachNhanhang = ngayKhachNhanhang;
    }

    public String getThoiGianBaohanh() {
        return thoiGianBaohanh;
    }

    public void setThoiGianBaohanh(String thoiGianBaohanh) {
        this.thoiGianBaohanh = thoiGianBaohanh;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getHanTra() {
        return hanTra;
    }

    public void setHanTra(String hanTra) {
        this.hanTra = hanTra;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
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

}
