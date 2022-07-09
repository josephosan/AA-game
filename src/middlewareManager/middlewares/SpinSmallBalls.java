package middlewareManager.middlewares;

import java.util.ArrayList;
import config.Config;
import utils.calculations.Rotation;
import elementManager.ElementManager;
import elementManager.elements.*;

public class SpinSmallBalls extends Middleware {
    ElementManager elementManager = Config.getElementManager();
    ArrayList<Element> rotatingSmallBalls;
    Rotation rotator = new Rotation();

    public SpinSmallBalls(){
        super("spinSmallBalls");
    }
    @Override
    public void run(){
        //getting rotatingSmallBalls Group (Elements are added to this Group using DrawSmallBall middleware)
        rotatingSmallBalls = elementManager.getElementsByGroup("rotatingSmallBalls");
        //setting speed of rotator
        rotator.setSpeed(Double.parseDouble(this.getValue("rotationSpeed")));

        //rotating SmallBalls
        if(rotatingSmallBalls == null){
            return;
        }
        for(Element smallBall : rotatingSmallBalls){
            rotator.rotate((SmallBall)smallBall);
        }
    }

}