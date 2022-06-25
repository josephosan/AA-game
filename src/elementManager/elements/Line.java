package elementManager.elements;

import javax.swing.*;
import java.awt.*;

public class Line extends Element {
    int startXPos;
    int startYPos;
    int endXPos;
    int endYPos;

    public Line(JPanel panel) {
        super(panel);
    }

    public void setPos(int sxp, int syp, int exp, int eyp) {
        this.startXPos = sxp;
        this.startYPos = syp;
        this.endXPos = exp;
        this.endYPos = eyp;
    }

    @Override
    public void paintSelf(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(startXPos, startYPos, endXPos, endYPos);
    }
}
