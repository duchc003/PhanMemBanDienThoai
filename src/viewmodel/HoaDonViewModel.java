package viewmodel;

public class HoaDonViewModel {

    private int id;
    private String maHdString;
    private String ngayTao;
    private long tienKhachCanTra;
    private long tongTien;
    private String trangThai;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(int id, String maHdString, String ngayTao, long tienKhachCanTra, long tongTien, String trangThai) {
        this.id = id;
        this.maHdString = maHdString;
        this.ngayTao = ngayTao;
        this.tienKhachCanTra = tienKhachCanTra;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public HoaDonViewModel(int id, String maHdString, String ngayTao, String trangThai) {
        this.id = id;
        this.maHdString = maHdString;
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaHdString() {
        return maHdString;
    }

    public void setMaHdString(String maHdString) {
        this.maHdString = maHdString;
    }

    public long getTienKhachCanTra() {
        return tienKhachCanTra;
    }

    public void setTienKhachCanTra(long tienKhachCanTra) {
        this.tienKhachCanTra = tienKhachCanTra;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "HoaDonViewModel{" + "id=" + id + ", maHdString=" + maHdString + ", ngayTao=" + ngayTao + ", trangThai=" + trangThai + '}';
    }

}
