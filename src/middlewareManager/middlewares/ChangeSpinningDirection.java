package middlewareManager.middlewares;

public class ChangeSpinningDirection extends Middleware{
    int delayFrame;
    public ChangeSpinningDirection(String delayFrame) {
        super("changeSpinningDirection");
        this.delayFrame = Integer.parseInt(delayFrame);
        this.setValue("levelSpinningDirection", "1");
    }

    @Override
    public void run() { 
        
        if ((this.getLoopingNumbers() % delayFrame) == 0) {
            String prevDirection = this.getValue("levelSpinningDirection");
            this.setValue("levelSpinningDirection", (
                prevDirection.equals("1") ? "-1" : "1"
            ));
        }
    }
}
