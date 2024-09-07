package Gobrary.GCombo;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

import Gobrary.GIcon.*;

public class HomePanel extends JPanel implements ActionListener {
    // private final JPanel topButtonHomePanel = new JPanel();
    // private final JPanel btmButtonHomePanel = new JPanel();
    // private final JPanel centerHomePanel = new JPanel();
    public HomePanel() {
        //

        this.setLayout(new BorderLayout());

        JPanel topButtonHomePanel = new JPanel();
        topButtonHomePanel.setBackground(new Color(0x555555));
        topButtonHomePanel.setPreferredSize(new Dimension(1080, 60));
        this.add(topButtonHomePanel, BorderLayout.NORTH);

        JPanel btmButtonHomePanel = new JPanel();
        btmButtonHomePanel.setBackground(new Color(0x555555));
        btmButtonHomePanel.setPreferredSize(new Dimension(1080, 60));
        this.add(btmButtonHomePanel, BorderLayout.SOUTH);

        JPanel centerHomePanel = new JPanel();
        centerHomePanel.setBackground(new Color(0xFF00AA));
        centerHomePanel.setPreferredSize(new Dimension(1080, 20));
        this.add(centerHomePanel, BorderLayout.CENTER);

        //

        topButtonHomePanel.setLayout(null);

        JButton corporationButton = new JButton();
        corporationButton.addActionListener(this);
        corporationButton.setBounds(new Rectangle(5, 5, 150, 50));
        corporationButton.setIcon(GIcon.iconCorp);
        corporationButton.setText("Gorth Inc.");
        corporationButton.setFont(new Font("Arial", Font.BOLD, 16));
        corporationButton.setFocusable(true);
        corporationButton.setHorizontalAlignment(JButton.LEFT);
        // corporationButton.setHorizontalTextPosition(JButton.LEFT);
        // corporationButton.setVerticalTextPosition(JButton.CENTER);
        // corporationButton.setForeground(getForeground());
        // corporationButton.setBackground(new Color(0xFF00AA));
        // corporationButton.setBorder(null);
        // corporationButton.setEnabled(false);
        topButtonHomePanel.add(corporationButton); // , BorderLayout.NORTH

        //

        btmButtonHomePanel.setLayout(null);

        JButton devJaptorButton = new JButton();
        devJaptorButton.addActionListener(this);
        devJaptorButton.setBounds(new Rectangle(5, 5, 150, 50));
        devJaptorButton.setIcon(GIcon.iconJaptor);
        devJaptorButton.setText("Giang Pham"); // Founder
        devJaptorButton.setFont(new Font("Arial", Font.BOLD, 16));
        devJaptorButton.setFocusable(true);
        devJaptorButton.setHorizontalAlignment(JButton.LEFT);
        // devJaptorButton.setHorizontalTextPosition(JButton.LEFT);
        // devJaptorButton.setVerticalTextPosition(JButton.CENTER);
        // devJaptorButton.setForeground(getForeground());
        // devJaptorButton.setBackground(new Color(0xFF00AA));
        // devJaptorButton.setBorder(null);
        // devJaptorButton.setEnabled(false);
        btmButtonHomePanel.add(devJaptorButton); // , BorderLayout.NORTH

        JButton devPayHDButton = new JButton();
        devPayHDButton.addActionListener(this);
        devPayHDButton.setBounds(new Rectangle(160, 5, 150, 50));
        devPayHDButton.setIcon(GIcon.iconPayHD);
        devPayHDButton.setText("Phan Anh"); // Leader
        devPayHDButton.setFont(new Font("Arial", Font.BOLD, 16));
        devPayHDButton.setFocusable(true);
        devPayHDButton.setHorizontalAlignment(JButton.LEFT);
        // devPayHDButton.setHorizontalTextPosition(JButton.LEFT);
        // devPayHDButton.setVerticalTextPosition(JButton.CENTER);
        // devPayHDButton.setForeground(getForeground());
        // devPayHDButton.setBackground(new Color(0xFF00AA));
        // devPayHDButton.setBorder(null);
        // devPayHDButton.setEnabled(false);
        btmButtonHomePanel.add(devPayHDButton); // , BorderLayout.NORTH

        JButton devHoiButton = new JButton();
        devHoiButton.addActionListener(this);
        devHoiButton.setBounds(new Rectangle(315, 5, 150, 50));
        devHoiButton.setIcon(GIcon.iconHoi);
        devHoiButton.setText("Quoc Hoi");
        devHoiButton.setFont(new Font("Arial", Font.BOLD, 16));
        devHoiButton.setFocusable(true);
        devHoiButton.setHorizontalAlignment(JButton.LEFT);
        // devHoiButton.setHorizontalTextPosition(JButton.LEFT);
        // devHoiButton.setVerticalTextPosition(JButton.CENTER);
        // devHoiButton.setForeground(getForeground());
        // devHoiButton.setBackground(new Color(0xFF00AA));
        // devHoiButton.setBorder(null);
        // devHoiButton.setEnabled(false);
        btmButtonHomePanel.add(devHoiButton); // , BorderLayout.NORTH

        //

        Border centerPanelBorder = BorderFactory.createMatteBorder(0, 5, 0, 5, new Color(0x555555));
        centerHomePanel.setBorder(centerPanelBorder);
        centerHomePanel.setLayout(new BorderLayout());

        JLabel topCopyright = new JLabel();
        topCopyright.setText("Welcome to Gobrary");
        topCopyright.setFont(new Font("Arial", Font.BOLD, 32));
        topCopyright.setPreferredSize(new Dimension(0, 72));
        topCopyright.setHorizontalTextPosition(JLabel.CENTER);
        topCopyright.setVerticalTextPosition(JLabel.CENTER);
        topCopyright.setVerticalAlignment(JLabel.CENTER);
        topCopyright.setHorizontalAlignment(JLabel.CENTER);
        topCopyright.setBackground(new Color(0xAAAAAA));
        topCopyright.setForeground(new Color(0xFFFFFF));
        topCopyright.setOpaque(true);
        centerHomePanel.add(topCopyright, BorderLayout.NORTH);

        JLabel btmCopyright = new JLabel();
        btmCopyright.setText("Powered by Gorth Inc. Copyright © 2020 - 2024 Gorth Inc. All rights reserved.");
        btmCopyright.setFont(new Font("Arial", Font.PLAIN, 20));
        btmCopyright.setPreferredSize(new Dimension(0, 60));
        btmCopyright.setHorizontalTextPosition(JLabel.CENTER);
        btmCopyright.setVerticalTextPosition(JLabel.CENTER);
        btmCopyright.setVerticalAlignment(JLabel.CENTER);
        btmCopyright.setHorizontalAlignment(JLabel.CENTER);
        btmCopyright.setBackground(new Color(0xAAAAAA));
        btmCopyright.setForeground(new Color(0xFFFFFF));
        btmCopyright.setOpaque(true);
        centerHomePanel.add(btmCopyright, BorderLayout.SOUTH);
        
        JLabel centerContent = new JLabel();
        // centerContent.setText("");
        // centerContent.setFont(new Font("Arial", Font.PLAIN, 20));
        // centerContent.setPreferredSize(new Dimension(0, 0));
        // centerContent.setHorizontalTextPosition(JLabel.CENTER);
        // centerContent.setVerticalTextPosition(JLabel.CENTER);
        // centerContent.setVerticalAlignment(JLabel.CENTER);
        // centerContent.setHorizontalAlignment(JLabel.CENTER);
        // centerContent.setBackground(new Color(0x555555));
        // centerContent.setForeground(new Color(0xFFFFFF));
        centerContent.setOpaque(true);
        centerHomePanel.add(centerContent, BorderLayout.CENTER);

        //

        centerContent.setLayout(new GridLayout(1, 3));

        JPanel centerLeftContent = new JPanel();
        centerLeftContent.setBackground(new Color(0xFF00AA));
        centerLeftContent.setOpaque(true);
        centerLeftContent.setLayout(new BorderLayout());
        centerContent.add(centerLeftContent, GridLayout.class);

        JLabel leftLabel = new JLabel();
        leftLabel.setText("Japtor");
        leftLabel.setFont(new Font("Arial", Font.BOLD, 32));
        leftLabel.setPreferredSize(new Dimension(0, 0));
        leftLabel.setHorizontalTextPosition(JLabel.CENTER);
        leftLabel.setVerticalTextPosition(JLabel.CENTER);
        leftLabel.setVerticalAlignment(JLabel.CENTER);
        leftLabel.setHorizontalAlignment(JLabel.CENTER);
        // leftLabel.setBackground(new Color(0x555555));
        leftLabel.setForeground(new Color(0xFFFFFF));
        // leftLabel.setOpaque(true);
        centerLeftContent.add(leftLabel);

        JPanel centerCenterContent = new JPanel();
        centerCenterContent.setBackground(new Color(0xAA00FF));
        centerCenterContent.setOpaque(true);
        centerCenterContent.setLayout(new BorderLayout());
        centerContent.add(centerCenterContent, GridLayout.class);

        JLabel centerLabel = new JLabel();
        centerLabel.setText("PayHD");
        centerLabel.setFont(new Font("Arial", Font.BOLD, 32));
        centerLabel.setPreferredSize(new Dimension(0, 0));
        centerLabel.setHorizontalTextPosition(JLabel.CENTER);
        centerLabel.setVerticalTextPosition(JLabel.CENTER);
        centerLabel.setVerticalAlignment(JLabel.CENTER);
        centerLabel.setHorizontalAlignment(JLabel.CENTER);
        // centerLabel.setBackground(new Color(0x555555));
        centerLabel.setForeground(new Color(0xFFFFFF));
        // centerLabel.setOpaque(true);
        centerCenterContent.add(centerLabel);

        JPanel centerRightContent = new JPanel();
        centerRightContent.setBackground(new Color(0x55AAFF));
        centerRightContent.setOpaque(true);
        centerRightContent.setLayout(new BorderLayout());
        centerContent.add(centerRightContent, GridLayout.class);

        JLabel rightLabel = new JLabel();
        rightLabel.setText("Draco");
        rightLabel.setFont(new Font("Arial", Font.BOLD, 32));
        rightLabel.setPreferredSize(new Dimension(0, 0));
        rightLabel.setHorizontalTextPosition(JLabel.CENTER);
        rightLabel.setVerticalTextPosition(JLabel.CENTER);
        rightLabel.setVerticalAlignment(JLabel.CENTER);
        rightLabel.setHorizontalAlignment(JLabel.CENTER);
        // rightLabel.setBackground(new Color(0x555555));
        rightLabel.setForeground(new Color(0xFFFFFF));
        // rightLabel.setOpaque(true);
        centerRightContent.add(rightLabel);


        // ImageIcon background = GIcon.resizeImage(new ImageIcon("./img/theme.png"), 1280, 720);
        // centerContent.setIcon(background);




        //
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
