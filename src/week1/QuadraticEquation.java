package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bogdan on 2/20/2017.
 */
public class QuadraticEquation {
    //Input valid value
    private static double inputMult () throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isExit=false;
        String s;
        do {
            if (isExit)
                System.out.println("Error! Please enter double value!");
            s = reader.readLine();
            if (doubleCheck(s)){
                return Double.parseDouble(s);
            }
            else {
                System.out.println("Error! Please enter double value!");
                s = reader.readLine();
                isExit = true;
            }
        } while (isExit);
        return Double.parseDouble(s);
    }
    //checks for valid value
    private static boolean doubleCheck(String s){
        try {
            Double.parseDouble(s);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    private static void solutionQE() throws IOException {
        System.out.println("Please enter coefficients(a, b, c) in double value for quadratic equation ax*x+bx+c=0");
        System.out.print("a= ");
        double a = inputMult();
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