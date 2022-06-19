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
    AaPosition position = new AaPosition();
    Rotation rotation;
    private double angle = 90.0;
    public DrawSmallBall(APanel aPanel){
        super("drawSmallBall");
        this.panel = aPanel;
        
    }

    public void setAngle(double ang){
        this.angle = ang;
    }

    public double getAngle(){
        return this.angle;
    }

    public void angularMovement(){              //basically uses Rotation class in order to get the positions in angular
        position = rotation.rotate(this);  //shape so we can pass it to SmallBall element to draw
    }                                           //also, we use the AaPosition class to handle the output of rotate function

    public void straightMovement(int x, int y){ //In case anyone would need to pass coordination's instead of angles
        position.setX(x);
        position.setY(y);
    }

    public AaPosition getPos(){
        return position;
    }
    
    @Override
    public void run(){
        smallBall = (SmallBall)elementManager.getElementById("drawSmallBall");
        smallBall.setPos(position.getX(), position.getY());  //here we pass the coordination's to SmallBall Element
        panel.repaint();
    }
    
}
