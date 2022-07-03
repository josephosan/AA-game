package middlewareManager.middlewares;

import java.util.ArrayList;
import config.Config;
import elementManager.ElementManager;
import elementManager.elements.Element;
import elementManager.elements.Line;
import elementManager.elements.SmallBall;


//This middleware should be added right after SpinSmallBalls middleware
//and before DrawLine

public class AnimatedRotation extends Middleware {
    ElementManager elementManager = Config.getElementManager();

    // Rotation rotator = new Rotation();
    ArrayList<Element> rotatingSmallBalls;
    ArrayList<Element> lines;
    public AnimatedRotation(){
        super("animatedRotation");
    }

    @Override
    public void run(){
        rotatingSmallBalls = elementManager.getElementsByGroup("rotatingSmallBalls");
        lines = elementManager.getElementsByGroup("lines");

        if (rotatingSmallBalls == null || lines == null) return;

        //TODO only animate the starting smallballs that are connected
        
        for(int i=0; i<rotatingSmallBalls.size(); i++){
            SmallBall a = (SmallBall)rotatingSmallBalls.get(i);
            Line b = (Line)lines.get(i);
            double ang = a.getAngle().getInDegree();
            if(ang>360)
                ang-=360;

            if(ang%360==0){
                a.setVisible(!a.getVisible()); 
                b.setVisible(!b.getVisible()); 
            }
        }

    }

}
