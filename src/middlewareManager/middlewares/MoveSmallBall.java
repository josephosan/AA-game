package middlewareManager.middlewares;

import config.Config;
import elementManager.ElementManager;
import elementManager.elements.SmallBall;

public class MoveSmallBall extends Middleware  {
    SmallBall smallBall;

    ElementManager elementManager= Config.getElementManager();
    public MoveSmallBall(String id){
        super("moveSmallBall");
        smallBall= (SmallBall)this.elementManager.getElementById(id);
    }

    @Override
    public void run() {
        this.smallBall.getPosition().setY(this.smallBall.getPosition().getY()-Config.getSpeedShootBall()); 
    }
}

