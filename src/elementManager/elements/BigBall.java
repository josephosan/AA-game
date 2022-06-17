package elementManager.elements;

import config.Config;
import elementManager.coordinate.AaPosition;

import javax.swing.*;
import java.awt.*;
public class BigBall extends Element{
    public static AaPosition aaPosition = new AaPosition();

    public BigBall(JPanel panel) {
        super(panel);
        this.size.setSize(Config.getMainCircleSize().getWidth(), Config.getMainCircleSize().getHeight());
        aaPosition.setX(Config.getFrameWidth()/2);
        aaPosition.setY(this.size.getHeight() + Config.getSpinningCircleRadius() + 50);
    }

    public static AaPosition getPos() {
        return aaPosition;
    }


    @Override
    public void paintSelf(Graphics g) {

        g.fillOval(
            this.position.getX() - this.size.getWidth() / 2,
            this.position.getY() - this.size.getHeight() / 2,
            this.size.getWidth(), 
            this.size.getHeight());
    }

    public Integer getR() {
        return 0;
    }
}
