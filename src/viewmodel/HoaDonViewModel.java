
package viewmodel;

public class HoaDonViewModel {
   private String maHD;
   private String ngayTao;
   private String trangThai;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String maHD, String ngayTao, String trangThai) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
   
}
