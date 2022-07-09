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

public class PausePanel extends APanel{
    MiddlewareManager middlewareManager = Config.getMiddlewareManager();
    FrameManager frameManager = Config.getFrameManager();
    ArrayList<JButton> buttons = new ArrayList<JButton>();
    private Color backgroundColor = new Color(0xd48a98);
    private Color buttonsColor = new Color(0x32ff98);
    private Color buttonBorderColor = new Color(0x2a6a7b);


    public PausePanel(String id){
        super(id);
        this.setBackground(backgroundColor);


        JButton resumeButton = new JButton();
        JButton menuButton = new JButton();
        JButton retryButton = new JButton();

        buttons.add(resumeButton);
        buttons.add(menuButton);
        buttons.add(retryButton);

        //Bounds
        resumeButton.setBounds(25, 25, 75, 75);
        menuButton.setBounds(150, 225, 100, 75);
        retryButton.setBounds(150, 350, 100, 75);

        //Icons
        resumeButton.setIcon(new ImageIcon("src/Icons/X.png"));
        menuButton.setIcon(new ImageIcon("src/Icons/menu.png"));
        retryButton.setIcon(new ImageIcon("src/Icons/retry.png"));

        //ActionListener
        resumeButton.addActionListener(e -> {
            middlewareManager.addMiddleware(new middlewareManager.middlewares.Pause("game", false), new MiddlewareLocation());
            middlewareManager.addMiddleware(new TransitionPanels("pause", "game",false), new MiddlewareLocation());
            });
        
        menuButton.addActionListener(e -> {

            middlewareManager.addMiddleware(new TransitionPanels("pause", "menu",false), new MiddlewareLocation());
            });

        retryButton.addActionListener(e -> {
            //TODO  add retry lvl functionalit
            middlewareManager.addMiddleware(new ClearLevel(), new MiddlewareLocation());
            middlewareManager.addMiddleware(new TransitionPanels("pause", "game"), new MiddlewareLocation());
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

        



    }

    
}
