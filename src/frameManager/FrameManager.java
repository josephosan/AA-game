package frameManager;

import java.util.HashMap;
import middlewareManager.*;
import middlewareManager.middlewares.*;
import java.awt.*;
import javax.swing.*;

import config.Config;
import frameManager.panels.*;

public class FrameManager extends JFrame{
    HashMap<String, APanel> aPanels = new HashMap<String, APanel>();
    APanel activePanel;

        // this method will call when all the components of app 
    // getting accessible from the Config
    public void onConfigSubscribe() {

        


    }

    public FrameManager() {
        // Implement the frame;
        setLayout(null);
        pack();
        Insets insets = getInsets();
        setSize(
            new Dimension(
                (insets.left + insets.right + Config.getFrameWidth()), 
                (insets.bottom + insets.top + Config.getFrameHeight())
            )
        );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        APanel mainPanel = new MainPanel("mainPanel");
        APanel menuPanel = new MenuPanel("menuPanel");
        APanel gamePanel = new GamePanel("gamePanel");
        APanel pausePanel = new PausePanel("pausePanel");
        APanel levelPanel = new LevelPanel("levelPanel");
        APanel loginPanel = new LoginPanel("loginPanel");
        APanel gameOverPanel = new GameOverPanel("gameOverPanel");


        gamePanel.setPaintOrder("lines>*");

        aPanels.put("main", mainPanel);
        aPanels.put("menu", menuPanel);
        aPanels.put("game", gamePanel);
        aPanels.put("levels",levelPanel);
        aPanels.put("pause", pausePanel);
        aPanels.put("login", loginPanel);
        aPanels.put("gameOver", gameOverPanel);
        // aPanels.put("game", );
        add(mainPanel);
        mainPanel.add(menuPanel);
        mainPanel.add(gamePanel);
        mainPanel.add(pausePanel);
        mainPanel.add(levelPanel);
        mainPanel.add(loginPanel);
        mainPanel.add(gameOverPanel);

        setActivePanel("menu");
        getAPanel("main").setVisible(true);
        getAPanel("menu").setVisible(false);
        getAPanel("game").setVisible(false);
        getAPanel("pause").setVisible(false);
        getAPanel("levels").setVisible(false);
        getAPanel("login").setVisible(false);
        getAPanel("gameOver").setVisible(false);

        setVisible(true);
    }

    public void addMiddlewares() {
        
    }

    public APanel getAPanel(String id) {
        return aPanels.get(id);
    }

    public APanel getActivePanel() {
        return activePanel;
    }

    public void setActivePanel(String id) {
        activePanel = aPanels.get(id);
    }
}
