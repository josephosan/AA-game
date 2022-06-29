package middlewareManager.middlewares;

import frameManager.APanel;
import middlewareManager.MiddlewareLocation;

import java.awt.Color;
import config.Config;

public class GameOver extends Middleware {
    String panelId = "game";
    public GameOver() {
        super("gameOver");
    }

    public GameOver(String panelId) {
        super("gameOver");
        this.panelId = panelId;
    }

    @Override
    public void init() {
        //setting red background
        APanel gamePanel = this.frameManager.getAPanel(panelId);
        gamePanel.setBackground(Color.RED);
        //stopping rotation (keeping SpinSmallBalls middleware for animation)
        this.setValue("rotationSpeed", "0");
    }

    @Override
    public void run(){
        // //Generating an animation for when the game is over.
        // if((Config.getLineLength())<(Config.getFrameHeight()))
        //     Config.setLineLength(Config.getLineLength()+5);
        // //pausing middlewares,showing gameover panel and removing self.
        //else{
            this.middlewareManager.setPausedMiddlewaresByGroup(panelId, true);
        //     this.middlewareManager.addMiddleware(new TransitionPanels("game", "gameOver"), new MiddlewareLocation());
        //     //TODO add remove elements middleware
        //     this.remove();
        // }
    }
}


