package elementManager.calculation;

public class Angle {
    private double angle;

    Angle(Double angle){
        this.angle = angle;
    }
    Angle(){
        this.angle = 90;    //The constructor default to 90 degree as it is the starting position.
    }

    double getInRadian(){
        return Math.toRadians(this.angle);
    }

    void add(double degree){
        this.angle += degree;
    }

}