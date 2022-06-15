package middlewareManager.middlewares;

import config.Config;

import elementManager.*;
import elementManager.elements.*;
import middlewareManager.MiddlewareManager;
import middlewareManager.middlewares.*;

import javax.swing.*;
import java.awt.*;
public class RepaintPanelElements extends Middleware{
    JPanel panel;
    ElementManager elementManager = Config.getElementManager();
    public RepaintPanelElements(JPanel panel) {
        super("repaintPanelElements");
        this.panel = panel;
    }

    @Override
    public void run() {
        AaText text = (AaText)elementManager.getElementById("menuPanelAaText");
        text.setText("donya" +  System.currentTimeMillis());
        System.out.println("from repaintPanelElements ");
        panel.repaint();
    }
}
