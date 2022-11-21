/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author ASUS
 */
public class SanPhamHetHang {

    private int id;
    private String maSp;
    private String tenSP;
    private String tenHang;
    private int soLuong;
    private String ram;
    private String xuatXu;
    private String camere;
    private String manHinh;
    private String boNho;
    private String mauSac;
    private String trangThaiString;

    public SanPhamHetHang() {
    }

    public SanPhamHetHang(int id, String maSp, String tenSP, String tenHang, int soLuong, String ram, String xuatXu, String camere, String manHinh, String boNho, String mauSac, String trangThaiString) {
        this.id = id;
        this.maSp = maSp;
        this.tenSP = tenSP;
        this.tenHang = tenHang;
        this.soLuong = soLuong;
        this.ram = ram;
        this.xuatXu = xuatXu;
        this.camere = camere;
        this.manHinh = manHinh;
        this.boNho = boNho;
        this.mauSac = mauSac;
        this.trangThaiString = trangThaiString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
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

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getCamere() {
        return camere;
    }

    public void setCamere(String camere) {
        this.camere = camere;
    }

    public String getManHinh() {
        return manHinh;
    }

    public void setManHinh(String manHinh) {
        this.manHinh = manHinh;
    }

    public String getBoNho() {
        return boNho;
    }

    public void setBoNho(String boNho) {
        this.boNho = boNho;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getTrangThaiString() {
        return trangThaiString;
    }

    public void setTrangThaiString(String trangThaiString) {
        this.trangThaiString = trangThaiString;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }
    
    public Object[] toDataRow(){
        return new Object[] {id,maSp,tenSP,tenHang,soLuong,ram,xuatXu,camere,manHinh,boNho,mauSac,trangThaiString};
    }

    @Override
    public String toString() {
        return "SanPhamHetHang{" + "id=" + id + ", maSp=" + maSp + ", tenSP=" + tenSP + ", tenHang=" + tenHang + ", soLuong=" + soLuong + ", ram=" + ram + ", xuatXu=" + xuatXu + ", camere=" + camere + ", manHinh=" + manHinh + ", boNho=" + boNho + ", mauSac=" + mauSac + ", trangThaiString=" + trangThaiString + '}';
    }

}
