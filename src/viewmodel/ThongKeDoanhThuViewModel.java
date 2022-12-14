/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author ADMIN
 */
public class ThongKeDoanhThuViewModel {

    private String MaHD;
    private int SoLuong;
    private long GiaNhap;
    private long giaBan;
    private long doanhThu;

    public ThongKeDoanhThuViewModel() {
    }

    public ThongKeDoanhThuViewModel(String MaHD, int SoLuong, long GiaNhap, long giaBan, long doanhThu) {
        this.MaHD = MaHD;
        this.SoLuong = SoLuong;
        this.GiaNhap = GiaNhap;
        this.giaBan = giaBan;
        this.doanhThu = doanhThu;
    }

    public Object[] toDatarow() {
        return new Object[]{MaHD, SoLuong, GiaNhap, giaBan, doanhThu};
    }


    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(long GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
    }

    public float getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(long doanhThu) {
        this.doanhThu = doanhThu;
    }

    @Override
    public String toString() {
        return "ThongKeDoanhThuViewModel{" + "MaHD=" + MaHD + ", SoLuong=" + SoLuong + ", GiaNhap=" + GiaNhap + ", giaBan=" + giaBan + ", doanhThu=" + doanhThu + '}';
    }

}
