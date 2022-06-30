package utils.calculations;

import java.lang.Math;

import config.Config;
import elementManager.coordinate.AaPosition;
import elementManager.elements.*;

public class Rotation{
    private double rotationSpeed; //should be in degree
    private AaPosition origin; //coordinates of center of the Big Ball
    private Integer r; // radius of the Main Circle

    public Rotation(){
        this.rotationSpeed = 2;
    }

    public Rotation(double rotationSpeed){
        this.rotationSpeed = rotationSpeed;
    }

    public void setSpeed(double rotationSpeed){
        this.rotationSpeed = rotationSpeed;
    }

    public void rotate(SmallBall smallBall){
        this.origin = Config.getMainCirclePosition();
        this.r = Config.getLineLength();
        Angle angle = smallBall.getAngle();
        angle.add(this.rotationSpeed);
        double a = angle.getInRadian();
        Integer x = (int) (this.origin.getX() + (Math.cos(a) * r) + 0) ;
        Integer y = (int) (this.origin.getY() + (Math.sin(a) * r) - 0);
        smallBall.setAngle(angle);
        smallBall.setPosition(new AaPosition(x,y));
    }
}