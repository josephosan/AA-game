package utils;

import config.Config;
import middlewareManager.MiddlewareManager;
import middlewareManager.middlewares.DrawSmallBall;

public class AddSmallBallsInEqualAngle {
    public static void create(int numberOfBalls){
        MiddlewareManager middlewareManager = Config.getMiddlewareManager();
        double angle = 360/numberOfBalls;
        for(int i=0;i<numberOfBalls;i++){
            middlewareManager.addMiddlewareInSeries(new DrawSmallBall((String.valueOf(i*angle))));
        }
    }

    public static void create(int numberOfBalls, String rgb){
        MiddlewareManager middlewareManager = Config.getMiddlewareManager();
        double angle = 360/numberOfBalls;
        for(int i=0;i<numberOfBalls;i++){
            middlewareManager.addMiddlewareInSeries(new DrawSmallBall((String.valueOf(i*angle)), rgb));
        }
    }

    public static void create(int numberOfBalls, String rgb, String panelId){
        MiddlewareManager middlewareManager = Config.getMiddlewareManager();
        double angle = 360/numberOfBalls;
        for(int i=0;i<numberOfBalls;i++){
            middlewareManager.addMiddlewareInSeries(new DrawSmallBall((String.valueOf(i*angle)), rgb, panelId));
        }
    }
}
