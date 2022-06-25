package middlewareManager.middlewares;

import config.Config;
import elementManager.ElementManager;
import elementManager.elements.Element;

public class AddShootingBallToRotatingBalls extends Middleware {
    int numberOfAllRotatingSmallBalls = 20; //TODO get numberOfAllBalls as a variable
    ElementManager elementManager = Config.getElementManager();
    Element shootingSB;

    public AddShootingBallToRotatingBalls(Element shootingSB) {
        super("checkInterSection");
        this.shootingSB = shootingSB;
    }

    public void run() {
        shootingSB.leave("shootingSmallBalls");

        shootingSB.setId("smallBall"+(numberOfAllRotatingSmallBalls -elementManager.getElementsByGroup("rotatingSmallBalls").size()));
        shootingSB.join("rotatingSmallBalls");
        this.remove();
    }
}
