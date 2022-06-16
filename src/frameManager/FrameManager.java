package frameManager;

import java.util.HashMap;
import middlewareManager.*;
import middlewareManager.middlewares.*;
import java.awt.*;
import javax.swing.*;
import frameManager.APanel;
import config.Config;

import frameManager.panels.MainPanel;
import frameManager.panels.MenuPanel;

public class FrameManager extends JFrame{
    HashMap<String, APanel> aPanels = new HashMap<String, APanel>();
    APanel activePanel;

    public FrameManager() {
        // Implement the frame;
        setLayout(null);
        pack();
        Insets insets = getInsets();
        setSize(
            new Dimension(
                (insets.left + insets.right + Config.getFrameWidth()), 
                (insets.bottom + insets.top + Config.getFrameHeight())
            )
        );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        APanel mainPanel = new MainPanel("mainPanel");
        APanel menuPanel = new MenuPanel("menuPanel");

        aPanels.put("main", mainPanel);
        aPanels.put("menu", menuPanel);
        // aPanels.put("game", );
        add(mainPanel);
        mainPanel.add(menuPanel);

        MiddlewareManager middlewareManager = Config.getMiddlewareManager();
        Middleware repaintPanelElements = new RepaintPanelElements(menuPanel);
        MiddlewareLocation middlewareLocation = new MiddlewareLocation();
        middlewareManager.addMiddleware(repaintPanelElements, middlewareLocation);

        setActivePanel("main");
        getAPanel("main").setVisible(true);
        getAPanel("menu").setVisible(true);

        setVisible(true);
    }

    public APanel getAPanel(String id) {
        return aPanels.get(id);
    }

    public APanel getActivePanel() {
        return activePanel;
    }

    public void setActivePanel(String id) {
        activePanel = aPanels.get(id);
    }
}
