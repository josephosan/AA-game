package middlewareManager.middlewares;

import config.Config;
import utils.calculations.Angle;
import utils.calculations.Rotation;
import elementManager.ElementManager;
import elementManager.elements.*;
import elementManager.coordinate.AaPosition;
import frameManager.APanel;

public class DrawSmallBall extends Middleware {
    APanel panel;
    ElementManager elementManager = Config.getElementManager();
    SmallBall smallBall;
    Angle angle;
    AaPosition position = new AaPosition();
    Rotation rotation;
   
    public DrawSmallBall(APanel aPanel){
        super("drawSmallBall");
        this.panel = aPanel;
        
    }

    public void angularMovement(){              //basically uses Rotation class in order to get the positions in angular
        position = rotation.rotate(smallBall);  //shape so we can pass it to SmallBall element to draw
    }                                           //also, we use the AaPosition class to handle the output of rotate function

    public void straightMovement(int x, int y){ //In case anyone would need to pass coordination's instead of angles
        position.setX(x);
        position.setY(y);
    }
    
    @Override
    public void run(){
        smallBall = (SmallBall)elementManager.getElementById("drawSmallBall");
        smallBall.setPos(position.getX(), position.getY());  //here we pass the coordination's to SmallBall Element
        panel.repaint();
    }
    
}
