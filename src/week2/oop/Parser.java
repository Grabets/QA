package week2.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bogdan on 3/13/2017.
 */
public class Parser {

    private static final String QUADRATIC_EQUATION = "^([+-]?\\d+|[+-]?\\d+\\.\\d+)x\\^2\\s([+-])\\s(\\d+|\\d+\\.\\d+)x"
                                                        +"\\s([+-])\\s(\\d+|\\d+\\.\\d+)\\s=\\s0$";
    private static final String LINEAR_EQUATION = "^([+-]?\\d+|[+-]?\\d+\\.\\d+)x\\s([+-])\\s(\\d+|\\d+\\.\\d+)\\s=\\s0$";

    public int parse(String s){
        Pattern pattern = Pattern.compile(QUADRATIC_EQUATION);
        Matcher matcher = pattern.matcher(s);

        if (matcher.matches()){
            return 1;
            /*
                double a = Double.valueOf(matcher.group(1));
                double b = Double.valueOf(matcher.group(2)+matcher.group(3));
                double c = Double.valueOf(matcher.group(4)+matcher.group(5));
                System.out.println("a=" + a + " b=" + b + " c=" + c);*/
        }
        else {
            pattern = Pattern.compile(LINEAR_EQUATION);
            matcher = pattern.matcher(s);
            if (matcher.matches()) {
                return 0;
                /*
                double a = Double.valueOf(matcher.group(1));
                double b = Double.valueOf(matcher.group(2) + matcher.group(3));
                System.out.println("a=" + a + " b=" + b);*/
            }
        }
        return -1;
    }

    public static String getQuadraticEquation() {
        return QUADRATIC_EQUATION;
    }

    public static String getLinearEquation() {
        return LINEAR_EQUATION;
    }

    public static void main(String[] args) {
        Parser parser = new Parser();
        System.out.println(parser.parse("-4.1212x^2 - 0x - 16 = 0"));

        /*parse("-4.1212x^2 - 0x - 16 = 0");
        parse("-0.25x + 16 = 0");
        parse("-4.1212x^2 - 0x - 16 = 5");
        parse("- 0x - 16 = 0");*/
    }
}
