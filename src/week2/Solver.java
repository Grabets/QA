package week2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bogdan on 3/4/2017.
 */
public class Solver {
    //private Memory memorySell;

    public void readAndSolve(List<double[]> list){
        double[] arr;

        for (int i = 0; i < list.size(); i++) {
            arr = list.get(i);
            System.out.print("Equation "+i+": ");
            if (arr.length==3){
                //solveQuadraticEquation(arr[0],arr[1],arr[2]);
                System.out.println(Arrays.toString(solveQuadraticEquation(arr[0],arr[1],arr[2])));
            }
            if (arr.length==2){
                //solveLinearEquation(arr[0],arr[1]);
                System.out.println(Arrays.toString(solveLinearEquation(arr[0],arr[1])));
            }
            if (arr.length==0)
                //TODO: need fix this for later operations
                System.out.println("Invalid input");
        }

    }

    private double[] solveQuadraticEquation(double a, double b, double c){
        double disc = Math.pow(b,2)-4*a*c;
        if (a==0&b!=0)
        {
            return solveLinearEquation(b,c);
        }
        else
            if (disc > 0&&a!=0){
                double[] quadRoots = {(0-b+Math.sqrt(disc))/(2*a),(0-b-Math.sqrt(disc))/(2*a)};
                return quadRoots;
        }
        else
            //for equal roots
            if (disc==0&&a!=0){
                double[] quadRoot = {(0-b)/(2*a)};
                return quadRoot;
            }
        //for negative discriminant
        else{
                return null;
            }

        //// TODO: check for return if b=0
    }

    private double[] solveLinearEquation(double a, double b){
        double[] linRoot = {(0-b)/a};
        return linRoot;

    }

    //only for test
    public static void main(String[] args) {
        Reader reader = new Reader();
        Transformer transformer = new Transformer();
        transformer.transform(reader.readFromFile("src/week2/data.txt"));
        Solver solver = new Solver();
        solver.readAndSolve(transformer.getTransformedFile());
    }

}
