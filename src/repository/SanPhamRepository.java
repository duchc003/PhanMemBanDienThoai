package repository;

import java.util.List;
import model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.HangSP;
import model.KhuyenMai;
import util.ConnectDB;
import viewmodel.SanPhamViewModel;

public class SanPhamRepository {

    public ArrayList<SanPhamViewModel> all() {
        ArrayList<SanPhamViewModel> lists = new ArrayList<>();
        String query = " SELECT [ID]\n"
                + "      ,[IDHang]\n"
                + "      ,[MaSP]\n"
                + "      ,[TenSp]\n"
                + "  FROM [dbo].[SanPham] ";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
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

    public List<HangSP> getALLHang() {
        String query = "select * from HangSanPham";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
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
    
    public List<KhuyenMai> getALLKM() {
        String query = "select * from GiamGia";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<KhuyenMai> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhuyenMai(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
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
                + "           ,[IDHang]\n"
                + "           ,[MaSP]\n"
                + "           ,[TenSp])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
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
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
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
        System.out.println(new SanPhamRepository().getALLKM());
    }
}
