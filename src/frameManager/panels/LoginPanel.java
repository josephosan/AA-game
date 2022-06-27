package frameManager.panels;

import config.Config;
import frameManager.APanel;
import middlewareManager.MiddlewareLocation;
import middlewareManager.MiddlewareManager;
import middlewareManager.middlewares.TransitionPanels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;


public class LoginPanel extends APanel {
    JTextField textField;
    JButton startGame;
    JLabel loginLabel;
    private int toLeft = -5;
    private String nameInput = "";
    MiddlewareManager middlewareManager = Config.getMiddlewareManager();


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
        textField = new JTextField(5);
        textField.setBorder(new EmptyBorder(10, 10, 10, 10));
        textField.setBackground(Color.lightGray);
        textField.setText("Your Name Here");
        textField.setFont(new Font("serif", Font.ITALIC, 18));
        textField.setBounds(toLeft+100, 270, 210, 40);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (textField.getText().length() > 10) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });


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
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startGame.setBackground(Color.lightGray);
            }
        });
        startGame.addActionListener(e -> {
            if (!Objects.equals(textField.getText(), "Your Name Here") && textField.getText().length() != 0) {
                middlewareManager.addMiddleware(new TransitionPanels("login", "menu"), new MiddlewareLocation());
                nameInput = textField.getText();
                textField.setText("");
            }
        });



        add(loginLabel);
        add(textField);
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
