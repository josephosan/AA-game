package middlewareManager.middlewares;

import javax.swing.JPanel;

import config.Config;
import elementManager.ElementManager;
import elementManager.elements.SmallBall;
import utils.calculations.Angle;;

public class AddSmallBall extends Middleware{
    static int id = 0;
    Angle angle;
    ElementManager elementManager = Config.getElementManager();

    AddSmallBall(String angle){
        super("AddSmallBall"+id);
        id++;
        this.angle = new Angle(Double.parseDouble(angle));
    }

    @Override
    public void init(){
        SmallBall smallBall = new SmallBall(new JPanel(),angle);
        elementManager.addElement("smallBall"+id, smallBall);
        elementManager.joinGroup("rotatingSmallBalls", "smallBall"+id);
        this.remove();
    }
    
}
