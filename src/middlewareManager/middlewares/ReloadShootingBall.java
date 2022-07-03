package middlewareManager.middlewares;

import config.Config;
import elementManager.coordinate.AaPosition;
import elementManager.elements.SmallBall;
import java.util.*;
public class ReloadShootingBall extends Middleware {
    SmallBall smallBall;
    int speed = 30;
    int acceleration = -1;
    int ballNumber;

    AaPosition shootingPosition = Config.getShootingPosition();
    ReloadShootingBall(){
        super("reloadShootingBall");
        ballNumber = Integer.parseInt(this.getValue("levelNumberOfBallsToConnect"));
    }

    @Override
    public void run(){
        //System.out.println(ballNumber);
        if(ballNumber<1) {this.remove(); return;}
        if(smallBall==null){
            smallBall = (SmallBall)Config.getElementManager().getElementById("smallBall"+ballNumber);
            //System.out.println(Config.getElementManager().getElementsByGroup("rotatingSmallBalls"));
            //System.out.println(smallBall);
        }
        if(smallBall.getPosition().getY()-shootingPosition.getY()>0){
            AaPosition sbp = smallBall.getPosition();
            smallBall.setPosition(new AaPosition(sbp.getX(),sbp.getY()-speed));
            if(speed>3) speed += acceleration;
        }
        else{
            smallBall.setPosition(new AaPosition(shootingPosition.getX(),shootingPosition.getY()));
            this.setValue("readyToShootBall", smallBall.getId());
            this.remove();
        }
    }
}
