package middlewareManager.middlewares;

import config.Config;
import elementManager.ElementManager;
import middlewareManager.MiddlewareLocation;

public class SelectShootBall extends Middleware  {

  ElementManager elementManager = Config.getElementManager();
 
    public SelectShootBall() {

      super("selectShootBall");
    }
    
    @Override
    public void run() {
      //"readyToShootBall" is set at ReloadShootBall class.
      //it indicates the ball that is in shooting position.
      String readyToShootBall = this.getValue("readyToShootBall");
      //null or empty string indicate that the ball is not in shooting position yet.
      //as a result it is not possible to shoot.
      if( readyToShootBall!=null && readyToShootBall!=""){
        //"selectShootBall" is the group of balls waiting to be shot.
        //this ball leaves the group because its being shot.
        this.elementManager.getElementById(readyToShootBall).leave("SelectShootBall");
        //"shootingBall" is the group of balls that are moving toward bigBall.
        //currently there can only be one shooting ball.
        this.elementManager.getElementById(readyToShootBall).join("shootingSmallBalls");

        //setting "readyToShootBall" value to empty string to indicate there is no ball in shooting position.
        this.setValue("readyToShootBall","");
        //setting "levelNumberOfBallsToConnect" value for use of other middlewares
        this.setValue("levelNumberOfBallsToConnect", String.valueOf(Integer.parseInt(this.getValue("levelNumberOfBallsToConnect"))-1));
        //BallIsCloseEnough will check if the ball has reached the orbit.
        middlewareManager.addMiddleware(new BallIsCloseEnough(readyToShootBall), new MiddlewareLocation());

        Config.getSoundManager().play("shootBall");
      }  
      // this middleware should be removed regardless of whether the ball is shot or not.
      this.remove();
    }
  }
  
    
  
