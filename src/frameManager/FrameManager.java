package frameManager;

import java.util.HashMap;
import middlewareManager.*;
import middlewareManager.middlewares.*;
import java.awt.*;
import javax.swing.*;
import frameManager.APanel;
import config.Config;
import elementManager.elements.SmallBall;
import frameManager.panels.*;

public class FrameManager extends JFrame{
    HashMap<String, APanel> aPanels = new HashMap<String, APanel>();
    APanel activePanel;

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

        aPanels.put("main", mainPanel);
        aPanels.put("menu", menuPanel);
        aPanels.put("game", gamePanel);
        // aPanels.put("game", );
        add(mainPanel);
        mainPanel.add(menuPanel);
        mainPanel.add(gamePanel);

        setActivePanel("main");
        getAPanel("main").setVisible(true);
        getAPanel("menu").setVisible(false);
        getAPanel("game").setVisible(true);

        setVisible(true);
    }

    public void addMiddlewares() {
        MiddlewareManager middlewareManager = Config.getMiddlewareManager();

        Middleware repaintPanelElements = new RepaintPanelElements(getAPanel("menu"));
        MiddlewareLocation middlewareLocation = new MiddlewareLocation();
        middlewareManager.addMiddleware(repaintPanelElements, middlewareLocation);

        Middleware transitionPanels = new TransitionPanels("game", "menu");
        MiddlewareLocation transitionPanelsLocation = new MiddlewareLocation();
        middlewareManager.addMiddleware(transitionPanels, transitionPanelsLocation);

        // Middleware drawSmallBall = new DrawSmallBall(getAPanel("game"));
        // MiddlewareLocation drawSmallBaLocation = new MiddlewareLocation();
        // middlewareManager.addMiddleware(drawSmallBall, drawSmallBaLocation);
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
