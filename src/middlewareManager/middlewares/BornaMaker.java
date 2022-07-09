package middlewareManager.middlewares;

import config.Config;
import elementManager.ElementManager;
import elementManager.elements.BigBall;


public class BornaMaker extends Middleware {
    // This is a special method created only for Dr.borna.
    // Cheers!!!
    // This method will draw a picture of Dr.borna inside the main ball, in the center.

    ElementManager elementManager = Config.getElementManager();
    BigBall bigBall;

    public BornaMaker() {
        super("bornaMaker");
    }

    private int generateNum(int max , int min) {
        int ii = -min + (int) (Math.random() * ((max - (-min)) + 1));
        return ii;
    }

    public void run() {
        bigBall = (BigBall)elementManager.getElementById("bigBall");
        bigBall.setOsPosition(bigBall.getPosition().getX()+ generateNum(5, 0)-30,
                bigBall.getPosition().getY()+generateNum(5, 0)-30);
    }
}
