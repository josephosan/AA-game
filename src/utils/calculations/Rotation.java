package utils.calculations;

import java.lang.Math;

import config.Config;
import elementManager.ElementManager;
import elementManager.coordinate.AaPosition;
import elementManager.elements.*;

public class Rotation{
    private Integer rotationSpeed; //should be in degree
    private AaPosition origin; //coordinates of center of the Big Ball
    private Integer r; // radius of the Main Circle

    public Rotation(){
        this.rotationSpeed = 2;
    }

    public Rotation(Integer rotationSpeed){
        this.rotationSpeed = rotationSpeed;
    }

    public void setSpeed(Integer rotationSpeed){
        this.rotationSpeed = rotationSpeed;
    }

    public void rotate(SmallBall smallBall){
        if(origin == null){
            BigBall bigBall =  (BigBall)Config.getElementManager().getElementById("bigBall");
            this.origin = bigBall.getPosition();
            this.r = bigBall.getR();
        }
        Angle angle = smallBall.getAngle();
        angle.add(this.rotationSpeed);
        double a = angle.getInRadian();
        Integer x = (int) (this.origin.getX() + (Math.cos(a) * r) + 0) ;
        Integer y = (int) (this.origin.getY() + (Math.sin(a) * r) - 0);
        smallBall.setAngle(angle);
        smallBall.setPos(new AaPosition(x,y));
    }
}