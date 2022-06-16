package middlewareManager.middlewares;

import config.Config;

import elementManager.*;
import elementManager.elements.*;
import javax.swing.*;

public class RepaintPanelElements extends Middleware {
    JPanel panel;
    ElementManager elementManager = Config.getElementManager();
    public RepaintPanelElements(JPanel panel) {
        super("repaintPanelElements");
        this.panel = panel;
    }

    @Override
    public void run() {
        panel.repaint();
    }
}
