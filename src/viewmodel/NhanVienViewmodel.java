/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author HieuIT
 */
public class NhanVienViewmodel {

    private String maNV;
    private String hoVaTen;
    private String diaChi;
    private String gioiTinh;
    private String sdt;
    private String email;
    private boolean vaiTro;
    private String trangThai;

    public NhanVienViewmodel() {
    }

    public NhanVienViewmodel(String maNV, String hoVaTen, String diaChi, String gioiTinh, String sdt, String email, boolean vaiTro, String trangThai) {
        this.maNV = maNV;
        this.hoVaTen = hoVaTen;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.email = email;
        this.vaiTro = vaiTro;
        this.trangThai = trangThai;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "NhanVienViewmodel{" + "maNV=" + maNV + ", hoVaTen=" + hoVaTen + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + ", sdt=" + sdt + ", email=" + email + ", vaiTro=" + vaiTro + ", trangThai=" + trangThai + '}';
    }

    public Object[] toRowData() {
        return new Object[]{maNV, hoVaTen, diaChi, gioiTinh, sdt, email, vaiTro == true ? "Nhân viên" : "Quản lý", trangThai};
    }
}
