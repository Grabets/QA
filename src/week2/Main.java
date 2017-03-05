package week2;

import java.util.List;

/**
 * Created by bogdan on 3/4/2017.
 */
public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        Transformer transformer = new Transformer();
        //reads from file
        List<String> listOfEquation = reader.readFromFile("src/week2/data.txt");
        //check for validity and after that transform string lines to coefficient as double variables
        transformer.transform(listOfEquation);
        Solver solver = new Solver();
        //solve equation and save roots in RootsStorage class
        solver.solveAndWrite(transformer.getTransformedFile());
        //extract maximum root from storage and extract equation which responsible to this root
        System.out.print("Max root: "+solver.getRootsStorageCell().getMaxRoot());
        System.out.println(" from this equation: "+listOfEquation.get((int)solver.getRootsStorageCell().getNumOfEquationWithMaxRoot()));
        //extract minimal root from storage and extract equation which responsible to this root
        System.out.print("Min root: "+solver.getRootsStorageCell().getMinRoot());
        System.out.println(" from this equation: "+listOfEquation.get((int)solver.getRootsStorageCell().getNumOfEquationWithMinRoot()));
        //print equation which haven't real roots
        solver.getRootsStorageCell().printListOfNullRoots(listOfEquation);
    }
}
