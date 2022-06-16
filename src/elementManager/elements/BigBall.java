package elementManager.elements;

import javax.swing.*;

public class BigBall extends Element {
    Position position;

    public BigBall(JPanel panel) {
        super(panel);
        this.position = new Position();
    }


    public static int getXPos() {
        return 0;
    }
    public static int getYPos() {
        return 0;
    }
}
