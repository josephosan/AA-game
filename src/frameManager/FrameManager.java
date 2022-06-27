package frameManager;

import java.util.HashMap;
import middlewareManager.*;
import middlewareManager.middlewares.*;
import java.awt.*;
import javax.swing.*;

import config.Config;
import frameManager.APanel;
import frameManager.panels.*;

public class FrameManager extends JFrame{
    HashMap<String, APanel> aPanels = new HashMap<String, APanel>();
    APanel activePanel;

        // this method will call when all the components of app 
    // getting accessible from the Config
    public void onConfigSubscribe() {
        MiddlewareManager middlewareManager = Config.getMiddlewareManager();

        Middleware repaintPanelElements = new RepaintPanelElements(getAPanel("menu"));
        middlewareManager.addMiddleware(repaintPanelElements, new MiddlewareLocation());
        repaintPanelElements.setValue("rotationSpeed", "3");
        repaintPanelElements.setValue("numOfAllBalls", "1");


        Middleware transitionPanels = new TransitionPanels("game", "menu");
        middlewareManager.addMiddleware(transitionPanels, new MiddlewareLocation());

        middlewareManager.addMiddleware(new DrawBigBall("200","200","0x000000","menu"), new MiddlewareLocation());
        middlewareManager.addMiddleware(new DrawSmallBall("0","0x000000","menu"), new MiddlewareLocation());
        middlewareManager.addMiddleware(new SpinSmallBalls(), new MiddlewareLocation());
        middlewareManager.addMiddleware(new DrawLine("game"), new MiddlewareLocation());


        
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
        APanel loginPanel = new LoginPanel("loginPanel");
        APanel levelPanel = new LevelPanel("levelPanel");


        aPanels.put("main", mainPanel);
        aPanels.put("menu", menuPanel);
        aPanels.put("game", gamePanel);
        aPanels.put("levels",levelPanel);
        aPanels.put("login", loginPanel);
        // aPanels.put("game", );
        add(mainPanel);
        mainPanel.add(menuPanel);
        mainPanel.add(gamePanel);
        mainPanel.add(levelPanel);
        mainPanel.add(loginPanel);

        setActivePanel("menu");
        getAPanel("main").setVisible(true);
        getAPanel("menu").setVisible(false);
        getAPanel("game").setVisible(true);
        getAPanel("login").setVisible(false);
        getAPanel("levels").setVisible(false);

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
