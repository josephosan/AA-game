package middlewareManager.middlewares;
import java.util.ArrayList;

import config.Config;
import elementManager.ElementManager;
import elementManager.elements.Element;
import elementManager.elements.SmallBall;

public class selectShootBall extends Middleware  {

  ElementManager elementManager = Config.getElementManager();
 
      selectShootBall() {
        super("selectShootBall");
      
    }
    
    @Override
    public void init() {
      ArrayList<Element> ShootBallElements ;
      Element top = null;
      ShootBallElements  =elementManager.getElementsByGroup("selectShootBalls");
      for(Element element:ShootBallElements){
        if(top==null)
          top = element;
        else if(element.getPosition().getY()<top.getPosition().getY()){
          top = element;
        }
       top.leave("selectShootBalls");
       top.join("movingShootBalls");
       new MoveSmallBall((SmallBall) top);
       this.remove();

      }

    }
    
}
