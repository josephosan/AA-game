package middlewareManager.middlewares;

import frameManager.FrameManager;
import middlewareManager.MiddlewareManager;
import java.util.ArrayList;
import config.Config;
import utils.AaLinkedList;

public class Middleware {
    String id;
    //---------
    // when a middleware is paused the run method will not 
    // onvoke in the loop but init method will be called
    Boolean paused = false;
    //---------

    //---------
    // a refrence to LinkedElement that wraps this middleware 
    AaLinkedList.LinkedElement linkedElement;
    //---------
    Boolean firstTime = true;
    int loopingNumbers = 0;
    long enteringLoopTime;
    Boolean shouldRemove = false;
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
        shouldRemove = true;
    }

    public Boolean getShouldRemove() {
        return shouldRemove;
    }

    public void setShouldRemove(Boolean shouldRemove) {
        this.shouldRemove = shouldRemove;
    }

    public void addLoopingNumber() {
        loopingNumbers++;
    }

    public void setEnteringLoopTime(long time) {
        enteringLoopTime = time;
    }

    public long getTimePassedFromEnteringLoop() {
        return System.currentTimeMillis() - enteringLoopTime;
    }

    public int getLoopingNumbers() {
        return loopingNumbers;
    }

    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    public Boolean isPaused() {
        return paused;
    }

    public void setLinkedElement(AaLinkedList.LinkedElement linkedElement) {
        this.linkedElement = linkedElement;
    }

    public AaLinkedList.LinkedElement getLinkedElement() {
        return linkedElement;
    }
}
