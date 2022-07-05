package middlewareManager.middlewares;

public class ChangeLineLength extends Middleware{
  int direction = 1;
  int amount;
  int max;
  int min;
  public ChangeLineLength(String amount, String max, String min) {
    super("changeLineLength");
    this.amount = Integer.valueOf(amount);
    this.max = Integer.valueOf(max);
    this.min = Integer.valueOf(min);
  }

  @Override
  public void run() {
    int lineLenght = Integer.valueOf(this.getValue("levelLineLength"));
    if (direction < 0) {
      if (lineLenght <= min) {
        direction = 1;
        this.run();
        return;
      }
      this.setValue("levelLineLength", String.valueOf(lineLenght - amount));
    } else {
      if (lineLenght >= max) {
        direction = -1;
        this.run();
        return;
      }
      this.setValue("levelLineLength", String.valueOf(lineLenght + amount));
    }
  }
}
