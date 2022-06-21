package middlewareManager.middlewares;

import java.awt.*;

import config.Config;
import elementManager.ElementManager;
import elementManager.elements.*;
import frameManager.APanel;


public class DrawLine extends Middleware {
    APanel aPanel;
    ElementManager elementManager = Config.getElementManager();
    private float smallBXPos;
    private float smallBYPos;

    public DrawLine(APanel apanel) {
        super("drawLine");
        this.aPanel = apanel;
    }

    public DrawLine(APanel apanel, float smallBXPos, float smallBYPos) {
        super("drawLine");
        this.aPanel = apanel;
        this.smallBXPos = smallBXPos;
        this.smallBYPos = smallBYPos;
    }

    @Override
    public void run() {
        Line line = (Line)elementManager.getElementById("drawLine");
        line.setPos(BigBall.getPos().getX(), BigBall.getPos().getY(), (int)smallBXPos, (int)smallBYPos);
    }
}
