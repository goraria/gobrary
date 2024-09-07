package Gobrary;

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
import Gobrary.GPanel.*;

public class Demo extends JFrame {
    Demo() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1280, 720));
        this.setLocationRelativeTo(null);
        // this.setLayout(null);
        this.setTitle("Japtor Goraria el Destinia Ichibulup de Gortheia");

        Statistic bug = new Statistic();
        this.add(bug);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Demo();
    }
}
