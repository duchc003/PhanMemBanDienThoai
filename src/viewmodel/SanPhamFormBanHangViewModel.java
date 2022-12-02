package viewmodel;

import java.math.BigDecimal;

public class SanPhamFormBanHangViewModel {

    private String maSp;
    private String tenSp;
    private int soLuong;
    private String giamGia;
    private String hang;
    private Long giaBan;
    private String xuatXu;

    public SanPhamFormBanHangViewModel() {
    }

    public SanPhamFormBanHangViewModel(String maSp, String tenSp, int soLuong, String giamGia, String hang, Long giaBan, String xuatXu) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.giamGia = giamGia;
        this.hang = hang;
        this.giaBan = giaBan;
        this.xuatXu = xuatXu;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(String giamGia) {
        this.giamGia = giamGia;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public Long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Long giaBan) {
        this.giaBan = giaBan;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    @Override
    public String toString() {
        return "SanPhamFormBanHangViewModel{" + "maSp=" + maSp + ", tenSp=" + tenSp + ", soLuong=" + soLuong + ", giamGia=" + giamGia + ", hang=" + hang + ", giaBan=" + giaBan + ", xuatXu=" + xuatXu + '}';
    }


}
