package Gobrary.GPanel;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Gobrary.GIcon.*;
import Gobrary.GObject.*;
import Gobrary.GProcess.*;

public class ListType extends JPanel implements ActionListener, MouseListener, ItemListener, CaretListener, HierarchyListener {
    DefaultTableModel Model = new DefaultTableModel();
    Vector<String> columns = new Vector<String>();
    Vector<Vector<Object>> rows = new Vector<>();
    TypeProcess pds = new TypeProcess();

    private final JLabel lblTypeID = new JLabel();
    private final JTextField txtTypeID = new JTextField();
    private final JLabel lblNameBook = new JLabel();
    private final JTextField txtNameBook = new JTextField();
    private final JLabel lblQuantity = new JLabel();
    private final JTextField txtQuantity = new JTextField();
    private final JLabel lblTypeBook = new JLabel();
    private final JTextField txtTypeBook = new JTextField();
    private final JLabel lblAuthor = new JLabel();
    private final JTextField txtAuthor = new JTextField();
    private final JLabel lblPublisher = new JLabel();
    private final JTextField txtPublisher = new JTextField();
    private final JLabel lblYear = new JLabel();
    private final JTextField txtYear = new JTextField();

    private JTable table;
    private final JPanel panel = new JPanel();

    private final JButton addButton = new JButton();
    private final JButton delButton = new JButton();
    private final JButton editButton = new JButton();
    private final JButton refButton = new JButton();

    public ListType() {
        Border panelBorder = BorderFactory.createMatteBorder(0, 5, 0, 5, new Color(0x555555));
        this.setBorder(panelBorder);
        this.setLayout(new BorderLayout());

        JPanel leftListTypePanel = new JPanel();
        leftListTypePanel.setBackground(new Color(0xFFFFFF));
        leftListTypePanel.setPreferredSize(new Dimension(0, 0));
        this.add(leftListTypePanel, BorderLayout.CENTER);

        JPanel rightListTypePanel = new JPanel();
        rightListTypePanel.setBackground(new Color(0xAAAAAA));
        rightListTypePanel.setPreferredSize(new Dimension(370, 0));
        this.add(rightListTypePanel, BorderLayout.EAST);

        JPanel btmButtonBookPanel = new JPanel();
        btmButtonBookPanel.setBackground(new Color(0x555555));
        btmButtonBookPanel.setPreferredSize(new Dimension(0, 60));
        this.add(btmButtonBookPanel, BorderLayout.SOUTH);

        ////

        rightListTypePanel.setLayout(null); // new BorderLayout()

        lblTypeID.setText("Mã đầu sách");
        lblTypeID.setFont(new Font("Arial", Font.PLAIN, 16));
        lblTypeID.setBounds(new Rectangle(5, 5, 360, 30));
        rightListTypePanel.add(lblTypeID);

        txtTypeID.setFont(new Font("Arial", Font.PLAIN, 16));
        txtTypeID.setBounds(new Rectangle(5, 40, 360, 30));
        rightListTypePanel.add(txtTypeID);

        lblNameBook.setText("Tên sách");
        lblNameBook.setFont(new Font("Arial", Font.PLAIN, 16));
        lblNameBook.setBounds(new Rectangle(5, 80, 360, 30));
        rightListTypePanel.add(lblNameBook);

        txtNameBook.setFont(new Font("Arial", Font.PLAIN, 15));
        txtNameBook.setBounds(new Rectangle(5, 115, 360, 30));
        rightListTypePanel.add(txtNameBook);
        
        lblQuantity.setText("Số lượng");
        lblQuantity.setFont(new Font("Arial", Font.PLAIN, 16));
        lblQuantity.setBounds(new Rectangle(5, 155, 360, 30));
        rightListTypePanel.add(lblQuantity);

        txtQuantity.setFont(new Font("Arial", Font.PLAIN, 16));
        txtQuantity.setBounds(new Rectangle(5, 190, 360, 30));
        rightListTypePanel.add(txtQuantity);
        
        lblTypeBook.setText("Thể loại");
        lblTypeBook.setFont(new Font("Arial", Font.PLAIN, 16));
        lblTypeBook.setBounds(new Rectangle(5, 230, 360, 30));
        rightListTypePanel.add(lblTypeBook);

        txtTypeBook.setFont(new Font("Arial", Font.PLAIN, 16));
        txtTypeBook.setBounds(new Rectangle(5, 265, 360, 30));
        rightListTypePanel.add(txtTypeBook);
        
        lblAuthor.setText("Tác giả");
        lblAuthor.setFont(new Font("Arial", Font.PLAIN, 16));
        lblAuthor.setBounds(new Rectangle(5, 305, 360, 30));
        rightListTypePanel.add(lblAuthor);

        txtAuthor.setFont(new Font("Arial", Font.PLAIN, 16));
        txtAuthor.setBounds(new Rectangle(5, 340, 360, 30));
        rightListTypePanel.add(txtAuthor);
        
        lblPublisher.setText("Nhà xuất bản");
        lblPublisher.setFont(new Font("Arial", Font.PLAIN, 16));
        lblPublisher.setBounds(new Rectangle(5, 380, 360, 30));
        rightListTypePanel.add(lblPublisher);

        txtPublisher.setFont(new Font("Arial", Font.PLAIN, 16));
        txtPublisher.setBounds(new Rectangle(5, 415, 360, 30));
        rightListTypePanel.add(txtPublisher);
        
        lblYear.setText("Năm xuất bản");
        lblYear.setFont(new Font("Arial", Font.PLAIN, 16));
        lblYear.setBounds(new Rectangle(5, 455, 360, 30));
        rightListTypePanel.add(lblYear);

        txtYear.setFont(new Font("Arial", Font.PLAIN, 16));
        txtYear.setBounds(new Rectangle(5, 490, 360, 30));
        rightListTypePanel.add(txtYear);

        //

        btmButtonBookPanel.setLayout(null);

        JButton typeButton = new JButton();
        typeButton.setText("Đầu sách");
        typeButton.addActionListener(this);
        typeButton.setFont(new Font("Arial", Font.BOLD, 16));
        typeButton.setBounds(new Rectangle(0, 5, 150, 50));
        typeButton.setEnabled(false);
        btmButtonBookPanel.add(typeButton);

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

        //

        leftListTypePanel.setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 0, 0);
        leftListTypePanel.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.addMouseListener(this);
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        scrollPane.setViewportView(table);

        // .addItemListener(this);
        // getTenSach();
        // .setSelectedIndex(-1);
        // .setSelectedIndex(-1);
        // .setText(null);

        //

        columns.add("Mã đầu sách");
        columns.add("Tên sách");
        columns.add("Số lượng");
        columns.add("Thể loại");
        columns.add("Tác giả");
        columns.add("Nhà xuất bản");
        columns.add("Năm xuất bản");

        getAllDauSach();

        //

        this.setVisible(true);
    }

    public void getAllDauSach() {
        Model.setRowCount(0);
        ArrayList<Type> ls = pds.getListDauSach();
        for (int i = 0; i < ls.size(); i++) {
            Type s = (Type) ls.get(i);
            Vector<Object> tbRow = new Vector<>();
            tbRow.add(s.getMaDauSach());
            tbRow.add(s.getTenSach());
            tbRow.add(s.getSoLuong());
            tbRow.add(s.getTheLoai());
            tbRow.add(s.getTacGia());
            tbRow.add(s.getNXB());
            tbRow.add(s.getNamXB());
            rows.add(tbRow);
        }
        Model.setDataVector(rows, columns);
        table.setModel(Model);
    }

    public void insertDauSach(String MaDauSach, String TenSach, int SoLuong, String TheLoai, String TacGia, String NXB, int NamXB) {
        Model.setRowCount(0);
        if (pds.insertDauSach(MaDauSach, TenSach, SoLuong, TheLoai, TacGia, NXB, NamXB)== true) {
            getAllDauSach();
        }
        else {
            getAllDauSach();
        }
    }

    public void updateDauSach(String MaDauSach, String TenSach, int SoLuong, String TheLoai, String TacGia, String NXB, int NamXB) {
        Model.setRowCount(0);
        if (pds.updateDauSach(MaDauSach, TenSach, SoLuong, TheLoai, TacGia, NXB, NamXB)== true) {
            getAllDauSach();
        }
    }

    public void delDauSach(String MaDauSach) {
        Model.setRowCount(0);
        if (pds.delDauSach(MaDauSach) == true) {
            ArrayList<Type> ls = pds.getListDauSach();
            for (int i = 0; i < ls.size(); i++) {
                Type s = (Type) ls.get(i);
                Vector<Object> tbRow = new Vector<>();
                tbRow.add(s.getMaDauSach());
                tbRow.add(s.getTenSach());
                tbRow.add(s.getSoLuong());
                tbRow.add(s.getTheLoai());
                tbRow.add(s.getTacGia());
                tbRow.add(s.getNXB());
                tbRow.add(s.getNamXB());
                rows.add(tbRow);
            }
            Model.setDataVector(rows, columns);
            table.setModel(Model);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            if (txtTypeID.getText().equals("") || txtQuantity.getText().equals("") || txtAuthor.getText().equals("") || txtTypeBook.getText().equals("") || txtYear.getText().equals("") || txtPublisher.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin!" , "Thông báo", 1);
            } else {
                insertDauSach(txtTypeID.getText(), txtNameBook.getText(), Integer.parseInt(txtQuantity.getText()), txtTypeBook.getText(), txtAuthor.getText(), txtPublisher.getText(), Integer.parseInt(txtYear.getText()));
                txtNameBook.setText("");
                txtAuthor.setText("");
                txtTypeID.setText("");
                txtQuantity.setText("");
                txtTypeBook.setText("");
                txtYear.setText(null);
                txtPublisher.setText(null);
                editButton.setEnabled(false);
                delButton.setEnabled(false);
            }
        }

        if (e.getSource() == delButton) {
            int n = JOptionPane.showConfirmDialog(panel, "Bạn muốn xóa?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                delDauSach(txtTypeID.getText());
                txtTypeID.setEnabled(true);
                txtNameBook.setText(null);
                txtAuthor.setText(null);
                txtTypeID.setText(null);
                txtQuantity.setText(null);
                txtTypeBook.setText(null);
                txtNameBook.setText(null);
                txtYear.setText(null);
                txtPublisher.setText(null);
                delButton.setEnabled(false);
                editButton.setEnabled(false);
                addButton.setEnabled(true);
            }
        }

        if (e.getSource() == editButton) {
            int n = JOptionPane.showConfirmDialog(panel, "Bạn muốn sửa?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                updateDauSach(txtTypeID.getText(), txtNameBook.getText(), Integer.parseInt(txtQuantity.getText()), txtTypeBook.getText(), txtAuthor.getText(), txtPublisher.getText(), Integer.parseInt(txtYear.getText()));
            }
        }

        if (e.getSource() == refButton) {
            editButton.setEnabled(false);
            delButton.setEnabled(false);
            addButton.setEnabled(true);

            txtTypeID.setEnabled(true);
            txtNameBook.setText(null);
            txtAuthor.setText(null);
            txtTypeID.setText(null);
            txtQuantity.setText(null);
            txtTypeBook.setText(null);
            txtNameBook.setText(null);
            txtYear.setText(null);
            txtPublisher.setText(null);

            getAllDauSach();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        addButton.setEnabled(false);
        delButton.setEnabled(true);
        editButton.setEnabled(true);
        txtTypeID.setEnabled(false);
        int index = table.getSelectedRow();
        txtTypeID.setText((String)(Model.getValueAt(index, 0)));
        txtNameBook.setText((String)(Model.getValueAt(index, 1)));
        txtQuantity.setText(String.valueOf(Model.getValueAt(index, 2)));
        txtTypeBook.setText((String)(Model.getValueAt(index, 3)));
        txtAuthor.setText((String)(Model.getValueAt(index, 4)));
        txtPublisher.setText((String)(Model.getValueAt(index, 5)));
        txtYear.setText(String.valueOf(Model.getValueAt(index, 6)));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        addButton.setEnabled(false);
        delButton.setEnabled(true);
        editButton.setEnabled(true);
        txtTypeID.setEnabled(false);
        int index = table.getSelectedRow();
        txtTypeID.setText((String)(Model.getValueAt(index, 0)));
        txtNameBook.setText((String)(Model.getValueAt(index, 1)));
        txtQuantity.setText(String.valueOf(Model.getValueAt(index, 2)));
        txtTypeBook.setText((String)(Model.getValueAt(index, 3)));
        txtAuthor.setText((String)(Model.getValueAt(index, 4)));
        txtPublisher.setText((String)(Model.getValueAt(index, 5)));
        txtYear.setText(String.valueOf(Model.getValueAt(index, 6)));
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

    @Override
    public void caretUpdate(CaretEvent e) {
        if (e.getSource() == txtQuantity) {

        }
    }

    @Override
    public void hierarchyChanged(HierarchyEvent e) {
        if (e.getSource() == txtQuantity) {

        }
    }
}
