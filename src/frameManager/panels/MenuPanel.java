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
        setLocation(0, 0);
        AaMainCircle aaMainCircle = new AaMainCircle(this);
        elementManager.addElement("mainCircle", aaMainCircle);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // System.exit(0);
        System.out.println("menu panel repaintng");
        ArrayList<Element> elements = elementManager.getElementsByPanel(this);
        System.out.println(elements);
        for (Element element : elements) {
            System.out.println("from paint component");
            element.paintSelf(g);
        }
    }
}
