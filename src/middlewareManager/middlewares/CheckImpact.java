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
    MiddlewareManager middleWareManager  = Config.getMiddlewareManager();
    ArrayList<Element> rotatingSmallBalls;
    ArrayList<Element> shootingSmallBalls;

    public CheckImpact() {
        super("checkInterSection");
    }

    public boolean checkIfClashed(Element rotatingSB, Element shootingSB) { // checking if balls had impacted.
        int impactRange = Config.getBigCircleRadios()*2; // impact range is 2*smallCircleRadios
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
                if (checkIfClashed(rotatingSB, shootingSB)) { // if two balls clashed end the game
                    Middleware gameOver = new GameOver();     // by adding the gameOver class to middlewareManager.
                    middleWareManager.addMiddleware(gameOver, new MiddlewareLocation());
                    this.remove();
                } else { // if not add the ball to rotating balls by adding checkInterSection to middlewareManager.
                    Middleware checkInterSection = new CheckInterSection();
                    middleWareManager.addMiddleware(checkInterSection, new MiddlewareLocation());
                }
    }
}
