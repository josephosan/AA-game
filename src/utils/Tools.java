package utils;

import elementManager.elements.SmallBall;

public class Tools {
    public static double getTwoPointDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }
    public static void AddShootingBallToRotatingBalls(SmallBall shootingSB){
        shootingSB.leave("shootingSmallBalls"); // removing the shot ball form its group.
        shootingSB.join("rotatingSmallBalls"); // joining the shooting ball using join method in Element class.
    }
}
