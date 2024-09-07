package Gobrary;

import Gobrary.GCombo.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

import Gobrary.GIcon.*;

public class Application extends JFrame implements ActionListener {
    public static final JButton panelHomeButton = new JButton();
    public static final JButton panelBookButton = new JButton();
    public static final JButton panelAccountButton = new JButton();

    // private final JButton userButton = new JButton();
    // private final JButton outButton = new JButton();

    private final JPanel sideBarPanel = new JPanel();
    private final JPanel contentPanel = new JPanel();

    private final HomePanel homePanel = new HomePanel();
    private final BookPanel bookPanel = new BookPanel();
    private final AccountPanel accountPanel = new AccountPanel();

    // private final JPanel centerHomePanel = new JPanel();
    // private final JPanel centerBookPanel = new JPanel();
    // private final JPanel centerAccountPanel = new JPanel();

    public Application() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1280, 720));
        this.setLocationRelativeTo(null);
        // this.setLayout(null);
        this.setTitle("Gobrary");

        ////

        sideBarPanel.setBackground(new Color(0xAAAAAA));
        sideBarPanel.setPreferredSize(new Dimension(200, 720));
        this.add(sideBarPanel, BorderLayout.WEST);

        contentPanel.setBackground(new Color(0x555555));
        contentPanel.setPreferredSize(new Dimension(1080, 720));
        this.add(contentPanel, BorderLayout.CENTER);

        ////

        sideBarPanel.setVisible(true);
        sideBarPanel.setLayout(null);

        JLabel appLogo = new JLabel();
        appLogo.setText("  Gobrary");
        appLogo.setIcon(GIcon.iconLogo);
        appLogo.setBounds(new Rectangle(5, 5, 190, 70));
        appLogo.setFont(new Font("Arial", Font.BOLD, 20));
        appLogo.setVisible(true);
        sideBarPanel.add(appLogo);

        panelHomeButton.addActionListener(this);
        panelHomeButton.setBounds(new Rectangle(5, 80, 190, 50));
        panelHomeButton.setIcon(GIcon.iconHome);
        panelHomeButton.setText("Trang chủ");
        panelHomeButton.setFont(new Font("Arial", Font.PLAIN, 14));
        panelHomeButton.setFocusable(false);
        panelHomeButton.setHorizontalAlignment(JButton.LEFT);
        // panelHomeButton.setHorizontalTextPosition(JButton.LEFT);
        // panelHomeButton.setVerticalTextPosition(JButton.CENTER);
        panelHomeButton.setForeground(new Color(0x000000));
        panelHomeButton.setBackground(new Color(0xFFFFFF));
        // panelHomeButton.setBorder(null);
        // panelHomeButton.setOpaque(true);
        panelHomeButton.setEnabled(false);
        sideBarPanel.add(panelHomeButton); // , BorderLayout.NORTH, GridLayout.class

        panelBookButton.addActionListener(this);
        panelBookButton.setBounds(new Rectangle(5, 135, 190, 50)); // 130
        panelBookButton.setIcon(GIcon.iconBlock);
        panelBookButton.setText("Quản lý");
        panelBookButton.setFont(new Font("Arial", Font.PLAIN, 14));
        panelBookButton.setFocusable(false);
        panelBookButton.setHorizontalAlignment(JButton.LEFT);
        // panelBookButton.setHorizontalTextPosition(JButton.CENTER);
        // panelBookButton.setVerticalTextPosition(JButton.CENTER);
        panelBookButton.setForeground(new Color(0x000000));
        panelBookButton.setBackground(new Color(0xFFFFFF));
        // panelBookButton.setBorder(null);
        // panelBookButton.setOpaque(true);
        panelBookButton.setEnabled(false);
        sideBarPanel.add(panelBookButton); // , BorderLayout.CENTER

        panelAccountButton.addActionListener(this);
        panelAccountButton.setBounds(new Rectangle(5, 190, 190, 50)); // 180
        panelAccountButton.setIcon(GIcon.iconAccount);
        panelAccountButton.setText("Tài khoản");
        panelAccountButton.setFont(new Font("Arial", Font.PLAIN, 14));
        panelAccountButton.setFocusable(false);
        panelAccountButton.setHorizontalAlignment(JButton.LEFT);
        // panelAccountButton.setHorizontalTextPosition(JButton.CENTER);
        // panelAccountButton.setVerticalTextPosition(JButton.CENTER);
        panelAccountButton.setForeground(new Color(0x000000));
        panelAccountButton.setBackground(new Color(0xFFFFFF));
        // panelAccountButton.setBorder(null);
        // panelAccountButton.setOpaque(true);
        panelAccountButton.setEnabled(false);
        sideBarPanel.add(panelAccountButton); // , BorderLayout.SOUTH


        ////////

        // Border centerPanelBorder = BorderFactory.createMatteBorder(0, 5, 0, 5, new Color(0x555555));

        contentPanel.setLayout(new BorderLayout());
        // contentPanel.setBorder(centerPanelBorder);
        contentPanel.setVisible(true);

        ////

        //

        ////

        //

        ////

        //

        ////

        // contentPanel.add(homePanel);
        // contentPanel.add(bookPanel);
        contentPanel.add(accountPanel);
        homePanel.setVisible(false);
        bookPanel.setVisible(false);
        accountPanel.setVisible(true);

        ////////

        this.setVisible(true);
    }

    private static ImageIcon resizeImage(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image modify = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(modify);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelHomeButton) {
            panelHomeButton.setEnabled(false);
            panelBookButton.setEnabled(true);
            panelAccountButton.setEnabled(true);
            // this.dispose();  // close before window
            contentPanel.add(homePanel);
            contentPanel.remove(bookPanel);
            contentPanel.remove(accountPanel);
            contentPanel.repaint();

            homePanel.setVisible(true);
            bookPanel.setVisible(false);
            accountPanel.setVisible(false);
        } else if (e.getSource() == panelBookButton) {
            panelHomeButton.setEnabled(true);
            panelBookButton.setEnabled(false);
            panelAccountButton.setEnabled(true);
            // this.dispose();  // close before windows
            contentPanel.remove(homePanel);
            contentPanel.add(bookPanel);
            contentPanel.remove(accountPanel);
            contentPanel.repaint();

            homePanel.setVisible(false);
            bookPanel.setVisible(true);
            accountPanel.setVisible(false);
        } else if (e.getSource() == panelAccountButton) {
            panelHomeButton.setEnabled(true);
            panelBookButton.setEnabled(true);
            panelAccountButton.setEnabled(false);
            // this.dispose();  // close before windows
            contentPanel.remove(homePanel);
            contentPanel.remove(bookPanel);
            contentPanel.add(accountPanel);
            contentPanel.repaint();

            homePanel.setVisible(false);
            bookPanel.setVisible(false);
            accountPanel.setVisible(true);
        }
    }


    public static void main(String[] args) {
        new Application();
    }
}
