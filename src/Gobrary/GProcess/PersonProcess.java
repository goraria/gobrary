package Gobrary.GProcess;

import Gobrary.GObject.*;

import javax.swing.*;
import java.sql.*;
import java.util.*;

public class PersonProcess {
    DataBaseProcess cd = new DataBaseProcess();

    public ArrayList<Person> getListNguoiMuon() {
        Connection cn = cd.getCon();
        ArrayList<Person> ls = new ArrayList<>();
        String sql = "SELECT * FROM tb_nguoimuon;";
        try {
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Person st = new Person();
                st.setMaNguoiMuon(rs.getString("MaNguoiMuon"));
                st.setTenNguoiMuon(rs.getString("TenNguoiMuon"));
                st.setDiaChi(rs.getString("DiaChi"));
                st.setGmail(rs.getString("Gmail"));
                st.setSDT(rs.getString("SDT"));
                ls.add(st);
            }
        } catch (Exception ignored) {

        }
        return ls;
    }


    public boolean insertNguoiMuon(String MaNguoiMuon, String TenNguoiMuon, String DiaChi, String Gmail, String SDT) {
        Connection cn = cd.getCon();
        String sql = "insert into tb_nguoimuon(MaNguoiMuon, TenNguoiMuon, DiaChi, Gmail, SDT) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.setString(1, MaNguoiMuon);
            ps.setString(2, TenNguoiMuon);
            ps.setString(3, DiaChi);
            ps.setString(4, Gmail);
            ps.setString(5, SDT);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Đã thêm khách hàng thành công!" , "Thông báo", 1);
            return true;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại!" , "Thông báo", 1);
            return false;
        }
    }

    public boolean updateNguoiMuon(String MaNguoiMuon, String TenNguoiMuon, String DiaChi, String Gmai, String SDT) {
        Connection cn = cd.getCon();
        String sql = "update tb_nguoimuon set TenNguoiMuon = ?, DiaChi = ?, Gmail = ?, SDT = ? where MaNguoiMuon = ?";
        try {
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.setString(5, MaNguoiMuon);
            ps.setString(1, TenNguoiMuon);
            ps.setString(2, DiaChi);
            ps.setString(3, Gmai);
            ps.setString(4, SDT);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!" , "Thông báo", 1);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại!" , "Thông báo", 1);
            return false;
        }
    }

    public boolean delNguoiMuon(String MaNguoiMuon) {
        Connection cn = cd.getCon();
        String sql = "delete from tb_nguoimuon where MaNguoiMuon = ?";
        try {
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
            ps.setString(1, MaNguoiMuon);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Xóa thành công!" , "Thông báo", 1);
            return true;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Xóa thất bại!" , "Thông báo", 1);
            return false;
        }
    }
}
