package middlewareManager.middlewares;

import config.Config;
import elementManager.ElementManager;
import elementManager.elements.Element;
import middlewareManager.MiddlewareLocation;
import middlewareManager.MiddlewareManager;
import utils.Tools;

import java.util.ArrayList;

public class CheckImpact extends Middleware {
    ElementManager elementManager = Config.getElementManager();
    MiddlewareManager middleWareManager;
    ArrayList<Element> rotatingSmallBalls;
    ArrayList<Element> shootingSmallBalls;

    public CheckImpact() {
        super("checkInterSection");
    }

    public boolean checkIfClashed(Element rotatingSB, Element shootingSB) {
        int impactRange = Config.getSpinningCircleRadius()*2;
        int distance = (int)Tools.getTwoPointDistance(
                rotatingSB.getPosition().getX(),
                rotatingSB.getPosition().getY(),
                shootingSB.getPosition().getX(),
                shootingSB.getPosition().getY());
        return distance < impactRange;
    }

    public void run() {
        rotatingSmallBalls = elementManager.getElementsByGroup("rotatingSmallBalls");
        shootingSmallBalls = elementManager.getElementsByGroup("shootingSmallBalls");

        for (Element rotatingSB : rotatingSmallBalls)
            for (Element shootingSB : shootingSmallBalls)
                if (checkIfClashed(rotatingSB, shootingSB)) {
                    Middleware gameOver = new GameOver();
                    middleWareManager = Config.getMiddlewareManager();
                    middleWareManager.addMiddleware(gameOver, new MiddlewareLocation());
                    this.remove();
                }
    }
}
