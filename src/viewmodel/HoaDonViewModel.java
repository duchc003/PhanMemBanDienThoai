package viewmodel;

public class HoaDonViewModel {

    private int id;
    private String ngayTao;
    private int trangThai;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(int id, String ngayTao, int trangThai) {
        this.id = id;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
