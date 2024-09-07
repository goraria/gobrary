package Gobrary.GPanel;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import Gobrary.GIcon.*;
import Gobrary.GObject.*;
import Gobrary.GProcess.*;

public class Statistic extends JPanel implements ActionListener {
    private JTable tableDauSach;
    private JTable tableSach;
    private JTable tableNguoiMuon;
    private JTable tablePhieuMuon;
    private JTable tableThongke;
    private JTable tableThongtinNguoimuonsach;

    DataBaseProcess cd = new DataBaseProcess();

    DefaultTableModel Model1 = new DefaultTableModel();
    Vector<String> columns1 = new Vector<String>();
    Vector<Vector<Object>> rows1 = new Vector<>();

    DefaultTableModel Model2 = new DefaultTableModel();
    Vector<String> columns2 = new Vector<String>();
    Vector<Vector<Object>> rows2 = new Vector<>();

    DefaultTableModel Model3 = new DefaultTableModel();
    Vector<String> columns3 = new Vector<String>();
    Vector<Vector<Object>> rows3 = new Vector<>();

    DefaultTableModel Model4 = new DefaultTableModel();
    Vector<String> columns4 = new Vector<String>();
    Vector<Vector<Object>> rows4 = new Vector<>();

    DefaultTableModel Model5 = new DefaultTableModel();
    Vector<String> columns5 = new Vector<String>();
    Vector<Vector<Object>> rows5 = new Vector<>();

    DefaultTableModel Model6 = new DefaultTableModel();
    Vector<String> columns6 = new Vector<String>();
    Vector<Vector<Object>> rows6 = new Vector<>();

    TypeProcess pds = new TypeProcess();
    BookProcess ps = new BookProcess();
    PersonProcess pmn = new PersonProcess();
    FormProcess pm = new FormProcess();

    private final JComboBox cbbDauSach = new JComboBox();
    private final JTextField txtSearchDS = new JTextField();
    private final JButton btnSearchDauSach = new JButton();
    private final JButton btnLamMoiDS = new JButton();

    private final JComboBox cbbSach = new JComboBox();
    private final JTextField txtSearchSach = new JTextField();
    private final JButton btnSearchSach = new JButton();
    private final JButton btnLamMoiSach = new JButton();

    private final JComboBox cbbNguoiMuon = new JComboBox();
    private final JTextField txtSearchNguoiMuon = new JTextField();
    private final JButton btnNewButton = new JButton();
    private final JButton btnLamMoiNguoiMuon = new JButton();

    private final JComboBox cbbPhieuMuon = new JComboBox();
    private final JTextField txtSearchPhieuMuon = new JTextField();
    private final JButton btnSearchPhieuMuon = new JButton();
    private final JButton btnLamMoiPhieuMuon = new JButton();

    private final JLabel lblTongsoSach = new JLabel();
    private final JLabel lblTongsoNguoiMuon = new JLabel();
    private final JLabel lblTongSoPhieuMuon = new JLabel();
    private final JLabel lblTongSoPhieuMuonQuaHan = new JLabel();
    private final JButton buttonRefreshStatistics = new JButton();

    public Statistic() {
        Border panelBorder = BorderFactory.createMatteBorder(0, 5, 5, 5, new Color(0x555555));
        this.setBorder(panelBorder);
        this.setLayout(new BorderLayout());

        // JPanel leftStatisticPanel = new JPanel();
        // leftStatisticPanel.setBackground(new Color(0xFFFFFF));
        // leftStatisticPanel.setPreferredSize(new Dimension(0, 0));
        // this.add(leftStatisticPanel, BorderLayout.CENTER);

        // JPanel rightStatisticPanel = new JPanel();
        // rightStatisticPanel.setBackground(new Color(0xAAAAAA));
        // rightStatisticPanel.setPreferredSize(new Dimension(370, 0));
        // this.add(rightStatisticPanel, BorderLayout.EAST);

        // JPanel btmButtonBookPanel = new JPanel();
        // btmButtonBookPanel.setBackground(new Color(0x555555));
        // btmButtonBookPanel.setPreferredSize(new Dimension(0, 60));
        // this.add(btmButtonBookPanel, BorderLayout.SOUTH);

        // JPanel contentPanel = new JPanel();
        // contentPanel.setBackground(new Color(0xFF00AA));
        // contentPanel.setPreferredSize(new Dimension(0, 0));
        // contentPanel.setOpaque(true);
        // this.add(contentPanel, BorderLayout.CENTER);

        //

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBackground(SystemColor.inactiveCaption);
        tabbedPane.setBounds(new Rectangle(0, 0, 0, 0));
        this.add(tabbedPane, BorderLayout.CENTER);

        ////

        JPanel panelDauSach = new JPanel();
        // panelDauSach.setBackground(SystemColor.inactiveCaption);
        tabbedPane.addTab("Đầu sách", null, panelDauSach, null);

        panelDauSach.setLayout(new BorderLayout());

        JPanel leftTypePanel = new JPanel();
        leftTypePanel.setBackground(new Color(0x555555));
        leftTypePanel.setPreferredSize(new Dimension(0, 0));
        panelDauSach.add(leftTypePanel, BorderLayout.CENTER);

        JPanel rightTypePanel = new JPanel();
        rightTypePanel.setBackground(new Color(0xAAAAAA));
        rightTypePanel.setPreferredSize(new Dimension(370, 0));
        panelDauSach.add(rightTypePanel, BorderLayout.EAST);

        //

        rightTypePanel.setLayout(null);
    
        JLabel lblTypeBook = new JLabel();
        lblTypeBook.setText("Đầu sách");
        lblTypeBook.setFont(new Font("Arial", Font.PLAIN, 16));
        lblTypeBook.setBounds(new Rectangle(5, 5, 360, 30));
        rightTypePanel.add(lblTypeBook);

        cbbDauSach.setModel(new DefaultComboBoxModel(new String[] {"Mã đầu sách", "Tên sách", "Số lượng", "Thể loại", "Tác giả", "Nhà xuất bản", "Năm xuất bản"}));
        cbbDauSach.setFont(new Font("Arial", Font.PLAIN, 16));
        cbbDauSach.setBounds(new Rectangle(5, 40, 360, 30));
        rightTypePanel.add(cbbDauSach);

        txtSearchDS.setFont(new Font("Arial", Font.PLAIN, 16));
        txtSearchDS.setBounds(new Rectangle(5, 75, 360, 30));
        rightTypePanel.add(txtSearchDS);

        btnSearchDauSach.setText("Tìm kiếm");
        btnSearchDauSach.addActionListener(this);
        btnSearchDauSach.setFont(new Font("Arial", Font.PLAIN, 16));
        btnSearchDauSach.setBounds(new Rectangle(5, 110, 360, 30));
        rightTypePanel.add(btnSearchDauSach);

        btnLamMoiDS.setText("Làm mới");
        btnLamMoiDS.addActionListener(this);
        btnLamMoiDS.setFont(new Font("Arial", Font.PLAIN, 16));
        btnLamMoiDS.setBounds(new Rectangle(5, 145, 360, 30));
        rightTypePanel.add(btnLamMoiDS);

        //

        leftTypePanel.setLayout(new BorderLayout());

        JScrollPane scrollPane_0 = new JScrollPane();
        scrollPane_0.setBounds(new Rectangle(0, 0, 0, 0));
        leftTypePanel.add(scrollPane_0, BorderLayout.CENTER);

        tableDauSach = new JTable();
        tableDauSach.setFont(new Font("Arial", Font.PLAIN, 16));
        tableDauSach.setModel(new DefaultTableModel(new Object[][] {},  new String[] {}));
        scrollPane_0.setViewportView(tableDauSach);

        cbbDauSach.setSelectedIndex(-1);
        
        ////

        JPanel panelSach = new JPanel();
        // panelSach.setBackground(SystemColor.inactiveCaption);
        tabbedPane.addTab("Sách mượn", null, panelSach, null);

        panelSach.setLayout(new BorderLayout());

        JPanel leftBookPanel = new JPanel();
        leftBookPanel.setBackground(new Color(0x555555));
        leftBookPanel.setPreferredSize(new Dimension(0, 0));
        panelSach.add(leftBookPanel, BorderLayout.CENTER);

        JPanel rightBookPanel = new JPanel();
        rightBookPanel.setBackground(new Color(0xAAAAAA));
        rightBookPanel.setPreferredSize(new Dimension(370, 0));
        panelSach.add(rightBookPanel, BorderLayout.EAST);

        //

        rightBookPanel.setLayout(null);

        JLabel lblNameBook = new JLabel();
        lblNameBook.setText("Sách mượn");
        lblNameBook.setFont(new Font("Arial", Font.PLAIN, 16));
        lblNameBook.setBounds(new Rectangle(5, 5, 360, 30));
        rightBookPanel.add(lblNameBook);

        cbbSach.setModel(new DefaultComboBoxModel(new String[] {"Mã sách", "Tên sách", "Trạng thái", "Mã đầu sách"}));
        cbbSach.setFont(new Font("Arial", Font.PLAIN, 16));
        cbbSach.setBounds(new Rectangle(5, 40, 360, 30));
        rightBookPanel.add(cbbSach);

        txtSearchSach.setFont(new Font("Arial", Font.PLAIN, 16));
        txtSearchSach.setBounds(new Rectangle(5, 75, 360, 30));
        rightBookPanel.add(txtSearchSach);

        btnSearchSach.setText("Tìm kiếm");
        btnSearchSach.addActionListener(this);
        btnSearchSach.setFont(new Font("Arial", Font.PLAIN, 16));
        btnSearchSach.setBounds(new Rectangle(5, 110, 360, 30));
        rightBookPanel.add(btnSearchSach);

        btnLamMoiSach.setText("Làm mới");
        btnLamMoiSach.addActionListener(this);
        btnLamMoiSach.setFont(new Font("Arial", Font.PLAIN, 16));
        btnLamMoiSach.setBounds(new Rectangle(5, 145, 360, 30));
        rightBookPanel.add(btnLamMoiSach);

        //

        leftBookPanel.setLayout(new BorderLayout());

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(new Rectangle(0, 0, 0, 0));
        leftBookPanel.add(scrollPane_1, BorderLayout.CENTER);

        tableSach = new JTable();
        tableSach.setFont(new Font("Arial", Font.PLAIN, 16));
        scrollPane_1.setViewportView(tableSach);
        
        cbbSach.setSelectedIndex(-1);
        
        ////

        JPanel panelNguoiMuon = new JPanel();
        // panelNguoiMuon.setBackground(SystemColor.inactiveCaption);
        tabbedPane.addTab("Độc giả", null, panelNguoiMuon, null);

        panelNguoiMuon.setLayout(new BorderLayout());

        JPanel leftPersonPanel = new JPanel();
        leftPersonPanel.setBackground(new Color(0x555555));
        leftPersonPanel.setPreferredSize(new Dimension(0, 0));
        panelNguoiMuon.add(leftPersonPanel, BorderLayout.CENTER);

        JPanel rightPersonPanel = new JPanel();
        rightPersonPanel.setBackground(new Color(0xAAAAAA));
        rightPersonPanel.setPreferredSize(new Dimension(370, 0));
        panelNguoiMuon.add(rightPersonPanel, BorderLayout.EAST);

        //

        rightPersonPanel.setLayout(null);

        JLabel lblPerson = new JLabel();
        lblPerson.setText("Độc giả");
        lblPerson.setFont(new Font("Arial", Font.PLAIN, 16));
        lblPerson.setBounds(new Rectangle(5, 5, 360, 30));
        rightPersonPanel.add(lblPerson);

        cbbNguoiMuon.setModel(new DefaultComboBoxModel(new String[] {"Mã độc giả", "Tên độc giả", "Địa chỉ", "Gmail", "SDT"}));
        cbbNguoiMuon.setFont(new Font("Arial", Font.PLAIN, 16));
        cbbNguoiMuon.setBounds(new Rectangle(5, 40, 360, 30));
        rightPersonPanel.add(cbbNguoiMuon);

        txtSearchNguoiMuon.setFont(new Font("Arial", Font.PLAIN, 16));
        txtSearchNguoiMuon.setBounds(new Rectangle(5, 75, 360, 30));
        rightPersonPanel.add(txtSearchNguoiMuon);

        btnNewButton.setText("Tìm kiếm");
        btnNewButton.addActionListener(this);
        btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
        btnNewButton.setBounds(new Rectangle(5, 110, 360, 30));
        rightPersonPanel.add(btnNewButton);

        btnLamMoiNguoiMuon.setText("Làm mới");
        btnLamMoiNguoiMuon.addActionListener(this);
        btnLamMoiNguoiMuon.setFont(new Font("Arial", Font.PLAIN, 16));
        btnLamMoiNguoiMuon.setBounds(new Rectangle(5, 145, 360, 30));
        rightPersonPanel.add(btnLamMoiNguoiMuon);

        //

        leftPersonPanel.setLayout(new BorderLayout());

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(new Rectangle(0, 0, 0, 0));
        leftPersonPanel.add(scrollPane_2, BorderLayout.CENTER);

        tableNguoiMuon = new JTable();
        tableNguoiMuon.setFont(new Font("Arial", Font.PLAIN, 16));
        scrollPane_2.setViewportView(tableNguoiMuon);

        cbbNguoiMuon.setSelectedIndex(-1);

        ////

        JPanel panelPhieuMuon = new JPanel();
        // panelPhieuMuon.setBackground(SystemColor.inactiveCaption);
        tabbedPane.addTab("Phiếu mượn", null, panelPhieuMuon, null);

        panelPhieuMuon.setLayout(new BorderLayout());

        JPanel leftFormPanel = new JPanel();
        leftFormPanel.setBackground(new Color(0x555555));
        leftFormPanel.setPreferredSize(new Dimension(0, 0));
        panelPhieuMuon.add(leftFormPanel, BorderLayout.CENTER);

        JPanel rightFormPanel = new JPanel();
        rightFormPanel.setBackground(new Color(0xAAAAAA));
        rightFormPanel.setPreferredSize(new Dimension(370, 0));
        panelPhieuMuon.add(rightFormPanel, BorderLayout.EAST);

        //

        rightFormPanel.setLayout(null);
    
        JLabel lblFormBook = new JLabel();
        lblFormBook.setText("Phiếu mượn");
        lblFormBook.setFont(new Font("Arial", Font.PLAIN, 16));
        lblFormBook.setBounds(new Rectangle(5, 5, 360, 30));
        rightFormPanel.add(lblFormBook);

        cbbPhieuMuon.setModel(new DefaultComboBoxModel(new String[] {"Mã phiếu mượn", "Ngày mượn", "Hạn trả", "Mã sách", "Mã độc giả", "Ngày trả"}));
        cbbPhieuMuon.setFont(new Font("Arial", Font.PLAIN, 16));
        cbbPhieuMuon.setBounds(new Rectangle(5, 40, 360, 30));
        rightFormPanel.add(cbbPhieuMuon);

        txtSearchPhieuMuon.setFont(new Font("Arial", Font.PLAIN, 16));
        txtSearchPhieuMuon.setBounds(new Rectangle(5, 75, 360, 30));
        rightFormPanel.add(txtSearchPhieuMuon);

        btnSearchPhieuMuon.setText("Tìm kiếm");
        btnSearchPhieuMuon.setFont(new Font("Arial", Font.PLAIN, 16));
        btnSearchPhieuMuon.setBounds(new Rectangle(5, 110, 360, 30));
        rightFormPanel.add(btnSearchPhieuMuon);

        btnLamMoiPhieuMuon.setText("Làm mới");
        btnLamMoiPhieuMuon.addActionListener(this);
        btnLamMoiPhieuMuon.setFont(new Font("Arial", Font.PLAIN, 16));
        btnLamMoiPhieuMuon.setBounds(new Rectangle(5, 145, 360, 30));
        rightFormPanel.add(btnLamMoiPhieuMuon);

        //

        leftFormPanel.setLayout(new BorderLayout());

        JScrollPane scrollPane_3 = new JScrollPane();
        scrollPane_3.setBounds(0, 0, 0, 0);
        leftFormPanel.add(scrollPane_3, BorderLayout.CENTER);

        tablePhieuMuon = new JTable();
        tablePhieuMuon.setFont(new Font("Arial", Font.PLAIN, 16));
        scrollPane_3.setViewportView(tablePhieuMuon);

        cbbPhieuMuon.setSelectedIndex(-1);

        ////

        JPanel panelThongKe = new JPanel();
        // panelThongKe.setBackground(SystemColor.inactiveCaption);
        tabbedPane.addTab("Thống kê", null, panelThongKe, null);

        panelThongKe.setLayout(new BorderLayout());

        JPanel leftStatisPanel = new JPanel();
        leftStatisPanel.setBackground(new Color(0x555555));
        leftStatisPanel.setPreferredSize(new Dimension(0, 0));
        panelThongKe.add(leftStatisPanel, BorderLayout.CENTER);

        JPanel rightStatisPanel = new JPanel();
        rightStatisPanel.setBackground(new Color(0xAAAAAA));
        rightStatisPanel.setPreferredSize(new Dimension(370, 0));
        panelThongKe.add(rightStatisPanel, BorderLayout.EAST);

        //

        rightStatisPanel.setLayout(null);

        lblTongsoSach.setText("1");
        lblTongsoSach.setFont(new Font("Arial", Font.PLAIN, 16));
        lblTongsoSach.setBounds(new Rectangle(5, 5, 360, 30));
        rightStatisPanel.add(lblTongsoSach);

        lblTongsoNguoiMuon.setText("2");
        lblTongsoNguoiMuon.setFont(new Font("Arial", Font.PLAIN, 16));
        lblTongsoNguoiMuon.setBounds(new Rectangle(5, 40, 360, 30));
        rightStatisPanel.add(lblTongsoNguoiMuon);

        lblTongSoPhieuMuon.setText("3");
        lblTongSoPhieuMuon.setFont(new Font("Arial", Font.PLAIN, 16));
        lblTongSoPhieuMuon.setBounds(new Rectangle(5, 75, 360, 30));
        rightStatisPanel.add(lblTongSoPhieuMuon);

        lblTongSoPhieuMuonQuaHan.setText("4");
        lblTongSoPhieuMuonQuaHan.setFont(new Font("Arial", Font.PLAIN, 16));
        lblTongSoPhieuMuonQuaHan.setBounds(new Rectangle(5, 110, 360, 30));
        rightStatisPanel.add(lblTongSoPhieuMuonQuaHan);

        buttonRefreshStatistics.setText("Refresh");
        buttonRefreshStatistics.addActionListener(this);
        buttonRefreshStatistics.setFont(new Font("Arial", Font.PLAIN, 16));
        buttonRefreshStatistics.setBounds(new Rectangle(5, 145, 360, 30));
        rightStatisPanel.add(buttonRefreshStatistics);

        // JLabel lblNewLabel = new JLabel("Thông tin phiếu mượn quá hạn");
        // lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        // lblNewLabel.setBounds(66, 357, 342, 19);
        // panelThongKe.add(lblNewLabel);

        // JLabel lblNewLabel_1 = new JLabel("Thông tin người mượn sách");
        // lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
        // lblNewLabel_1.setBounds(66, 130, 310, 21);
        // panelThongKe.add(lblNewLabel_1);
        

        JScrollPane scrollPane_4 = new JScrollPane();
        scrollPane_4.setBounds(new Rectangle(0, 0, 0, 0));
        panelThongKe.add(scrollPane_4);

        tableThongke = new JTable();
        tableThongke.setFont(new Font("Arial", Font.PLAIN, 16));
        scrollPane_4.setViewportView(tableThongke);

        //

        JScrollPane scrollPane_5 = new JScrollPane();
        scrollPane_5.setBounds(new Rectangle(1, 1, 1, 1));
        // panelThongKe.add(scrollPane_5);

        tableThongtinNguoimuonsach = new JTable();
        tableThongtinNguoimuonsach.setFont(new Font("Arial", Font.PLAIN, 16));
        scrollPane_5.setViewportView(tableThongtinNguoimuonsach);

        ////

        //

        columns1.add("Mã đầu sách");
        columns1.add("Tên sách");
        columns1.add("Số lượng");
        columns1.add("Thể loại");
        columns1.add("Tác giả");
        columns1.add("Nhà xuất bản");
        columns1.add("Năm xuất bản");

        columns2.add("Mã sách");
        columns2.add("Tên sách");
        columns2.add("Trạng thái");
        columns2.add("Mã đầu sách");

        columns3.add("Mã độc giả");
        columns3.add("Tên độc giả");
        columns3.add("Địa chỉ");
        columns3.add("Email");
        columns3.add("Số điện thoại");

        columns4.add("Mã phiếu mượn");
        columns4.add("Ngày mượn");
        columns4.add("Hạn trả");
        columns4.add("Mã sách");
        columns4.add("Mã độc giả");
        columns4.add("Ngày trả");

        columns5.add("Mã độc giả");
        columns5.add("Tên độc giả");
        columns5.add("Tên sách");
        columns5.add("Hạn trả");

        columns6.add("Mã độc giả");
        columns6.add("Tên độc giả");
        columns6.add("Số điện thoại");
        columns6.add("Tên sách");
        columns6.add("Thể loại");
        columns6.add("Ngày mượn");
        columns6.add("Hạn trả");

        getAllDauSach();
        getAllSach();
        getAllNguoiMuon();
        getAllPhieuMuon();
        Thongke(lblTongsoSach, lblTongsoNguoiMuon, lblTongSoPhieuMuon, lblTongSoPhieuMuonQuaHan);

        //

        this.setVisible(true);
    }

    public void getAllDauSach() {
        Model1.setRowCount(0);
        ArrayList<Type> ls = pds.getListDauSach();
        for (int i = 0; i < ls.size(); i++) {
            Type s = (Type) ls.get(i);
            Vector<Object> tbRow1 = new Vector<>();
            tbRow1.add(s.getMaDauSach());
            tbRow1.add(s.getTenSach());
            tbRow1.add(s.getSoLuong());
            tbRow1.add(s.getTheLoai());
            tbRow1.add(s.getTacGia());
            tbRow1.add(s.getNXB());
            tbRow1.add(s.getNamXB());
            rows1.add(tbRow1);
        }
        Model1.setDataVector(rows1, columns1);
        tableDauSach.setModel(Model1);
    }

    public void getAllSach() {
        Model2.setRowCount(0);
        ArrayList<Book> ls = ps.getListSach();
        for (int i = 0; i < ls.size(); i++) {
            Book s = (Book) ls.get(i);
            Vector<Object> tbRow2 = new Vector<>();
            tbRow2.add(s.getMaSach());
            tbRow2.add(s.getTenSach());
            tbRow2.add(s.getTrangThai());
            tbRow2.add(s.getMaDauSach());
            rows2.add(tbRow2);
        }
        Model2.setDataVector(rows2, columns2);
        tableSach.setModel(Model2);
    }

    public void getAllNguoiMuon() {
        Model3.setRowCount(0);
        ArrayList<Person> ls = pmn.getListNguoiMuon();
        for (int i = 0; i < ls.size(); i++) {
            Person s = (Person) ls.get(i);
            Vector<Object> tbRow3 = new Vector<>();
            tbRow3.add(s.getMaNguoiMuon());
            tbRow3.add(s.getTenNguoiMuon());
            tbRow3.add(s.getDiaChi());
            tbRow3.add(s.getGmail());
            tbRow3.add(s.getSDT());
            rows3.add(tbRow3);
        }
        Model3.setDataVector(rows3, columns3);
        tableNguoiMuon.setModel(Model3);
    }

    public void getAllPhieuMuon() {
        Model4.setRowCount(0);
        ArrayList<Form> ls = pm.getListPhieuMuon();
        for (int i = 0; i < ls.size(); i++) {
            Form s = (Form) ls.get(i);
            Vector<Object> tbRow4 = new Vector<>();
            tbRow4.add(s.getMaPhieuMuon());
            tbRow4.add(s.getNgayMuon());
            tbRow4.add(s.getHanTra());
            tbRow4.add(s.getMaSach());
            tbRow4.add(s.getMaNguoiMuon());
            tbRow4.add(s.getNgayTra());
            rows4.add(tbRow4);
        }
        Model4.setDataVector(rows4, columns4);
        tablePhieuMuon.setModel(Model4);
    }

    public void Thongke(JLabel lb1, JLabel lb2, JLabel lb3, JLabel lb4) {
        Connection cn = cd.getCon();
        String sql1 = "Select sum(Soluong)  as slsach from tb_dausach;";
        String sql2 = "Select Count(MaNguoiMuon)  as slnguoimuon from tb_nguoimuon;";
        String sql3 = "Select Count(MaPhieuMuon) as slphieumuon from tb_phieumuon;";
        String sql4 = "Select Count(MaPhieuMuon) as slphieumuonquahan from tb_phieumuon where (HanTra) < (SELECT CURDATE()) and NgayTra is NULL;";
        String sql5 = "SELECT tb_nguoimuon.MaNguoiMuon, tb_nguoimuon.TenNguoiMuon, tb_sach.TenSach, tb_phieumuon.HanTra"
                + " FROM tb_phieumuon INNER JOIN tb_nguoimuon ON tb_phieumuon.MaNguoiMuon = tb_nguoimuon.MaNguoiMuon"
                + " INNER JOIN tb_sach ON tb_phieumuon.MaSach = tb_sach.MaSach"
                + " INNER JOIN tb_dausach ON tb_sach.MaDauSach = tb_dausach.MaDauSach"
                + " where tb_phieumuon.HanTra < ( SELECT CURDATE()) and NgayTra is NULL;";

        String sql6 = "SELECT tb_nguoimuon.MaNguoiMuon, tb_nguoimuon.TenNguoiMuon, tb_nguoimuon.SDT, tb_sach.TenSach, tb_dausach.TheLoai, tb_phieumuon.NgayMuon, tb_phieumuon.HanTra "
                + "FROM  tb_phieumuon INNER JOIN tb_nguoimuon ON tb_phieumuon.MaNguoiMuon = tb_nguoimuon.MaNguoiMuon "
                + "INNER JOIN  tb_sach ON tb_phieumuon.MaSach = tb_sach.MaSach "
                + "INNER JOIN tb_dausach ON tb_sach.MaDauSach = tb_dausach.MaDauSach;";
        try {
            PreparedStatement ps1 = (PreparedStatement) cn.prepareStatement(sql1);
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.next()) lb1.setText("Tổng số sách trong kho: "+Integer.toString(rs1.getInt("slsach")));

            PreparedStatement ps2 = (PreparedStatement) cn.prepareStatement(sql2);
            ResultSet rs2 = ps2.executeQuery();
            if (rs2.next()) lb2.setText("Tổng số khách hàng : "+Integer.toString(rs2.getInt("slnguoimuon")));

            PreparedStatement ps3 = (PreparedStatement) cn.prepareStatement(sql3);
            ResultSet rs3 = ps3.executeQuery();
            if (rs3.next()) lb3.setText("Tổng số phiếu mượn : "+Integer.toString(rs3.getInt("slphieumuon")));

            PreparedStatement ps4 = (PreparedStatement) cn.prepareStatement(sql4);
            ResultSet rs4 = ps4.executeQuery();
            if (rs4.next()) lb4.setText("Tổng số phiếu mượn quá hạn : "+Integer.toString(rs4.getInt("slphieumuonquahan")));

            PreparedStatement ps5 = (PreparedStatement) cn.prepareStatement(sql5);
            ResultSet rs5 = ps5.executeQuery();
            Model5.setRowCount(0);
            while(rs5.next()) {
                Vector<Object> tbRow5 = new Vector<>();
                tbRow5.add(rs5.getString("MaNguoiMuon"));
                tbRow5.add(rs5.getString("TenNguoiMuon"));
                tbRow5.add(rs5.getString("TenSach"));
                tbRow5.add(rs5.getDate("HanTra"));
                rows5.add(tbRow5);
            }
            Model5.setDataVector(rows5, columns5);
            tableThongke.setModel(Model5);

            PreparedStatement ps6 = (PreparedStatement) cn.prepareStatement(sql6);
            ResultSet rs6 = ps6.executeQuery();
            Model6.setRowCount(0);
            while(rs6.next()) {
                Vector<Object> tbRow6 = new Vector<>();
                tbRow6.add(rs6.getString("MaNguoiMuon"));
                tbRow6.add(rs6.getString("TenNguoiMuon"));
                tbRow6.add(rs6.getString("SDT"));
                tbRow6.add(rs6.getString("TenSach"));
                tbRow6.add(rs6.getString("TheLoai"));
                tbRow6.add(rs6.getDate("NgayMuon"));
                tbRow6.add(rs6.getDate("HanTra"));
                rows6.add(tbRow6);
            }
            Model6.setDataVector(rows6, columns6);
            tableThongtinNguoimuonsach.setModel(Model6);

        } catch (Exception e) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearchDauSach) {
            String sql= null;
            if (txtSearchDS.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin!" , "Thông báo", 1);
            } else {
                if (cbbDauSach.getSelectedIndex() == 0) {
                    sql = "SELECT * FROM tb_dausach where MaDauSach = ?";
                } else if (cbbDauSach.getSelectedIndex() == 1) {
                    sql = "SELECT * FROM tb_dausach where TenSach = ?";
                } else if (cbbDauSach.getSelectedIndex() == 2) {
                    sql = "SELECT * FROM tb_dausach where SoLuong = ?";
                } else if (cbbDauSach.getSelectedIndex() == 3) {
                    sql = "SELECT * FROM tb_dausach where TheLoai = ?";
                } else if (cbbDauSach.getSelectedIndex() == 4) {
                    sql = "SELECT * FROM tb_dausach where TacGia = ?";
                } else if (cbbDauSach.getSelectedIndex() == 5) {
                    sql = "SELECT * FROM tb_dausach where NXB = ?";
                } else if (cbbDauSach.getSelectedIndex() == 6) {
                    sql = "SELECT * FROM tb_dausach where NamXB = ?";
                }
                Model1.setRowCount(0);
                Connection cn = cd.getCon();
                ArrayList<Type> ls = new ArrayList<>();
                try {
                    PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
                    ps.setString(1, txtSearchDS.getText());
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        Type st = new Type();
                        st.setMaDauSach(rs.getString("MaDauSach"));
                        st.setTenSach(rs.getString("TenSach"));
                        st.setSoLuong(rs.getInt("SoLuong"));
                        st.setTheLoai(rs.getString("TheLoai"));
                        st.setTacGia(rs.getString("TacGia"));
                        st.setNXB(rs.getString("NXB"));
                        st.setNamXB(rs.getInt("NamXB"));
                        ls.add(st);
                    }
                    for (int i = 0; i < ls.size(); i++) {
                        Type s = (Type) ls.get(i);
                        Vector<Object> tbRow1 = new Vector<>();
                        tbRow1.add(s.getMaDauSach());
                        tbRow1.add(s.getTenSach());
                        tbRow1.add(s.getSoLuong());
                        tbRow1.add(s.getTheLoai());
                        tbRow1.add(s.getTacGia());
                        tbRow1.add(s.getNXB());
                        tbRow1.add(s.getNamXB());
                        rows1.add(tbRow1);
                    }
                    Model1.setDataVector(rows1, columns1);
                    tableDauSach.setModel(Model1);

                    cbbDauSach.setSelectedIndex(-1);
                    txtSearchDS.setText(null);
                } catch (Exception e1) {

                }
                if (Model1.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy !" , "Thông báo", 1);
                }
            }
        }

        if (e.getSource() == btnSearchSach) {
            String sql = null;
            if (txtSearchSach.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin!" , "Thông báo", 1);
            } else {
                if (cbbSach.getSelectedIndex() == 0) {
                    sql = "SELECT * FROM tb_sach where MaSach = ?";
                } else if (cbbSach.getSelectedIndex() == 1) {
                    sql = "SELECT distinct * FROM tb_sach where TenSach = ?";
                } else if (cbbSach.getSelectedIndex() == 2) {
                    sql = "SELECT * FROM tb_sach where TrangThai = ?";
                } else if (cbbSach.getSelectedIndex() == 3) {
                    sql = "SELECT * FROM tb_sach where MaDauSach = ?";
                }

                Model2.setRowCount(0);
                Connection cn = cd.getCon();
                ArrayList<Book> ls = new ArrayList<>();
                try {
                    PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
                    ps.setString(1, txtSearchSach.getText());
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        Book st = new Book();
                        st.setMaSach(rs.getString("MaSach"));
                        st.setTenSach(rs.getString("TenSach"));
                        st.setTrangThai(rs.getString("TrangThai"));
                        st.setMaDauSach(rs.getString("MaDauSach"));
                        ls.add(st);
                    }
                    for (int i = 0; i < ls.size(); i++) {
                        Book s = (Book) ls.get(i);
                        Vector<Object> tbRow2 = new Vector<>();
                        tbRow2.add(s.getMaSach());
                        tbRow2.add(s.getTenSach());
                        tbRow2.add(s.getTrangThai());
                        tbRow2.add(s.getMaDauSach());
                        rows2.add(tbRow2);
                    }
                    Model2.setDataVector(rows2, columns2);
                    tableSach.setModel(Model2);
                    cbbSach.setSelectedIndex(-1);
                    txtSearchSach.setText(null);
                } catch (Exception e1) {

                }
                if (Model2.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy !" , "Thông báo", 1);
                }
            }
        }

        if (e.getSource() == btnNewButton) {
            String sql = null;
            if (txtSearchNguoiMuon.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin!" , "Thông báo", 1);
            } else {
                if (cbbNguoiMuon.getSelectedIndex() == 0) {
                    sql = "SELECT * FROM tb_nguoimuon where MaNguoiMuon = ?";
                } else if (cbbNguoiMuon.getSelectedIndex() == 1) {
                    sql = "SELECT * FROM tb_nguoimuon where TenNguoiMuon = ?";
                } else if (cbbNguoiMuon.getSelectedIndex() == 2) {
                    sql = "SELECT * FROM tb_nguoimuon where DiaChi = ?";
                } else if (cbbNguoiMuon.getSelectedIndex() == 3) {
                    sql = "SELECT * FROM tb_nguoimuon where Gmail = ?";
                } else if (cbbNguoiMuon.getSelectedIndex() == 4) {
                    sql = "SELECT * FROM tb_nguoimuon where SDT = ?";
                }

                Connection cn = cd.getCon();
                ArrayList<Person> ls = new ArrayList<>();
                try {
                    Model3.setRowCount(0);
                    PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
                    ps.setString(1, txtSearchNguoiMuon.getText());
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
                    for (int i = 0; i < ls.size(); i++) {
                        Person s = (Person) ls.get(i);
                        Vector<Object> tbRow3 = new Vector<>();
                        tbRow3.add(s.getMaNguoiMuon());
                        tbRow3.add(s.getTenNguoiMuon());
                        tbRow3.add(s.getDiaChi());
                        tbRow3.add(s.getGmail());
                        tbRow3.add(s.getSDT());
                        rows3.add(tbRow3);
                    }
                    Model3.setDataVector(rows3, columns3);
                    tableNguoiMuon.setModel(Model3);


                    cbbNguoiMuon.setSelectedIndex(-1);
                    txtSearchNguoiMuon.setText(null);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy!" , "Thông báo", 1);
                }
                if (Model3.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy !" , "Thông báo", 1);
                }
            }
        }

        if (e.getSource() == btnSearchPhieuMuon) {
            String sql= null;
            if (txtSearchPhieuMuon.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin!" , "Thông báo", 1);
            } else {
                if (cbbPhieuMuon.getSelectedIndex() == 0) {
                    sql = "SELECT * FROM tb_phieumuon where MaPhieuMuon = ?";
                } else if (cbbPhieuMuon.getSelectedIndex() == 1) {
                    sql = "SELECT * FROM tb_phieumuon where NgayMuon = ?";
                } else if (cbbPhieuMuon.getSelectedIndex() == 2) {
                    sql = "SELECT * FROM tb_phieumuon where HanTra = ?";
                } else if (cbbPhieuMuon.getSelectedIndex() == 3) {
                    sql = "SELECT * FROM tb_phieumuon where MaSach = ?";
                } else if (cbbPhieuMuon.getSelectedIndex() == 4) {
                    sql = "SELECT * FROM tb_phieumuon where MaNguoiMuon = ?";
                } else if (cbbPhieuMuon.getSelectedIndex() == 5) {
                    sql = "SELECT * FROM tb_phieumuon where NgayTra = ?";
                }

                Model4.setRowCount(0);
                Connection cn = cd.getCon();
                ArrayList<Form> ls = new ArrayList<>();
                try {
                    PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
                    ps.setString(1, txtSearchPhieuMuon.getText());
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        Form st = new Form();
                        st.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
                        st.setNgayMuon(rs.getDate("NgayMuon"));
                        st.setHanTra(rs.getDate("HanTra"));
                        st.setMaSach(rs.getString("MaSach"));
                        st.setMaNguoiMuon(rs.getString("MaNguoiMuon"));
                        st.setNgayTra(rs.getDate("NgayTra"));
                        ls.add(st);
                    }
                    for (int i = 0; i < ls.size(); i++) {
                        Form s = (Form) ls.get(i);
                        Vector<Object> tbRow4 = new Vector<>();
                        tbRow4.add(s.getMaPhieuMuon());
                        tbRow4.add(s.getNgayMuon());
                        tbRow4.add(s.getHanTra());
                        tbRow4.add(s.getMaSach());
                        tbRow4.add(s.getMaNguoiMuon());
                        tbRow4.add(s.getNgayTra());
                        rows4.add(tbRow4);
                    }
                    Model4.setDataVector(rows4, columns4);
                    tablePhieuMuon.setModel(Model4);
                    cbbPhieuMuon.setSelectedIndex(-1);
                    txtSearchPhieuMuon.setText(null);
                } catch (Exception e1) {
                    //JOptionPane.showMessageDialog(null, "Không tìm thấy!" , "Thông báo", 1);
                }
                if (Model4.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy !" , "Thông báo", 1);
                }
            }
        }

        if (e.getSource() == btnLamMoiPhieuMuon) {
            txtSearchPhieuMuon.setText(null);
            cbbPhieuMuon.setSelectedIndex(-1);
            getAllPhieuMuon();
        }

        if (e.getSource() == btnLamMoiNguoiMuon) {
            txtSearchNguoiMuon.setText(null);
            cbbNguoiMuon.setSelectedItem(-1);
            getAllNguoiMuon();
        }

        if (e.getSource() == btnLamMoiDS) {
            txtSearchDS.setText(null);
            cbbDauSach.setSelectedIndex(-1);
            getAllDauSach();
        }

        if (e.getSource() == btnLamMoiSach) {
            txtSearchSach.setText(null);
            cbbSach.setSelectedIndex(-1);
            getAllSach();
        }

        if (e.getSource() == buttonRefreshStatistics) {
            Thongke(lblTongsoSach, lblTongsoNguoiMuon, lblTongSoPhieuMuon, lblTongSoPhieuMuonQuaHan);
        }
    }
}
