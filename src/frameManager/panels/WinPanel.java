package frameManager.panels;

import config.Config;
import frameManager.APanel;
import middlewareManager.MiddlewareLocation;
import middlewareManager.MiddlewareManager;
import middlewareManager.middlewares.LevelTimer;
import middlewareManager.middlewares.*;
import utils.Tools;
import utils.parser.AParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;

public class WinPanel extends APanel {
    MiddlewareManager middlewaremanager = Config.getMiddlewareManager();
    JButton nextLevelButton;
    JButton retryButton;
    JButton menuButton;
    JLabel youWon;
    JLabel yourScore;
    int move = 5;
    ArrayList<JButton> buttons = new ArrayList<>();


    public WinPanel(String id) {
        super(id);

        youWon = new JLabel("YOU WON!");
        youWon.setBounds(95, 200, 300, 30);
        youWon.setFont(new Font("serif", Font.BOLD, 40));
        youWon.setForeground(Color.BLACK);

        // adding score label:
        // TODO getting score from score calculator.
        yourScore = new JLabel("Your time: ");
        yourScore.setFont(new Font("serif", Font.ITALIC, 15));
        yourScore.setBounds(150, 300, 300, 30);

        nextLevelButton = new JButton();
        retryButton = new JButton();
        menuButton = new JButton();

        buttons.add(nextLevelButton);
        buttons.add(retryButton);
        buttons.add(menuButton);


        // setting Icon for buttons:
        nextLevelButton.setIcon(new ImageIcon("src/Icons/nextLevel.png"));
        retryButton.setIcon(new ImageIcon("src/Icons/retry.png"));
        menuButton.setIcon(new ImageIcon("src/Icons/menu.png"));


        // setting bound for buttons:
        nextLevelButton.setBounds(move+260, 400, 70, 70);
        retryButton.setBounds(move+160, 400, 70, 70);
        menuButton.setBounds(move+60, 400, 70,  70);

        // action listeners:
        nextLevelButton.addActionListener(e -> {
            middlewaremanager.setMiddlewareValue("currentLevel",
                    (Tools.getWhichLevelWeShouldStartWith(middlewaremanager.getMiddlewareValue("userName")) == 0) ? ""+1
                            : ""+(Tools.getWhichLevelWeShouldStartWith(middlewaremanager.getMiddlewareValue("userName"))+1));
            middlewaremanager.addMiddleware(new ClearLevel(), new MiddlewareLocation());
            middlewaremanager.addMiddleware(new LoadGame(Integer.parseInt(middlewaremanager.getMiddlewareValue("currentLevel"))), new MiddlewareLocation());
            middlewaremanager.addMiddleware(new TransitionPanels("win", "game"), new MiddlewareLocation());
        });

        retryButton.addActionListener(e -> {
            middlewaremanager.addMiddleware(new ClearLevel(), new MiddlewareLocation());
            middlewaremanager.addMiddleware(new LoadGame(Integer.parseInt(middlewaremanager.getMiddlewareValue("levelNumber"))), new MiddlewareLocation());
            middlewaremanager.addMiddleware(new TransitionPanels("win", "game"), new MiddlewareLocation());
        });

        menuButton.addActionListener(e -> {
            middlewaremanager.addMiddleware(new TransitionPanels("win", "menu"), new MiddlewareLocation());
        });


        // additional setting for buttons:
        for(JButton b: buttons){
            b.setBackground(new Color(129, 163, 129, 255));
            b.setBorder(null);
            b.setFocusable(false);
            b.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    b.setBackground(new Color(129, 163, 129, 255));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    b.setBackground(new Color(129, 163, 129, 255));
                }
            });
            this.add(b);
        }


        add(youWon);
        add(yourScore);
        add(nextLevelButton);
        add(retryButton);
        add(menuButton);
        setBackground(new Color(129, 163, 129, 255));

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        String currentUser = middlewaremanager.getMiddlewareValue("userName");
        int currentLevel = Integer.parseInt(middlewaremanager.getMiddlewareValue("levelNumber"));
        Map<String, String> profileInformation = AParser.run("profile/"+currentUser+"Profile.json");
        g.drawString(profileInformation.get("level"+currentLevel)+" s", 230, 320);
    }
}
