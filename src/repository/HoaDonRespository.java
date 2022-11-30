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
import util.ConnectDB;
import util.JDBCHelper;
import viewmodel.HoaDonViewModel;

public class HoaDonRespository {

    public List<HoaDonViewModel> getAll() {
        List<HoaDonViewModel> hoaDonViewModels = new ArrayList<>();
        String sql = "SELECT Ngaytao,TrangThai FROM HoaDon";
        ResultSet rs = JDBCHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                hoaDonViewModels.add(new HoaDonViewModel(
                        rs.getString(1),
                        rs.getInt(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hoaDonViewModels;
    }

    public int addHoaDon(HoaDon hoaDon) {
        int row = 0;
        String sql = " INSERT INTO HoaDon(NgayTao,TrangThai) VALUES (?,?)";
        row = JDBCHelper.executeUpdate(sql, hoaDon.getNgayTao(), hoaDon.getTrangThai());
        return row;
    }

    public boolean huyDon(String maHD) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [TrangThai] = 2 \n"
                + " WHERE MaHD = ? and TrangThai = 0";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maHD);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

}
