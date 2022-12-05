package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;
import model.HoaDonCT;
import service.impl.hoaDonViewModelServicesImplHUY;
import util.ConnectDB;
import util.JDBCHelper;
import viewmodel.HoaDonViewModel;
import viewmodel.hoaDonViewModelHUY;

public class HoaDonRespository {

    public int addHoaDon(HoaDonViewModel hoaDon) {
        int row = 0;
        String sql = " INSERT INTO [dbo].[HoaDon]\n"
                + "           ([MaHD]\n"
                + "           ,[NgayTao]\n"
                + "           ,[TienKhachCanTra]\n"
                + "           ,[TongTien]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        row = JDBCHelper.executeUpdate(sql, hoaDon.getMaHdString(), hoaDon.getNgayTao(), hoaDon.getTienKhachCanTra(), hoaDon.getTongTien(), hoaDon.getTrangThai());
        return row;
    }

    public int addHoaDonCT(HoaDonCT hoaDon) {
        int row = 0;
        String sql = "INSERT INTO [dbo].[HoaDonChiTiet]\n"
                + "           ([IDHoaDon])\n"
                + "     VALUES\n"
                + "           (?)";
        row = JDBCHelper.executeUpdate(sql, hoaDon.getIdHoaDon());
        return row;
    }

    public boolean huyDon(int id) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [TrangThai] = N'Đã Hủy'\n"
                + " WHERE ID = ?";
        int check = 0;
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean huyDonShip(int id) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [TrangThai] = N'Đã Hủy Đơn Giao'\n"
                + " WHERE ID = ?";
        int check = 0;
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public List<HoaDonViewModel> getAllHoaDon() {
        List<HoaDonViewModel> listHD = new ArrayList<>();
        String sql = "SELECT id,MaHD, NgayTao, TrangThai\n"
                + " FROM     dbo.HoaDon where trangthai = N'Chờ Thanh Toán' or trangthai = N'Chờ Giao Hàng' or trangthai = N'Đang Giao Hàng'";
        ResultSet rs = JDBCHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                listHD.add(new HoaDonViewModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHD;
    }
    
     public List<hoaDonViewModelHUY> getAllHoaDonID() {
        List<hoaDonViewModelHUY> listHD = new ArrayList<>();
        String sql = "SELECT id,MaHD, NgayTao, TrangThai\n"
                + " FROM     dbo.HoaDon where trangthai = N'Chờ Thanh Toán' or trangthai = N'Chờ Giao Hàng' or trangthai = N'Đang Giao Hàng'";
        ResultSet rs = JDBCHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                listHD.add(new hoaDonViewModelHUY(
                        rs.getInt(1)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(hoaDonViewModelRepositoryHUY.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHD;
    }

    public boolean updateIDNhanVien(HoaDon hd, int id) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [IDNhanVien] = ?\n"
                + " WHERE ID = ?";
        int check = 0;
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getIdNhanVien());
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean updateHoaDonGiao(HoaDonViewModel hd, int id) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [IDKhachHang] = ?\n"
                + "      ,[MaHD] = ?\n"
                + "      ,[NgayGiaoHang] = ?\n"
                + "      ,[TienKhachCanTra] = ?\n"
                + "      ,[TongTien] = ?\n"
                + "      ,[SdtNguoiNhan] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE ID = ?";
        int check = 0;
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getGetIDKhachHang());
            ps.setObject(2, hd.getMaHdString());
            ps.setObject(3, hd.getNgayGiaohang());
            ps.setObject(4, hd.getTienKhachCanTra());
            ps.setObject(5, hd.getTongTien());
            ps.setObject(6, hd.getSdt());
            ps.setObject(7, hd.getTrangThai());
            ps.setObject(8, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean updateIDKhachHang(HoaDon hd, int id) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [IDKhachHang] = ?\n"
                + " WHERE ID = ?";
        int check = 0;
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getIdKhachHang());
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean updateIDHTTT(HoaDon hd, int id) {
        String query = "UPDATE [dbo].[HoaDon] SET [IDHinhTTT] = ? WHERE ID = ?";
        int check = 0;
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getIdHinhThucTT());
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean updateIDHTGH(HoaDon hd, int id) {
        String query = "UPDATE [dbo].[HoaDon] SET [IDHinhTGH] = ? WHERE ID = ?";
        int check = 0;
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getIdHinhThucGH());
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean updateHoaDon(HoaDon hd, int id) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [TienKhachCanTra] = ?\n"
                + "      ,[TongTien] = ?\n"
                + " WHERE ID = ?";
        int check = 0;
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getTienKhachCanTra());
            ps.setObject(2, hd.getTongTien());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean updateHoaDonThanhToan(HoaDonViewModel hd, int id) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [MaHD] = ?\n"
                + "      ,[NgayThanhToan] = ? \n"
                + "      ,[TienKhachCanTra] = ?\n"
                + "      ,[TongTien] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + "      ,[Mota] = ?\n"
                + " WHERE ID = ?";
        int check = 0;
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getMaHdString());
            ps.setObject(2, hd.getNgayThanhToan());
            ps.setObject(3, hd.getTienKhachCanTra());
            ps.setObject(4, hd.getTongTien());
            ps.setObject(5, hd.getTrangThai());
            ps.setObject(6, hd.getMota());
            ps.setObject(7, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean updateHoaDonCTThanhToan(HoaDon hd, int id) {
        String query = "";
        int check = 0;
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getMaHD());
            ps.setObject(2, hd.getNgayThanhToan());
            ps.setObject(3, hd.getTienKhachCanTra());
            ps.setObject(4, hd.getTongTien());
            ps.setObject(5, hd.getTrangThai());
            ps.setObject(6, hd.getMoTa());
            ps.setObject(7, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public static void main(String[] args) {
        System.out.println(new HoaDonRespository().getAllHoaDon().toString());
    }
}
