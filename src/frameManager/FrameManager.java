package frameManager;

import java.util.HashMap;
import middlewareManager.*;
import middlewareManager.middlewares.*;
import java.awt.*;
import javax.swing.*;
import frameManager.APanel;
import config.Config;
import elementManager.elements.BigBall;
import elementManager.elements.SmallBall;
import frameManager.panels.*;

public class FrameManager extends JFrame{
    HashMap<String, APanel> aPanels = new HashMap<String, APanel>();
    APanel activePanel;

        // this method will call when all the components of app 
    // getting accessible from the Config
    public void onConfigSubscribe() {
        MiddlewareManager middlewareManager = Config.getMiddlewareManager();

        Middleware repaintPanelElements = new RepaintPanelElements(getAPanel("menu"));
        MiddlewareLocation middlewareLocation = new MiddlewareLocation();
        middlewareManager.addMiddleware(repaintPanelElements, middlewareLocation);

        Middleware transitionPanels = new TransitionPanels("game", "menu");
        MiddlewareLocation transitionPanelsLocation = new MiddlewareLocation();
        middlewareManager.addMiddleware(transitionPanels, transitionPanelsLocation);
        
        middlewareManager.addMiddleware(new DrawBigBall("200","200","0x000000","menu"), new MiddlewareLocation());
        middlewareManager.addMiddleware(new DrawSmallBall("0","0x000000","menu"), new MiddlewareLocation());
        middlewareManager.addMiddleware(new DrawSmallBall("30","0x000000","menu"), new MiddlewareLocation());
        middlewareManager.addMiddleware(new DrawSmallBall("60","0x000000","menu"), new MiddlewareLocation());
        middlewareManager.addMiddleware(new DrawSmallBall("90","0x000000","menu"), new MiddlewareLocation());
        middlewareManager.addMiddleware(new DrawSmallBall("120","0x000000","menu"), new MiddlewareLocation());
        middlewareManager.addMiddleware(new DrawSmallBall("150","0x000000","menu"), new MiddlewareLocation());
        middlewareManager.addMiddleware(new DrawSmallBall("180","0x000000","menu"), new MiddlewareLocation());
        middlewareManager.addMiddleware(new DrawSmallBall("210","0x000000","menu"), new MiddlewareLocation());
        middlewareManager.addMiddleware(new DrawSmallBall("240","0x000000","menu"), new MiddlewareLocation());
        middlewareManager.addMiddleware(new DrawSmallBall("270","0x000000","menu"), new MiddlewareLocation());
        middlewareManager.addMiddleware(new DrawSmallBall("300","0x000000","menu"), new MiddlewareLocation());
        middlewareManager.addMiddleware(new DrawSmallBall("330","0x000000","menu"), new MiddlewareLocation());
        middlewareManager.addMiddleware(new SpinSmallBalls(), new MiddlewareLocation());
        middlewareManager.addMiddleware(new AnimatedRotaion(), new MiddlewareLocation());
        middlewareManager.addMiddleware(new DrawLine("menu"), new MiddlewareLocation());

        
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
        // MiddlewareManager middlewareManager = Config.getMiddlewareManager();

        // Middleware repaintPanelElements = new RepaintPanelElements(getAPanel("menu"));
        // MiddlewareLocation middlewareLocation = new MiddlewareLocation();
        // middlewareManager.addMiddleware(repaintPanelElements, middlewareLocation);

        // Middleware transitionPanels = new TransitionPanels("game", "menu");
        // MiddlewareLocation transitionPanelsLocation = new MiddlewareLocation();
        // middlewareManager.addMiddleware(transitionPanels, transitionPanelsLocation);

        //Following middlewares are just for test
        //TODO remove this middlewares in production

       

        //middlewareManager.addMiddleware(new LoadGame(2), new MiddlewareLocation());
        // middlewareManager.addMiddleware(new DrawSmallBall("0","menu"), new MiddlewareLocation());
        // middlewareManager.addMiddleware(new DrawSmallBall("90","menu"), new MiddlewareLocation());
        // middlewareManager.addMiddleware(new DrawSmallBall("270","menu"), new MiddlewareLocation());
        //middlewareManager.addMiddleware(new DrawLine("menu"), new MiddlewareLocation());
        
//         Middleware drawSmallBall = new DrawSmallBall(getAPanel("menu"));
//         MiddlewareLocation drawSmallBaLocation = new MiddlewareLocation();
//         middlewareManager.addMiddleware(drawSmallBall, drawSmallBaLocation);
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
