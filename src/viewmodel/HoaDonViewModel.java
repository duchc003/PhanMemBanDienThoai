package viewmodel;

public class HoaDonViewModel {

    
    private String ngayTao;
    private int trangThai;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String ngayTao, int trangThai) {
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

 
   

}
