package utils.calculations;

import java.lang.Math;

import elementManager.coordinate.AaPosition;
import elementManager.elements.*;
import middlewareManager.middlewares.DrawSmallBall;

public class Rotation{
    private final Integer rotationSpeed; //should be in degree
    private final AaPosition origin; //coordinates of center of the Big Ball
    private final Integer r; // radius of the Main Circle

    Rotation(Integer rotationSpeed , BigBall bigBall){
        this.rotationSpeed = rotationSpeed;
        this.origin = bigBall.getPosition();
        this.r = bigBall.getR();
    }

    public AaPosition rotate(DrawSmallBall drawSmallBall){
        Angle angle = new Angle(drawSmallBall.getAngle());
        angle.add(this.rotationSpeed);
        double a = angle.getInRadian();
        Integer x = (int) (this.origin.getX() + (Math.cos(a) * r));
        Integer y = (int) (this.origin.getY() + (Math.sin(a) * r));
        return new AaPosition(x,y);
    }
}