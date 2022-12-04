package viewmodel;

public class ThongkeSanPhamViewModel {

    private String MaSp;
    private String TenSP;
    private int SoLuong;
    private String TrangThai;

    public ThongkeSanPhamViewModel() {
    }

    public ThongkeSanPhamViewModel(String MaSp, String TenSP, int SoLuong, String TrangThai) {
        this.MaSp = MaSp;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.TrangThai = TrangThai;
    }

    public String getMaSp() {
        return MaSp;
    }

    public void setMaSp(String MaSp) {
        this.MaSp = MaSp;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return "ThongkeSanPhamViewModel{" + "MaSp=" + MaSp + ", TenSP=" + TenSP + ", SoLuong=" + SoLuong + ", TrangThai=" + TrangThai + '}';
    }

    public Object[] toDatarow() {
        return new Object[]{MaSp, TenSP, SoLuong, TrangThai };
    }
}
