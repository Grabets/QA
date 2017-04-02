package week2.oop;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bogdan on 3/13/2017.
 */
public class LinearEquation implements Equation{
    private int id;
    private String equation;
    private double a;
    private double b;

    @Override
    public boolean parse(String s) {
        this.equation = s;
        Pattern pattern = Pattern.compile(Parser.LINEAR_EQUATION);
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
             a = Double.valueOf(matcher.group(1));
             b = Double.valueOf(matcher.group(2) + matcher.group(3));
            return true;
        }
        else
            return false;
    }

    @Override
    public List<Double> getRoots() {
        if (a!=0)
            return Arrays.asList(new Double[] {-b/a});
        else
            return null;
    }

    public void printRoots() {
        System.out.println(getRoots().toString());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LinearEquation{" +
                "id=" + id +
                ", equation='" + equation + '\'' +
                ", a=" + a +
                ", b=" + b +
                '}';
    }

    public String getEquation() {
        return equation;
    }

}
