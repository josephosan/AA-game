package elementManager.elements;

import config.Config;
import java.awt.*;
import javax.swing.*;

import elementManager.coordinate.*;;
import elementManager.coordinate.*;
import elementManager.*;

public class Element {
    String id;
    JPanel panel;
    AaPosition position;
    AaSize size;
    ElementManager elementManager = Config.getElementManager();
    public Element(JPanel panel) {
        this.panel = panel;
        this.position = new AaPosition();
        this.size = new AaSize();
    }


    public AaPosition getPosition() {
        return this.position;
    }
    public JPanel getPanel() {
        return this.panel;
    }

    public AaSize getSize() {
        return this.size;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    // joins group
    public void join(String group) {
        elementManager.joinGroup(group, id);
    }

    // leaves group
    public void leave(String group) {
        elementManager.leaveGroup(group, id);
    }

    public void paintSelf(Graphics g) {
    
    }
}
