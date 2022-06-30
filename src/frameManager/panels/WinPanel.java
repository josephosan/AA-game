package frameManager.panels;

import config.Config;
import frameManager.APanel;
import middlewareManager.MiddlewareLocation;
import middlewareManager.MiddlewareManager;
import middlewareManager.middlewares.LevelTimer;
import middlewareManager.middlewares.TransitionPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class WinPanel extends APanel {
    MiddlewareManager middlewaremanager = Config.getMiddlewareManager();
    Image background = Toolkit.getDefaultToolkit().createImage("src/icons/WinBackground.png");
    JButton nextLevelButton;
    JButton retryButton;
    JButton menuButton;
    JLabel youWon;
    JLabel yourScore;
    int move = 5;
    ArrayList<JButton> buttons = new ArrayList<>();
    private Color backgroundColor = new Color(0xed3e44);
    private Color buttonsColor = new Color(0xe32d33);

    public WinPanel(String id) {
        super(id);

        youWon = new JLabel("YOU WON!");
        youWon.setBounds(95, 200, 300, 30);
        youWon.setFont(new Font("serif", Font.BOLD, 40));
        youWon.setForeground(Color.BLACK);

        // adding score label:
//        int score = LevelTimer.getEndTime(); // TODO calculate score.
        yourScore = new JLabel("Your Score: " + "" + "/10");
        yourScore.setFont(new Font("fuzzyBubbles", Font.ITALIC, 15));
        yourScore.setBounds(140, 300, 300, 30);

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
            middlewaremanager.addMiddleware(new TransitionPanels("win", "game"), new MiddlewareLocation());
        });

        retryButton.addActionListener(e -> {
            middlewaremanager.addMiddleware(new TransitionPanels("win", "game"), new MiddlewareLocation());
        });

        menuButton.addActionListener(e -> {
            middlewaremanager.addMiddleware(new TransitionPanels("win", "menu"), new MiddlewareLocation());
        });


        // additional setting for buttons:
        for(JButton b: buttons){
            b.setBackground(null);
            b.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.black));
            b.setFocusable(false);
            b.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    b.setBackground(Color.green);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    b.setBackground(null);
                }
            });
            this.add(b);
        }


        add(youWon);
        add(yourScore);
        add(nextLevelButton);
        add(retryButton);
        add(menuButton);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, 400, 800, null);
    }
}
