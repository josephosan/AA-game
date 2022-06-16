package middlewareManager;

import java.util.ArrayDeque;
import java.util.ArrayList;
import middlewareManager.middlewares.Middleware;

public class MiddlewareManager {
    ArrayList<Middleware> middlewares;

    Boolean removeRequestInThisTurn = false;
    ArrayList<Integer> removeMiddlewareIds = new ArrayList<Integer>();

    public MiddlewareManager() {
        middlewares = new ArrayList<Middleware>();
    }

    public Integer findMiddlewareIndexById(String id) {
        for (int i = 0; i < middlewares.size(); i++) {
            Middleware middleware = middlewares.get(i);
            if (middleware.getId().equals(id)) {
                return i;
            }
        }

        return -1;
    } 

    public void addMiddleware(Middleware middleware, MiddlewareLocation middlewareLocation) {
        System.out.println("adding middleware");
        Integer insertIndex = -1;
        
        if (middlewareLocation.atIndex != -1) {
            insertIndex = middlewareLocation.atIndex;
        } else if (middlewareLocation.atStart) {
            insertIndex = 0;
        } else if (middlewareLocation.atEnd) {
            insertIndex = middlewares.size() - 1;
            insertIndex = insertIndex == -1 ? 0 : insertIndex; // if size was 0 means no middleware found so insert index is 0;
        } else if (middlewareLocation.getAfter() != null) {
            insertIndex = findMiddlewareIndexById(middlewareLocation.getAfter());
        } else if (middlewareLocation.getBefore() != null) {
            insertIndex = findMiddlewareIndexById(middlewareLocation.getBefore());
        }


        if (insertIndex == -1) {
            // the insert index not found;
            // maybe something should be done here;
            return;
        }

        middlewares.add(insertIndex, middleware);
    }

    // main loop for executing middlewares
    public void loop() {
        System.out.println("from loop");
        for (int i = 0; i < middlewares.size(); i++) {
            System.out.println("from for in loop");
            Middleware middleware = middlewares.get(i);
            if (middleware.isFirstTime()) {
                middleware.setFirstTime(false);
                middleware.init();
                System.out.println("from first Time");
            } else {
                middleware.run();
            }

            if (removeRequestInThisTurn) {
                removeMiddlewareIds.add(i);
                removeRequestInThisTurn = false;
            }
        }

        removeMiddlewares();
    }

    public void removeMiddlewares() {
        for (int i : removeMiddlewareIds) {
            middlewares.set(i, null);
        }
        ArrayList<Middleware> newMiddlewares = new ArrayList<Middleware>();

        for (Middleware middleware : middlewares) {
            if (middleware != null) {
                newMiddlewares.add(middleware);
            }
        }

        middlewares = newMiddlewares;
        removeMiddlewareIds = new ArrayList<Integer>();
    }

    public void removeMiddlewareByIndex() {
        removeRequestInThisTurn = true;
    }
}