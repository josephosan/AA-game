package middlewareManager.middlewares;

import frameManager.APanel;
import frameManager.panels.GamePanel;
import middlewareManager.MiddlewareLocation;
import utils.Tools;
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
<<<<<<< HEAD
        GamePanel g = (GamePanel)gamePanel;
        g.setButtonColor(Color.RED);
        //stopping rotation (keeping SpinSmallBalls middleware for animation)
=======

        //playing game over sound //note that no sound will be played most of the times
>>>>>>> master
        this.setValue("rotationSpeed", "0");
        String[] sounds = {"emotionalDamage","soSad"};
        String sound = Tools.chooseRandomSound(sounds);
        Config.getSoundManager().play(sound);
        //stopping rotation (keeping SpinSmallBalls middleware for animation)
        this.middlewareManager.setPausedMiddlewareById("moveSmallBall", true);
        this.middlewareManager.setPausedMiddlewareById("reloadShootingBall", true);
    }

    @Override
    public void run(){

        //Generating an animation for when the game is over.
        if((Config.getLineLength())<(Config.getFrameHeight())) {
            Config.setLineLength(Config.getLineLength()+5);
        }
        //pausing middlewares,showing gameover panel and removing self.
        else{
            this.middlewareManager.addMiddleware(new TransitionPanels("game", "gameOver"), new MiddlewareLocation());
            this.middlewareManager.removeMiddlewaresByGroup(panelId);
            Config.getElementManager().removeElementsByGroup(panelId);
            //TODO remove elements
            this.remove();
        }
    }
}




