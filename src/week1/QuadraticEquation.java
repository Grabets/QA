package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bogdan on 2/20/2017.
 */
public class QuadraticEquation {
    static int count = 1;
    //Input valid value
    private static double inputMult () throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isExit=false;
        String s;
        //work until input valid value
        do {
            s = reader.readLine();
            if (doubleCheck(s))
                return Double.parseDouble(s);
        } while (!isExit);
        return Double.parseDouble(s);
    }
    //checks for valid value
    private static boolean doubleCheck(String s){
        try {
            double x =  Double.parseDouble(s);
            if (x==0.0 && count==1)
            {
                System.out.println("Division by zero! Please enter double value which not equal zero!");
                return false;
            }
            return true;
        }
        catch (NumberFormatException e){
            System.out.println("Error! Please enter double value!");
            return false;
        }
    }

    private static void solutionQE() throws IOException {
        System.out.println("Please enter coefficients(a, b, c) in double value for quadratic equation ax*x+bx+c=0");
        System.out.print("a= ");
        double a = inputMult();
        count--;
        System.out.print("b= ");
        double b = inputMult();
        System.out.print("c= ");
        double c = inputMult();
        double disc = Math.pow(b,2)-4*a*c;
        System.out.println("Result:");

        if (disc > 0){
            System.out.println("x1= "+((0-b+Math.sqrt(disc))/(2*a)));
            System.out.println("x2= "+((0-b-Math.sqrt(disc))/(2*a)));
        }
        else if (disc==0)
            System.out.println("x1=x2= "+((0-b)/(2*a)));
        else
            System.out.println("Discriminant is negative, then there are no real roots.");
    }

    public static void main(String[] args) throws IOException{
        solutionQE();
    }

}