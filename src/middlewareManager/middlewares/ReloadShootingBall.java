package middlewareManager.middlewares;

import config.Config;
import elementManager.coordinate.AaPosition;
import elementManager.elements.SmallBall;

public class ReloadShootingBall extends Middleware {
    SmallBall smallBall;
    int speed;
    int acceleration;
    int numberOfRenders = 60;
    AaPosition shootingPosition;
    ReloadShootingBall(){
        super("reloadShootingBall");
    }

    @Override
    public void init(){
        int ballNumber = Integer.parseInt(this.getValue("numOfBallsToConnect"));
        smallBall = (SmallBall)Config.getElementManager().getElementById("smallBall"+ballNumber);
        speed = (smallBall.getPosition().getY()-shootingPosition.getY())/(Config.getTimerDelay()*(numberOfRenders/2));
        acceleration = -(speed/(Config.getTimerDelay()*numberOfRenders));
    }

    public void run(){
        if(smallBall.getPosition().getY()-shootingPosition.getY()>0){
            AaPosition sbp = smallBall.getPosition();
            smallBall.setPosition(new AaPosition(sbp.getX(),sbp.getY()-speed));
            speed += acceleration;
        }
        else{
            smallBall.setPosition(shootingPosition);
            this.setValue("readyToShootBall", smallBall.getId());
            this.remove();
        }
    }
}
