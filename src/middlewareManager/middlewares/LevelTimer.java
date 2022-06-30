package middlewareManager.middlewares;
import java.awt.Font;

import javax.swing.JLabel;
import config.Config;
import frameManager.panels.GamePanel;

public class LevelTimer extends Middleware {
    JLabel updateTimeLabel;
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
        updateTimeLabel.setText(END_TIME);
        updateTimeLabel.setFont(new Font(Font.SERIF, Font.PLAIN,  30));
    }

    public static int getEndTime() {
        return ((END_TIME == null) ? 0 : Integer.parseInt(END_TIME));
    }
    
}
