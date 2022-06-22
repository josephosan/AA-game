package middlewareManager.middlewares;

import java.util.ArrayList;

import config.Config;
import elementManager.ElementManager;
import elementManager.coordinate.AaPosition;
import elementManager.elements.*;
import frameManager.APanel;
import frameManager.FrameManager;


public class DrawLine extends Middleware {
    ElementManager elementManager = Config.getElementManager();
    APanel gamePanel = Config.getFrameManager().getAPanel("game");
    ArrayList<Element> rotatingSmallBalls;
    BigBall bigBall = (BigBall)elementManager.getElementById("bigBall");
    AaPosition bbPosition = bigBall.getPos();
    public DrawLine() {
        super("drawLine");
    }


    @Override
    public void run() {
        //getting rotatingSmallBalls Group (Elements are added to this Group using DrawSmallBall middleware)
        rotatingSmallBalls = elementManager.getElementsByGroup("rotatingSmallBalls");
        //TODO remove all elements from "lines" Group.
        //rotating SmallBalls
        for(Element smallBall : rotatingSmallBalls){
            //creating a line
            Line line = new Line(gamePanel);
            AaPosition sbPosition = ((SmallBall)smallBall).getPosition();
            line.setPos(sbPosition.getX(), sbPosition.getY(), bbPosition.getX(), bbPosition.getY());

            //adding line to elementManager. id will be like "line1"
            elementManager.addElement("line"+((SmallBall)smallBall).getNumber(), line);
            //adding line to Group "lines"
            elementManager.joinGroup("lines", "line"+((SmallBall)smallBall).getNumber());
        }
    }
}
