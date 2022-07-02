package middlewareManager.middlewares;

import config.Config;

import java.awt.*;
import middlewareManager.middlewares.*;
import frameManager.*;

public class TransitionPanels extends Middleware{
    APanel panel1, panel2;
    boolean rightToLeft = true;
    FrameManager frameManager = Config.getFrameManager();
    int transitionSpeed;

    public TransitionPanels(String panel1Id, String panel2Id) {
        super("transitionPanels");
        this.panel1 = frameManager.getAPanel(panel1Id);
        this.panel2 = frameManager.getAPanel(panel2Id);
    }

    public TransitionPanels(String panel1Id, String panel2Id, boolean rightToLeft) {
        super("transitionPanels");
        this.panel1 = frameManager.getAPanel(panel1Id);
        this.panel2 = frameManager.getAPanel(panel2Id);
        this.rightToLeft = rightToLeft;
    }

    

    @Override
    public void init() {
        if(rightToLeft){
            this.panel2.setLocation(Config.getFrameWidth(), 0);
            this.panel2.setVisible(true);
        }
        else {
            this.panel2.setLocation(-Config.getFrameWidth(), 0);
            this.panel2.setVisible(true);
        }
        this.transitionSpeed = Config.getFrameWidth() / 25 ;
        
    }


    @Override
    public void run() {
        ////System.out.println(Config.getFrameWidth());
        if(rightToLeft){
            Point panel1Location = panel1.getLocation();
            if (panel1Location.getX() <= -Config.getFrameWidth()) {
                panel1.setVisible(false);
                panel1.setLocation(0, 0);
                panel2.setLocation(0, 0);
                panel2.requestFocus();;
                this.remove();
                return;
            }
            Point panel2Location = panel2.getLocation();
            panel1.setLocation((int)panel1Location.getX() - transitionSpeed, (int)panel1Location.getY());
            panel2.setLocation((int)panel2Location.getX() - transitionSpeed, (int)panel2Location.getY());
        }
        else {
            Point panel1Location = panel1.getLocation();
            if (panel1Location.getX() >= Config.getFrameWidth()) {
                panel1.setVisible(false);
                panel1.setLocation(0, 0);
                panel2.setLocation(0, 0);
                panel2.requestFocus();;
                this.remove();
                return;
            }
            Point panel2Location = panel2.getLocation();
            panel1.setLocation((int)panel1Location.getX() + transitionSpeed, (int)panel1Location.getY());
            panel2.setLocation((int)panel2Location.getX() + transitionSpeed, (int)panel2Location.getY());
        }
        double x = panel1.getLocation().getX();
        ////System.out.println(transitionSpeed>5 &&  rightToLeft ? x > -Config.getFrameWidth()/2 : x < -Config.getFrameWidth()/2);
        if(transitionSpeed>1 &&  (rightToLeft ? x < (-Config.getFrameWidth()/3)*2 : x > (Config.getFrameWidth()/3)*2)){
            this.transitionSpeed -= 1;
        }
    }
}
