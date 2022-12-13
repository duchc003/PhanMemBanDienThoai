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
    private String maNV;
    private String ngayTao;
    private String ngayThanhToan;
    private String ngayNhanHang;
    private String ngayGiaoHang;
    private String ngayKhachNhanhang;
    private long tongTien;
    private long tienKhachCanTra;
    private Long tienShip;
    private String soDienThoai;
    private String sdtNgShip;
    private String phanTramGiamGia;
    private String trangThai;
    private String moTa;
    private String tenKhack;

    public HoaDon() {
    }

    public HoaDon(String maHD) {
        this.maHD = maHD;
    }

    public HoaDon(int id) {
        this.id = id;
    }

    public HoaDon(int id, int idKhachHang, int idNhanVien, int idHinhThucTT, int idHinhThucGH, String maHD, String ngayTao, String ngayThanhToan, String ngayNhanHang, String ngayGiaoHang, String ngayKhachNhanhang, long tienKhachCanTra, long tongTien, String soDienThoai, String phanTramGiamGia, String trangThai, String moTa) {
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
        this.tienKhachCanTra = tienKhachCanTra;
        this.tongTien = tongTien;
        this.soDienThoai = soDienThoai;
        this.phanTramGiamGia = phanTramGiamGia;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }

    public HoaDon(int id, int idKhachHang, int idNhanVien, int idHinhThucTT, int idHinhThucGH, String maHD, String maNV, String ngayTao, String ngayThanhToan, String ngayNhanHang, String ngayGiaoHang, String ngayKhachNhanhang, long tongTien, long tienKhachCanTra, Long tienShip, String soDienThoai, String sdtNgShip, String phanTramGiamGia, String trangThai, String moTa, String tenKhack) {
        this.id = id;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.idHinhThucTT = idHinhThucTT;
        this.idHinhThucGH = idHinhThucGH;
        this.maHD = maHD;
        this.maNV = maNV;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayNhanHang = ngayNhanHang;
        this.ngayGiaoHang = ngayGiaoHang;
        this.ngayKhachNhanhang = ngayKhachNhanhang;
        this.tongTien = tongTien;
        this.tienKhachCanTra = tienKhachCanTra;
        this.tienShip = tienShip;
        this.soDienThoai = soDienThoai;
        this.sdtNgShip = sdtNgShip;
        this.phanTramGiamGia = phanTramGiamGia;
        this.trangThai = trangThai;
        this.moTa = moTa;
        this.tenKhack = tenKhack;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Long getTienShip() {
        return tienShip;
    }

    public void setTienShip(Long tienShip) {
        this.tienShip = tienShip;
    }

    public String getSdtNgShip() {
        return sdtNgShip;
    }

    public void setSdtNgShip(String sdtNgShip) {
        this.sdtNgShip = sdtNgShip;
    }

    public String getTenKhack() {
        return tenKhack;
    }

    public void setTenKhack(String tenKhack) {
        this.tenKhack = tenKhack;
    }

    public HoaDon(String ngayTao, long tongTien) {
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
    }

    public HoaDon(long tongTien) {

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

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
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

    public long getTienKhachCanTra() {
        return tienKhachCanTra;
    }

    public void setTienKhachCanTra(long tienKhachCanTra) {
        this.tienKhachCanTra = tienKhachCanTra;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getPhanTramGiamGia() {
        return phanTramGiamGia;
    }

    public void setPhanTramGiamGia(String phanTramGiamGia) {
        this.phanTramGiamGia = phanTramGiamGia;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + '}';
    }

}
