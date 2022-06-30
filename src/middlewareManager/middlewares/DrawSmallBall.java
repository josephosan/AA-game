package middlewareManager.middlewares;

import config.Config;
import elementManager.ElementManager;
import elementManager.coordinate.AaPosition;
import elementManager.elements.SmallBall;
import frameManager.FrameManager;
import middlewareManager.MiddlewareLocation;
import utils.calculations.Angle;
import java.awt.Color;

//This middleware create a SmallBall instance.
//Then it will add it to "rotatingSmallBalls" Group or "selectShooting"
//The constructor accepts String so it can work around "LoadGame" shortcomings.
//The us of "n" variable is to ensure that we won't use duplicate id.

public class DrawSmallBall extends Middleware{
    static int n = 0;   //to keep track how many times this middleware has been called.
    final int id;       // to store n before n changes as a result of this middleware being called again. 
    String panelId = "game";
    String rgb;
    boolean isRotating = true;
    Angle angle;
    ElementManager elementManager = Config.getElementManager();
    FrameManager frameManager = Config.getFrameManager();

    public DrawSmallBall(String angle){
        super("AddSmallBall"+n);
        int numberOfAllBalls = Integer.parseInt(this.getValue("numOfAllBalls")); 
        id = numberOfAllBalls - n;
        n++;
        this.angle = new Angle(Double.parseDouble(angle));
    }

    public DrawSmallBall(String angle, String rgb){
        super("AddSmallBall"+n);
        int numberOfAllBalls = Integer.parseInt(this.getValue("numOfAllBalls")); 
        id = numberOfAllBalls - n;
        n++;
        this.angle = new Angle(Double.parseDouble(angle));
        this.rgb = rgb;
    }

    public DrawSmallBall(String angle, String rgb,String panelId){
        super("AddSmallBall"+n);
        int numberOfAllBalls = Integer.parseInt(this.getValue("numOfAllBalls")); 
        id = numberOfAllBalls - n;
        n++;
        this.angle = new Angle(Double.parseDouble(angle));
        this.rgb = rgb;
        this.panelId = panelId;
    }


    public DrawSmallBall(String angle, boolean isRotating){
        super("AddSmallBall"+n);
        int numberOfAllBalls = Integer.parseInt(this.getValue("numOfAllBalls")); 
        id = numberOfAllBalls - n;
        n++;
        this.angle = new Angle(Double.parseDouble(angle));
        this.isRotating = isRotating;
    }

    public DrawSmallBall(String angle, String rgb, boolean isRotating){
        super("AddSmallBall"+n);
        int numberOfAllBalls = Integer.parseInt(this.getValue("numOfAllBalls")); 
        id = numberOfAllBalls - n;
        n++;
        this.angle = new Angle(Double.parseDouble(angle));
        this.rgb = rgb;
        this.isRotating = isRotating;
    }

    public DrawSmallBall(String angle, String rgb,String panelId, boolean isRotating){
        super("AddSmallBall"+n);
        int numberOfAllBalls = Integer.parseInt(this.getValue("numOfAllBalls")); 
        id = numberOfAllBalls - n;
        n++;
        this.angle = new Angle(Double.parseDouble(angle));
        this.rgb = rgb;
        this.panelId = panelId;
        this.isRotating = isRotating;
    }

    @Override
    public void init(){
        // handling creation of rotatinSmallBall
        if(isRotating){
            //creating SmallBall instance
            SmallBall smallBall = new SmallBall(frameManager.getAPanel(panelId), angle);
            smallBall.setNumber(id);
            if(rgb != null) smallBall.setColor(new Color(Integer.decode(rgb)));
            //adding smallBall to elementManager
            elementManager.addElement("smallBall"+id, smallBall);
            //adding SmallBall to "rotatingSmallBalls" Group.
            elementManager.joinGroup("rotatingSmallBalls", "smallBall"+id);
            elementManager.joinGroup("game", "smallBall"+id);
            this.middlewareManager.addMiddleware(new DrawLine(smallBall.getNumber(), panelId), new MiddlewareLocation());
            this.remove();
            return;
        }

        //handling creation of ShootingBalls
        SmallBall smallBall = new SmallBall(frameManager.getAPanel(panelId),new Angle());
        smallBall.setNumber(id);
        smallBall.setNumberVisible(true);
        if(rgb != null) smallBall.setColor(new Color(Integer.decode(rgb)));
        //setting smallBall Position
        AaPosition sp = Config.getShootingPosition();
        smallBall.setPosition(new AaPosition(sp.getX(),sp.getY()+400)); //TODO get a variable instaed of hardcoding 400
        //adding smallBall to elementManager
        elementManager.addElement("smallBall"+id, smallBall);
        //adding SmallBall to "selectShootBall" Group.
        elementManager.joinGroup("selectShootBall", "smallBall"+id);
        elementManager.joinGroup("game", "smallBall"+id);
        this.remove();
    }
    
}
