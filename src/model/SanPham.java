/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class SanPham {

    private int id;
    private int idHang;
    private String ma;
    private String ten;

    public SanPham() {
    }

    public SanPham(int idHang, String ma, String ten) {
        this.idHang = idHang;
        this.ma = ma;
        this.ten = ten;
    }

    public SanPham(int id, int idHang, String ma, String ten) {
        this.id = id;
        this.idHang = idHang;
        this.ma = ma;
        this.ten = ten;
    }

    public SanPham(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public SanPham(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHang() {
        return idHang;
    }

    public void setIdHang(int idHang) {
        this.idHang = idHang;
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

    @Override
    public String toString() {
        return "SanPham{" + "id=" + id + ", idHang=" + idHang + ", ma=" + ma + ", ten=" + ten + '}';
    }
}
