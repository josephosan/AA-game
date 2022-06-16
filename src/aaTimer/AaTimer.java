package aaTimer;

import config.Config;
import java.util.Timer;
import java.util.TimerTask;

public class AaTimer {
    TimerTask timerTask;
    Timer timer = new Timer();

    public AaTimer(TimerTask timerTask) {
        this.timerTask = timerTask;
    }

    public void play() {
        timer.scheduleAtFixedRate(timerTask, Config.getTimerDelay(), Config.getTimerDelay());
    }

    public void pause() {
        timer.cancel();
    }

}
