package week2.oop;

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
        for (String s:
             listOfEquation ) {
            System.out.println(parser.parse(s));
        }
    }

}
