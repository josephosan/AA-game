package middlewareManager.middlewares;

import config.Config;
import elementManager.ElementManager;
import elementManager.elements.Element;
import middlewareManager.MiddlewareLocation;
import middlewareManager.MiddlewareManager;
import utils.Tools;
import java.util.ArrayList;

public class CheckImpact extends Middleware {
    ElementManager elementManager = Config.getElementManager();
    MiddlewareManager middleWareManager  = Config.getMiddlewareManager();
    ArrayList<Element> rotatingSmallBalls;
    ArrayList<Element> shootingSmallBalls;

    public CheckImpact() {
        super("checkImpact");
    }

    public boolean checkIfClashed(Element rotatingSB, Element shootingSB) { // checking if balls had impacted.
        int impactRange = Config.getSmallCircleRadios()*2; // impact range is 2*smallCircleRadios
        double distance = Tools.getTwoPointDistance(
                rotatingSB.getPosition().getX(),
                rotatingSB.getPosition().getY(),
                shootingSB.getPosition().getX(),
                shootingSB.getPosition().getY());
                if(distance <= impactRange){
                    //System.out.println("IMPACT");
                    //System.out.println("rotating ball: "+rotatingSB.getPosition()+" shooting ball: "+shootingSB.getPosition());
                    //System.out.println("distance: "+distance+"impact range: "+impactRange);
                }
        return distance <= impactRange;
    }

    public void run() {
        rotatingSmallBalls = elementManager.getElementsByGroup("rotatingSmallBalls"); // getting two groups from ElementManager.
        shootingSmallBalls = elementManager.getElementsByGroup("shootingSmallBalls");

        if(rotatingSmallBalls==null || shootingSmallBalls==null) return;
        for (Element rotatingSB : rotatingSmallBalls)
            for (Element shootingSB : shootingSmallBalls)
                if (checkIfClashed(rotatingSB, shootingSB)) { // if two balls clashed: end the game
                    Middleware gameOver = new GameOver();     // by adding the gameOver class to middlewareManager.
                    middleWareManager.addMiddleware(gameOver, new MiddlewareLocation());
                    this.remove(); // after adding GameOver to the loop, this middleware will remove itself from loop.
                } 
    }
}
