package middlewareManager.middlewares;

import java.util.ArrayList;

import config.Config;
import elementManager.ElementManager;
import elementManager.elements.Element;
import elementManager.elements.Line;
import elementManager.elements.SmallBall;
import utils.calculations.Angle;
import utils.calculations.Rotation;

//This middleware should be added right after SpinSmallBalls middleware
//and before DrawLine

public class AnimatedRotaion extends Middleware {
    ElementManager elementManager = Config.getElementManager();

    // Rotation rotator = new Rotation();
    ArrayList<Element> rotatingSmallBalls;
    ArrayList<Element> lines;
    public AnimatedRotaion(){
        super("animatedRotation");
    }

    @Override
    public void run(){
        rotatingSmallBalls = elementManager.getElementsByGroup("rotatingSmallBalls");
        lines = elementManager.getElementsByGroup("lines");
        
        for(Element smallBall: rotatingSmallBalls){
            SmallBall a = (SmallBall)smallBall;
            Double ang = a.getAngle().getIndegree();
            if(ang>360)
                ang-=360;

            if(ang%360==0)
                a.setVisible(!a.getVisible()); 
        }

    }
    
}
