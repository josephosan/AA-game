package config;

import elementManager.ElementManager;
import frameManager.FrameManager;
import middlewareManager.MiddlewareManager;

public class Config {
    static FrameManager frameManager;
    static MiddlewareManager middlewareManager;
    static ElementManager elementManager;

    static final Integer 
        timerDelay = 300,

        frameWidth = 400, 
        frameHeight = 600;
    


    static final String 
        frameTitle = "AA GAME";


    public Config() {

    }

    public static void frameManagerSubscribe(FrameManager frameManager) {
        Config.frameManager = frameManager;
    }

    public static void middlewareManagerSubscribe(MiddlewareManager middlewareManager) {
        Config.middlewareManager = middlewareManager;
    }

    public static void elementManagerSubscribe(ElementManager elementManager) {
        Config.elementManager = elementManager;
    }

    public static FrameManager getFrameManager() {
        return frameManager;
    }

    public static MiddlewareManager getMiddlewareManager() {
        return middlewareManager;
    }

    public static ElementManager getElementManager() {
        System.out.println("returning elementManager");
        return elementManager;
    }

    public static Integer getFrameWidth() {
        return frameWidth;
    }

    public static Integer getFrameHeight() {
        return frameHeight;
    }

    public static Integer getTimerDelay() {
        return timerDelay;
    }
}
