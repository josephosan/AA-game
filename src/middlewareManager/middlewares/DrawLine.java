package middlewareManager.middlewares;

import java.awt.*;

import config.Config;
import elementManager.ElementManager;
import elementManager.elements.*;



public class DrawLine extends Middleware {
    Panel panel;
    ElementManager elementManager = Config.getElementManager();
    private float smallBXPos;
    private float smallBYPos;

    public DrawLine(Panel panel) {
        super("drawLine");
        this.panel = panel;
    }

    public DrawLine(Panel panel, float smallBXPos, float smallBYPos) {
        super("drawLine");
        this.panel = panel;
        this.smallBXPos = smallBXPos;
        this.smallBYPos = smallBYPos;
    }

    @Override
    public void run() {
        Line line = (Line)elementManager.getElementById("drawLine");
        line.setPos(BigBall.getPos().getX(), BigBall.getPos().getY(), (int)smallBXPos, (int)smallBYPos);
        panel.repaint();
    }
}
