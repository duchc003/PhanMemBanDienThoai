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
    private int soLuong;
    private String ram;
    private String xuatXu;
    private String camera;
    private String manHinh;
    private String boNho;
    private String mauSac;
    private float giaNhap;
    private float giaBan;
    private String image;
    private String barcode;
    private int trangThai;
    private String moTa;

    public ChiTietSPView() {
    }

    public ChiTietSPView(int id, int idSP, int idNcc, int soLuong, String ram, String xuatXu, String camera, String manHinh, String boNho, String mauSac, float giaNhap, float giaBan, String image, String barcode, int trangThai, String moTa) {
        this.id = id;
        this.idSP = idSP;
        this.idNcc = idNcc;
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

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Object[] toDataRow() {
        return new Object[]{id, idSP, idNcc, soLuong, ram, xuatXu, camera, manHinh, boNho, mauSac, giaNhap, giaBan, image, barcode, trangThai == 1 ? "Còn Hàng" :"Hết Hàng", moTa};
    }

    @Override
    public String toString() {
        return "ChiTietSPView{" + "id=" + id + ", idSP=" + idSP + ", idNcc=" + idNcc + ", soLuong=" + soLuong + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", barcode=" + barcode + ", image=" + image + ", ram=" + ram + ", xuatXu=" + xuatXu + ", camera=" + camera + ", manHinh=" + manHinh + ", boNho=" + boNho + ", mauSac=" + mauSac + ", trangThai=" + trangThai + ", moTa=" + moTa + '}';
    }
}
