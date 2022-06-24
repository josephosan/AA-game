package elementManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;
import elementManager.elements.Element;
import javax.swing.*;

public class ElementManager {
    Integer lastCircleCursorId = 0;
    HashMap<String, Element> elements = new HashMap<String, Element>();
    HashMap<String, ArrayList<Element>> groups = new HashMap<>();
    public ElementManager() {
    }

    // this method will call when all the components of app 
    // getting accessible from the Config
    public void onConfigSubscribe() {

    }

    public String getNextCircleId() {
        return "Circle" + (lastCircleCursorId++);
    }

    public void addElement(String id, Element element) {
        element.setId(id);
        elements.put(id, element);
    }

    public void newGroup(String group) {
        groups.put(group, new ArrayList<Element>());
    }

    public void joinGroup(String group, String id ) {
        if (!groups.containsKey(group)) {
            newGroup(group);
        }
        groups.get(group).add(getElementById(id));
    }

    public void leaveGroup(String group, String id ) {
        int index = -1;
        if (groups.containsKey(group)) {
            ArrayList<Element> elements = groups.get(group);
            Element leavingElement = getElementById(id);
            if (leavingElement == null) return;

            for (int i = 0; i < elements.size(); i++) {
                Element element = elements.get(i);
                if (element == leavingElement) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                elements.remove(index);
            }
        }
    }

    public ArrayList<Element> getElementsByGroup(String group) {
        return groups.get(group);
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
