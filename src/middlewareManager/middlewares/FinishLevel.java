package middlewareManager.middlewares;

import config.Config;
import frameManager.*;
import middlewareManager.MiddlewareManager;

import java.awt.Color;

public class FinishLevel extends Middleware {
    APanel panel = Config.getFrameManager().getActivePanel();
    MiddlewareManager middlewareManager = Config.getMiddlewareManager();
    String groupId = "game";

    public FinishLevel(){
        super("finishLevel");
    }

    public FinishLevel(String middlewaresGroupId){
        super("finishLevel");
        this.groupId = middlewaresGroupId;
    }

    @Override
    public void init(){
        //setting green background
        panel.setBackground(new Color(5,242,5));
        //setting rotation speed to 0
        this.setValue("rotationSpeed", "0");
    }

    @Override
    public void run(){

        //creating an animation for when the game is finished.
        if((Config.getLineLength())<(Config.getFrameHeight()))
            Config.setLineLength(Config.getLineLength()+5);
        //stopping procceses and showing finishLevel panel then removing self.
        else{
             //pausing middlewares
            middlewareManager.setPausedMiddlewaresByGroup(groupId, true);

            //TODO add time to profile
            //TODO mark this level as finished in profile
            //TODO open a popup with 3 options: 1.replay 2.next level 3.menu 
            
            this.remove();
        }

       
    }
}
