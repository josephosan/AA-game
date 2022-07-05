package middlewareManager.middlewares;

public class Lagger extends Middleware{
  private Boolean isStoped = true;
  private int frameDelay;
  private int framesPassed = 0;
  public Lagger() {
    super("lagger");
    this.setValue("rotationSpeed", "0");
    this.setFrameDelay();
  }

  private void setFrameDelay() {
    frameDelay = (int)(Math.random()*(60-20+1)+20);
  }

  private int getRandomSpeed() {
    return (int)(Math.random()*(100-10+1)+10);
  }

  @Override
  public void run() {
    framesPassed++;
    if (isStoped) {
      if ( frameDelay == framesPassed) {
        isStoped = false;
        framesPassed = 0;
        this.setFrameDelay();
        this.setValue("rotationSpeed", String.valueOf(getRandomSpeed()));
      }
    } else {
      this.setValue("rotationSpeed", "0");
      this.isStoped = true;
    }
  }
}
