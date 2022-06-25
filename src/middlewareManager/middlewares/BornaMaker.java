package middlewareManager.middlewares;

import config.Config;
import elementManager.ElementManager;
import elementManager.elements.BigBall;


public class BornaMaker extends Middleware {
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
        bigBall.setBornaPosition(bigBall.getPosition().getX()+ generateNum(5, 0)-30,
                bigBall.getPosition().getY()+generateNum(5, 0)-30);
    }
}
