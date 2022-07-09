package middlewareManager.middlewares;

import java.util.ArrayList;

import config.Config;
import middlewareManager.MiddlewareLocation;
import elementManager.elements.Element;
public class CheckRemainigBalls extends Middleware {
    final String groupId;
    boolean lastLoop = false; 
    //lastLoop is to wait one more loop before ending a level.
    //this is to ensure that there is no impact on last shot. 
    public CheckRemainigBalls(){
        super("checkRemainingBalls");
        groupId = "game";
    }

    public CheckRemainigBalls(String middlwareGroupId){
        super("checkRemainingBalls");
        groupId = middlwareGroupId;
    }

    @Override 
    public void run(){
        //this value is usally set using LoadGame
        //and is maniuplated by SelectShootBall
        int remainingBalls = Integer.parseInt(this.getValue("numOfBallsToConnect"));

        //if there are no balls left to shoot and there is no ball in the way, the level is finished.
        ArrayList<Element> shootingSmallBalls= Config.getElementManager().getElementsByGroup("shootingSmallBalls");
        if(remainingBalls==0 && shootingSmallBalls.size()==0){
            if(!lastLoop)
            {
                lastLoop = true;
                return;
            }
            this.middlewareManager.addMiddleware(new FinishLevel(), new MiddlewareLocation());
            Config.getSoundManager().play("winGame");
            this.remove();
        }
    }
}
