package frameManager.panels;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import config.Config;
import frameManager.APanel;
import middlewareManager.*;
import middlewareManager.middlewares.*;

public class LevelPanel extends APanel {
    MiddlewareManager middlewareManager = Config.getMiddlewareManager();
    private Color backgroundColor = new Color(0xd48a98);
    private Color buttonsColor = new Color(0x32ff98);
    ArrayList<JButton> buttons = new ArrayList<JButton>();

    public LevelPanel(String id){
        super(id);
        this.setBackground(backgroundColor);
        // JLabel title = new JLabel("LEVELS");
        // title.setBounds(100, 25, 200, 50);
        // title.setVerticalAlignment(JLabel.CENTER);
        // title.setHorizontalAlignment(JLabel.CENTER);
        // title.setFont(new Font("Inconsolata",Font.PLAIN,32));
        // title.setForeground(new Color(0x000000));

        ImageIcon returnIcon = new ImageIcon("src/Icons/return.png");
        ImageIcon level1Icon = new ImageIcon("src/Icons/1.png");
        ImageIcon level2Icon = new ImageIcon("src/Icons/2.png");
        ImageIcon level3Icon = new ImageIcon("src/Icons/3.png");
        ImageIcon level4Icon = new ImageIcon("src/Icons/4.png");
        ImageIcon level5Icon = new ImageIcon("src/Icons/5.png");
        ImageIcon level6Icon = new ImageIcon("src/Icons/6.png");
        ImageIcon level7Icon = new ImageIcon("src/Icons/7.png");
        ImageIcon level8Icon = new ImageIcon("src/Icons/8.png");
        ImageIcon level9Icon = new ImageIcon("src/Icons/9.png");
        ImageIcon level10Icon = new ImageIcon("src/Icons/10.png");
        JButton level1 = new JButton();
        JButton level2 = new JButton();
        JButton level3 = new JButton();
        JButton level4 = new JButton();
        JButton level5 = new JButton();
        JButton level6 = new JButton();
        JButton level7 = new JButton();
        JButton level8 = new JButton();
        JButton level9 = new JButton();
        JButton level10 = new JButton();
        JButton returnButton = new JButton();
      
        //Adding to ArrayList
        buttons.add(level1);
        buttons.add(level2);
        buttons.add(level3);
        buttons.add(level4);
        buttons.add(level5);
        buttons.add(level6);
        buttons.add(level7);
        buttons.add(level8);
        buttons.add(level9);
        buttons.add(level10);
        buttons.add(returnButton);

        //Bounds
        level1.setBounds(75, 100, 75, 75);
        level2.setBounds(75, 200, 75, 75);
        level3.setBounds(75, 300, 75, 75);
        level4.setBounds(75, 400, 75, 75);
        level5.setBounds(75, 500, 75, 75);
        level6.setBounds(250, 100, 75, 75);
        level7.setBounds(250, 200, 75, 75);
        level8.setBounds(250, 300, 75, 75);
        level9.setBounds(250, 400, 75, 75);
        level10.setBounds(250, 500, 75, 75);
        returnButton.setBounds(275, 25, 50, 50);

        //ActionListener
        //TODO Load levels through ActionListener methods
        level1.addActionListener(e -> {
            System.out.println("Load lvl");
            middlewareManager.addMiddleware(new TransitionPanels("levels", "game"), new MiddlewareLocation());
            });

        level2.addActionListener(e ->{
            middlewareManager.addMiddleware(new TransitionPanels("levels", "game"), new MiddlewareLocation());
            middlewareManager.addMiddleware(new LoadGame(2), new MiddlewareLocation());
            middlewareManager.addMiddleware(new DrawBigBall(200,200,"menu"), new MiddlewareLocation());
            middlewareManager.addMiddleware(new SpinSmallBalls(), new MiddlewareLocation());
            middlewareManager.addMiddleware(new DrawLine("menu"), new MiddlewareLocation());
            });

        level3.addActionListener(e ->{
            System.out.println("Load lvl");
            middlewareManager.addMiddleware(new TransitionPanels("levels", "game"), new MiddlewareLocation());
            });

        level4.addActionListener(e ->{
            System.out.println("Load lvl");
            middlewareManager.addMiddleware(new TransitionPanels("levels", "game"), new MiddlewareLocation());
            });

        level5.addActionListener(e ->{
            System.out.println("Load lvl");
            middlewareManager.addMiddleware(new TransitionPanels("levels", "game"), new MiddlewareLocation());
            });

        level6.addActionListener(e ->{
            System.out.println("Load lvl");
            middlewareManager.addMiddleware(new TransitionPanels("levels", "game"), new MiddlewareLocation());
            });

        level7.addActionListener(e ->{
            System.out.println("Load lvl");
            middlewareManager.addMiddleware(new TransitionPanels("levels", "game"), new MiddlewareLocation());
            });

        level8.addActionListener(e ->{
            System.out.println("Load lvl");
            middlewareManager.addMiddleware(new TransitionPanels("levels", "game"), new MiddlewareLocation());
            });

        level9.addActionListener(e ->{
            System.out.println("Load lvl");
            middlewareManager.addMiddleware(new TransitionPanels("levels", "game"), new MiddlewareLocation());
            });

        level10.addActionListener(e ->{
            System.out.println("Load lvl");
            middlewareManager.addMiddleware(new TransitionPanels("levels", "game"), new MiddlewareLocation());
            });

        returnButton.addActionListener(e ->{
            middlewareManager.addMiddleware(new TransitionPanels("levels", "menu"), new MiddlewareLocation());
            });

        //Set Values
        for(JButton b: buttons){
            b.setBackground(buttonsColor);
            b.setBorder(BorderFactory.createEtchedBorder(buttonsColor,buttonsColor));
            b.setFocusable(false);
            this.add(b);
        }

        //set Icons
        returnButton.setIcon(returnIcon);
        level1.setIcon(level1Icon);
        level2.setIcon(level2Icon);
        level3.setIcon(level3Icon);
        level4.setIcon(level4Icon);
        level5.setIcon(level5Icon);
        level6.setIcon(level6Icon);
        level7.setIcon(level7Icon);
        level8.setIcon(level8Icon);
        level9.setIcon(level9Icon);
        level10.setIcon(level10Icon);
       
    }
}
