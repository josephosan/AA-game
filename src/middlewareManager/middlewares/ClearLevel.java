package middlewareManager.middlewares;

import elementManager.ElementManager;
import middlewareManager.MiddlewareManager;
import config.Config;

public class ClearLevel extends Middleware{
    public ClearLevel() {
        super("clearLevel");
    }

    @Override
    public void init() {
        ElementManager elementManager = Config.getElementManager();
        MiddlewareManager middlewareManager = Config.getMiddlewareManager();

        elementManager.removeElementsByGroup("game");
        middlewareManager.removeMiddlewaresByGroup("game");

        this.remove();
    }
}
