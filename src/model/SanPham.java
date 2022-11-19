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
    private int idKM;
    private int idPK;
    private int idHang;
    private String ma;
    private String ten;
    private String maIMEI;

    public SanPham() {
    }

    public SanPham(int id, int idKM, int idPK, int idHang, String ma, String ten, String maIMEI) {
        this.id = id;
        this.idKM = idKM;
        this.idPK = idPK;
        this.idHang = idHang;
        this.ma = ma;
        this.ten = ten;
        this.maIMEI = maIMEI;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKM() {
        return idKM;
    }

    public void setIdKM(int idKM) {
        this.idKM = idKM;
    }

    public int getIdPK() {
        return idPK;
    }

    public void setIdPK(int idPK) {
        this.idPK = idPK;
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

    public String getMaIMEI() {
        return maIMEI;
    }

    public void setMaIMEI(String maIMEI) {
        this.maIMEI = maIMEI;
    }

}
