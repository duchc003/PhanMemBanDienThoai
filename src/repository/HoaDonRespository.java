package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;
import util.JDBCHelper;
import viewmodel.HoaDonViewModel;

public class HoaDonRespository {

    public List<HoaDonViewModel> getAll() {
        List<HoaDonViewModel> hoaDonViewModels = new ArrayList<>();
        String sql = "SELECT MaHD,Ngaytao,TrangThai FROM HoaDon";
        ResultSet rs = JDBCHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                hoaDonViewModels.add(new HoaDonViewModel(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hoaDonViewModels;
    }

    public int addHoaDon(HoaDon hoaDon) {
        int row = 0;
        String sql = " INSERT INTO HoaDon(MaHD,NgayTao,TrangThai) VALUES (?,?,?)";
        row = JDBCHelper.executeUpdate(sql, hoaDon.getMaHD(), hoaDon.getNgayTao(), hoaDon.getTrangThai());
        return row;
    }
}
