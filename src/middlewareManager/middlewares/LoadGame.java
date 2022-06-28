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
                            //throw error 
                    }

                    middlewareManager.addMiddlewareInSeries(middleware);
                    //adding middlewares to group. the id of the group is same as id of panel
                    //the panelId deafult is "game"
                    middlewareManager.joinGroup(panelId, middleware);
                    
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
        int ballsToConnect = Integer.parseInt(this.getValue("numOfBallsToConnect"));
        for(int k=0;k<ballsToConnect;k++ ){
            middlewareManager.addMiddlewareInSeries(new DrawSmallBall("90",this.getValue("smallBallsColor"),panelId,false));
        }
        //moving first ball into position
        middlewareManager.addMiddlewareInSeries(new ReloadShootingBall());
        //checking impact
        ////middlewareManager.addMiddlewareInSeries(new CheckImpact());
        //moving shooting balls upward
        middlewareManager.addMiddlewareInSeries(new MoveSmallBall());
        //adding rendering middleware
        middlewareManager.addMiddlewareInSeries(new RepaintPanelElements(Config.getFrameManager().getAPanel(panelId)));
        
        this.remove();
        
    }

}
