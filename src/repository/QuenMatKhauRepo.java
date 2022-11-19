package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NhanVien;
import util.JDBCHelper;
import viewmodel.QuenMatKhauModel;

public class QuenMatKhauRepo {

    public List<QuenMatKhauModel> getEmail(String ma) {
        List<QuenMatKhauModel> list = new ArrayList<>();
        String sql = "SELECT Email FROM NHANVIEN where MaNV = ?";
        ResultSet rs = JDBCHelper.executeQuery(sql, ma);
        try {
            while (rs.next()) {
                list.add(new QuenMatKhauModel(rs.getString(1)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuenMatKhauModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public int updatePassWord(String mk, String ma) {
        int row = 0;
        String sql = "UPDATE NhanVien SET MatKhau = ? \n"
                + "WHERE MaNV = ?";
        row = JDBCHelper.executeUpdate(sql, mk, ma);
        return row;
    }
}
