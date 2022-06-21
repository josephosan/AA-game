package middlewareManager.middlewares;

import frameManager.FrameManager;
import middlewareManager.MiddlewareManager;
import java.util.ArrayList;
import config.Config;

public class Middleware {
    String id;
    Boolean firstTime = true;
    FrameManager frameManager = Config.getFrameManager();
    MiddlewareManager middlewareManager = Config.getMiddlewareManager();
    ArrayList<String> groups = new ArrayList<>();

    public Middleware(String id) {
        this.id = id;
    }

    public ArrayList<String> getGroups() {
        return groups;
    }

    public void join(String group) {
        groups.add(group);
        middlewareManager.joinGroup(group, this);
    }

    public void leave(String group) {
        groups.remove(group);
        middlewareManager.leaveGroup(group, this);
    }

    public String getId() {
        return id;
    }

    public void setValue(String key, String value) {
        middlewareManager.setMiddlewareValue(key, value);
    }

    public String getValue(String key) {
        return middlewareManager.getMiddlewareValue(key);
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
