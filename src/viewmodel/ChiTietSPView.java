/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author ASUS
 */
public class ChiTietSPView {

    private int id;
    private int idSP;
    private int idNcc;
    private int idKM;
    private int soLuong;
    private String ram;
    private String xuatXu;
    private String camera;
    private String manHinh;
    private String boNho;
    private String mauSac;
    private long giaNhap;
    private long giaBan;
    private String image;
    private String barcode;
    private String trangThai;
    private String moTa;

    public ChiTietSPView() {
    }

    public ChiTietSPView(int id, int idSP, int idNcc, int idKM, int soLuong, String ram, String xuatXu, String camera, String manHinh, String boNho, String mauSac, long giaNhap, long giaBan, String image, String barcode, String trangThai, String moTa) {
        this.id = id;
        this.idSP = idSP;
        this.idNcc = idNcc;
        this.idKM = idKM;
        this.soLuong = soLuong;
        this.ram = ram;
        this.xuatXu = xuatXu;
        this.camera = camera;
        this.manHinh = manHinh;
        this.boNho = boNho;
        this.mauSac = mauSac;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.image = image;
        this.barcode = barcode;
        this.trangThai = trangThai;
        this.moTa = moTa;
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

    public int getIdNcc() {
        return idNcc;
    }

    public void setIdNcc(int idNcc) {
        this.idNcc = idNcc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(long giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
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

    public int getIdKM() {
        return idKM;
    }

    public void setIdKM(int idKM) {
        this.idKM = idKM;
    }

    public Object[] toDataRow() {
        return new Object[]{id, idSP, idNcc,idKM, soLuong, ram, xuatXu, camera, manHinh, boNho, mauSac, giaNhap, giaBan, image, barcode, trangThai, moTa};
    }

    @Override
    public String toString() {
        return "ChiTietSPView{" + "id=" + id + ", idSP=" + idSP + ", idNcc=" + idNcc + ", idKM=" + idKM + ", soLuong=" + soLuong + ", ram=" + ram + ", xuatXu=" + xuatXu + ", camera=" + camera + ", manHinh=" + manHinh + ", boNho=" + boNho + ", mauSac=" + mauSac + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", image=" + image + ", barcode=" + barcode + ", trangThai=" + trangThai + ", moTa=" + moTa + '}';
    }

}
