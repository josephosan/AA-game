package elementManager.elements;

import javax.swing.*;

import elementManager.coordinate.AaPosition;

import java.awt.*;

public class Line extends Element {
    AaPosition startPosition;
    AaPosition endPosition;

    public Line(JPanel panel) {
        super(panel);
    }

    public void setPosition(int sxp, int syp, int exp, int eyp) {
        this.startPosition = new AaPosition(sxp,syp);
        this.endPosition = new AaPosition(exp,eyp);
    }

    public void setPosition(AaPosition startPosition, AaPosition endPosition){
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    @Override
    public void paintSelf(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(startPosition.getX(), startPosition.getY(), endPosition.getX(), endPosition.getY());
    }
}
