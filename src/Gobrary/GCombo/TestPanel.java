package Gobrary.GCombo;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

import Gobrary.GIcon.*;

public class TestPanel extends JPanel implements ActionListener {
    // private final JPanel topButtonBookPanel = new JPanel();
    // private final JPanel btmButtonBookPanel = new JPanel();
    // private final JPanel centerBookPanel = new JPanel();
    private final JButton listBookButton = new JButton();
    private final JButton listPersonButton = new JButton();
    private final JButton listFormButton = new JButton();
    private final JButton statisticButton = new JButton();
    // private final JButton borBookButton = new JButton();
    // private final JButton rtnBookButton = new JButton();
    // private final JButton addBookButton = new JButton();
    // private final JButton delBookButton = new JButton();

    public TestPanel() {
        //

        this.setLayout(new BorderLayout());

        // private final JButton borBookButton = new JButton();
        // private final JButton rtnBookButton = new JButton();
        // private final JButton addBookButton = new JButton();
        // private final JButton delBookButton = new JButton();
        JPanel topButtonBookPanel = new JPanel();
        topButtonBookPanel.setBackground(new Color(0x555555));
        topButtonBookPanel.setPreferredSize(new Dimension(1080, 60));
        this.add(topButtonBookPanel, BorderLayout.NORTH);

        JPanel btmButtonBookPanel = new JPanel();
        btmButtonBookPanel.setBackground(new Color(0x555555));
        btmButtonBookPanel.setPreferredSize(new Dimension(1080, 60));
        this.add(btmButtonBookPanel, BorderLayout.SOUTH);

        JPanel centerBookPanel = new JPanel();
        centerBookPanel.setBackground(new Color(0x5500FF));
        centerBookPanel.setPreferredSize(new Dimension(1080, 20));
        this.add(centerBookPanel, BorderLayout.CENTER);

        //

        this.setLayout(new BorderLayout());

        topButtonBookPanel.setBackground(new Color(0x555555));
        topButtonBookPanel.setPreferredSize(new Dimension(1080, 60));
        this.add(topButtonBookPanel, BorderLayout.NORTH);

        btmButtonBookPanel.setBackground(new Color(0x555555));
        btmButtonBookPanel.setPreferredSize(new Dimension(1080, 60));
        this.add(btmButtonBookPanel, BorderLayout.SOUTH);

        centerBookPanel.setBackground(new Color(0x5500FF));
        centerBookPanel.setPreferredSize(new Dimension(1080, 20));
        this.add(centerBookPanel, BorderLayout.CENTER);

        //

        topButtonBookPanel.setLayout(null);

        listBookButton.addActionListener(this);
        listBookButton.setBounds(new Rectangle(5, 5, 150, 50));
        listBookButton.setIcon(GIcon.iconList);
        listBookButton.setText("List Book");
        listBookButton.setFont(new Font("Arial", Font.BOLD, 16));
        listBookButton.setFocusable(true);
        listBookButton.setHorizontalAlignment(JButton.LEFT);
        // listBookButton.setHorizontalTextPosition(JButton.LEFT);
        // listBookButton.setVerticalTextPosition(JButton.CENTER);
        // listBookButton.setForeground(getForeground());
        // listBookButton.setBackground(new Color(0xFF00AA));
        // listBookButton.setBorder(null);
        // listBookButton.setEnabled(false);
        topButtonBookPanel.add(listBookButton); // , BorderLayout.NORTH

        listPersonButton.addActionListener(this);
        listPersonButton.setBounds(new Rectangle(160, 5, 150, 50));
        listPersonButton.setIcon(GIcon.iconGive);
        listPersonButton.setText("List Person");
        listPersonButton.setFont(new Font("Arial", Font.BOLD, 16));
        listPersonButton.setFocusable(true);
        listPersonButton.setHorizontalAlignment(JButton.LEFT);
        // listPersonButton.setHorizontalTextPosition(JButton.LEFT);
        // listPersonButton.setVerticalTextPosition(JButton.CENTER);
        // listPersonButton.setForeground(getForeground());
        // listPersonButton.setBackground(new Color(0xFF00AA));
        // listPersonButton.setBorder(null);
        // listPersonButton.setEnabled(false);
        topButtonBookPanel.add(listPersonButton); // , BorderLayout.NORTH

        listFormButton.addActionListener(this);
        listFormButton.setBounds(new Rectangle(315, 5, 150, 50));
        listFormButton.setIcon(GIcon.iconRtn);
        listFormButton.setText("List Form");
        listFormButton.setFont(new Font("Arial", Font.BOLD, 16));
        listFormButton.setFocusable(true);
        listFormButton.setHorizontalAlignment(JButton.LEFT);
        // listFormButton.setHorizontalTextPosition(JButton.LEFT);
        // listFormButton.setVerticalTextPosition(JButton.CENTER);
        // listFormButton.setForeground(getForeground());
        // listFormButton.setBackground(new Color(0xFF00AA));
        // listFormButton.setBorder(null);
        // listFormButton.setEnabled(false);
        topButtonBookPanel.add(listFormButton); // , BorderLayout.NORTH

        statisticButton.addActionListener(this);
        statisticButton.setBounds(new Rectangle(470, 5, 150, 50));
        statisticButton.setIcon(GIcon.iconAdd);
        statisticButton.setText("Statistic");
        statisticButton.setFont(new Font("Arial", Font.BOLD, 16));
        statisticButton.setFocusable(true);
        statisticButton.setHorizontalAlignment(JButton.LEFT);
        // statisticButton.setHorizontalTextPosition(JButton.LEFT);
        // statisticButton.setVerticalTextPosition(JButton.CENTER);
        // statisticButton.setForeground(getForeground());
        // statisticButton.setBackground(new Color(0xFF00AA));
        // statisticButton.setBorder(null);
        // statisticButton.setEnabled(false);
        topButtonBookPanel.add(statisticButton); // , BorderLayout.NORTH

        //

        Border centerPanelBorder = BorderFactory.createMatteBorder(0, 5, 0, 5, new Color(0x555555));
        centerBookPanel.setBorder(centerPanelBorder);
        centerBookPanel.setVisible(true);

        //
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
