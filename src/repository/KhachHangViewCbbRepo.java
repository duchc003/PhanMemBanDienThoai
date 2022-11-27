package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KhachHang;
import util.ConnectDB;
import util.JDBCHelper;
import viewmodel.ChiTietSPView;
import viewmodel.KhachHangViewModel;

public class KhachHangViewCbbRepo {

    public List<KhachHang> getALL() {
        String query = "SELECT [ID]\n"
                + "      ,[MaKH]\n"
                + "      ,[HoVaTen]\n"
                + "      ,[SoDienThoai]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[MoTa]\n"
                + "  FROM [dbo].[KhachHang]";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            List<KhachHang> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhachHang(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public KhachHang getOne(String hoVaTen) {
        String query = "SELECT [ID]\n"
                + "      ,[HoVaTen]\n"
                + "  FROM [dbo].[KhachHang]\n"
                + "  Where HoVaTen = ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, hoVaTen);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new KhachHang(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<KhachHang> getTenKh(String sdt) {
        String query = "SELECT [ID]\n"
                + "      ,[MaKH]\n"
                + "      ,[HoVaTen]\n"
                + "      ,[SoDienThoai]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[MoTa]\n"
                + "  FROM [dbo].[KhachHang]\n"
                + "   where SoDienThoai like ?";
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, "%" + sdt + "%");
            List<KhachHang> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KhachHang(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
