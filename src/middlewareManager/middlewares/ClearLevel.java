package middlewareManager.middlewares;

import elementManager.ElementManager;
import frameManager.FrameManager;
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
        frameManager.getAPanel("game").setBackground(new Color(0x6ae7f8));
        elementManager.removeElementsByGroup("game");
        middlewareManager.removeMiddlewaresByGroup("game");

        this.remove();
    }
}
