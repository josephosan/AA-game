package frameManager.panels;

import java.util.*;

import frameManager.APanel;
import elementManager.*;
import elementManager.elements.*;
import config.Config;

import java.awt.*;

public class MenuPanel extends APanel{
    ElementManager elementManager = Config.getElementManager();
    public MenuPanel(String id) {
        super(id);
        // AaText text = new AaText(this);
        // System.out.println(text);
        // elementManager.addElement("menuPanelAaText", text);


        // you commented this 
        // setLocation(0, 0);
        // BigBall bigBall = new BigBall(this);
        // elementManager.addElement("mainCircle", bigBall);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // System.exit(0);
        System.out.println("menu panel repainting");
        ArrayList<Element> elements = elementManager.getElementsByPanel(this);
        System.out.println(elements);
        for (Element element : elements) {
            System.out.println("from paint component");
            element.paintSelf(g);
        }
    }
}
