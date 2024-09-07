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

public class ListPerson extends JPanel implements ActionListener, MouseListener {
    DefaultTableModel Model = new DefaultTableModel();
	Vector<String> columns = new Vector<String>();
	Vector<Vector<Object>> rows = new Vector<>();
    PersonProcess pmn = new PersonProcess();

    private final JLabel lblIDPerson = new JLabel();
    private final JTextField txtIDPerson = new JTextField();
    private final JLabel lblNamePerson = new JLabel();
    private final JTextField txtNamePerson = new JTextField();
    private final JLabel lblAddress = new JLabel();
    private final JTextField txtAddress = new JTextField();
    private final JLabel lblEmail = new JLabel();
    private final JTextField txtEmail = new JTextField();
    private final JLabel lblPhone = new JLabel();
    private final JTextField txtPhone = new JTextField();

    private JTable table;
    private final JPanel panel = new JPanel();

    private final JButton addButton = new JButton();
    private final JButton delButton = new JButton();
    private final JButton editButton = new JButton();
    private final JButton refButton = new JButton();

    public ListPerson() {
        Border panelBorder = BorderFactory.createMatteBorder(0, 5, 0, 5, new Color(0x555555));
        this.setBorder(panelBorder);
        this.setLayout(new BorderLayout());

        JPanel leftListPersonPanel = new JPanel();
        leftListPersonPanel.setBackground(new Color(0xFFFFFF));
        leftListPersonPanel.setPreferredSize(new Dimension(0, 0));
        this.add(leftListPersonPanel, BorderLayout.CENTER);

        JPanel rightListPersonPanel = new JPanel();
        rightListPersonPanel.setBackground(new Color(0xAAAAAA));
        rightListPersonPanel.setPreferredSize(new Dimension(370, 0));
        this.add(rightListPersonPanel, BorderLayout.EAST);

        JPanel btmButtonBookPanel = new JPanel();
        btmButtonBookPanel.setBackground(new Color(0x555555));
        btmButtonBookPanel.setPreferredSize(new Dimension(0, 60));
        this.add(btmButtonBookPanel, BorderLayout.SOUTH);

        //

        rightListPersonPanel.setLayout(null); // new BorderLayout()

        lblIDPerson.setText("Mã độc giả");
        lblIDPerson.setFont(new Font("Arial", Font.PLAIN, 16));
        lblIDPerson.setBounds(new Rectangle(5, 5, 360, 30));
        rightListPersonPanel.add(lblIDPerson);

        txtIDPerson.setFont(new Font("Arial", Font.PLAIN, 16));
        txtIDPerson.setBounds(new Rectangle(5, 40, 360, 30));
        rightListPersonPanel.add(txtIDPerson);

        lblNamePerson.setText("Tên độc giả");
        lblNamePerson.setFont(new Font("Arial", Font.PLAIN, 16));
        lblNamePerson.setBounds(new Rectangle(5, 80, 360, 30));
        rightListPersonPanel.add(lblNamePerson);

        txtNamePerson.setFont(new Font("Arial", Font.PLAIN, 15));
        txtNamePerson.setBounds(new Rectangle(5, 115, 360, 30));
        rightListPersonPanel.add(txtNamePerson);

        lblAddress.setText("Địa chỉ");
        lblAddress.setFont(new Font("Arial", Font.PLAIN, 16));
        lblAddress.setBounds(new Rectangle(5, 155, 360, 30));
        rightListPersonPanel.add(lblAddress);

        txtAddress.setFont(new Font("Arial", Font.PLAIN, 16));
        txtAddress.setBounds(new Rectangle(5, 190, 360, 30));
        rightListPersonPanel.add(txtAddress);

        lblEmail.setText("Email");
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        lblEmail.setBounds(new Rectangle(5, 230, 360, 30));
        rightListPersonPanel.add(lblEmail);

        txtEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        txtEmail.setBounds(new Rectangle(5, 265, 360, 30));
        rightListPersonPanel.add(txtEmail);

        lblPhone.setText("Số điện thoại");
        lblPhone.setFont(new Font("Arial", Font.PLAIN, 16));
        lblPhone.setBounds(new Rectangle(5, 305, 360, 30));
        rightListPersonPanel.add(lblPhone);

        txtPhone.setFont(new Font("Arial", Font.PLAIN, 16));
        txtPhone.setBounds(new Rectangle(5, 340, 360, 30));
        rightListPersonPanel.add(txtPhone);

        //

        btmButtonBookPanel.setLayout(null);

        JButton personButton = new JButton();
        personButton.setText("Độc giả");
        personButton.addActionListener(this);
        personButton.setFont(new Font("Arial", Font.BOLD, 16));
        personButton.setBounds(new Rectangle(0, 5, 150, 50));
        personButton.setEnabled(false);
        btmButtonBookPanel.add(personButton);

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

        leftListPersonPanel.setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 0, 0);
		leftListPersonPanel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(this);
        table.setFont(new Font("Arial", Font.PLAIN, 16));
		scrollPane.setViewportView(table);

        //

        columns.add("Mã độc giả");
		columns.add("Tên độc giả");
		columns.add("Địa chỉ");
		columns.add("Email");
		columns.add("Số điện thoại");
		
		getAllNguoiMuon();

        //

        this.setVisible(true);
    }

    public void getAllNguoiMuon() {
		Model.setRowCount(0);

		ArrayList<Person> ls = pmn.getListNguoiMuon();
		for (int i = 0; i < ls.size(); i++) {
			Person s = (Person) ls.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(s.getMaNguoiMuon());
			tbRow.add(s.getTenNguoiMuon());
			tbRow.add(s.getDiaChi());
			tbRow.add(s.getGmail());
			tbRow.add(s.getSDT());	
			rows.add(tbRow);
		}
		Model.setDataVector(rows, columns);
		table.setModel(Model);
	}

	public void insertNguoiMuon(String MaNguoiMuon, String TenNguoiMuon, String DiaChi, String Gmail, String SDT) {
		Model.setRowCount(0);
		if (pmn.insertNguoiMuon(MaNguoiMuon.trim(), TenNguoiMuon.trim(), DiaChi.trim(), Gmail.trim(), SDT.trim()) == true) {
			ArrayList<Person> ls = pmn.getListNguoiMuon();
			for (int i = 0; i < ls.size(); i++) {
				Person s = (Person) ls.get(i);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(s.getMaNguoiMuon());
				tbRow.add(s.getTenNguoiMuon());
				tbRow.add(s.getDiaChi());
				tbRow.add(s.getGmail());
				tbRow.add(s.getSDT());	
				rows.add(tbRow);
			}
			Model.setDataVector(rows, columns);
			table.setModel(Model);
		} else {
			getAllNguoiMuon();
		}
	}

	public void updateNguoiMuon(String MaNguoiMuon, String TenNguoiMuon, String DiaChi,String Gmail, String SDT) {
		Model.setRowCount(0);
		if (pmn.updateNguoiMuon(MaNguoiMuon, TenNguoiMuon, DiaChi, Gmail, SDT) == true) {
			ArrayList<Person> ls = pmn.getListNguoiMuon();
			for(int i = 0; i< ls.size(); i++) {
				Person s = (Person) ls.get(i);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(s.getMaNguoiMuon());
				tbRow.add(s.getTenNguoiMuon());
				tbRow.add(s.getDiaChi());
				tbRow.add(s.getGmail());
				tbRow.add(s.getSDT());
				rows.add(tbRow);
			}
			Model.setDataVector(rows, columns);
			table.setModel(Model);
		}
	}

	public void delNguoiMuon(String MaNguoiMuon) {
		Model.setRowCount(0);
		if (pmn.delNguoiMuon(MaNguoiMuon) == true) {
			ArrayList<Person> ls = pmn.getListNguoiMuon();
			for(int i = 0; i<ls.size(); i++) {
				Person s = (Person) ls.get(i);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(s.getMaNguoiMuon());
				tbRow.add(s.getTenNguoiMuon());
				tbRow.add(s.getDiaChi());
				tbRow.add(s.getGmail());
				tbRow.add(s.getSDT());
				rows.add(tbRow);
			}
			Model.setDataVector(rows, columns);
			table.setModel(Model);
		}
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            if (txtIDPerson.getText().equals("")  || txtNamePerson.getText().equals("") || txtAddress.getText().equals("") || txtEmail.getText().equals("") || txtPhone.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin" , "Thông báo", 1);
            } else {
				insertNguoiMuon(txtIDPerson.getText(), txtNamePerson.getText(), txtAddress.getText(), txtEmail.getText(), txtPhone.getText());
				txtAddress.setText("");
				txtEmail.setText("");
				txtPhone.setText("");
				txtNamePerson.setText("");
				txtIDPerson.setText("");
            }
        }

        if (e.getSource() == delButton) {
            int n = JOptionPane.showConfirmDialog(panel, "Bạn muốn xóa?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                delNguoiMuon(txtIDPerson.getText());
                txtIDPerson.setEnabled(true);
                txtEmail.setText(null);
                txtAddress.setText(null);
                txtIDPerson.setText(null);
                txtPhone.setText(null);
                txtNamePerson.setText(null);
                editButton.setEnabled(false);
                delButton.setEnabled(false);
            }
        }

        if (e.getSource() == editButton) {
            int n = JOptionPane.showConfirmDialog(panel, "Bạn muốn sửa?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                updateNguoiMuon(txtIDPerson.getText(), txtNamePerson.getText(), txtAddress.getText(), txtEmail.getText(), txtPhone.getText());
            }
        }

        if (e.getSource() == refButton) {
            addButton.setEnabled(true);
            editButton.setEnabled(false);
            delButton.setEnabled(false);
            txtIDPerson.setEnabled(true);
            getAllNguoiMuon();
            txtEmail.setText(null);
            txtAddress.setText(null);
            txtIDPerson.setText(null);
            txtPhone.setText(null);
            txtNamePerson.setText(null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == table) {
            addButton.setEnabled(false);
            delButton.setEnabled(true);
            editButton.setEnabled(true);
            txtIDPerson.setEnabled(false);
            int index = table.getSelectedRow();

            txtIDPerson.setText((String)(Model.getValueAt(index, 0)));
            txtNamePerson.setText((String)(Model.getValueAt(index, 1)));
            txtAddress.setText((String)(Model.getValueAt(index, 2)));
            txtEmail.setText((String)(Model.getValueAt(index, 3)));
            txtPhone.setText((String)(Model.getValueAt(index, 4)));
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
