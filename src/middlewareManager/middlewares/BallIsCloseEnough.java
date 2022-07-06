package middlewareManager.middlewares;

import config.Config;
import elementManager.coordinate.AaPosition;
import elementManager.elements.Element;
import elementManager.elements.SmallBall;
import middlewareManager.MiddlewareLocation;
import middlewareManager.MiddlewareManager;
import utils.Tools;

public class BallIsCloseEnough extends Middleware {
    private final Element shootingBall;
    private Integer normalConnectionDistance = Integer.valueOf(this.getValue("levelLineLength"));
    private final AaPosition mainCirclePosition = Config.getMainCirclePosition();
    private final MiddlewareManager middlewareManager = Config.getMiddlewareManager();

    public BallIsCloseEnough(Element shootingBall) {
        super("ballIsCloseEnough");
        this.shootingBall = shootingBall;
    }

    public BallIsCloseEnough(String shootingBallId) {
        super("ballIsCloseEnough");
        this.shootingBall = Config.getElementManager().getElementById(shootingBallId);
    }

    public boolean isBallCloseEnough(Element shootingBall) {
        normalConnectionDistance = Integer.valueOf(this.getValue("levelLineLength"));
        double sBallDistanceFromMainCircle = Tools.getTwoPointDistance(
                shootingBall.getPosition().getX(),
                shootingBall.getPosition().getY(),
                mainCirclePosition.getX(),
                mainCirclePosition.getY());
        return normalConnectionDistance >= sBallDistanceFromMainCircle;
    }

    public void run() {
        if (isBallCloseEnough(shootingBall)) {
            //ReloadShootingBall will put a new ball in shooting position.
            middlewareManager.addMiddleware(new ReloadShootingBall(),new MiddlewareLocation());
            //drawing a line for it
            middlewareManager.addMiddleware(new DrawLine(((SmallBall)shootingBall).getNumber()), new MiddlewareLocation());
            // add the ball to rotating balls.
            Tools.AddShootingBallToRotatingBalls((SmallBall)shootingBall);
            this.remove();
        }
    }
}
