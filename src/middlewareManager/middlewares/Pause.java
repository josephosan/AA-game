package middlewareManager.middlewares;

public class Pause extends Middleware {

    private boolean pause;
    private String group;
    public Pause(String group ,boolean pause){
        super("pause");
        this.pause = pause;
        this.group = group;
    }   
    
    @Override
    public void init(){
        this.middlewareManager.setPausedMiddlewaresByGroup(group, pause);
        this.remove();
    }
    
}
