package dao;
import connection.MyConnection;
import model.Logins;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO {
    // Dinh nghia: xem, them, sua, xoa

    public Logins getById(long id) {
        Logins logins = null;
        try {
            // Tao ket noi
            Connection conn = MyConnection.getConnection();
            // Chuan bi cau lenh, thuc thi
            String sql = "SELECT * FROM `accounts` WHERE `id` = " + id + " LIMIT 1";
            Statement stmt = conn.createStatement();

            // Ket qua
            ResultSet resultSet = stmt.executeQuery(sql);

            if (resultSet.next()) {
                logins = new Logins();
                logins.setAccount_id(resultSet.getLong("account_id"));
                logins.setUsername(resultSet.getString("username"));
            }
            // Dong tai nguyen
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return logins;
    }

    public Logins getByUserNameAndPassword(String username, String password) {
        Logins logins = null;
        try {
            Connection conn = MyConnection.getConnection();
            String sql = String.format("SELECT account_id, username FROM logins WHERE username='%s' AND password='%s' LIMIT 1 ",
                    username, password);

            // THUC THI
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            if (resultSet.next()) {
                logins = new Logins();
                logins.setAccount_id(resultSet.getLong("account_id"));
                logins.setUsername(resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return logins;
    }

    // Co the lam them phan sua xoa nhe....

}