package middlewareManager.middlewares;
import config.Config;
import elementManager.ElementManager;
import elementManager.elements.BigBall;
import elementManager.elements.SmallBall;

public class MoveSmallBall extends Middleware  {
    SmallBall smallBall;
    BigBall bigBall;
    int endY;
    String id;
    ElementManager elementManager= Config.getElementManager();
    public MoveSmallBall(String id){
    super("moveSmallBall");
    this.id=id;
    bigBall = (BigBall)elementManager.getElementById("bigBall");
    endY = bigBall.getR()+bigBall.getPosition().getY();

    }

    @Override
    public void run() {
        smallBall= (SmallBall)this.elementManager.getElementById(id);
        this.smallBall.getPosition().setY(this.smallBall.getPosition().getY()-this.v);
        
    
    }

}

