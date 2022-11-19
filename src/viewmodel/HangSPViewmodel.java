/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author HieuIT
 */
public class HangSPViewmodel {

    private int id;
    private String ma;
    private String ten;

    public HangSPViewmodel() {
    }

    public HangSPViewmodel(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public HangSPViewmodel(int id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "HangSPViewmodel{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + '}';
    }

    public Object[] toRowData() {
        return new Object[]{id, ma, ten};
    }
}
