package elementManager.elements;

import config.Config;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

import elementManager.coordinate.*;
import elementManager.*;

public class Element {
    String id;
    Boolean painted = false;
    ArrayList<String> groups = new ArrayList<>();
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
        groups.add(group);
        elementManager.joinGroup(group, id);
    }

    // leaves group
    public void leave(String group) {
        groups.remove(group);
        elementManager.leaveGroup(group, id);
    }

    public ArrayList<String> getGroups() {
        return groups;
    }

    public void paintSelf(Graphics g) {
    
    }

    public Boolean isPainted() {
        return painted;
    }

    public void setPainted(Boolean painted) {
        this.painted =  painted;
    }
}
