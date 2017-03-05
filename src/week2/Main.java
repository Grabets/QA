package week2;

import java.util.List;

/**
 * Created by bogdan on 3/4/2017.
 */
public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        Transformer transform = new Transformer();
        List<String> list = reader.readFromFile("src/week2/data.txt");
        transform.transform(list);
        transform.toString();
    }
}
