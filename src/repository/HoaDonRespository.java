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

    public int addHoaDon(HoaDon hoaDon) {
        int row = 0;
        String sql = " INSERT INTO HoaDon(NgayTao,TrangThai) VALUES (?,?)";
        row = JDBCHelper.executeUpdate(sql, hoaDon.getNgayTao(), hoaDon.getTrangThai());
        return row;
    }

    public boolean huyDon(int id) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [TrangThai] = 2\n"
                + " WHERE ID = ? and TrangThai = 0";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean huyDonShip(int id) {
        String query = "UPDATE [dbo].[HoaDon]\n"
                + "   SET [TrangThai] = 5\n"
                + " WHERE ID = ? and TrangThai = 4";
        int check = 0;
        try ( Connection con = ConnectDB.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

}
