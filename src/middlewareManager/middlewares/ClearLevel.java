package middlewareManager.middlewares;

import elementManager.ElementManager;
import frameManager.FrameManager;
import frameManager.panels.GamePanel;
import middlewareManager.MiddlewareManager;
import config.Config;
import middlewareManager.middlewares.*;
import java.awt.*;
public class ClearLevel extends Middleware{
    public ClearLevel() {
        super("clearLevel");
    }

    @Override
    public void init() {
        ElementManager elementManager = Config.getElementManager();
        MiddlewareManager middlewareManager = Config.getMiddlewareManager();
        FrameManager frameManager = Config.getFrameManager();
        DrawSmallBall.n = 0;
        Config.setLineLength(Config.defaultLineLength);
        // gamePanelBackground is set in GamePanel.java constructor
        frameManager.getAPanel("game").setBackground(new Color(Integer.decode(middlewareManager.getMiddlewareValue("gamePanelBackground"))));
        elementManager.removeElementsByGroup("game");
        middlewareManager.removeMiddlewaresByGroup("game");
        
        //to reverse the color changes made to buttons in GamePanel
        GamePanel g = (GamePanel)frameManager.getAPanel("game");
        g.setButtonColor(new Color(Integer.decode(middlewareManager.getMiddlewareValue("gamePanelBackground"))));

        this.remove();
    }
}
