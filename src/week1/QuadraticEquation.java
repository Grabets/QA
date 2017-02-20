package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bogdan on 2/20/2017.
 */
public class QuadraticEquation {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double a = Double.parseDouble(reader.readLine());
        double b = Double.parseDouble(reader.readLine());
        double c = Double.parseDouble(reader.readLine());

        double disc = Math.pow(b,2)-4*a*c;
        System.out.println(disc);
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
}
