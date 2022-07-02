package middlewareManager.middlewares;

import config.Config;
import elementManager.ElementManager;
import elementManager.coordinate.AaPosition;
import elementManager.elements.*;
import frameManager.APanel;

public class DrawLine extends Middleware {
    ElementManager elementManager = Config.getElementManager();
    final APanel panel;
    final String smallBallNumber;
    
    public DrawLine(String smallBallNumber) {
        super("drawLine"+smallBallNumber);
        panel = Config.getFrameManager().getAPanel("game");
        this.smallBallNumber = smallBallNumber;
    }

    public DrawLine(String smallBallNumber, String panelId) {
        super("drawLine"+smallBallNumber);
        panel = Config.getFrameManager().getAPanel(panelId);
        this.smallBallNumber = smallBallNumber;
    }
    @Override
    public void run(){
        AaPosition bbPosition = Config.getMainCirclePosition();
        Line line = new Line(panel);
        line.setPosition(bbPosition, elementManager.getElementById("smallBall"+smallBallNumber).getPosition());
        //adding line to elementManager. id will be like "line1"
        elementManager.addElement("line"+smallBallNumber, line);
        //adding line to Group "lines"
        line.join("lines");
        line.join("game");
        this.remove();
    }
}
