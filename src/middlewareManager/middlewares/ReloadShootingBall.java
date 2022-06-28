package middlewareManager.middlewares;

import config.Config;
import elementManager.coordinate.AaPosition;
import elementManager.elements.SmallBall;

public class ReloadShootingBall extends Middleware {
    SmallBall smallBall;
    int speed;
    int acceleration;
    int numberOfRenders = 60;
    int ballNumber;
    AaPosition shootingPosition = Config.getShootingPosition();
    ReloadShootingBall(){
        super("reloadShootingBall");
        ballNumber = Integer.parseInt(this.getValue("numOfBallsToConnect"));
        System.out.println("from reload: "+ballNumber);
    }

    public void run(){
        if(acceleration == 0){
            smallBall = (SmallBall)Config.getElementManager().getElementById("smallBall"+ballNumber);
            speed = (smallBall.getPosition().getY()-shootingPosition.getY())/(Config.getTimerDelay()*(numberOfRenders/2));
            acceleration = -(speed/(Config.getTimerDelay()*numberOfRenders));
        }
        System.out.println("");
        if(shootingPosition.getY()-smallBall.getPosition().getY()>0){
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
