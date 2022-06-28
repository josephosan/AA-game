package middlewareManager.middlewares;

import middlewareManager.MiddlewareLocation;

public class CheckRemainigBalls extends Middleware {
    final String groupId;

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

        //if there are no balls left the level is finished.
        if(remainingBalls==0){
            this.middlewareManager.addMiddleware(new FinishLevel(), new MiddlewareLocation());
            this.remove();
        }
    }
}
