package middlewareManager.middlewares;

import config.Config;
import middlewareManager.MiddlewareManager;
import utils.parser.AParser;
import java.util.HashMap;

public class LoadGame extends Middleware {
    int level;
    MiddlewareManager middlewareManager;
    Middleware middleware;
    public LoadGame(int level){
        super("LoadGame");
        this.level = level;
        this.middlewareManager = Config.getMiddlewareManager();
    }

    //THIS CLASS DOES NOT CURRENTLY SUPPORT OBJECT ARGUEMENT FOR CONSTRUCTORS!
    @Override
    public void init(){
        HashMap<String,String> data = AParser.run("level"+level+".json");
        
        int i = 0;
        while(true){
        
            if(data.containsKey("middleware"+i)){
                try{
                    String[] middlwareInfo = data.get("middleware"+i).split(" ");
                    //getting class name from hashmap
                    String className = middlwareInfo[0];
    
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
                    middlewareManager.joinGroup("game", middleware);
                    
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
        this.remove();
        
    }

}
