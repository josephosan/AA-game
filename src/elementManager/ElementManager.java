package elementManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;
import javax.swing.*;

public class ElementManager {
    Integer lastCircleCursorId = 0;
    HashMap<String, Element> elements = new HashMap<String, Element>();
    public ElementManager() {
    }

    public String getNextCircleId() {
        return "Circle" + (lastCircleCursorId++);
    }

    public void addElement(String id, Element element) {
        elements.put(id, element);
    }

    public Element getElementById(String id) {
        return elements.get(id);
    }

    public ArrayList<Element> getElementsByPanel(JPanel panel) {
        ArrayList<Element> resultElements = new ArrayList<>();
        Collection<Element> elements = this.elements.values();
        for (Element element : elements) {
            if (element.getPanel() == panel) {
                resultElements.add(element);
            }
        }

        return resultElements;
    }
}
