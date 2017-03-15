package week2.oop;

import javax.sound.sampled.Line;
import java.util.List;

/**
 * Created by bogdan on 3/13/2017.
 */
public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        //reads from file
        List<String> listOfEquation = reader.readFromFile("src/week2/oop/data.txt");
        Parser parser = new Parser();
        int count = 0;

        for (String s:
             listOfEquation ) {
            System.out.print("Line "+(count++)+" : ");
            if (parser.parse(s)==1)
            {
                QuadraticEquation quadraticEquation = new QuadraticEquation();
                quadraticEquation.parse(s);
                System.out.println(quadraticEquation.getRoots());
            }
            else
                if (parser.parse(s)==0){
                    LinearEquation linearEquation = new LinearEquation();
                    linearEquation.parse(s);
                    System.out.println(linearEquation.getRoots());
                }
                else
                    System.out.println("invalid string");

        }
    }

}
