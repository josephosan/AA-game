package middlewareManager.middlewares;

import java.util.ArrayList;

import config.Config;
import elementManager.ElementManager;
import elementManager.elements.SmallBall;
import elementManager.elements.Element;

public class MoveSmallBall extends Middleware  {

    ElementManager elementManager= Config.getElementManager();
    public MoveSmallBall(){
        super("moveSmallBall");
    }

    @Override
    public void run() {
        ArrayList<Element> shootingSmallBalls= this.elementManager.getElementsByGroup("shootingSmallBalls");
        if(shootingSmallBalls==null) return;
        for (Element ssb : shootingSmallBalls){
            ((SmallBall)ssb).getPosition().setY(((SmallBall)ssb).getPosition().getY()-Config.getSpeedShootBall());
        }
         
    }
}

