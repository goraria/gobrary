package Gobrary.GPanel;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.*;

import Gobrary.GIcon.*;
import Gobrary.GObject.*;
import Gobrary.GProcess.*;

public class ListForm extends JPanel implements ActionListener, MouseListener {
    DefaultTableModel Model = new DefaultTableModel();
    Vector<String> columns = new Vector<String>();
    Vector<Vector<Object>> rows = new Vector<>();
    FormProcess ppm = new FormProcess();

    private final JLabel lblIBForm = new JLabel();
    private final JTextField txtIBForm = new JTextField();
    private final JLabel lblIBBook = new JLabel();
    private final JComboBox cbbIBBook = new JComboBox();
    private final JLabel lblIBPerson = new JLabel();
    private final JComboBox cbbIBPerson = new JComboBox();
    private final JLabel lblBorrowDate = new JLabel();
    private final JTextField txtBorrowDate = new JTextField();
    private final JLabel lblDeadline = new JLabel();
    private final JTextField txtDeadline = new JTextField();
    private final JLabel lblReturnDate = new JLabel();
    private final JTextField txtReturnDate = new JTextField();

    private JTable table;
    private final JPanel panel = new JPanel();

    private final JButton addButton = new JButton();
    private final JButton delButton = new JButton();
    private final JButton editButton = new JButton();
    private final JButton allButton = new JButton();
    private final JButton refButton = new JButton();

    public ListForm() {
        Border panelBorder = BorderFactory.createMatteBorder(0, 5, 0, 5, new Color(0x555555));
        this.setBorder(panelBorder);
        this.setLayout(new BorderLayout());

        JPanel leftListFormPanel = new JPanel();
        leftListFormPanel.setBackground(new Color(0xFFFFFF));
        leftListFormPanel.setPreferredSize(new Dimension(0, 0));
        this.add(leftListFormPanel, BorderLayout.CENTER);

        JPanel rightListFormPanel = new JPanel();
        rightListFormPanel.setBackground(new Color(0xAAAAAA));
        rightListFormPanel.setPreferredSize(new Dimension(370, 0));
        this.add(rightListFormPanel, BorderLayout.EAST);

        JPanel btmButtonBookPanel = new JPanel();
        btmButtonBookPanel.setBackground(new Color(0x555555));
        btmButtonBookPanel.setPreferredSize(new Dimension(0, 60));
        this.add(btmButtonBookPanel, BorderLayout.SOUTH);

        ////

        rightListFormPanel.setLayout(null); // new BorderLayout()

        lblIBForm.setText("Mã phiếu");
        lblIBForm.setFont(new Font("Arial", Font.PLAIN, 16));
        lblIBForm.setBounds(new Rectangle(5, 5, 360, 30));
        rightListFormPanel.add(lblIBForm);

        txtIBForm.setFont(new Font("Arial", Font.PLAIN, 16));
        txtIBForm.setBounds(new Rectangle(5, 40, 360, 30));
        rightListFormPanel.add(txtIBForm);

        lblIBBook.setText("Mã sách");
        lblIBBook.setFont(new Font("Arial", Font.PLAIN, 16));
        lblIBBook.setBounds(new Rectangle(5, 80, 360, 30));
        rightListFormPanel.add(lblIBBook);

        cbbIBBook.setFont(new Font("Arial", Font.PLAIN, 15));
        cbbIBBook.setBounds(new Rectangle(5, 115, 360, 30));
        rightListFormPanel.add(cbbIBBook);

        lblIBPerson.setText("Mã người mượn");
        lblIBPerson.setFont(new Font("Arial", Font.PLAIN, 16));
        lblIBPerson.setBounds(new Rectangle(5, 155, 360, 30));
        rightListFormPanel.add(lblIBPerson);

        cbbIBPerson.setFont(new Font("Arial", Font.PLAIN, 16));
        cbbIBPerson.setBounds(new Rectangle(5, 190, 360, 30));
        rightListFormPanel.add(cbbIBPerson);

        lblBorrowDate.setText("Ngày mượn");
        lblBorrowDate.setFont(new Font("Arial", Font.PLAIN, 16));
        lblBorrowDate.setBounds(new Rectangle(5, 230, 360, 30));
        rightListFormPanel.add(lblBorrowDate);

        txtBorrowDate.setFont(new Font("Arial", Font.PLAIN, 16));
        txtBorrowDate.setBounds(new Rectangle(5, 265, 360, 30));
        rightListFormPanel.add(txtBorrowDate);

        lblDeadline.setText("Hạn trả");
        lblDeadline.setFont(new Font("Arial", Font.PLAIN, 16));
        lblDeadline.setBounds(new Rectangle(5, 305, 360, 30));
        rightListFormPanel.add(lblDeadline);

        txtDeadline.setFont(new Font("Arial", Font.PLAIN, 16));
        txtDeadline.setBounds(new Rectangle(5, 340, 360, 30));
        rightListFormPanel.add(txtDeadline);

        lblReturnDate.setText("Ngày trả");
        lblReturnDate.setFont(new Font("Arial", Font.PLAIN, 16));
        lblReturnDate.setBounds(new Rectangle(5, 380, 360, 30));
        rightListFormPanel.add(lblReturnDate);

        txtReturnDate.setFont(new Font("Arial", Font.PLAIN, 16));
        txtReturnDate.setBounds(new Rectangle(5, 415, 360, 30));
        rightListFormPanel.add(txtReturnDate);

        //

        btmButtonBookPanel.setLayout(null);

        JButton formButton = new JButton();
        formButton.setText("Phiếu mượn");
        formButton.addActionListener(this);
        formButton.setFont(new Font("Arial", Font.BOLD, 16));
        formButton.setBounds(new Rectangle(0, 5, 150, 50));
        formButton.setEnabled(false);
        btmButtonBookPanel.add(formButton);

        addButton.setText("Thêm");
        addButton.addActionListener(this);
        addButton.setFont(new Font("Arial", Font.BOLD, 16));
        addButton.setBounds(new Rectangle(155, 5, 150, 50));
        addButton.setEnabled(true);
        btmButtonBookPanel.add(addButton);

        delButton.setText("Xóa");
        delButton.addActionListener(this);
        delButton.setFont(new Font("Arial", Font.BOLD, 16));
        delButton.setBounds(new Rectangle(310, 5, 150, 50));
        delButton.setEnabled(false);
        btmButtonBookPanel.add(delButton);

        editButton.setText("Sửa");
        editButton.addActionListener(this);
        editButton.setFont(new Font("Arial", Font.BOLD, 16));
        editButton.setBounds(new Rectangle(465, 5, 150, 50));
        editButton.setEnabled(false);
        btmButtonBookPanel.add(editButton);

        allButton.setText("Xoá tất cả");
        allButton.addActionListener(this);
        allButton.setFont(new Font("Arial", Font.BOLD, 16));
        allButton.setBounds(new Rectangle(620, 5, 150, 50));
        allButton.setEnabled(false);
        btmButtonBookPanel.add(allButton);

        refButton.setText("Làm mới");
        refButton.addActionListener(this);
        refButton.setFont(new Font("Arial", Font.BOLD, 16));
        refButton.setBounds(new Rectangle(775, 5, 150, 50));
        refButton.setEnabled(true);
        btmButtonBookPanel.add(refButton);

        ////

        leftListFormPanel.setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 0, 0);
        leftListFormPanel.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.addMouseListener(this);
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        scrollPane.setViewportView(table);

        getMaSach(cbbIBBook);
        getMaNguoiMuon(cbbIBPerson);
        cbbIBBook.setSelectedIndex(-1);
        cbbIBPerson.setSelectedIndex(-1);

        //

        columns.add("Mã phiếu mượn");
        columns.add("Ngày mượn");
        columns.add("Hạn trả");
        columns.add("Mã sách");
        columns.add("Mã độc giả");
        columns.add("Ngày trả");
        getAllPhieuMuon();

        //

        this.setVisible(true);
    }

    public void getAllPhieuMuon() {
        Model.setRowCount(0);
        ArrayList<Form> ls = ppm.getListPhieuMuon();
        for (int i = 0; i < ls.size(); i++) {
            Form s = (Form) ls.get(i);
            Vector<Object> tbRow = new Vector<>();
            tbRow.add(s.getMaPhieuMuon());
            tbRow.add(s.getNgayMuon());
            tbRow.add(s.getHanTra());
            tbRow.add(s.getMaSach());
            tbRow.add(s.getMaNguoiMuon());
            tbRow.add(s.getNgayTra());
            rows.add(tbRow);
        }
        Model.setDataVector(rows, columns);
        table.setModel(Model);
    }

    public boolean insertPhieuMuon(String MaPhieuMuon, java.sql.Date NgayMuon, java.sql.Date HanTra, String MaSach, String MaNguoiMuon) {
        Model.setRowCount(0);
        if(ppm.insertPhieuMuon(MaPhieuMuon, NgayMuon,HanTra, MaSach, MaNguoiMuon)) {
            ArrayList<Form> ls = ppm.getListPhieuMuon();
            for (int i = 0; i < ls.size(); i++) {
                Form s = (Form) ls.get(i);
                Vector<Object> tbRow = new Vector<>();
                tbRow.add(s.getMaPhieuMuon());
                tbRow.add(s.getNgayMuon());
                tbRow.add(s.getHanTra());
                tbRow.add(s.getMaSach());
                tbRow.add(s.getMaNguoiMuon());
                tbRow.add(s.getNgayTra());
                rows.add(tbRow);
            }
            Model.setDataVector(rows, columns);
            table.setModel(Model);

            return true;
        } else {
            return false;
        }
    }

    public void updatePhieuMuon(String MaPhieuMuon, java.sql.Date NgayMuon, java.sql.Date HanTra, String MaSach, String MaNguoiMuon) {
        Model.setRowCount(0);
        if(ppm.updatePhieuMuon(MaPhieuMuon, NgayMuon,HanTra, MaSach, MaNguoiMuon)) {
            ArrayList<Form> ls = ppm.getListPhieuMuon();
            for (int i = 0; i < ls.size(); i++) {
                Form s = (Form) ls.get(i);
                Vector<Object> tbRow = new Vector<>();
                tbRow.add(s.getMaPhieuMuon());
                tbRow.add(s.getNgayMuon());
                tbRow.add(s.getHanTra());
                tbRow.add(s.getMaSach());
                tbRow.add(s.getMaNguoiMuon());
                tbRow.add(s.getNgayTra());
                rows.add(tbRow);
            }
            Model.setDataVector(rows, columns);
            table.setModel(Model);
        } else {
            System.out.println(false);
        }

    }

    public void updatePMNgayTra(Date NgayTra, String MaPhieuMuon) {
        Model.setRowCount(0);
        if(ppm.updatePhieuMuonNgayTra(NgayTra, MaPhieuMuon)) {
            ArrayList<Form> ls = ppm.getListPhieuMuon();
            for (int i = 0; i < ls.size(); i++) {
                Form s = (Form) ls.get(i);
                Vector<Object> tbRow = new Vector<>();
                tbRow.add(s.getMaPhieuMuon());
                tbRow.add(s.getNgayMuon());
                tbRow.add(s.getHanTra());
                tbRow.add(s.getMaSach());
                tbRow.add(s.getMaNguoiMuon());
                tbRow.add(s.getNgayTra());
                rows.add(tbRow);
            }
            Model.setDataVector(rows, columns);
            table.setModel(Model);
        } else {
            System.out.println(false);
        }

    }

    public boolean delPhieuMuon(String MaPhieuMuon) {
        Model.setRowCount(0);
        if(ppm.delPhieuMuon(MaPhieuMuon)) {
            ArrayList<Form> ls = ppm.getListPhieuMuon();
            for (int i = 0; i < ls.size(); i++) {
                Form s = (Form) ls.get(i);
                Vector<Object> tbRow = new Vector<>();
                tbRow.add(s.getMaPhieuMuon());
                tbRow.add(s.getNgayMuon());
                tbRow.add(s.getHanTra());
                tbRow.add(s.getMaSach());
                tbRow.add(s.getMaNguoiMuon());
                tbRow.add(s.getNgayTra());
                rows.add(tbRow);
            }
            Model.setDataVector(rows, columns);
            table.setModel(Model);
            return true;
        } else {
            return false;
        }
    }

    public boolean delPhieuMuonDaTra() {
        Model.setRowCount(0);
        if(ppm.delPhieuMuonDaTra()) {
            ArrayList<Form> ls = ppm.getListPhieuMuon();
            for (int i = 0; i < ls.size(); i++) {
                Form s = (Form) ls.get(i);
                Vector<Object> tbRow = new Vector<>();
                tbRow.add(s.getMaPhieuMuon());
                tbRow.add(s.getNgayMuon());
                tbRow.add(s.getHanTra());
                tbRow.add(s.getMaSach());
                tbRow.add(s.getMaNguoiMuon());
                tbRow.add(s.getNgayTra());
                rows.add(tbRow);
            }
            Model.setDataVector(rows, columns);
            table.setModel(Model);
            return true;

        } else {
            return false;
        }
    }

    public void getMaSach(JComboBox ComboBox) {
        ArrayList<String> arr = ppm.getSach();
        for (String mds : arr) {
            ComboBox.addItem(mds);
        }
    }

    public void getMaNguoiMuon(JComboBox ComboBox) {
        ArrayList<String> arr = ppm.getMaNguoiMuon();
        for (String mds : arr) {
            ComboBox.addItem(mds);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            if (txtIBForm.getText().equals("") || txtBorrowDate.getText().equals("") || cbbIBBook.getSelectedIndex() == -1 || cbbIBPerson.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin!" , "Thông báo", 1);
            } else {
                if (insertPhieuMuon(txtIBForm.getText(), Date.valueOf(txtBorrowDate.getText()),Date.valueOf(txtDeadline.getText()), (String)cbbIBBook.getSelectedItem(), (String)cbbIBPerson.getSelectedItem())) {
                    JOptionPane.showMessageDialog(null, "Thêm thành công!" , "Thông báo", 1);
                    BookProcess ps = new BookProcess();
                    ps.updateSachTrangThai((String)cbbIBBook.getSelectedItem());
                    txtIBForm.setText(null);
                    txtDeadline.setText(null);
                    txtReturnDate.setText(null);
                    txtBorrowDate.setText(null);
                    cbbIBBook.setSelectedIndex(-1);
                    cbbIBPerson.setSelectedIndex(-1);
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm thất bại!" , "Thông báo", 1);
                    getAllPhieuMuon();
                }
            }
        }

        if (e.getSource() == delButton) {
            int n = JOptionPane.showConfirmDialog(panel, "Bạn muốn xoá?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                if (delPhieuMuon(txtIBForm.getText())) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công!" , "Thông báo", 1);
                    BookProcess ps = new BookProcess();
                    ps.updateSachTrangThai2((String)cbbIBBook.getSelectedItem());
                    txtIBForm.setEnabled(true);
                    txtIBForm.setText(null);
                    txtDeadline.setText(null);
                    txtBorrowDate.setText(null);
                    cbbIBBook.setSelectedIndex(-1);
                    cbbIBPerson.setSelectedIndex(-1);
                    txtReturnDate.setText(null);
                    editButton.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại!" , "Thông báo", 1);
                }
            }
        }

        if (e.getSource() == editButton) {
            int n = JOptionPane.showConfirmDialog(panel, "Bạn muốn sửa?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                if (txtReturnDate.getText().equals("")) {
                    updatePhieuMuon(txtIBForm.getText(), Date.valueOf(txtBorrowDate.getText()),Date.valueOf(txtDeadline.getText()), (String)cbbIBBook.getSelectedItem(), (String)cbbIBPerson.getSelectedItem());
                } else {
                    updatePMNgayTra(Date.valueOf(txtReturnDate.getText()), txtIBForm.getText());
                    BookProcess ps = new BookProcess();
                    ps.updateSachTrangThai2((String)cbbIBBook.getSelectedItem());
                }
            }
        }

        if (e.getSource() == allButton) {
            if(delPhieuMuonDaTra()) {
                JOptionPane.showMessageDialog(null, "Xóa thành công!" , "Thông báo", 1);
                getAllPhieuMuon();
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại!" , "Thông báo", 1);
            }
        }

        if (e.getSource() == refButton) {
            addButton.setEnabled(true);
            delButton.setEnabled(false);
            editButton.setEnabled(false);
            txtReturnDate.setEnabled(false);
            getAllPhieuMuon();
            txtIBForm.setEnabled(true);
            txtIBForm.setText(null);
            txtDeadline.setText(null);
            txtReturnDate.setText(null);
            txtBorrowDate.setText(null);
            cbbIBBook.removeAllItems();
            getMaSach(cbbIBBook);
            cbbIBBook.setSelectedIndex(-1);
            cbbIBPerson.setSelectedIndex(-1);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == table) {
            addButton.setEnabled(false);
            txtIBForm.setEnabled(false);
            editButton.setEnabled(true);
            delButton.setEnabled(true);
            txtReturnDate.setEnabled(true);
            int index = table.getSelectedRow();
            txtIBForm.setText((String)(Model.getValueAt(index, 0)));
            txtBorrowDate.setText( (Model.getValueAt(index, 1)).toString());
            txtDeadline.setText( (Model.getValueAt(index, 2)).toString());
            cbbIBBook.addItem((String)(Model.getValueAt(index, 3)));
            cbbIBBook.setSelectedItem((String)(Model.getValueAt(index, 3)));
            cbbIBPerson.setSelectedItem((String)(Model.getValueAt(index, 4)));

            try {
                txtReturnDate.setText( (Model.getValueAt(index, 5)).toString());
            } catch (Exception e2) {
                txtReturnDate.setText(null);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
