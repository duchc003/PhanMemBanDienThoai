/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class HinhThucThanhToan {
    
    private int id;
    private String tenHinhThuc;

    public HinhThucThanhToan() {
    }

    public HinhThucThanhToan(int id) {
        this.id = id;
    }

    public HinhThucThanhToan(int id, String tenHinhThuc) {
        this.id = id;
        this.tenHinhThuc = tenHinhThuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenHinhThuc() {
        return tenHinhThuc;
    }

    public void setTenHinhThuc(String tenHinhThuc) {
        this.tenHinhThuc = tenHinhThuc;
    }
    
}
