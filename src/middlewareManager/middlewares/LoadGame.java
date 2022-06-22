package middlewareManager.middlewares;

import config.Config;
import middlewareManager.MiddlewareLocation;
import middlewareManager.MiddlewareManager;
import utils.parser.AParser;
import java.io.File;
import java.util.HashMap;
import java.lang.reflect.*;

public class LoadGame extends Middleware {
    int level;
    MiddlewareManager middlewareManager;

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
                    // defining middleware manager arguements
                    Class[] middlewareManagerArgs = new Class[2];
                    middlewareManagerArgs[0] = Middleware.class; middlewareManagerArgs[1]= MiddlewareLocation.class;  
                    // Using Method class to invoke the method from heap on run time.
                    Method addMiddleware = middlewareManager.getClass().getMethod("addMiddleware", middlewareManagerArgs);
    
                    int numberOfArgs = Integer.parseInt(middlwareInfo[1]);

                    Class[] middlwareArgTypes = new Class[numberOfArgs];
                    String[] args = new String[numberOfArgs];
                    for (int j=0 ; j<numberOfArgs ; j++){
                        middlwareArgTypes[j] = String.class;
                        args[j] = middlwareInfo[j+2];
                    }

                    switch (numberOfArgs){
                        case 0:
                            addMiddleware
                                .invoke(
                                    middlewareManager,
                                    Class.forName(className).getConstructor().newInstance(),
                                    new MiddlewareLocation());
                            break;
                        case 1:
                            addMiddleware
                                .invoke(
                                    middlewareManager,
                                    Class.forName(className).getConstructor(middlwareArgTypes).newInstance(args[0]),
                                    new MiddlewareLocation());
                            break;
                        case 2:
                            addMiddleware
                                .invoke(
                                    middlewareManager,
                                    Class.forName(className).getConstructor(middlwareArgTypes).newInstance(args[0],args[1]),
                                    new MiddlewareLocation());
                            break;
                        case 3:
                            addMiddleware
                                .invoke(
                                    middlewareManager,
                                    Class.forName(className).getConstructor(middlwareArgTypes).newInstance(args[0],args[1],args[2]),
                                    new MiddlewareLocation());
                            break;
                        case 4:
                            addMiddleware
                                .invoke(
                                    middlewareManager,
                                    Class.forName(className).getConstructor(middlwareArgTypes).newInstance(args[0],args[1],args[2],args[3]),
                                    new MiddlewareLocation());
                            break;
                        default:
                            //throw error 
                    }
                    
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
