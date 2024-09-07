package Gobrary.GPanel;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Gobrary.GIcon.*;
import Gobrary.GObject.*;
import Gobrary.GProcess.*;

public class ListBook extends JPanel implements ActionListener, MouseListener, ItemListener {
    DefaultTableModel Model = new DefaultTableModel();
    Vector<String> columns = new Vector<String>();
    Vector<Vector<Object>> rows = new Vector<>();
    BookProcess ps = new BookProcess();

    private final JLabel lblIDBook = new JLabel();
    private final JTextField txtIDBook = new JTextField();
    private final JLabel lblNameBook = new JLabel();
    private final JComboBox cbbNameBook = new JComboBox();
    private final JLabel lblTypeID = new JLabel();
    private final JTextField txtTypeID = new JTextField();
    private final JLabel lblStatusBook = new JLabel();
    private final JComboBox cbbStatus = new JComboBox();

    private JTable table;
    private final JPanel panel = new JPanel();

    private final JButton addButton = new JButton();
    private final JButton delButton = new JButton();
    private final JButton editButton = new JButton();
    private final JButton refButton = new JButton();

    public ListBook() {
        Border panelBorder = BorderFactory.createMatteBorder(0, 5, 0, 5, new Color(0x555555));
        this.setBorder(panelBorder);
        this.setLayout(new BorderLayout());

        JPanel leftListBookPanel = new JPanel();
        leftListBookPanel.setBackground(new Color(0xFFFFFF));
        leftListBookPanel.setPreferredSize(new Dimension(0, 0));
        this.add(leftListBookPanel, BorderLayout.CENTER);

        JPanel rightListBookPanel = new JPanel();
        rightListBookPanel.setBackground(new Color(0xAAAAAA));
        rightListBookPanel.setPreferredSize(new Dimension(370, 0));
        this.add(rightListBookPanel, BorderLayout.EAST);

        JPanel btmButtonBookPanel = new JPanel();
        btmButtonBookPanel.setBackground(new Color(0x555555));
        btmButtonBookPanel.setPreferredSize(new Dimension(0, 60));
        this.add(btmButtonBookPanel, BorderLayout.SOUTH);

        ////

        rightListBookPanel.setLayout(null); // new BorderLayout()
    
        lblIDBook.setText("Mã sách");
        lblIDBook.setFont(new Font("Arial", Font.PLAIN, 16));
        lblIDBook.setBounds(new Rectangle(5, 5, 360, 30));
        rightListBookPanel.add(lblIDBook);

		txtIDBook.setFont(new Font("Arial", Font.PLAIN, 16));
		txtIDBook.setBounds(new Rectangle(5, 40, 360, 30));
		rightListBookPanel.add(txtIDBook);

        lblNameBook.setText("Tên sách");
        lblNameBook.setFont(new Font("Arial", Font.PLAIN, 16));
        lblNameBook.setBounds(new Rectangle(5, 80, 360, 30));
        rightListBookPanel.add(lblNameBook);

		cbbNameBook.setFont(new Font("Arial", Font.PLAIN, 15));
		cbbNameBook.setBounds(new Rectangle(5, 115, 360, 30));
		cbbNameBook.setSelectedIndex(-1);
		rightListBookPanel.add(cbbNameBook);

        lblTypeID.setText("Mã đầu sách");
        lblTypeID.setFont(new Font("Arial", Font.PLAIN, 16));
        lblTypeID.setBounds(new Rectangle(5, 155, 360, 30));
        rightListBookPanel.add(lblTypeID);

		txtTypeID.setEnabled(false);
		txtTypeID.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTypeID.setBounds(new Rectangle(5, 190, 360, 30));
		rightListBookPanel.add(txtTypeID);

        lblStatusBook.setText("Trạng thái");
        lblStatusBook.setFont(new Font("Arial", Font.PLAIN, 16));
        lblStatusBook.setBounds(new Rectangle(5, 230, 360, 30));
        rightListBookPanel.add(lblStatusBook);

		cbbStatus.setFont(new Font("Arial", Font.PLAIN, 16));
		cbbStatus.setBounds(new Rectangle(5, 265, 360, 30));
		cbbStatus.setModel(new DefaultComboBoxModel(new String[] {"Còn", "Đã mượn"}));
		rightListBookPanel.add(cbbStatus);

        // JPanel panel = new JPanel();
        // panel.setBackground(SystemColor.inactiveCaption);
        // panel.setBounds(new Rectangle(5, 305, 10, 10));
        // rightListBookPanel.add(panel);

        //

        btmButtonBookPanel.setLayout(null);

        JButton bookButton = new JButton();
        bookButton.setText("Sách mượn");
        bookButton.addActionListener(this);
        bookButton.setFont(new Font("Arial", Font.BOLD, 16));
        bookButton.setBounds(new Rectangle(0, 5, 150, 50));
        bookButton.setEnabled(false);
        btmButtonBookPanel.add(bookButton);

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

        refButton.setText("Làm mới");
        refButton.addActionListener(this);
        refButton.setFont(new Font("Arial", Font.BOLD, 16));
        refButton.setBounds(new Rectangle(620, 5, 150, 50));
        refButton.setEnabled(true);
        btmButtonBookPanel.add(refButton);

        ////

        leftListBookPanel.setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 0, 0);
        leftListBookPanel.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.addMouseListener(this);
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        scrollPane.setViewportView(table);

        cbbNameBook.addItemListener(this);
        getTenSach(cbbNameBook);
        cbbNameBook.setSelectedIndex(-1);
        cbbStatus.setSelectedIndex(-1);
        txtTypeID.setText(null);

        //

        columns.add("Mã sách");
        columns.add("Tên sách");
        columns.add("Trạng thái");
        columns.add("Mã đầu sách");
        getAllSach();

        this.setVisible(true);
    }

    public void getAllSach() {
        Model.setRowCount(0);

        ArrayList<Book> ls = ps.getListSach();
        for (int i = 0; i < ls.size(); i++) {
            Book s = (Book) ls.get(i);
            Vector<Object> tbRow = new Vector<>();
            tbRow.add(s.getMaSach());
            tbRow.add(s.getTenSach());
            tbRow.add(s.getTrangThai());
            tbRow.add(s.getMaDauSach());
            rows.add(tbRow);
        }
        Model.setDataVector(rows, columns);
        table.setModel(Model);
    }

    public boolean insertSach(String MaSach, String TenSach, String TrangThai, String MaDauSach) {
        Model.setRowCount(0);
        if (ps.insertSach(MaSach, TenSach, TrangThai, MaDauSach) == true) {
            ArrayList<Book> ls = ps.getListSach();
            for (int i = 0; i < ls.size(); i++) {
                Book s = (Book) ls.get(i);
                Vector<Object> tbRow = new Vector<>();
                tbRow.add(s.getMaSach());
                tbRow.add(s.getTenSach());
                tbRow.add(s.getTrangThai());
                tbRow.add(s.getMaDauSach());
                rows.add(tbRow);
            }
            Model.setDataVector(rows, columns);
            table.setModel(Model);
            return true;
        } else {
            return false;
        }

    }

    public void updateSach(String MaSach, String TenSach, String TrangThai, String MaDauSach) {
        if (ps.updateSach(MaSach, TenSach, TrangThai, MaDauSach) == true) {
            Model.setRowCount(0);
            ArrayList<Book> ls = ps.getListSach();
            for(int i = 0; i< ls.size(); i++) {
                Book s = (Book) ls.get(i);
                Vector<Object> tbRow = new Vector<>();
                tbRow.add(s.getMaSach());
                tbRow.add(s.getTenSach());
                tbRow.add(s.getTrangThai());
                tbRow.add(s.getMaDauSach());
                rows.add(tbRow);
            }
            Model.setDataVector(rows, columns);
            table.setModel(Model);
        }
    }

    public void delSach(String MaSach) {
        if(ps.delSach(MaSach) == true) {
            Model.setRowCount(0);
            ArrayList<Book> ls = ps.getListSach();
            for(int i = 0; i<ls.size(); i++) {
                Book s = (Book) ls.get(i);
                Vector<Object> tbRow = new Vector<>();
                tbRow.add(s.getMaSach());
                tbRow.add(s.getTenSach());
                tbRow.add(s.getTrangThai());
                tbRow.add(s.getMaDauSach());
                rows.add(tbRow);
            }
            Model.setDataVector(rows, columns);
            table.setModel(Model);
        }
    }

    public void getMaDauSach(JComboBox ComboBox) {
        ArrayList<String> arr = ps.getMaDauSach();
        for (String mds : arr) {
            ComboBox.addItem(mds);
        }
    }

    public void getTenSach(JComboBox ComboBox) {
        ArrayList<String> arr = ps.getTenSach();
        for (String mds : arr) {
            ComboBox.addItem(mds);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            if (txtIDBook.getText().equals("") || cbbNameBook.getSelectedIndex() == -1 || cbbStatus.getSelectedIndex() == -1 || txtTypeID.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin!" , "Thông báo", 1);
            } else {
                if (insertSach(txtIDBook.getText(), (String)cbbNameBook.getSelectedItem(), (String)cbbStatus.getSelectedItem(), txtTypeID.getText())) {
                    TypeProcess pds  = new TypeProcess();
                    pds.updateDauSachSoLuong(txtTypeID.getText());
                    txtIDBook.setText(null);
                    cbbStatus.setSelectedIndex(-1);
                    cbbNameBook.setSelectedIndex(-1);
                    txtTypeID.setText(null);
                    JOptionPane.showMessageDialog(null, "Thêm thành công!" , "Thông báo", 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm thất bại!" , "Thông báo", 1);
                    getAllSach();
                }
            }
        }

        if (e.getSource() == delButton) {
            int n = JOptionPane.showConfirmDialog(panel, "Bạn muốn xóa?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if(n == JOptionPane.YES_OPTION) {
                delSach(txtIDBook.getText());
                delButton.setEnabled(false);
                editButton.setEnabled(false);
                txtIDBook.setEnabled(true);
                txtIDBook.setText(null);
                cbbStatus.setSelectedIndex(-1);
                cbbNameBook.setSelectedIndex(-1);
                txtTypeID.setText(null);
            }
        }

        if (e.getSource() == editButton) {
            int n = JOptionPane.showConfirmDialog(panel, "Bạn muốn sửa?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                updateSach(txtIDBook.getText(), (String)cbbNameBook.getSelectedItem(), (String)cbbStatus.getSelectedItem(), txtTypeID.getText());
            }
        }

        if (e.getSource() == refButton) {
            getAllSach();
            addButton.setEnabled(true);
            delButton.setEnabled(false);
            editButton.setEnabled(false);
            
            txtIDBook.setEnabled(true);
            txtIDBook.setText(null);
            cbbStatus.setSelectedIndex(-1);
            cbbNameBook.setSelectedIndex(-1);
            txtTypeID.setText(null);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == cbbNameBook) {
            try {
                String string = cbbNameBook.getSelectedItem().toString();
                txtTypeID.setText(ps.getMaDauSach2(string));

            } catch (Exception e2) {
                
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == table) {
            addButton.setEnabled(false);
            delButton.setEnabled(true);
            editButton.setEnabled(true);
            txtIDBook.setEnabled(false);
            int index = table.getSelectedRow();
            txtIDBook.setText((String)(Model.getValueAt(index, 0)));
            cbbStatus.setSelectedItem((String)(Model.getValueAt(index, 2)));
            txtTypeID.setText((String)(Model.getValueAt(index, 3)));
            cbbNameBook.setSelectedItem((String)(Model.getValueAt(index, 1)));
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
