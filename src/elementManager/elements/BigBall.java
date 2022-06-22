package elementManager.elements;

import config.Config;
import elementManager.coordinate.AaPosition;

import javax.swing.*;
import java.awt.*;
public class BigBall extends Element{
    public static AaPosition aaPosition = new AaPosition();
    Color color;
    public BigBall(JPanel panel) {
        super(panel);
        this.size.setSize(Config.getMainCircleSize().getWidth(), Config.getMainCircleSize().getHeight());
        aaPosition.setX(Config.getFrameWidth()/2);
        aaPosition.setY(this.size.getHeight() + Config.getBigCircleRadios() + 50);
    }

    public static AaPosition getPos() {
        return aaPosition;
    }

    public void setPos(int x, int y){
        position.setX(x);
        position.setY(y);
    }

    public void setColor(Color c){
        this.color = c;
    }


    @Override
    public void paintSelf(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;
        g2D.setPaint(this.color);
        g2D.fillOval(
            this.position.getX() - this.size.getWidth() / 2,
            this.position.getY() - this.size.getHeight() / 2,
            this.size.getWidth(), 
            this.size.getHeight());
    }

    public Integer getR() {
        return 0;
    }
}
