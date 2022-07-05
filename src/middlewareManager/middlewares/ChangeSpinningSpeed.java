package middlewareManager.middlewares;

public class ChangeSpinningSpeed extends Middleware{
  private int direction = -1;
  private double amount;
  private int max;
  private int min;
  public ChangeSpinningSpeed(String amount, String max, String min) {
    super("changeSpinningSpeed");
    this.amount = Double.valueOf(amount);
    this.max = Integer.valueOf(max);
    this.min = Integer.valueOf(min);
    if (this.getValue("levelSpinningDirection") == null) {
      this.setValue("levelSpinningDirection", "1");
    }
  } 

  @Override
  public void run() {
    direction = Integer.valueOf(this.getValue("levelSpinningDirection"));
    double rotationSpeed = Double.valueOf(this.getValue("rotationSpeed"));
    if (direction < 0) {
      if (rotationSpeed <= min) {
        this.setValue("levelSpinningDirection", "1");
        this.run();
        return;
      }
      this.setValue("rotationSpeed", String.valueOf(rotationSpeed - amount));
    } else {
      if (rotationSpeed >= max) {
        this.setValue("levelSpinningDirection", "-1");
        this.run();
        return;
      }
      this.setValue("rotationSpeed", String.valueOf(rotationSpeed + amount));
    }
  }
}
