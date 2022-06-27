package middlewareManager.middlewares;
import java.util.ArrayList;

import config.Config;
import elementManager.ElementManager;
import elementManager.elements.Element;
import elementManager.elements.SmallBall;
import middlewareManager.MiddlewareLocation;

public class selectShootBall extends Middleware  {

  ElementManager elementManager = Config.getElementManager();
 
      selectShootBall() {
        super("selectShootBall");
      
    }
    
    @Override
    public void run() {
      String readyToShootBall = this.getValue("readyToShootBall");
       if( readyToShootBall!=null && readyToShootBall!="" ){
          middlewareManager.addMiddleware(new MoveSmallBall(readyToShootBall),new MiddlewareLocation());
          this.setValue("readyToShootBall","");
          middlewareManager.addMiddleware(new Reload(),new MiddlewareLocation());
       }
       
          
      }

    }
    
  
