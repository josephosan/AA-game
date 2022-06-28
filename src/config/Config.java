package config;

import elementManager.ElementManager;
import frameManager.FrameManager;
import middlewareManager.MiddlewareManager;
import elementManager.coordinate.*;

public class Config {
    static FrameManager frameManager;
    static MiddlewareManager middlewareManager;
    static ElementManager elementManager;

    static final Integer
        timerDelay = 30,

        frameWidth = 400, 
        frameHeight = 600,
        smallCircleRadios = 0;

    static Integer lineLength = 100;
    
    static final int speedShootBall = 30;
    static final AaPosition mainCirclePosition = new AaPosition(200, 200), // mahbod
                            shootingPosition = new AaPosition(200,400);
    static final AaSize 
        mainCircleSize = new AaSize(100, 100);

    static final AaSize
        smallBallSize = new AaSize(16,16);

    static final String 
        frameTitle = "AA GAME";


    public Config() {

    }

    public static void frameManagerSubscribe(FrameManager frameManager) {
        Config.frameManager = frameManager;
        Config.emitConfigSubscribe();
    }

    public static void middlewareManagerSubscribe(MiddlewareManager middlewareManager) {
        Config.middlewareManager = middlewareManager;
        Config.emitConfigSubscribe();
    }

    public static void elementManagerSubscribe(ElementManager elementManager) {
        Config.elementManager = elementManager;
        Config.emitConfigSubscribe();
    }

    public static void emitConfigSubscribe() {
        if (
            Config.elementManager != null
            && Config.middlewareManager != null
            && Config.frameManager != null
        ) {
            Config.elementManager.onConfigSubscribe();
            Config.middlewareManager.onConfigSubscribe();
            Config.frameManager.onConfigSubscribe();
        }
       
    }

    public static FrameManager getFrameManager() {
        return frameManager;
    }

    public static MiddlewareManager getMiddlewareManager() {
        return middlewareManager;
    }

    public static ElementManager getElementManager() {
//        System.out.println("returning elementManager");
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

    public static AaSize getMainCircleSize() {
        return mainCircleSize;
    }

    public static AaSize getSmallBallSize(){
        return smallBallSize;
    }
    public static int getSpeedShootBall(){
        return speedShootBall;
    }
    public static Integer getSmallCircleRadios() { return smallCircleRadios; }

    public static Integer getLineLength() { return lineLength; }


    public static AaPosition getMainCirclePosition() { return mainCirclePosition; }

    public static AaPosition getShootingPosition() {return shootingPosition; }

    public static void setLineLength(Integer lengthOfLines){
        lineLength = lengthOfLines;
    }
}


