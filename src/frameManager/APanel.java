package frameManager;

import config.Config;

import javax.swing.*;
import java.awt.*;
import config.Config;
import java.util.regex.Pattern;
import java.util.Arrays;
import elementManager.*;
import java.util.ArrayList;
import elementManager.elements.Element;

public class APanel extends JPanel{
    String stdOrderPattern = "*";
    ElementManager elementManager = Config.getElementManager();
    String id;
    Boolean active = false;
    String[] paintOrder = {};

    public APanel(String id) {
        this.id = id;
        setPaintOrder(stdOrderPattern);
        setSize(new Dimension(Config.getFrameWidth(), Config.getFrameHeight()));
        setLayout(null);
        setLocation(0, 0);
        setOpaque(true);
        setVisible(false);

    }

    public void setPaintOrder(String pattern) {
        if (pattern == null || pattern.equals("")) {
            paintOrder = new String[0];
            return;
        }

        if (!Pattern.matches("^((\\#?[\\w]+\\>)|(\\*\\>))+(\\#?[\\w]+|\\*)$", pattern)) {
            System.out.println("pattern not matched");
            return;
        }

        paintOrder = pattern.split(">");
    }

    //----- EVENTS -----
    // you should override this methods in your panel class if needed;

    // if panel is in transition by a for example tansitionPanel middle
    // the middleware emits this event before starting the transition
    // if the panel is replacing by another panel isReplacing will be true
    // if replacing panels doesn't done with transition middleware 
    // this event will not emit;
    public void onPanelTransitionStart(Boolean isReplacing) {

    }

    // if panel is in the final position after transition 
    // and becomes the activePanel this event will emit.
    public void onActivePanel() {
        
    }

    // when panel becomes deactive.
    public void onDeactivePanel() {

    }

    
    // ----- /EVENTS -----
    
    public void setActive(Boolean active) {
        if (active) {
            Config.getFrameManager().setActivePanel(this.id);
        }
        this.active = active;
    } 

    public Boolean isActive() {
        return active;
    }

    public void doPaintSelf(Graphics g, ArrayList<Element> arr) {
        for (Element element : arr) {
            if (!element.isPainted()) {
                element.paintSelf(g);
                element.setPainted(true);
            }
        }
    }

    public void doPaintSelf(Graphics g, Element element) {
        element.paintSelf(g);
        element.setPainted(true);
    }

    public void doForcePaintSelf(Graphics g, ArrayList<Element> arr) {
        for (Element element : arr) {
            element.paintSelf(g);
            element.setPainted(true);
        }
    }

    public void doForcePaintSelf(Graphics g, Element element) {
        element.paintSelf(g);
        element.setPainted(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        ArrayList<Element> elements = elementManager.getElementsByPanel(this);

        for (int i=0; i < paintOrder.length; i++) {
            String token = paintOrder[i];

            if (token.equals("*")) {
                for (Element element : elements) {
                    ArrayList<String> elementGroups = element.getGroups();
                    if (element.isPainted()) continue;
                    Boolean shouldPaint = true;
                    
                    for (int j = 0; j < paintOrder.length; j++) {
                        String jToken = paintOrder[j];
                        if (
                            jToken.equals("*")
                            && jToken.charAt(0) == '#' 
                            && element.getId().equals(token.substring(1))
                            && elementGroups.contains(token)
                        ) {
                            shouldPaint = false;
                            break;
                        }
                    }

                    if (shouldPaint) doPaintSelf(g, element);
                }
            } else {
                if (token.charAt(0) == '#') {
                    Element element = elementManager.getElementById(token.substring(1));
                    if (element == null) continue;
                    doPaintSelf(g, element);
                } else {
                    ArrayList<Element> groupElements = elementManager.getElementsByGroup(token);
                    if (groupElements == null) continue;

                    doPaintSelf(g, groupElements);
                }
            }
        }

        for (Element element: elements) {
            element.setPainted(false);
        }
    }
}
