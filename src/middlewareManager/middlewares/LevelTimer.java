package middlewareManager.middlewares;
import java.awt.Font;

import javax.swing.JLabel;
import config.Config;
import frameManager.panels.GamePanel;
import middlewareManager.MiddlewareManager;

public class LevelTimer extends Middleware {
    MiddlewareManager middlewareManager = Config.getMiddlewareManager();
    public static JLabel updateTimeLabel;
    static String END_TIME;
    long startTime=System.currentTimeMillis();
    public LevelTimer() {
        super("levelTimer");
    }
    public void init(){
       this.setValue("levelStartTime",String.valueOf(startTime));
    }
    public void run(){
        updateTimeLabel= ((GamePanel) Config.getFrameManager().getAPanel("game")).getTimerLevel();
        long currentTime= System.currentTimeMillis();
        END_TIME = String.valueOf((currentTime-startTime)/1000);
        middlewareManager.setMiddlewareValue("levelEndTime", END_TIME);
        updateTimeLabel.setText(END_TIME);
        updateTimeLabel.setFont(new Font(Font.SERIF, Font.PLAIN,  30));
    }

}
