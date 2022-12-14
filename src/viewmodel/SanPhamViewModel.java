package viewmodel;

public class SanPhamViewModel {

    private int id;
    private int idHang;
    private String ten;
    private String ma;

    public SanPhamViewModel() {
    }

    public SanPhamViewModel(int id, int idHang, String ten, String ma) {
        this.id = id;
        this.idHang = idHang;
        this.ten = ten;
        this.ma = ma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHang() {
        return idHang;
    }

    public void setIdHang(int idHang) {
        this.idHang = idHang;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Object[] todataRow() {
        return new Object[]{
            id ,idHang,ma, ten
        };
    }
}
