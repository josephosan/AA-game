package middlewareManager.middlewares;

import java.util.ArrayList;

import config.Config;
import elementManager.ElementManager;
import elementManager.elements.Element;
import elementManager.elements.SmallBall;
import utils.calculations.Angle;
import utils.calculations.Rotation;

public class AnimatedRotaion extends Middleware {
    ElementManager elementManager = Config.getElementManager();

    // Rotation rotator = new Rotation();
    ArrayList<Element> rotatingSmallBalls;
    boolean visible= false;
    public AnimatedRotaion(){
        super("animatedRotation");
    }

    @Override
    public void run(){
        rotatingSmallBalls = elementManager.getElementsByGroup("rotatingSmallBalls");
        
        for(Element smallBall: rotatingSmallBalls){
            SmallBall a = (SmallBall)smallBall;
            Double ang = a.getAngle().angle;
            if(ang>=360)
                ang-=360;

            if(ang%360==0){
                a.setVisible(!a.getVisible()); 
            }
        }

    }
    
}
