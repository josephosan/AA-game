package frameManager.panels;


import frameManager.APanel;
import frameManager.FrameManager;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import config.Config;
import middlewareManager.middlewares.*;
import middlewareManager.*;

public class GameOverPanel extends APanel {
    MiddlewareManager middlewareManager = Config.getMiddlewareManager();
    FrameManager frameManager = Config.getFrameManager();
    ArrayList<JButton> buttons = new ArrayList<JButton>();
    private Color backgroundColor = new Color(0xed3e44);
    private Color buttonsColor = new Color(0xe32d33);
    private Color buttonBorderColor = new Color(0x30010c);

    public GameOverPanel(String id){
        super(id);
        this.setBackground(backgroundColor);

        JLabel gameOverLabel = new JLabel("Game Over");
        JButton menuButton = new JButton();
        JButton retryButton = new JButton();


        buttons.add(menuButton);
        buttons.add(retryButton);

        //Bounds
        gameOverLabel.setBounds(125, 30, 350, 130);
        menuButton.setBounds(150, 225, 100, 75);
        retryButton.setBounds(150, 350, 100, 75);

        //Icons
        menuButton.setIcon(new ImageIcon("src/Icons/menu.png"));
        retryButton.setIcon(new ImageIcon("src/Icons/retry.png"));

        //ActionListener
        menuButton.addActionListener(e -> {
            middlewareManager.addMiddleware(new TransitionPanels("gameOver", "menu",false), new MiddlewareLocation());
            });

        retryButton.addActionListener(e -> {
            //TODO  add retry lvl functionality
            middlewareManager.removeMiddlewaresByGroup("game");
            middlewareManager.addMiddleware(new TransitionPanels("gameOver", "game"), new MiddlewareLocation());
            middlewareManager.addMiddleware(new LoadGame(Integer.parseInt(middlewareManager.getMiddlewareValue("currentLevel"))), new MiddlewareLocation());
        });

        for(JButton b: buttons){
            b.setBackground(backgroundColor);
            b.setBorder(BorderFactory.createEtchedBorder(buttonBorderColor,buttonBorderColor));
            b.setFocusable(false);
            b.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    b.setBackground(buttonsColor);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    b.setBackground(backgroundColor);
                }
            });
            this.add(b);
        }

        //labels color and font
        gameOverLabel.setForeground(new Color(0x87070b));
        gameOverLabel.setFont(new Font("serif",Font.BOLD,25));

        //adding labels
        this.add(gameOverLabel);
    }
    
}
