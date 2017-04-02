package week2.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bogdan on 3/13/2017.
 */
public class Parser {

    public static final String QUADRATIC_EQUATION = "^([+-]?\\d+|[+-]?\\d+\\.\\d+)x\\^2\\s([+-])\\s(\\d+|\\d+\\.\\d+)x"
                                                        +"\\s([+-])\\s(\\d+|\\d+\\.\\d+)\\s=\\s0$";
    public static final String LINEAR_EQUATION = "^([+-]?\\d+|[+-]?\\d+\\.\\d+)x\\s([+-])\\s(\\d+|\\d+\\.\\d+)\\s=\\s0$";

    public EquationType parse(String s){
        Pattern pattern = Pattern.compile(QUADRATIC_EQUATION);
        Matcher matcher = pattern.matcher(s);

        if (matcher.matches()){
            return EquationType.QUADRATIC;
        }
        else {
            pattern = Pattern.compile(LINEAR_EQUATION);
            matcher = pattern.matcher(s);
            if (matcher.matches()) {
                return EquationType.LINEAR;
            }
        }
        return null;
    }
}
