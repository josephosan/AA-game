package middlewareManager.middlewares;

import config.Config;
import elementManager.coordinate.AaPosition;
import elementManager.elements.Element;
import middlewareManager.MiddlewareLocation;
import middlewareManager.MiddlewareManager;
import utils.Tools;

public class BallIsCloseEnough extends Middleware {
    private final Element shootingBall;
    private final Integer normalConnectionDistance = Config.getLineLength();
    private final AaPosition mainCirclePosition = Config.getMainCirclePosition();
    private final MiddlewareManager middlewareManager = Config.getMiddlewareManager();

    public BallIsCloseEnough(Element shootingBall) {
        super("ballIsCloseEnough");
        this.shootingBall = shootingBall;
    }

    public BallIsCloseEnough(Element shootingBall, String id) {
        super(id);
        this.shootingBall = shootingBall;
    }

    public boolean isBallCloseEnough(Element shootingBall) {
        double sBallDistanceFromMainCircle = Tools.getTwoPointDistance(
                shootingBall.getPosition().getX(),
                shootingBall.getPosition().getY(),
                mainCirclePosition.getX(),
                mainCirclePosition.getY());

        return normalConnectionDistance >= sBallDistanceFromMainCircle;
    }

    public void run() {
        if (isBallCloseEnough(shootingBall)) {
            // add the ball to rotating balls.
            Middleware addShootingBallToRotatingBalls = new AddShootingBallToRotatingBalls(shootingBall);
            middlewareManager.addMiddleware(addShootingBallToRotatingBalls, new MiddlewareLocation());

            // removing moveShooting ball middleware form loop(for preventing the shooting ball from moving).
            // TODO remove the moveShootingBall from loop.

            this.remove();
        }
    }
}
