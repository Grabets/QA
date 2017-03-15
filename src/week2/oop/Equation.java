package week2.oop;

import java.util.List;

/**
 * Created by bogdan on 3/13/2017.
 */
public interface Equation {
    boolean parse(String s);
    List<Double> getRoots();

}
