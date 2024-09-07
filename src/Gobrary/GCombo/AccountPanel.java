package Gobrary.GCombo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import Gobrary.Application;
import Gobrary.GIcon.*;
import Gobrary.GProcess.*;

public class AccountPanel extends JPanel implements ActionListener {
    // private final JPanel topButtonAccountPanel = new JPanel();
    // private final JPanel btmButtonAccountPanel = new JPanel();
    // private final JPanel centerAccountPanel = new JPanel();
    private final JPanel centerAccountPanel = new JPanel();
    private final JButton personButton = new JButton();
    private final JButton signInButton = new JButton();
    private final JButton signUpButton = new JButton();
    private final JButton signOutButton = new JButton();

    DataBaseProcess cd = new DataBaseProcess();
    private final JPanel dangnhap = new JPanel();
    private final JTextField username = new JTextField();
    private final JPasswordField password = new JPasswordField();
    private final JButton buttonDangnhap = new JButton();

    public AccountPanel() {
        //

        this.setLayout(new BorderLayout());

        JPanel topButtonAccountPanel = new JPanel();
        topButtonAccountPanel.setBackground(new Color(0x555555));
        topButtonAccountPanel.setPreferredSize(new Dimension(1080, 60));
        this.add(topButtonAccountPanel, BorderLayout.NORTH);

        JPanel btmButtonAccountPanel = new JPanel();
        btmButtonAccountPanel.setBackground(new Color(0x555555));
        btmButtonAccountPanel.setPreferredSize(new Dimension(1080, 60));
        this.add(btmButtonAccountPanel, BorderLayout.SOUTH);

        // JPanel centerAccountPanel = new JPanel();
        centerAccountPanel.setBackground(new Color(0xFFFFFF));
        centerAccountPanel.setPreferredSize(new Dimension(1080, 20));
        this.add(centerAccountPanel, BorderLayout.CENTER);

        //

        topButtonAccountPanel.setLayout(null);

        
        personButton.addActionListener(this);
        personButton.setBounds(new Rectangle(5, 5, 150, 50));
        personButton.setIcon(GIcon.iconAccount);
        personButton.setText("Account");
        personButton.setFont(new Font("Arial", Font.BOLD, 16));
        personButton.setFocusable(true);
        personButton.setHorizontalAlignment(JButton.LEFT);
        // personButton.setHorizontalTextPosition(JButton.LEFT);
        // personButton.setVerticalTextPosition(JButton.CENTER);
        // personButton.setForeground(getForeground());
        // personButton.setBackground(new Color(0xFF00AA));
        // personButton.setBorder(null);
        // personButton.setEnabled(false);
        topButtonAccountPanel.add(personButton); // , BorderLayout.NORTH

        
        signInButton.addActionListener(this);
        signInButton.setBounds(new Rectangle(160, 5, 150, 50));
        signInButton.setIcon(GIcon.iconBor);
        signInButton.setText("Sign in");
        signInButton.setFont(new Font("Arial", Font.BOLD, 16));
        signInButton.setFocusable(true);
        signInButton.setHorizontalAlignment(JButton.LEFT);
        // signInButton.setHorizontalTextPosition(JButton.LEFT);
        // signInButton.setVerticalTextPosition(JButton.CENTER);
        // signInButton.setForeground(getForeground());
        // signInButton.setBackground(new Color(0xFF00AA));
        // signInButton.setBorder(null);
        // signInButton.setEnabled(false);
        // topButtonAccountPanel.add(signInButton); // , BorderLayout.NORTH

        
        signUpButton.addActionListener(this);
        signUpButton.setBounds(new Rectangle(315, 5, 150, 50));
        signUpButton.setIcon(GIcon.iconRtn);
        signUpButton.setText("Sign up");
        signUpButton.setFont(new Font("Arial", Font.BOLD, 16));
        signUpButton.setFocusable(true);
        signUpButton.setHorizontalAlignment(JButton.LEFT);
        // signUpButton.setHorizontalTextPosition(JButton.LEFT);
        // signUpButton.setVerticalTextPosition(JButton.CENTER);
        // signUpButton.setForeground(getForeground());
        // signUpButton.setBackground(new Color(0xFF00AA));
        // signUpButton.setBorder(null);
        // signUpButton.setEnabled(false);
        // topButtonAccountPanel.add(signUpButton); // , BorderLayout.NORTH

        //

        btmButtonAccountPanel.setLayout(null);

        
        signOutButton.addActionListener(this);
        signOutButton.setBounds(new Rectangle(5, 5, 150, 50));
        signOutButton.setIcon(GIcon.iconAccount);
        signOutButton.setText("Sign out");
        signOutButton.setFont(new Font("Arial", Font.BOLD, 16));
        signOutButton.setFocusable(true);
        signOutButton.setHorizontalAlignment(JButton.LEFT);
        // signOutButton.setHorizontalTextPosition(JButton.LEFT);
        // signOutButton.setVerticalTextPosition(JButton.CENTER);
        // signOutButton.setForeground(getForeground());
        // signOutButton.setBackground(new Color(0xFF00AA));
        // signOutButton.setBorder(null);
        signOutButton.setEnabled(false);
        btmButtonAccountPanel.add(signOutButton); // , BorderLayout.NORTH

        //

        Border centerPanelBorder = BorderFactory.createMatteBorder(0, 5, 0, 5, new Color(0x555555));
        centerAccountPanel.setBorder(centerPanelBorder);
        centerAccountPanel.setVisible(true);

        //

        dangnhap.setPreferredSize(new Dimension(370,500));
        dangnhap.setBackground(new Color(0xAAAAAA));
        dangnhap.setLayout(null);
        centerAccountPanel.add(dangnhap);

        JLabel lblUsername = new JLabel();
        lblUsername.setText("Tài khoản");
        lblUsername.setFont(new Font("Arial", Font.PLAIN, 16));
        lblUsername.setBounds(new Rectangle(5, 5, 360, 30));
        dangnhap.add(lblUsername);

        username.setBounds(new Rectangle(5,40, 360, 30));
        username.setFont(new Font("Arial", Font.PLAIN, 16));
        dangnhap.add(username);

        JLabel lblPassword = new JLabel();
        lblPassword.setText("Mật khẩu");
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 16));
        lblPassword.setBounds(new Rectangle(5, 80, 360, 30));
        dangnhap.add(lblPassword);

        password.setBounds(new Rectangle(5,115, 360, 30));
        password.setFont(new Font("Arial", Font.PLAIN, 16));
        dangnhap.add(password);

        //

        buttonDangnhap.setText("Đăng nhập");
        buttonDangnhap.addActionListener(this);
        buttonDangnhap.setFont(new Font("Arial", Font.BOLD, 16));
        buttonDangnhap.setBounds(new Rectangle(5, 200, 360, 30));
        buttonDangnhap.setEnabled(true);
        dangnhap.add(buttonDangnhap);

        //

        this.setVisible(true);
    }

    public void login(String user, String pass) {
        StringBuffer sb = new StringBuffer();
        if (user.length() == 0) {
            sb.append("Tài khoản không được để trống\n");
        }
        if (pass.length() == 0) {
            sb.append("Mật khẩu không được để trống");
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString());
        }
        if (cd.login(user, pass)) {
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Đăng nhập thất bại");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonDangnhap) {
            // login(username.getText().trim(), password.getText());
            String user = username.getText().trim();
            String pass = password.getText();

            StringBuffer sb = new StringBuffer();
            if (user.length() == 0) {
                sb.append("Tài khoản không được để trống\n");
            }
            if (pass.length() == 0) {
                sb.append("Mật khẩu không được để trống");
            }
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
            }
            if (cd.login(user, pass)) {
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
                signOutButton.setEnabled(true);
                Application.panelHomeButton.setEnabled(true);
                Application.panelBookButton.setEnabled(true);

                dangnhap.setVisible(false);
                centerAccountPanel.remove(dangnhap);
            } else {
                JOptionPane.showMessageDialog(this, "Đăng nhập thất bại");
            }

            // signOutButton.setEnabled(true);
            // Application.panelHomeButton.setEnabled(true);
            // Application.panelBookButton.setEnabled(true);

            // dangnhap.setVisible(false);
            // centerAccountPanel.remove(dangnhap);
        }

        if (e.getSource() == signOutButton) {
            signOutButton.setEnabled(false);
            Application.panelHomeButton.setEnabled(false);
            Application.panelBookButton.setEnabled(false);

            centerAccountPanel.add(dangnhap);
            dangnhap.setVisible(true);
        }
    }
}
