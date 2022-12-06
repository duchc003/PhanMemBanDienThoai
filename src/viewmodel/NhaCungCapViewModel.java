/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author HieuIT
 */
public class NhaCungCapViewModel {

    private int id;
    private String ma;
    private String ten;
    private String sdt;

    public NhaCungCapViewModel() {
    }

    public NhaCungCapViewModel(String ma, String ten, String sdt) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
    }

    public NhaCungCapViewModel(int id, String ma, String ten, String sdt) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "NhaCungCapViewModel{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + '}';
    }

    public Object[] toRowDataNcc() {
        return new Object[]{id, ma, ten,sdt};
    }
}
