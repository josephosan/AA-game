package middlewareManager.middlewares;

import config.Config;
import elementManager.ElementManager;
import elementManager.elements.BigBall;
import utils.Tools;

public class OsMaker extends Middleware {
    ElementManager elementManager = Config.getElementManager();



    public OsMaker() {
        super("osMaker");

    }

    public void run() {
        BigBall bigBall = (BigBall)elementManager.getElementById("bigBall");
        bigBall.setOsSize(50, 50);
        bigBall.setOsPosition(170+Tools.generatRandomPositiveNegitiveValue(10, 0), 180+Tools.generatRandomPositiveNegitiveValue(0, 10));
    }
}
