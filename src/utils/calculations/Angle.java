package utils.calculations;

public class Angle {
    private double angle;

    public Angle(int angle){
        this.angle = (double)angle;
    }
    public Angle(Double angle){
        this.angle = angle;
    }
    public Angle(){
        this.angle = 90;    //The constructor default to 90 degree as it is the starting position.
    }

    public double getInRadian(){
        return Math.toRadians(this.angle);
    }

    public void add(double degree){
        this.angle += degree;
    }

}