package viewmodel;

import java.math.BigDecimal;
import util.XMoney;

public class SanPhamFormBanHangViewModel {

    private int id;
    private String maSp;
    private String tenSp;
    private int soLuong;
    private long giamGia;
    private Long giaBan;
    private String xuatXu;
    private String hinhThuc;

    public SanPhamFormBanHangViewModel() {
    }

    public SanPhamFormBanHangViewModel(int id, String maSp, String tenSp, int soLuong, long giamGia, Long giaBan, String xuatXu, String hinhThuc) {
        this.id = id;
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.giamGia = giamGia;
        this.giaBan = giaBan;
        this.xuatXu = xuatXu;
        this.hinhThuc = hinhThuc;
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

    public Long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Long giaBan) {
        this.giaBan = giaBan;
    }

    public long getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(long giamGia) {
        this.giamGia = giamGia;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }
    
    private String giamGia() {
        if (getHinhThuc().equalsIgnoreCase("Giảm Giá %")) {
            return getGiamGia() + " " + "%";
        } else {
            return XMoney.themDauCham(getGiamGia()) + " " + "VND";
        }
    }

    @Override
    public String toString() {
        return "SanPhamFormBanHangViewModel{" + "id=" + id + ", maSp=" + maSp + ", tenSp=" + tenSp + ", soLuong=" + soLuong + ", giamGia=" + giamGia + ", giaBan=" + giaBan + ", xuatXu=" + xuatXu + ", hinhThuc=" + hinhThuc + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{maSp, tenSp, soLuong, giamGia(), giaBan, xuatXu};
    }
}
