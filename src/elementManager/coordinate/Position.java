package elementManager.coordinate;

public class Position {
    Integer x, y;
    public Position() {
        this.x = 0;
       this.y = 0;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
}
