import org.testng.Assert;
import org.testng.annotations.Test;
import week2.oop.QuadraticEquation;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by bogdan on 3/27/2017.
 */
public class QuadraticEquationTest {
    QuadraticEquation equation = new QuadraticEquation();

    @Test
    public void testParseMatcherTrue() throws Exception {
        Assert.assertTrue(equation.parse("1x^2 + 5x - 25 = 0"));
    }

    @Test
    public void testParseMatcherFalse() throws Exception {
        Assert.assertFalse(equation.parse("5x - 25 = 0"));
    }

    @Test
    public void testCheckParseCoefficients() throws Exception {
        equation.parse("1x^2 + 5x - 25 = 0");
        Assert.assertEquals(equation.getCoefficients(), Arrays.asList(new Double[] {1d,5d,-25d}));
    }

    @Test
    public void testParse() throws Exception {
        equation.parse("1x^2 + 5x - 25 = 0");
        Assert.assertTrue(equation.parse());
    }

    @Test //a=0,b=0
    public void testGetRoots1() throws Exception {
        equation.parse("0x^2 + 0x - 25 = 0");
        Assert.assertEquals(equation.getRoots(),null);
    }

    @Test //a==0&b!=0
    public void testGetRoots2() throws Exception {
        equation.parse("0x^2 + 5x - 25 = 0");
        Assert.assertEquals(equation.getRoots(),Arrays.asList(new Double[] {(0-(-25))/5d}));
    }

    @Test //getDiscriminant() > 0&&a!=0
    public void testGetRoots3() throws Exception {
        equation.parse("1x^2 + 5x - 3 = 0");
        List<Double> list= Arrays.asList(new Double[] {(0-5+Math.sqrt(Math.pow(5,2)-4*1*(-3)))/(2*1),
                (0-5-Math.sqrt(Math.pow(5,2)-4*1*(-3)))/(2*1)});
        Assert.assertEquals(equation.getRoots(),list);
    }

    @Test //getDiscriminant() = 0&&a!=0
    public void testGetRoots4() throws Exception {
        equation.parse("1x^2 + 4x + 4 = 0");
        Assert.assertEquals(equation.getRoots(),Arrays.asList(new Double[] {-4/(2*1d)}));
    }

    @Test //negative Discriminant
    public void testGetRoots5() throws Exception {
        equation.parse("1x^2 + 1x + 4 = 0");
        Assert.assertEquals(equation.getRoots(),null);
    }

    @Test //for null statement D<0
    public void testPrintRoots1() throws Exception {
        equation.parse("1x^2 + 1x + 4 = 0");
        Assert.assertFalse(equation.printRoots());
    }

    @Test
    public void testPrintRoots2() throws Exception {
        equation.parse("1x^2 + 1x - 4 = 0");
        Assert.assertTrue(equation.printRoots());
    }

    @Test
    public void testToString() throws Exception {
        QuadraticEquation eq = new QuadraticEquation();
        eq.parse("1x^2 + 1x - 4 = 0");
        String eqToStr = "QuadraticEquation{id=0, equation='1x^2 + 1x - 4 = 0', a=1.0, b=1.0, c=-4.0}";
        Assert.assertEquals(eq.toString(),eqToStr);
    }

    @Test
    public void testSetAndGetId() throws Exception {
        equation.setId(5);
        Assert.assertEquals(equation.getId(),5);
    }

    @Test
    public void testGetEquation() throws Exception {
        equation.parse("1x^2 + 1x - 4 = 0");
        Assert.assertEquals(equation.getEquation(),"1x^2 + 1x - 4 = 0");
    }
}