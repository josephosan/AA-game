package middlewareManager.middlewares;

import elementManager.elements.SmallBall;

public class MoveSmallBall extends Middleware  {
    SmallBall smallBall;

    int endY;
    
    public MoveSmallBall(SmallBall smallBall){
    super("moveSmallBall");
    this.smallBall = smallBall;
    }

    @Override
    public void run() {
        this.smallBall.getPosition().setY(this.smallBall.getPosition().getY()-10);;
        if(this.smallBall.getPosition().getY()<=endY){
            this.remove();
            return;
        }
    
    }

}

