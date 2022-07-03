package middlewareManager.middlewares;

import config.Config;
import middlewareManager.MiddlewareManager;
import utils.parser.AParser;
import java.util.HashMap;
import java.util.Map;

public class LoadGame extends Middleware {
    int level;
    String panelId = "game";
    MiddlewareManager middlewareManager;
    Middleware middleware;
    public LoadGame(int level){
        super("loadGame");
        this.level = level;
        this.middlewareManager = Config.getMiddlewareManager();
    }

    public LoadGame(int level, String panelId){
        super("loadGame");
        this.level = level;
        this.panelId = panelId;
        this.middlewareManager = Config.getMiddlewareManager();
    }

    //THIS CLASS DOES NOT CURRENTLY SUPPORT OBJECT ARGUEMENT FOR CONSTRUCTORS!
    @Override
    public void init(){
        HashMap<String,String> data = AParser.run("levels/level"+level+".json");
        
        //loading dictionary to middleware manager


        this.setValue("levelSpinningDirection", "1");

        //adding options to middleware manager
        for (Map.Entry<String, String> set : data.entrySet()) {
            if(set.getValue().startsWith("middleware")) continue;
            this.setValue(set.getKey(), set.getValue());
        }

        int i = 0;
        while(true){
        
            if(data.containsKey("middleware"+i)){
                try{
                    String[] middlwareInfo = data.get("middleware"+i).split(" ");
                    //getting class name from hashmap
                    String className = middlwareInfo[0];
                    //adding package name to class
                    className = "middlewareManager.middlewares."+className;
                    int numberOfArgs = Integer.parseInt(middlwareInfo[1]);
                    Class[] middlwareArgTypes = new Class[numberOfArgs];
                    String[] args = new String[numberOfArgs];
                    for (int j=0 ; j<numberOfArgs ; j++){
                        middlwareArgTypes[j] = String.class;
                        args[j] = middlwareInfo[j+2];
                    }

                    switch (numberOfArgs){
                        case 0:
                            middleware = (Middleware)Class.forName(className).getConstructor().newInstance();
                            break;
                        case 1:
                            middleware = (Middleware)Class.forName(className).getConstructor(middlwareArgTypes).newInstance(args[0]);
                            break;
                        case 2:
                            middleware = (Middleware)Class.forName(className).getConstructor(middlwareArgTypes).newInstance(args[0],args[1]);
                            break;
                        case 3:
                            middleware = (Middleware)Class.forName(className).getConstructor(middlwareArgTypes).newInstance(args[0],args[1],args[2]);
                            break;
                        case 4:
                            middleware = (Middleware)Class.forName(className).getConstructor(middlwareArgTypes).newInstance(args[0],args[1],args[2],args[3]);
                            break;
                        default:
                            System.out.println("LoadGame did not load "+middleware.getId());
                    }

                    middlewareManager.addMiddlewareInSeries(middleware);
                    //adding middlewares to group. the id of the group is same as id of panel
                    //the panelId deafult is "game"
                    middleware.join(panelId);
                    
                }
                catch(Exception e){
                    e.printStackTrace();
                    break;
                }
                
            }
            else{
                break;
            }
            i++;
        }
        //creating shootingBalls
        int ballsToConnect = Integer.parseInt(this.getValue("levelNumberOfBallsToConnect"));
        for(int k=0;k<ballsToConnect;k++ ){
            Middleware drawWaitingSmallBall = new DrawSmallBall("90",this.getValue("levelSmallBallsColor"),panelId,false);
            middlewareManager.addMiddlewareInSeries(drawWaitingSmallBall);
            drawWaitingSmallBall.join(panelId);
        }
        //moving first ball into position
        Middleware reloadShootingBall = new ReloadShootingBall();
        middlewareManager.addMiddlewareInSeries(reloadShootingBall);
        reloadShootingBall.join(panelId);
        //rotating small balls that are in orbit
        Middleware spinSmallBalls = new SpinSmallBalls();
        middlewareManager.addMiddlewareInSeries(spinSmallBalls);
        spinSmallBalls.join(panelId);
        //moving shooting balls upward
        Middleware moveSmallBalls = new MoveSmallBall();
        middlewareManager.addMiddlewareInSeries(moveSmallBalls);
        moveSmallBalls.join(panelId);
        //checking impact
        Middleware checkImpact = new CheckImpact();
        middlewareManager.addMiddlewareInSeries( checkImpact);
        checkImpact.join(panelId);
        //checking for remaining balls if there is none, the level is finished
        Middleware checkRemainingBalls = new CheckRemainigBalls(panelId);
        middlewareManager.addMiddlewareInSeries(checkRemainingBalls);
        checkRemainingBalls.join(panelId);
        //adding level timer
        Middleware levelTimer = new LevelTimer();
        middlewareManager.addMiddlewareInSeries(levelTimer);
        levelTimer.join(panelId);
        //adding rendering middleware
        Middleware repaintPanelElements = new RepaintPanelElements(Config.getFrameManager().getAPanel(panelId));
        middlewareManager.addMiddlewareInSeries(repaintPanelElements);
        repaintPanelElements.join(panelId);
        this.remove();
        
    }

}
