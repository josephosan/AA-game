package frameManager.panels;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.*;

import config.Config;
import frameManager.APanel;
import middlewareManager.*;
import middlewareManager.middlewares.*;
import soundManager.SoundManager;

public class LevelPanel extends APanel {
    MiddlewareManager middlewareManager = Config.getMiddlewareManager();
    private Color backgroundColor = new Color(0xd48a98);
    private Color buttonsColor = new Color(0x32ff98);
//    SoundManager soundManager = Config.getSoundManager();
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
            middlewareManager.addMiddleware(new ClearLevel(), new MiddlewareLocation());
            middlewareManager.setMiddlewareValue("currentLevel", "1");
            middlewareManager.addMiddleware(new TransitionPanels("levels", "game"), new MiddlewareLocation());
            middlewareManager.addMiddleware(new LoadGame(1), new MiddlewareLocation());
//            soundManager.play("levelButtonSound");
            });

        level2.addActionListener(e ->{
            middlewareManager.addMiddleware(new ClearLevel(), new MiddlewareLocation());
            middlewareManager.setMiddlewareValue("currentLevel", "2");
            middlewareManager.addMiddleware(new TransitionPanels("levels", "game"), new MiddlewareLocation());
            middlewareManager.addMiddleware(new LoadGame(2), new MiddlewareLocation());
//            soundManager.play("levelButtonSound");
        });

        level3.addActionListener(e ->{
            middlewareManager.addMiddleware(new ClearLevel(), new MiddlewareLocation());
            middlewareManager.setMiddlewareValue("currentLevel", "3");
            middlewareManager.addMiddleware(new TransitionPanels("levels", "game"), new MiddlewareLocation());
            middlewareManager.addMiddleware(new LoadGame(3), new MiddlewareLocation());
//            soundManager.play("levelButtonSound");
        });

        level4.addActionListener(e ->{
            middlewareManager.addMiddleware(new ClearLevel(), new MiddlewareLocation());
            middlewareManager.setMiddlewareValue("currentLevel", "4");
            middlewareManager.addMiddleware(new TransitionPanels("levels", "game"), new MiddlewareLocation());
            middlewareManager.addMiddleware(new LoadGame(4), new MiddlewareLocation());
//            soundManager.play("levelButtonSound");
        });

        level5.addActionListener(e ->{
            middlewareManager.addMiddleware(new ClearLevel(), new MiddlewareLocation());
            middlewareManager.setMiddlewareValue("currentLevel", "5");
            middlewareManager.addMiddleware(new TransitionPanels("levels", "game"), new MiddlewareLocation());
            middlewareManager.addMiddleware(new LoadGame(5), new MiddlewareLocation());
//            soundManager.play("levelButtonSound");
        });

        level6.addActionListener(e ->{
            middlewareManager.addMiddleware(new ClearLevel(), new MiddlewareLocation());
            middlewareManager.setMiddlewareValue("currentLevel", "6");
            middlewareManager.addMiddleware(new TransitionPanels("levels", "game"), new MiddlewareLocation());
            middlewareManager.addMiddleware(new LoadGame(6), new MiddlewareLocation());
//            soundManager.play("levelButtonSound");
        });

        level7.addActionListener(e ->{
            middlewareManager.addMiddleware(new ClearLevel(), new MiddlewareLocation());
            middlewareManager.setMiddlewareValue("currentLevel", "7");
            middlewareManager.addMiddleware(new TransitionPanels("levels", "game"), new MiddlewareLocation());
            middlewareManager.addMiddleware(new LoadGame(7), new MiddlewareLocation());
//            soundManager.play("levelButtonSound");
        });

        level8.addActionListener(e ->{
            middlewareManager.addMiddleware(new ClearLevel(), new MiddlewareLocation());
            middlewareManager.setMiddlewareValue("currentLevel", "8");
            middlewareManager.addMiddleware(new TransitionPanels("levels", "game"), new MiddlewareLocation());
            middlewareManager.addMiddleware(new LoadGame(8), new MiddlewareLocation());
//            soundManager.play("levelButtonSound");
        });

        level9.addActionListener(e ->{
            middlewareManager.addMiddleware(new ClearLevel(), new MiddlewareLocation());
            middlewareManager.setMiddlewareValue("currentLevel", "9");
            middlewareManager.addMiddleware(new TransitionPanels("levels", "game"), new MiddlewareLocation());
            middlewareManager.addMiddleware(new LoadGame(9), new MiddlewareLocation());
//            soundManager.play("levelButtonSound");
        });

        level10.addActionListener(e ->{
            middlewareManager.addMiddleware(new ClearLevel(), new MiddlewareLocation());
            middlewareManager.setMiddlewareValue("currentLevel", "10");
            middlewareManager.addMiddleware(new TransitionPanels("levels", "game"), new MiddlewareLocation());
            middlewareManager.addMiddleware(new LoadGame(10), new MiddlewareLocation());
//            soundManager.play("levelButtonSound");
        });

        returnButton.addActionListener(e ->{
            middlewareManager.addMiddleware(new TransitionPanels("levels", "menu"), new MiddlewareLocation());
            });

        //Set Values
        for(JButton b: buttons){
            b.setBackground(backgroundColor);
            b.setBorder(BorderFactory.createEmptyBorder());
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

        //set Icons
        returnButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Icons/return.png"))));
        level1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Icons/1.png"))));
        level2.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Icons/2.png"))));
        level3.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Icons/3.png"))));
        level4.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Icons/4.png"))));
        level5.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Icons/5.png"))));
        level6.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Icons/6.png"))));
        level7.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Icons/7.png"))));
        level8.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Icons/8.png"))));
        level9.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Icons/9.png"))));
        level10.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Icons/10.png"))));
        
    }
}
