package middlewareManager.middlewares;

import config.Config;
import middlewareManager.MiddlewareManager;

public class ChangeSpinningDirectionOnShootBall extends Middleware{
    MiddlewareManager middlewareManager = Config.getMiddlewareManager();
    private Boolean changed = false;
    public ChangeSpinningDirectionOnShootBall() {
        super("changeSpinningDirectionOnShootBall");
    }

    @Override
    public void run() {
        if (middlewareManager.getMiddlewareById("reloadShootingBall") != null) {
            if (!this.changed) {
                this.changed = true;
                String prevDirection = this.getValue("levelSpinningDirection");
                this.setValue("levelSpinningDirection", (
                    prevDirection.equals("1") ? "-1" : "1"
                ));
            }
        } else if (this.changed) this.changed = false;
    }
}
