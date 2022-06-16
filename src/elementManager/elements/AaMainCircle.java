package elementManager.elements;

import elementManager.elements.*;
import config.Config;

import javax.swing.*;
import java.awt.*;
public class AaMainCircle extends Element{
    public AaMainCircle(JPanel panel) {
        super(panel);
        this.size.setSize(Config.getMainCircleSize().getWidth(), Config.getMainCircleSize().getHeight());
        this.position.setX(Config.getFrameWidth()/2);
        this.position.setY(this.size.getHeight() + Config.getSpinningCircleRadius() + 50);
    }

    @Override
    public void paintSelf(Graphics g) {

        g.fillOval(
            this.position.getX() - this.size.getWidth() / 2,  
            this.position.getY() - this.size.getHeight() / 2, 
            this.size.getWidth(), 
            this.size.getHeight());
    }
}
