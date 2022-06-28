package middlewareManager.middlewares;

import java.awt.Color;
import config.Config;
import elementManager.elements.BigBall;

public class DrawBigBall extends Middleware {
    BigBall bigBall;
    String panelId = "game";
    String rgb;

    public DrawBigBall(int x, int y){
        super("drawBigBall");
        bigBall = new BigBall(this.frameManager.getAPanel(panelId));
        bigBall.setPos(x, y);
    }

    public DrawBigBall(int x, int y , String panelId){
        super("drawBigBall");
        this.panelId = panelId;
        bigBall = new BigBall(this.frameManager.getAPanel(panelId));
        bigBall.setPos(x, y);
    }

    public DrawBigBall(String x, String y){
        super("drawBigBall");
        bigBall = new BigBall(this.frameManager.getAPanel(panelId));
        bigBall.setPos(Integer.parseInt(x), Integer.parseInt(y));
    }

    public DrawBigBall(String x, String y, String panelId){
        super("drawBigBall");
        bigBall = new BigBall(this.frameManager.getAPanel(panelId));
        this.panelId = panelId;
        bigBall.setPos(Integer.parseInt(x), Integer.parseInt(y));
    }

    public DrawBigBall(String x, String y, String rgb, String panelId){
        super("drawBigBall");
        bigBall = new BigBall(this.frameManager.getAPanel(panelId));
        this.panelId = panelId;
        bigBall.setPos(Integer.parseInt(x), Integer.parseInt(y));
        this.rgb = rgb;
    }

    public DrawBigBall(BigBall bigBall){
        super("drawBigBall");
        this.bigBall = bigBall;
    }

    @Override
    public void init(){
        Config.getElementManager().addElement("bigBall", bigBall);
        if(rgb != null){
            bigBall.setColor(new Color(Integer.decode(rgb)));
        }
        this.remove();
    }
}
