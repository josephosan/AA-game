package middlewareManager.middlewares;

import java.util.ArrayList;
import config.Config;
import utils.calculations.Rotation;
import elementManager.ElementManager;
import elementManager.elements.*;

public class DrawSmallBall extends Middleware {
    ElementManager elementManager = Config.getElementManager();
    BigBall bigBall;
    ArrayList<Element> rotatingSmallBalls;
    Rotation rotator;

    public DrawSmallBall(BigBall bigBall){
        super("drawSmallBall");
        this.bigBall = bigBall;
    }

    @Override
    public void init(){
        rotator = new Rotation(3, bigBall); //TODO rotationSpeed should be passed as a var.
    }
    @Override
    public void run(){
        rotatingSmallBalls = elementManager.getElementsByGroup("rotatingSmallBalls");
        
        for(Element smallBall : rotatingSmallBalls){
            rotator.rotate((SmallBall)smallBall);
        }

        //TODO if game is over remove self
    }

}