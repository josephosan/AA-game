package middlewareManager.middlewares;

import config.Config;
import java.util.ArrayList;
import elementManager.elements.Element;
import elementManager.elements.SmallBall;
import middlewareManager.MiddlewareLocation;

public class AutoShooter extends Middleware {
    final int distance;
    final int shootingSpeed;
    int rotationSpeed;
    public AutoShooter(){
        super("autoShooter");
        distance = Config.getShootingPosition().getY()-Config.getMainCirclePosition().getY();
        shootingSpeed = Config.getSpeedShootBall();
    }

    @Override
    public void run(){
        //getting rotationSpeed
        //note that rotation speed may change during runtime
        rotationSpeed = Integer.parseInt(this.getValue("rotationSpeed"));
        //getting small balls around the big ball.
        ArrayList<Element> rotatingSmallBalls = Config.getElementManager().getElementsByGroup("rotatingSmallBalls");
        if(rotatingSmallBalls==null) return;

        //calculating rotationAmount and impactRange
        int rotationAmount = (distance/shootingSpeed)*rotationSpeed;
        double impactRange = Math.toDegrees(Math.asin(((2*(double)Config.getSmallCircleRadios())/(double)Config.getLineLength())));

        for(Element smallBall:rotatingSmallBalls){
            double sbAngle = ((SmallBall)smallBall).getAngle().getInDegree();
            //check for possible impact
            System.out.println("rotation amount: "+rotationAmount+" impact range: "+impactRange);
            System.out.println((90-rotationAmount+impactRange)+"  "+(90-rotationAmount-impactRange));
            System.out.println(sbAngle+"  "+((sbAngle <= (90-rotationAmount+impactRange)) && (sbAngle>=(90-rotationAmount-impactRange))));
            if((sbAngle <= (90-rotationAmount+impactRange)) && (sbAngle>=(90-rotationAmount-impactRange))) return;
        }

        //shooting the ball
        middlewareManager.addMiddleware(new middlewareManager.middlewares.SelectShootBall(), new MiddlewareLocation());
        this.remove();
    }

}
