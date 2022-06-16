package middlewareManager.middlewares;

import config.Config;

import java.awt.*;
import middlewareManager.middlewares.*;
import frameManager.*;

public class TransitionPanels extends Middleware{
    APanel panel1, panel2;
    FrameManager frameManager = Config.getFrameManager();
    public TransitionPanels(String panel1Id, String panel2Id) {
        super("transitionPanels");
        this.panel1 = frameManager.getAPanel(panel1Id);
        this.panel2 = frameManager.getAPanel(panel2Id);
    }

    @Override
    public void init() {
        this.panel2.setLocation(Config.getFrameWidth(), 0);
        this.panel2.setVisible(true);
    }


    @Override
    public void run() {
        Point panel1Location = panel1.getLocation();
        if (panel1Location.getX() <= -Config.getFrameWidth()) {
            panel1.setVisible(false);
            panel1.setLocation(0, 0);
            panel2.setLocation(0, 0);
            this.remove();
            return;
        }
        Point panel2Location = panel2.getLocation();
        panel1.setLocation((int)panel1Location.getX() - 10, (int)panel1Location.getY());
        panel2.setLocation((int)panel2Location.getX() - 10, (int)panel2Location.getY());

    }
}
