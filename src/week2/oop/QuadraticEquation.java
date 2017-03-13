package week2.oop;

/**
 * Created by bogdan on 3/13/2017.
 */
public class QuadraticEquation implements Equation {
    private double a;
    private double b;
    private double c;

    @Override
    public boolean parse(String s) {
        return false;
    }

    @Override
    public double getRoots() {
        return 0;
    }
}
