import middlewareManager.*;
import middlewareManager.middlewares.*;
import elementManager.*;
import frameManager.*;
import soundManager.*;

import java.util.ListResourceBundle;
import java.util.TimerTask;
import aaTimer.AaTimer;
import config.Config;

import utils.AaLinkedList;

public class Aa {
    public static void main(String[] args) {


        Middleware middleawre1 = new Middleware("test");
        
        AaLinkedList list = new AaLinkedList();
        for (int i = 0; i < 5; i++) {
            list.add(middleawre1);
        }
        //System.out.println("HHHHHHHH");
        //System.out.println(list);
        list.addAtStart(middleawre1);


        //System.out.println(list);
        list.remove(list.getByIndex(0));
        list.remove(list.getByIndex(3));
        list.remove(list.getByIndex(0));
        //System.out.println(list);
        // System.exit(0);

        MiddlewareManager middlewareManager = new MiddlewareManager();
        Config.middlewareManagerSubscribe(middlewareManager);

        ElementManager elementManager = new ElementManager();
        Config.elementManagerSubscribe(elementManager);

        FrameManager frameManager = new FrameManager();
        Config.frameManagerSubscribe(frameManager);

        SoundManager soundManager = new SoundManager();
        Config.soundManagerSubscribe(soundManager);
        
        frameManager.addMiddlewares();

        TimerTask timerTask = new TimerTask() {
            public void run() {
                ////System.out.println("from timer run");
                middlewareManager.loop();
            }
        };

        Middleware showLogin = new ShowPanel("login");
        MiddlewareLocation showMenuLocation = new MiddlewareLocation();

        middlewareManager.addMiddleware(showLogin, showMenuLocation);
       

        AaTimer aaTimer = new AaTimer(timerTask);
        aaTimer.play();


    }
}