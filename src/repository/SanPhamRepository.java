package repository;

import java.util.List;
import model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.HangSP;
import model.HinhThucKhuyenMai;
import model.KhuyenMai;
import util.ConnectDB;
import viewmodel.KhuyenMaiViewModel;
import viewmodel.SanPhamViewModel;

public class SanPhamRepository {

    public ArrayList<SanPhamViewModel> all() {
        ArrayList<SanPhamViewModel> lists = new ArrayList<>();
        String query = " SELECT [ID]\n"
                + "      ,[IDHang]\n"
                + "      ,[MaSP]\n"
                + "      ,[TenSp]\n"
                + "  FROM [dbo].[SanPham] ";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamViewModel sanphamViewModel = new SanPhamViewModel();
                sanphamViewModel.setId(rs.getInt(1));
                sanphamViewModel.setIdHang(rs.getInt(2));
                sanphamViewModel.setMa(rs.getString(3));
                sanphamViewModel.setTen(rs.getString(4));
                lists.add(sanphamViewModel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lists;
    }

    public HangSP getOneHang(String hang) {
        String query = "select * from HangSanPham where TenHangSP = ?";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, hang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new HangSP(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HangSP> getALLHang() {
        String query = "select * from HangSanPham";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            List<HangSP> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HangSP(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HinhThucKhuyenMai> getALLHT() {
        String query = "select * from HinhThucKhuyenMai";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            List<HinhThucKhuyenMai> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HinhThucKhuyenMai(rs.getInt(1), rs.getString(2)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<KhuyenMaiViewModel> getALLKM() {
        String query = "SELECT dbo.GiamGia.ID, dbo.GiamGia.MaKM, dbo.GiamGia.Ten, dbo.HinhThucKhuyenMai.TenHinhThucKm, dbo.GiamGia.NgayBD, dbo.GiamGia.NgayKT, dbo.GiamGia.GiamGia, dbo.GiamGia.TrangThai, \n"
                + "                  dbo.GiamGia.Mota\n"
                + "FROM     dbo.GiamGia INNER JOIN\n"
                + "                  dbo.HinhThucKhuyenMai ON dbo.GiamGia.IDHinhThuc = dbo.HinhThucKhuyenMai.Id";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            List<KhuyenMaiViewModel> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhuyenMaiViewModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getLong(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(SanPham SP) {
        String query = "INSERT INTO [dbo].[SanPham]\n"
                + "           ([IDHang]\n"
                + "           ,[MaSP]\n"
                + "           ,[TenSp])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        int check = 0;
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, SP.getIdHang());
            ps.setObject(2, SP.getMa());
            ps.setObject(3, SP.getTen());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean update(SanPham SP, int viTri) {
        String query = "UPDATE [dbo].[SanPham]\n"
                + "      ,[IDHang] ?\n"
                + "      ,[MaSP] = ?\n"
                + "      ,[TenSp] = ?\n"
                + " WHERE ID =?";
        int check = 0;
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareCall(query)) {
            check = ps.executeUpdate();
            ps.setObject(1, SP.getIdHang());
            ps.setObject(2, SP.getMa());
            ps.setObject(3, SP.getTen());
            ps.setObject(4, viTri);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public static void main(String[] args) {
        System.out.println(new SanPhamRepository().getOneHang("APPLE"));
    }
}
