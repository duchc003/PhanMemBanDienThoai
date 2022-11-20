package viewmodel;

public class SanPhamViewModel {

    private int id;
    private int idKM;
    private int idPK;
    private int idHang;
    private String ten;
    private String ma;
    private String maIMEI;

    public SanPhamViewModel() {
    }

    public SanPhamViewModel(int id, int idKM, int idPK, int idHang, String ten, String ma, String maIMEI) {
        this.id = id;
        this.idKM = idKM;
        this.idPK = idPK;
        this.idHang = idHang;
        this.ten = ten;
        this.ma = ma;
        this.maIMEI = maIMEI;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKM() {
        return idKM;
    }

    public void setIdKM(int idKM) {
        this.idKM = idKM;
    }

    public int getIdPK() {
        return idPK;
    }

    public void setIdPK(int idPK) {
        this.idPK = idPK;
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

    public String getMaIMEI() {
        return maIMEI;
    }

    public void setMaIMEI(String maIMEI) {
        this.maIMEI = maIMEI;
    }

    @Override
    public String toString() {
        return "SanPhamViewModel{" + "id=" + id + ", idKM=" + idKM + ", idPK=" + idPK + ", idHang=" + idHang + ", ten=" + ten + ", ma=" + ma + ", maIMEI=" + maIMEI + '}';
    }

    public Object[] todataRow() {
        return new Object[]{
            id, idKM, idPK, idHang,  ma, ten,maIMEI
        };
    }
}
