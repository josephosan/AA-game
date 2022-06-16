package middlewareManager.middlewares;

import java.awt.*;

import config.Config;
import elementManager.ElementManager;
import elementManager.elements.*;


public class DrawLine extends Middleware {            ;
    Panel panel;
    ElementManager elementManager = Config.getElementManager();


    public DrawLine(Panel panel) {
        super("drawLine");
        this.panel = panel;

    }

    @Override
    public void run() {
        Line line = (Line)elementManager.getElementById("drawLine");
        line.setPos(BigBall.getXPos(), BigBall.getYPos(), SmallBall.getXPos(), SmallBall.getYPos());
        panel.repaint();
    }
}
