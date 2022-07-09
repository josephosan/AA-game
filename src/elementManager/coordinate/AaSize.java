package elementManager.coordinate;

public class AaSize {
    Integer width, height;
    public AaSize() {
        this(0, 0);
    }

    public AaSize(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    public void setSize(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return this.width;
    }

    public Integer getHeight()
    { 
        return this.height;
    }

    @Override 
    public String toString() {
        return "(width: " + this.getWidth() + ", height: " + this.getHeight() + ")";
    }
}
