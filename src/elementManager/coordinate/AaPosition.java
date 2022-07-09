package elementManager.coordinate;

public class AaPosition {
    Integer x, y;
    public AaPosition() {
        this.x = 0;
        this.y = 0;
    }

    public AaPosition(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }

    @Override 
    public String toString() {
        return "(x: " + this.getX() + ", y: " + this.getY() + ")";
    }
}
