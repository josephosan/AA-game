package utils.calculations;

import java.lang.Math;

import elementManager.coordinate.AaPosition;
import elementManager.elements.*;

public class Rotation{
    private final Integer rotationSpeed; //should be in degree
    private final AaPosition origin; //coordinates of center of the Big Ball
    private final Integer r; // radius of the Main Circle

    public Rotation(Integer rotationSpeed , BigBall bigBall){
        this.rotationSpeed = rotationSpeed;
        this.origin = bigBall.getPosition();
        this.r = bigBall.getR();
    }

    public void rotate(SmallBall smallBall){
        Angle angle = smallBall.getAngle();
        angle.add(this.rotationSpeed);
        double a = angle.getInRadian();
        Integer x = (int) (this.origin.getX() + (Math.cos(a) * r));
        Integer y = (int) (this.origin.getY() + (Math.sin(a) * r));
        smallBall.setAngle(angle);
        smallBall.setPos(new AaPosition(x,y));
    }
}