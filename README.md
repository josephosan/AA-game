# AA-GAME by java
## Contributers
- Yousof Osanlou 
- Mahbod Ghadiri Sani
- Duniyal Rasouli 
- Danial Azimi 
- Arman Rostami

## Document
use this document to understand!

### setValue and getValue
you can use setValue and getValue in middleware or use setMiddlewareValue and getMiddlewareValue from MiddlewareManager to set and retrive.
it is not necessary to set values only in the middleware you can use this from anywhere in the project
#### keys

- gameName // its aa!
- username // current username from login page 
- levelAuthor 
- levelNumber
- levelName 
- levelBigBallRotationSpeed
- levelNumberOfAllBalls // this key is equal to numOfAllBalls
- levelNumberOfSpinningBalls // this key is equal to numOfBallsToConnect
- levelSmallBallsColor
- levelBigBallColor
- levelSmallBallRadius
- levelBigBallRadius
- levelLineLength
- levelShootBallSpeed
- levelBigBallPosition // use comma seperated statements for matrices. x,y => 200,200
- levelShootingBallPosition
- levelStartTime

### Middleware
#### public Middleware(String id)
constructor of the Middleware gets and id. 
**important:** the should be unique please becareful!

#### public ArrayList<String> getGroups()
returns groups name that this middleware joined.

#### public void join(String group)
this method will join the method to a group.
this method finally calls ```MiddlewareManager.joinGroup```.

#### public void leave(String group) 
this middleware will leave the group.
this method finally calls ```MiddlewareManager.leaveGroup```.

#### public String getId()
returns middleware id.

#### public void setValue(String key, String value)
use this method for communicating between middlewars.
this method finally calls ```MiddlewareManager.setMiddleValue```.

#### public String getValue(String key)
use this method for communicating between middlewars.
this method finally calls ```MiddlewareManager.getMiddlewareValue```.

#### public void init()
this method will call just once by the middlwareManager.
use this method for statements that you want just execute once.

#### public void run() 
this method will call in every loop iteration except the first iteration of the middleware.
use this method for statements that you want to execute every time the loop iterates.

#### public Boolean isFirstTime()
if middleware init method doesn't executed yet this method returns true.

#### public void setFirstTime(Boolean firstTime)
this method is used by the middlewareManager and you should not use it.

#### public void remove() 
whenever you call this method the middleware be removed from the loop and will not execute in the next iteration.

#### public Boolean getShouldRemove()
this method is used by the middlewareManager and you should not use it.

#### public void addLoopingNumber()
this method is used by the middlewareManager and you should not use it.

#### public void setEnteringLoopTime(long time)
this method is used by the middlewareManager and you should not use it.

#### public long getTimePassedFromEnteringLoop()
this method returns the duration that middleware is in the loop in ms.

#### public int getLoopingNumbers()
this method returns the numbers of iteration of the loop from entering this middleware to loop.

### MiddlewareManager
#### public void setMiddlewareValue(String key, String value)
sets a value in ```middlewareValues``` hashmap.
**usage:** if you want communicate between the middlewares you can use this method and it's complement [getMiddlewareValue()](#public-String-getMiddlewareValue(String-key)).

#### public String getMiddlewareValue(String key)
gets a value from ```middlewareValues``` and returns it.

#### public void addMiddleware(Middleware middleware, MiddlewareLocation middlewareLocation)
this is very important method. it gets a middleware and a middlewareLocation and adds the middleware in the main loop.
whenever you want to add a middleware you should use this or [addMiddlewareInSeries()](#public-void-addMiddlewareInSeries(Middleware-middleware)).

#### public void addMiddlewareInSeries(Middleware middleware)
this methods adds a middleware to loop but it doesn't need any MiddlewareLocation.
this method remebers the last middleware that added to loop and adds the middleware after that.
so it is useful if you have some middleware that the orders of them is important just for themself and not the location in main loop.
you can add the first element with ```addMiddleware``` and use this method for rest of the them.
**important:** it is important that you use the ```addMiddleware``` for the first one to update the cursor and prevent unhandled errors.

#### public Middleware getMiddlewareById(String id)
use this if you want access to a middleware with id name.

#### public void loop()
this method is the main loop. you should not touch this one if you don't know what are you doing!!
this method will call every 30ms to run the middlewares.

#### public void removeMiddleware(AaLinkedList.LinkedElement element)
this method is used by the main loop. 
**important:** you never should use this method directly for removing a middleware. instead you should use the ```remove``` method of the ```Middleware```.

#### public void setLoopPause(Boolean pause)
this method pauses the loop.

#### public Boolean isLoopPaused()
this method returns true if loop is paused and false viceversa.

#### public ArrayList<Middleware> getGroup(String group)
returns an ```ArrayList``` that holds the middlewars with this groupname.

#### public void joinGroup(String group, Middleware middleware)
this methods adds a middleware to a group. you shouldn't use this mehtod directly use ```Middleware.join``` method instead.

#### public void leaveGroup(String group, String middlewareId)
this methods find the middleware by id name and calls the below method.

#### public void leaveGroup(String group, Middleware middleware)
removes a middleware from group. you shouldn't use this method directly use ```Middleware.leave``` instead.
