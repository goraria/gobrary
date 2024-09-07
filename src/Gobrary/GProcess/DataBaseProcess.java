package Gobrary.GProcess;

import java.sql.*;

public class DataBaseProcess {
    public static Connection cn;
    public static Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qltv","root","Jiang@99@03$0820");
        } catch (ClassNotFoundException | SQLException ignored) {

        }
        return cn;
    }

    public static boolean login(String user, String pass) {
        Connection cn = getCon();
        boolean kq = false;
        String sql_login = "select * from admin where username = ? and password = ?;";
        try {
            PreparedStatement ps = cn.prepareStatement(sql_login);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                kq = true;
            }
        } catch (Exception e) {
            return false;
        }
        return kq;
    }
}