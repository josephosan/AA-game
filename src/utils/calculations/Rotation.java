package utils.calculations;

import java.lang.Math;

import config.Config;
import elementManager.ElementManager;
import elementManager.coordinate.AaPosition;
import elementManager.elements.*;

public class Rotation{
    private Integer rotationSpeed; //should be in degree
    private final AaPosition origin; //coordinates of center of the Big Ball
    private final Integer r; // radius of the Main Circle

    public Rotation(){
        this.rotationSpeed = 2;
        ElementManager elementManager = Config.getElementManager();
        BigBall bigBall =  (BigBall)elementManager.getElementById("bigBall");
        this.origin = bigBall.getPosition();
        this.r = bigBall.getR();
    }

    public Rotation(Integer rotationSpeed){
        this.rotationSpeed = rotationSpeed;
        ElementManager elementManager = Config.getElementManager();
        BigBall bigBall =  (BigBall)elementManager.getElementById("bigBall");
        this.origin = bigBall.getPosition();
        this.r = bigBall.getR();
    }

    public void setSpeed(Integer rotationSpeed){
        this.rotationSpeed = rotationSpeed;
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