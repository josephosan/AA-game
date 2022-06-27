package frameManager.panels;

import frameManager.APanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LoginPanel extends APanel {
    JTextField nameInput;
    JButton startGame;
    JLabel loginLabel;
    private int toLeft = -5;


    public LoginPanel(String id) {
        super(id);
        setBackground(Color.lightGray);
        setLayout(null);

        // setting text for BIG LABEL:
        loginLabel = new JLabel();
        loginLabel.setText("Login");
        loginLabel.setFont(new Font("serif", Font.PLAIN, 30));
        loginLabel.setSize(new Dimension(100, 40));
        loginLabel.setBounds(toLeft+168, 200, 80, 40);

        // setting input field for entering name:
        nameInput = new JTextField(5);
        nameInput.setBorder(new EmptyBorder(10, 10, 10, 10));
        nameInput.setBackground(Color.lightGray);
        nameInput.setText("Your Name Here");
        nameInput.setFont(new Font("serif", Font.ITALIC, 18));
        nameInput.setBounds(toLeft+100, 270, 210, 40);



        // setting up start button:
        startGame = new JButton();
        startGame.setBorder(null);
        startGame.setText("Start");
        startGame.setBackground(Color.lightGray);
        startGame.setFocusable(false);
        startGame.setBounds(toLeft+155, 400, 115, 40);
        startGame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startGame.setBackground(Color.gray);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startGame.setBackground(Color.lightGray);
                repaint();
            }
        });
        startGame.addActionListener(e -> {

        });



        add(loginLabel);
        add(nameInput);
        add(startGame);


        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.gray);
        g2d.fillRect(toLeft+100, 310, 210, 3);


        g2d.setColor(Color.gray);
        g2d.drawRoundRect(toLeft+154, 399, 116, 41, 10, 10);
    }
}
