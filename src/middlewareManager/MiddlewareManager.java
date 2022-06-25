package middlewareManager;

import java.util.ArrayList;
import java.util.HashMap;
import middlewareManager.middlewares.Middleware;
import utils.AaLinkedList;
import utils.AaLinkedList.LinkedElement;

public class MiddlewareManager {
    // when loop is runnig the var becomes true;
    Boolean inLoop = false;
    Middleware runningMiddlewareInLoop;
    //------------
    HashMap<String, AaLinkedList.LinkedElement> middlewaresMap = new HashMap<>();
    AaLinkedList middlewares = new AaLinkedList();
    Boolean loopIsPaused = false;
    ArrayList<Integer> removeMiddlewareIds = new ArrayList<Integer>();
    HashMap<String, String> middlewareValues = new HashMap<>();
    HashMap<String, ArrayList<Middleware>> groups = new HashMap<>();

    public MiddlewareManager() {
    }

    // this method will call when all the components of app 
    // getting accessible from the Config
    public void onConfigSubscribe() {

    }

    public void joinGroup(String group, Middleware middleware) {
        if (groups.containsKey(group) == false) {
            groups.put(group, new ArrayList<Middleware>());
        }
        groups.get(group).add(middleware);
    }

    public void leaveGroup(String group, String middlewareId) {
        Middleware middleware = getMiddlewareById(middlewareId);
        leaveGroup(group, middleware);
    }

    public void leaveGroup(String group, Middleware middleware) {
        if (middleware == null) return;
        int i = -1;
        if (groups.containsKey(group)) {
            ArrayList<Middleware> middlewares = getGroup(group);
            for (Middleware _middleware : middlewares) {
                i++;
                if (_middleware == middleware) {
                    middlewares.remove(i);
                    return;
                }
            }
        }   
    }

    public ArrayList<Middleware> getGroup(String group) {
        return groups.get(group);
    }

    public void setMiddlewareValue(String key, String value) {
        middlewareValues.put(key, value);
    }

    public String getMiddlewareValue(String key) {
        return middlewareValues.get(key);
    }

    public AaLinkedList.LinkedElement findLinkedElementById(String id) {
        AaLinkedList.Iterator iterator = middlewares.getIterator();
        while(iterator.hasNext()) {
            AaLinkedList.LinkedElement element= iterator.next();
            Middleware middleware = element.getMiddleware();
            if (middleware.getId().equals(id)) {
                return element;
            }
        }

        return null;
    }

    public void addMiddleware(Middleware middleware, MiddlewareLocation middlewareLocation) {
        Boolean done = true;
        if (middlewareLocation.atStart) {
            middlewares.addAtStart(middleware);
        } else if (middlewareLocation.atEnd) {
            middlewares.add(middleware);
        } else if (middlewareLocation.getAfter() != null) {
            AaLinkedList.LinkedElement element = findLinkedElementById(middlewareLocation.getAfter());
            middlewares.addAfter(middleware, element);
        } else if (middlewareLocation.getBefore() != null) {
            AaLinkedList.LinkedElement element = findLinkedElementById(middlewareLocation.getAfter());
            middlewares.addAfter(middleware, element);
        } else if (middlewareLocation.atIndex != -1) {

        } else {
            done = false;
        }

        if (done) {
            middlewaresMap.put(middleware.getId(), middlewares.getLastAddedLinkedElement());
            middleware.setLinkedElement(middlewares.getLastAddedLinkedElement());
        }
    }


    // add middlewars in series 
    // for example if your middlewares has order in adding to loop
    // and it is not important where middleware is actually in the loop
    // you can use this method.
    public void addMiddlewareInSeries(Middleware middleware) {
        AaLinkedList.LinkedElement lastAddedElement = middlewares.getLastAddedLinkedElement();
        middlewares.addAfter(middleware, lastAddedElement);

        middlewaresMap.put(middleware.getId(), middlewares.getLastAddedLinkedElement());
        middleware.setLinkedElement(middlewares.getLastAddedLinkedElement());
    }

    public Middleware getMiddlewareById(String id) {
        return middlewaresMap.get(id).getMiddleware();
    }

    public void loop() {
        if (loopIsPaused) return;
        inLoop = true;

        AaLinkedList.Iterator iterator = middlewares.getIterator();
        while(iterator.hasNext()) {
            AaLinkedList.LinkedElement element = iterator.next();
            Middleware middleware = element.getMiddleware();
            runningMiddlewareInLoop = middleware;

            if (middleware.isFirstTime()) {
                middleware.setEnteringLoopTime(System.currentTimeMillis());
                middleware.setFirstTime(false);
                middleware.init();
            } else if (middleware.isPaused() == false) {
                middleware.run();
            }

            middleware.addLoopingNumber();

            if (middleware.getShouldRemove()) {
                removeMiddleware(element);
            }
        }

        runningMiddlewareInLoop = null;
        inLoop = false;
    }

    public void removeMiddleware(AaLinkedList.LinkedElement element) {
        middlewares.remove(element);
        // removing from groups
        Middleware middleware = element.getMiddleware();
        for (String group : middleware.getGroups()) {
            leaveGroup(group, middleware);
        }
    }

    // use this method to remove the middlewares in a group;
    // becareful when using this method it can make conflicts 
    // in loop
    public void removeMiddlewaresByGroup(String group) {
        if (!groups.containsKey(group)) return;
        for (Middleware middleware : groups.get(group)) {
            if (middleware == runningMiddlewareInLoop) {
                // if current running middleware is in this group 
                // we not removing that
                // because the this middleware is invoking this 
                // removing the group and may cause some problems
                middleware.setShouldRemove(true);
            } else {
                middlewares.remove(middleware.getLinkedElement());
            }
        }
    }

    // use this method to pause middlewars in a group
    // runningMiddleware also will be setted and not there is 
    // no checks;
    public void setPausedMiddlewaresByGroup(String group, Boolean paused) {
        if (!groups.containsKey(group)) return;
        for (Middleware middleware : groups.get(group)) {
            middleware.setPaused(paused);
        }
    }

    public void setLoopPause(Boolean pause) {
        loopIsPaused = pause;
    }

    public Boolean isLoopPaused() {
        return loopIsPaused;
    }
}