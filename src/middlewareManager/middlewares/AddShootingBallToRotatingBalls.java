package middlewareManager.middlewares;

import config.Config;
import elementManager.ElementManager;
import elementManager.elements.Element;

public class AddShootingBallToRotatingBalls extends Middleware {
    int numberOfAllRotatingSmallBalls = Integer.parseInt(this.getValue("numOfAllBalls"));
    ElementManager elementManager = Config.getElementManager();
    Element shootingSB;

    public AddShootingBallToRotatingBalls(Element shootingSB) {
        super("addShootingBallsToRotatingBalls");
        this.shootingSB = shootingSB; // getting shooting small ball from CheckImpact class.
                                      // this is the ball that is shot;
    }

    @Override
    public void init() {
        shootingSB.leave("shootingSmallBalls"); // removing the shot ball form its group.
        shootingSB.join("rotatingSmallBalls"); // joining the shooting ball using join method in Element class.
        this.remove(); // after doing so, this middleware will remove itself from loop.
    }
}
