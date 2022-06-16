package elementManager.elements;

import elementManager.coordinate.AaPosition;

import javax.swing.*;

public class BigBall extends Element {
    AaPosition position;

    public BigBall(JPanel panel) {
        super(panel);
        this.position = new AaPosition();
    }


    public static int getXPos() {
        return 0;
    }
    public static int getYPos() {
        return 0;
    }

    public Integer getR() {
        return 0;
    }
}
