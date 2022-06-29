package middlewareManager.middlewares;
import java.awt.Font;

import javax.swing.JLabel;
import config.Config;
import frameManager.panels.GamePanel;

public class LevelTimer extends Middleware {
      JLabel updateTimeLabel;
  long startTime=System.currentTimeMillis();
    public LevelTimer(String id) {
        super("levelTimer");
        
    }
    public void init(){
       this.setValue("levelStartTime",String.valueOf(startTime));
    }
    public void run(){
        updateTimeLabel= ((GamePanel) Config.getFrameManager().getAPanel("game")).getTimerLevel();
        long currentTime= System.currentTimeMillis();
        updateTimeLabel.setText(String.valueOf((currentTime-startTime)/1000));
        updateTimeLabel.setFont(new Font(Font.SERIF, Font.PLAIN,  30));
    }
    
}
