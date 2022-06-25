package middlewareManager.middlewares;
import java.util.ArrayList;

import config.Config;
import elementManager.ElementManager;
import elementManager.elements.Element;

public class shootingShootBall extends Middleware  {

  ElementManager elementManager = Config.getElementManager();
  ArrayList<Element> ShootBallElements ;
  ArrayList<shootingShootBall> ShootBalls;
 
      shootingShootBall() {
        super("shootingShootBall");
      
    }
    
    @Override
    public void run() {
      ShootBallElements  =elementManager.getElementsByGroup("ShootBalls");
    for(Element shootingSmallBall : ShootBalls){
      ShootBalls.add((ShootBall)shootingSmallBall);
    }
    
}
}