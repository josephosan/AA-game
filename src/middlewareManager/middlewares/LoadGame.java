package middlewareManager.middlewares;

import config.Config;
import middlewareManager.MiddlewareLocation;
import middlewareManager.MiddlewareManager;
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

    //THIS CLASS DOES NOT CURRENTLY SUPPORT CUSTOM CONSTRUCTOR FOR MIDDLEWARES.
    //DO NOT MERGE WITH MASTER YET.
    @Override
    public void init(){
        System.out.println("LOAD GAME INIT");
        HashMap<String,HashMap<String,String>> data = new HashMap<String, HashMap<String,String>>();
        //Loading from file
        File file = new File("./../../data/levels/"+level+".aa");
        if(file.exists()){
            // parse file
            // get hashmap
        }
        else{
            System.out.println("Level file not found!");
        }

        HashMap<String,String> h = new HashMap<String,String>();

        //THIS PART IS FOR TEST AND SHOULD BE REMOVED LATER
        h.put("className","middlewareManager.middlewares.ShowMenu"); //name
        //h.put("numberOfArgs",""); //number of args
        //h.put("arg0","");

        data.put("middleware0",h);
        //END OF TEST SECTION
        
        int i = 0;
        while(true){
        
            if(data.containsKey("middleware"+i)){
                try{
                    //getting class name from hashmap
                    String className = data.get("middleware"+i).get("className");
                    // defining middleware manager arguements
                    Class[] middlewareManagerArgs = new Class[2];
                    middlewareManagerArgs[0] = Middleware.class; middlewareManagerArgs[1]= MiddlewareLocation.class;  
                    // Using Method class to invoke the method from heap on run time.
                    Method addMiddleware = middlewareManager.getClass().getMethod("addMiddleware", middlewareManagerArgs);

                    if(data.get("middleware"+i).containsKey("numberOfArgs")){
                        //Middlewares with custom constructor

                        
                        int numberOfArgs = Integer.parseInt(data.get("middleware"+i).get("numberOfArgs"));
                        //Type of middleware's costructor arguments
                        Class[] middlwareArgTypes = new Class[numberOfArgs];
                        //Constructor arguements
                        String[] middlewareArgs = new String[numberOfArgs];

                        // resolving types
                        for (int j=0 ; j<numberOfArgs ; j++){
                            String arg = data.get("middleware"+i).get("arg"+j);
                            if(this.isNumeric(arg)){
                                middlwareArgTypes [j] = double.class;
                                middlewareArgs[j] = arg;
                            }
                            else if (this.isMiddleware(arg)){
                                middlwareArgTypes[j] = Class.forName(arg).getClass();
                                middlewareArgs[j] = arg;
                            }
                            else {
                                middlwareArgTypes[j] = String.class;
                                middlewareArgs[j] = arg;
                            }
                        }
                        //invoking addMiddleware method.
                        addMiddleware.invoke(middlewareManager,Class.forName(className).getConstructor(middlwareArgTypes).newInstance(middlewareArgs), new MiddlewareLocation());
                    }
                    else{
                        //default constructor
                        //invoking addMiddleware method.
                        addMiddleware.invoke(middlewareManager,Class.forName(className).getConstructor().newInstance(),new MiddlewareLocation());
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                    System.out.println("AN ERROR HAPPENED");
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

    private boolean isNumeric(String string){
        try{
            Integer.parseInt(string);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }

    }

    private boolean isMiddleware(String string){
        if(Character.isUpperCase(string.charAt(0))) return true;
        return false;
    }


}
