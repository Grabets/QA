package week2.oop;


/**
 * Created by bogdan on 3/13/2017.
 */
public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        Storage storage = new Storage();
        storage.fillEquationList(reader.readFromFile("src/week2/oop/data.txt"));
        storage.fillListOfRoots();
        storage.printMinAndMaxRoots();
        storage.printEquationWithMinMaxRoot();
        storage.printEquationWithNegDiscriminant();
    }

}
