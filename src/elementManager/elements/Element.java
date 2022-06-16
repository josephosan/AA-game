package elementManager.elements;

import java.awt.*;
import javax.swing.*;
import elementManager.coordinate.*;

public class Element {
    JPanel panel;
    Position position;
    public Element(JPanel panel) {
        this.panel = panel;
        this.position = new Position();
    }

    public Position getPosition() {
        return this.position;
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public void paintSelf(Graphics g) {

    }
}
