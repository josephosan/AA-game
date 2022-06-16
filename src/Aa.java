import middlewareManager.*;
import middlewareManager.middlewares.*;
import elementManager.*;
import frameManager.*;
import java.util.TimerTask;

import aaTimer.AaTimer;
import config.Config;

public class Aa {
    public static void main(String[] args) {
        MiddlewareManager middlewareManager = new MiddlewareManager();
        Config.middlewareManagerSubscribe(middlewareManager);

        ElementManager elementManager = new ElementManager();
        Config.elementManagerSubscribe(elementManager);

        FrameManager frameManager = new FrameManager();
        Config.frameManagerSubscribe(frameManager);
        
        frameManager.addMiddlewares();

        TimerTask timerTask = new TimerTask() {
            public void run() {
                System.out.println("from timer run");
                middlewareManager.loop();
            }
        };

        Middleware showMenu = new ShowMenu();
        MiddlewareLocation showMenuLocation = new MiddlewareLocation();

         middlewareManager.addMiddleware(showMenu, showMenuLocation);

        AaTimer aaTimer = new AaTimer(timerTask);
        aaTimer.play();
    }
}