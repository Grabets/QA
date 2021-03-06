package week2.oop;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bogdan on 3/13/2017.
 */
public class QuadraticEquation implements Equation {
    private int id;
    private String equation;
    private double a;
    private double b;
    private double c;


    @Override
    public boolean parse(String s) {
        this.equation = s;
        Pattern pattern = Pattern.compile(Parser.QUADRATIC_EQUATION);
        Matcher matcher = pattern.matcher(s);

        if (matcher.matches()) {
            a = Double.valueOf(matcher.group(1));
            b = Double.valueOf(matcher.group(2) + matcher.group(3));
            c = Double.valueOf(matcher.group(4) + matcher.group(5));
            return true;
        } else
            return false;
    }

    public boolean parse(){
        return parse(equation);
    }

    @Override
    public List<Double> getRoots() {
        if (a==0&b!=0)
        {
            return Arrays.asList(new Double[] {(0-c)/b});
        }
        else
        if (getDiscriminant() > 0&&a!=0){
            return Arrays.asList(new Double[] {(0-b+Math.sqrt(getDiscriminant()))/(2*a),
                                                (0-b-Math.sqrt(getDiscriminant()))/(2*a)});
        }
        else
            //for equal roots
            if (getDiscriminant()==0&&a!=0){
                return Arrays.asList(new Double[] {(0-b)/(2*a)});
            }
            //for negative discriminant
        else
            {
                return null;
            }
    }

    public boolean printRoots(){
        if (getRoots()!=null)
        {
            System.out.println(getRoots().toString());
            return true;
        }
        return false;
    }

    private double getDiscriminant(){
        return Math.pow(b,2)-4*a*c;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquation() {
        return equation;
    }

    public List<Double> getCoefficients(){
        return Arrays.asList(new Double[] {a,b,c});
    }

    @Override
    public String toString() {
        return "QuadraticEquation{" +
                "id=" + id +
                ", equation='" + equation + '\'' +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
