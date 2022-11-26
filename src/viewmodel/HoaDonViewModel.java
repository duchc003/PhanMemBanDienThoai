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

    public String trangThaiHoaDon() {
        if (getTrangThai() == "1") {
            return "Đã Thanh Toán";
        }
        if (getTrangThai() == "2") {
            return "Đã Hủy";
        }
        if (getTrangThai() == "3") {
            return "Giao Hàng Thành Công";
        }
        if (getTrangThai() == "4") {
            return "Đang Giao Hàng";
        }
        if (getTrangThai() == "5") {
            return "Giao Hàng Thất Bại";
        }
        return null;
    }
}
