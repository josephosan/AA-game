package middlewareManager.middlewares;

import frameManager.APanel;

public class ShowGame extends Middleware{

    public ShowGame(){
        super("showGame");
    }
    @Override
    public void init(){
        APanel gamePanel = this.frameManager.getAPanel("gamePanel");
        gamePanel.setVisible(true);
        this.remove();
    }
    
}
