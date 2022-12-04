package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietSP;
import model.HoaDon;
import model.SanPham;
import util.ConnectDB;
import util.JDBCHelper;
import viewmodel.SanPhamViewModel;
import viewmodel.ThongkeSanPhamViewModel;
import viewmodel.ThongKeDoanhThuViewModel;

public class ThongKeSanPhamRepository {

    public List<ThongkeSanPhamViewModel> all() {
        List<ThongkeSanPhamViewModel> lists = new ArrayList<>();
        String query = " SELECT dbo.SanPham.MaSP, dbo.SanPham.TenSp, dbo.ChiTietSanPham.SoLuong, dbo.ChiTietSanPham.TrangThai\n"
                + "FROM     dbo.ChiTietSanPham INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSanPham.IDSP = dbo.SanPham.ID";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongkeSanPhamViewModel thongKeSanPhamViewModel = new ThongkeSanPhamViewModel();
                thongKeSanPhamViewModel.setMaSp(rs.getString(1));
                thongKeSanPhamViewModel.setTenSP(rs.getString(2));
                thongKeSanPhamViewModel.setSoLuong(rs.getInt(3));
                thongKeSanPhamViewModel.setTrangThai(rs.getString(4));

                lists.add(thongKeSanPhamViewModel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lists;
    }

    public List<HoaDon> thongKeCot() {
        List<HoaDon> listt = new ArrayList<>();
        String query = "select  Year(ngayTao),tongTien  from hoaDon";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listt.add(new HoaDon(rs.getString(1), rs.getLong(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listt;
    }

    public List<ThongKeDoanhThuViewModel> getall() {
        List<ThongKeDoanhThuViewModel> listt = new ArrayList<>();
        String query = "SELECT dbo.HoaDon.MaHD, dbo.HoaDonChiTiet.SoLuong, dbo.ChiTietSanPham.GiaNhap, dbo.ChiTietSanPham.GiaBan, dbo.HoaDon.TongTien\n"
                + "FROM     dbo.ChiTietSanPham INNER JOIN\n"
                + "                  dbo.HoaDonChiTiet ON dbo.ChiTietSanPham.ID = dbo.HoaDonChiTiet.ID INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.HoaDonChiTiet.IDHoaDon = dbo.HoaDon.ID";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeDoanhThuViewModel thongKedoanhthuViewModel = new ThongKeDoanhThuViewModel();
                thongKedoanhthuViewModel.setMaHD(rs.getString(1));
                thongKedoanhthuViewModel.setSoLuong(rs.getInt(2));
                thongKedoanhthuViewModel.setGiaNhap(rs.getLong(3));
                thongKedoanhthuViewModel.setGiaBan(rs.getLong(4));
                thongKedoanhthuViewModel.setDoanhThu(rs.getLong(5));

                listt.add(thongKedoanhthuViewModel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listt;
    }

    public List<ChiTietSP> ConHang() {
        List<ChiTietSP> listt = new ArrayList<>();
        String query = "SELECT count(trangThai) FROM ChiTietSanPham\n"
                + "WHERE TrangThai = N'Còn Hàng';";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listt.add(new ChiTietSP(rs.getInt(1)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listt;
    }

    public List<ChiTietSP> HetHang() {
        List<ChiTietSP> listt = new ArrayList<>();
        String query = "SELECT count(trangThai) FROM ChiTietSanPham\n"
                + "WHERE TrangThai = N'Hết Hàng';";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listt.add(new ChiTietSP(rs.getInt(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listt;
    }

    public List<SanPham> SoSanPhamDangKinhDoanh() {
        List<SanPham> listt = new ArrayList<>();
        String query = "SELECT count(ID) FROM SanPham";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listt.add(new SanPham(rs.getInt(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listt;
    }

    public List<HoaDon> TongDoanhThuNam() {
        List<HoaDon> listt = new ArrayList<>();
        String query = " select sum(TongTien) from HoaDon where Year(NgayThanhToan) = Year(GETDATE())";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listt.add(new HoaDon(rs.getLong(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listt;
    }

    public List<HoaDon> tonDonHangTaiQuay() {
        List<HoaDon> listt = new ArrayList<>();
        String query = "SELECT count(dbo.HoaDon.MaHD)\n"
                + "FROM     dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH\n"
                + "				  where TenHTGH = N'Tại Quầy' and trangthai = N'Đã Thanh Toán' or TrangThai = N'Đã Hủy'";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listt.add(new HoaDon(rs.getString(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listt;
    }

    public List<HoaDon> tonDonGiao() {
        List<HoaDon> listt = new ArrayList<>();
        String query = "SELECT count(dbo.HoaDon.MaHD)\n"
                + "FROM     dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                  dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH\n"
                + "				  where TenHTGH = N'Khác'";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listt.add(new HoaDon(rs.getString(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listt;
    }

    public List<HoaDon> tongDonThanhCong() {
        List<HoaDon> listt = new ArrayList<>();
        String query = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH\n"
                + "				where TenHTGH = N'Khác' and trangthai = N'Đã Thanh Toán' ";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listt.add(new HoaDon(rs.getString(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listt;
    }

    public List<HoaDon> tongDonHuy() {
        List<HoaDon> listt = new ArrayList<>();
        String query = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH\n"
                + "				where TenHTGH = N'Tại Quầy' and trangthai = N'Đã Hủy'";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listt.add(new HoaDon(rs.getString(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listt;
    }

    public List<HoaDon> tongDonHuyGiaoHang() {
        List<HoaDon> listt = new ArrayList<>();
        String query = "select count(MaHD) from HoaDon where TrangThai = N'Đã Hủy Giao Hàng'";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listt.add(new HoaDon(rs.getString(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listt;
    }

    public List<HoaDon> tongDonGiaoThanhCong() {
        List<HoaDon> listt = new ArrayList<>();
        String query = "select count(MaHD) from HoaDon where TrangThai = N'Giao Hàng Thành Công'";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listt.add(new HoaDon(rs.getString(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listt;
    }

    public List<Integer> selectDoanhThuTheoThang1() {
        String sql = "SELECT SUM(TONGTIEN) TBTIEN FROM HOADON where MONTH(NGAYTAO) = 1";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectDoanhThuTheoThang2() {
        String sql = "SELECT SUM(TONGTIEN) TBTIEN FROM HOADON where MONTH(NGAYTAO) = 2";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectDoanhThuTheoThang3() {
        String sql = "SELECT SUM(TONGTIEN) TBTIEN FROM HOADON where MONTH(NGAYTAO) = 3";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectDoanhThuTheoThang4() {
        String sql = "SELECT SUM(TONGTIEN) TBTIEN FROM HOADON where MONTH(NGAYTAO) = 4";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectDoanhThuTheoThang5() {
        String sql = "SELECT SUM(TONGTIEN) TBTIEN FROM HOADON where MONTH(NGAYTAO) = 5";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectDoanhThuTheoThang6() {
        String sql = "SELECT SUM(TONGTIEN) TBTIEN FROM HOADON where MONTH(NGAYTAO) = 6";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectDoanhThuTheoThang7() {
        String sql = "SELECT SUM(TONGTIEN) TBTIEN FROM HOADON where MONTH(NGAYTAO) = 7";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectDoanhThuTheoThang8() {
        String sql = "SELECT SUM(TONGTIEN) TBTIEN FROM HOADON where MONTH(NGAYTAO) = 8";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectDoanhThuTheoThang9() {
        String sql = "SELECT SUM(TONGTIEN) TBTIEN FROM HOADON where MONTH(NGAYTAO) = 9";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectDoanhThuTheoThang10() {
        String sql = "SELECT SUM(TONGTIEN) TBTIEN FROM HOADON where MONTH(NGAYTAO) = 10";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectDoanhThuTheoThang11() {
        String sql = "SELECT SUM(TONGTIEN) TBTIEN FROM HOADON where MONTH(NGAYTAO) = 11";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectDoanhThuTheoThang12() {
        String sql = "SELECT SUM(TONGTIEN) TBTIEN FROM HOADON where MONTH(NGAYTAO) = 12";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonTheoThang1() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HoaDon where trangthai = 1 or TrangThai =2 and MONTH(NGAYTAO) = 1";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonTheoThang2() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HoaDon where trangthai = 1 or TrangThai =2 and MONTH(NGAYTAO) = 2";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonTheoThang3() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HoaDon where trangthai = 1 or TrangThai =2 and MONTH(NGAYTAO) = 3";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonTheoThang4() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HoaDon where trangthai = 1 or TrangThai =2 and MONTH(NGAYTAO) = 4";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonTheoThang5() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HoaDon where trangthai = 1 or TrangThai =2 and MONTH(NGAYTAO) = 5";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonTheoThang6() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HoaDon where trangthai = 1 or TrangThai =2 and MONTH(NGAYTAO) = 6";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonTheoThang7() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HoaDon where trangthai = 1 or TrangThai =2 and MONTH(NGAYTAO) = 7";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonTheoThang8() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HoaDon where trangthai = 1 or TrangThai =2 and MONTH(NGAYTAO) = 8";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonTheoThang9() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HoaDon where trangthai = 1 or TrangThai =2 and MONTH(NGAYTAO) = 9";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonTheoThang10() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HoaDon where trangthai = 1 or TrangThai =2 and MONTH(NGAYTAO) = 10";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonTheoThang11() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HoaDon where trangthai = 1 or TrangThai =2 and MONTH(NGAYTAO) =11";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonTheoThang12() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HoaDon where trangthai = 1 or TrangThai =2 and MONTH(NGAYTAO) = 12";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonThanhCongTheoThang1() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH\n"
                + "				where TenHTGH = 1 and trangthai = 1 and MONTH(NGAYTAO) = 1";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonThanhCongTheoThang2() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH\n"
                + "				where TenHTGH = 1 and trangthai = 1 and MONTH(NGAYTAO) = 2";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonThanhCongTheoThang3() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH\n"
                + "				where TenHTGH = 1 and trangthai = 1 and MONTH(NGAYTAO) = 3";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonThanhCongTheoThang4() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH\n"
                + "				where TenHTGH = 1 and trangthai = 1 and MONTH(NGAYTAO) = 4";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonThanhCongTheoThang5() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH\n"
                + "				where TenHTGH = 1 and trangthai = 1 and MONTH(NGAYTAO) = 5";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonThanhCongTheoThang6() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH\n"
                + "				where TenHTGH = 1 and trangthai = 1 and MONTH(NGAYTAO) = 6";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonThanhCongTheoThang7() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH\n"
                + "				where TenHTGH = 1 and trangthai = 1 and MONTH(NGAYTAO) = 7";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonThanhCongTheoThang8() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH\n"
                + "				where TenHTGH = 1 and trangthai = 1 and MONTH(NGAYTAO) = 8";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonThanhCongTheoThang9() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH\n"
                + "				where TenHTGH = 1 and trangthai = 1 and MONTH(NGAYTAO) = 9";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonThanhCongTheoThang10() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH\n"
                + "				where TenHTGH = 1 and trangthai = 1 and MONTH(NGAYTAO) = 10";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonThanhCongTheoThang11() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH\n"
                + "				where TenHTGH = 1 and trangthai = 1 and MONTH(NGAYTAO) = 11";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonThanhCongTheoThang12() {
        String sql = "SELECT count(dbo.HoaDon.MaHD) FROM dbo.HinhThucGiaoHang INNER JOIN\n"
                + "                dbo.HoaDon ON dbo.HinhThucGiaoHang.ID = dbo.HoaDon.IDHinhTGH\n"
                + "				where TenHTGH = 1 and trangthai = 1 and MONTH(NGAYTAO) = 12";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonHuyTheoThang1() {
        String sql = "select count(MaHD) from HoaDon where TrangThai = 2 and MONTH(NGAYTAO) = 1";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonHuyTheoThang2() {
        String sql = "select count(MaHD) from HoaDon where TrangThai = 2 and MONTH(NGAYTAO) = 2";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonHuyTheoThang3() {
        String sql = "select count(MaHD) from HoaDon where TrangThai = 2 and MONTH(NGAYTAO) = 3";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonHuyTheoThang4() {
        String sql = "select count(MaHD) from HoaDon where TrangThai = 2 and MONTH(NGAYTAO) = 4";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonHuyTheoThang5() {
        String sql = "select count(MaHD) from HoaDon where TrangThai = 2 and MONTH(NGAYTAO) = 5";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonHuyTheoThang6() {
        String sql = "select count(MaHD) from HoaDon where TrangThai = 2 and MONTH(NGAYTAO) = 6";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonHuyTheoThang7() {
        String sql = "select count(MaHD) from HoaDon where TrangThai = 2 and MONTH(NGAYTAO) = 7";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonHuyTheoThang8() {
        String sql = "select count(MaHD) from HoaDon where TrangThai = 2 and MONTH(NGAYTAO) = 8";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonHuyTheoThang9() {
        String sql = "select count(MaHD) from HoaDon where TrangThai = 2 and MONTH(NGAYTAO) = 9";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonHuyTheoThang10() {
        String sql = "select count(MaHD) from HoaDon where TrangThai = 2 and MONTH(NGAYTAO) = 10";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonHuyTheoThang11() {
        String sql = "select count(MaHD) from HoaDon where TrangThai = 2 and MONTH(NGAYTAO) = 11";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectTongHoaDonHuyTheoThang12() {
        String sql = "select count(MaHD) from HoaDon where TrangThai = 2 and MONTH(NGAYTAO) = 12";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
