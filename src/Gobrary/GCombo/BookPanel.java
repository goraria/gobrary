package Gobrary.GCombo;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

import Gobrary.GIcon.*;
import Gobrary.GPanel.*;

public class BookPanel extends JPanel implements ActionListener {
    // private final JPanel topButtonBookPanel = new JPanel();
    // private final JPanel btmButtonBookPanel = new JPanel();
    // private final JPanel centerBookPanel = new JPanel();
    // private final JButton borBookButton = new JButton();
    // private final JButton rtnBookButton = new JButton();
    // private final JButton addBookButton = new JButton();
    // private final JButton delBookButton = new JButton();
    private final JButton listTypeButton = new JButton();
    private final JButton listBookButton = new JButton();
    private final JButton listPersonButton = new JButton();
    private final JButton listFormButton = new JButton();
    private final JButton statisticButton = new JButton();
    private final ListBook listBookPanel = new ListBook();
    private final ListType listTypePanel = new ListType();
    private final ListPerson listPersonPanel = new ListPerson();
    private final ListForm listFormPanel = new ListForm();
    private final Statistic statisticPanel = new Statistic();
    // private final Test statisticPanel = new Test();

    public BookPanel() {
        //

        this.setLayout(new BorderLayout());

        // private final JButton borBookButton = new JButton();
        // private final JButton rtnBookButton = new JButton();
        // private final JButton addBookButton = new JButton();
        // private final JButton delBookButton = new JButton();
        JPanel topButtonBookPanel = new JPanel();
        topButtonBookPanel.setBackground(new Color(0x555555));
        topButtonBookPanel.setPreferredSize(new Dimension(0, 60));
        this.add(topButtonBookPanel, BorderLayout.NORTH);

        // JPanel btmButtonBookPanel = new JPanel();
        // btmButtonBookPanel.setBackground(new Color(0x555555));
        // btmButtonBookPanel.setPreferredSize(new Dimension(0, 60));
        // this.add(btmButtonBookPanel, BorderLayout.SOUTH);

        JPanel centerBookPanel = new JPanel();
        centerBookPanel.setBackground(new Color(0x5500FF));
        centerBookPanel.setPreferredSize(new Dimension(0, 0));
        this.add(centerBookPanel, BorderLayout.CENTER);

        //

        topButtonBookPanel.setLayout(null);

        listTypeButton.addActionListener(this);
        listTypeButton.setBounds(new Rectangle(5, 5, 150, 50));
        listTypeButton.setIcon(GIcon.iconSnip);
        listTypeButton.setText("Đầu sách");
        listTypeButton.setFont(new Font("Arial", Font.BOLD, 16));
        listTypeButton.setFocusable(true);
        listTypeButton.setHorizontalAlignment(JButton.LEFT);
        // listTypeButton.setHorizontalTextPosition(JButton.LEFT);
        // listTypeButton.setVerticalTextPosition(JButton.CENTER);
        // listTypeButton.setForeground(getForeground());
        // listTypeButton.setBackground(new Color(0xFF00AA));
        // listTypeButton.setBorder(null);
        // listTypeButton.setEnabled(false);
        topButtonBookPanel.add(listTypeButton); // , BorderLayout.NORTH

        listBookButton.addActionListener(this);
        listBookButton.setBounds(new Rectangle(160, 5, 150, 50));
        listBookButton.setIcon(GIcon.iconBook);
        listBookButton.setText("Sách mượn");
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
        listPersonButton.setBounds(new Rectangle(315, 5, 150, 50));
        listPersonButton.setIcon(GIcon.iconMember);
        listPersonButton.setText("Độc giả");
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
        listFormButton.setBounds(new Rectangle(470, 5, 150, 50));
        listFormButton.setIcon(GIcon.iconForm);
        listFormButton.setText("Phiếu mượn");
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
        statisticButton.setBounds(new Rectangle(625, 5, 150, 50));
        statisticButton.setIcon(GIcon.iconInfo);
        statisticButton.setText("Tìm kiếm");
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
        centerBookPanel.setLayout(new BorderLayout());

        ////
        
        listBookButton.setEnabled(true);
        listTypeButton.setEnabled(true);
        listPersonButton.setEnabled(true);
        listFormButton.setEnabled(true);
        statisticButton.setEnabled(false);

        // this.remove(listBookPanel);
        // this.remove(listTypePanel);
        // this.remove(listPersonPanel);
        // this.remove(listFormPanel);
        this.add(statisticPanel);

        listBookPanel.setVisible(false);
        listTypePanel.setVisible(false);
        listPersonPanel.setVisible(false);
        listFormPanel.setVisible(false);
        statisticPanel.setVisible(true);

        ////

        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == listBookButton) {
            listBookButton.setEnabled(false);
            listTypeButton.setEnabled(true);
            listPersonButton.setEnabled(true);
            listFormButton.setEnabled(true);
            statisticButton.setEnabled(true);

            this.add(listBookPanel);
            this.remove(listTypePanel);
            this.remove(listPersonPanel);
            this.remove(listFormPanel);
            this.remove(statisticPanel);

            listBookPanel.setVisible(true);
            listTypePanel.setVisible(false);
            listPersonPanel.setVisible(false);
            listFormPanel.setVisible(false);
            statisticPanel.setVisible(false);

        } else if (e.getSource() == listTypeButton) {
            listBookButton.setEnabled(true);
            listTypeButton.setEnabled(false);
            listPersonButton.setEnabled(true);
            listFormButton.setEnabled(true);
            statisticButton.setEnabled(true);

            this.remove(listBookPanel);
            this.add(listTypePanel);
            this.remove(listPersonPanel);
            this.remove(listFormPanel);
            this.remove(statisticPanel);

            listBookPanel.setVisible(false);
            listTypePanel.setVisible(true);
            listPersonPanel.setVisible(false);
            listFormPanel.setVisible(false);
            statisticPanel.setVisible(false);

        } else if (e.getSource() == listPersonButton) {
            listBookButton.setEnabled(true);
            listTypeButton.setEnabled(true);
            listPersonButton.setEnabled(false);
            listFormButton.setEnabled(true);
            statisticButton.setEnabled(true);

            this.remove(listBookPanel);
            this.remove(listTypePanel);
            this.add(listPersonPanel);
            this.remove(listFormPanel);
            this.remove(statisticPanel);

            listBookPanel.setVisible(false);
            listTypePanel.setVisible(false);
            listPersonPanel.setVisible(true);
            listFormPanel.setVisible(false);
            statisticPanel.setVisible(false);

        } else if (e.getSource() == listFormButton) {
            listBookButton.setEnabled(true);
            listTypeButton.setEnabled(true);
            listPersonButton.setEnabled(true);
            listFormButton.setEnabled(false);
            statisticButton.setEnabled(true);

            this.remove(listBookPanel);
            this.remove(listTypePanel);
            this.remove(listPersonPanel);
            this.add(listFormPanel);
            this.remove(statisticPanel);

            listBookPanel.setVisible(false);
            listTypePanel.setVisible(false);
            listPersonPanel.setVisible(false);
            listFormPanel.setVisible(true);
            statisticPanel.setVisible(false);

        } else if (e.getSource() == statisticButton) {
            listBookButton.setEnabled(true);
            listTypeButton.setEnabled(true);
            listPersonButton.setEnabled(true);
            listFormButton.setEnabled(true);
            statisticButton.setEnabled(false);

            this.remove(listBookPanel);
            this.remove(listTypePanel);
            this.remove(listPersonPanel);
            this.remove(listFormPanel);
            this.add(statisticPanel);

            listBookPanel.setVisible(false);
            listTypePanel.setVisible(false);
            listPersonPanel.setVisible(false);
            listFormPanel.setVisible(false);
            statisticPanel.setVisible(true);
        }
    }
}
