package middlewareManager.middlewares;
import config.Config;
import elementManager.ElementManager;
import elementManager.elements.BigBall;
import elementManager.elements.SmallBall;

public class MoveSmallBall extends Middleware  {
    SmallBall smallBall;
    BigBall bigBall;
    int endY;
    
    public MoveSmallBall(SmallBall smallBall){
    super("moveSmallBall");
    this.smallBall = smallBall;
    ElementManager elementManager= Config.getElementManager();
    bigBall = (BigBall)elementManager.getElementById("bigBall");
    endY = bigBall.getR()+bigBall.getPosition().getY();

    }

    @Override
    public void run() {
        this.smallBall.getPosition().setY(this.smallBall.getPosition().getY()-10);;
        if(this.smallBall.getPosition().getY()<=endY){
            this.remove();
            return;
        }
    
    }

}

