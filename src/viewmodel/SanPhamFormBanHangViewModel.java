
package viewmodel;

public class SanPhamFormBanHangViewModel {
    private String maSp;
    private String tenSp;
    private int soLuong;
    private String hang;
    private Double giaBan;
    private String xuatXu;

    public SanPhamFormBanHangViewModel() {
    }

    public SanPhamFormBanHangViewModel(String maSp, String tenSp, int soLuong, String hang, Double giaBan, String xuatXu) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
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

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }
    
}
