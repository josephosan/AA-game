package middlewareManager.middlewares;

import frameManager.FrameManager;
import middlewareManager.MiddlewareManager;

import config.Config;

public class Middleware {
    String id;
    Boolean firstTime = true;
    FrameManager frameManager = Config.getFrameManager();
    MiddlewareManager middlewareManager = Config.getMiddlewareManager();

    public Middleware(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void init() {
        
    }

    public void run() {

    }

    public Boolean isFirstTime() {
        return firstTime; 
    }

    public void setFirstTime(Boolean firstTime) {
        this.firstTime = firstTime;
    }

    public void remove() {
        this.middlewareManager.removeMiddlewareByIndex();
    }
}
