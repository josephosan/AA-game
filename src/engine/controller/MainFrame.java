package engine.controller;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 600);
        add(new GamePanel());
        setVisible(true);
    }
}

