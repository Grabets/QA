import org.testng.Assert;
import org.testng.annotations.Test;
import week2.oop.EquationType;
import week2.oop.Parser;

import static org.testng.Assert.*;

/**
 * Created by bogdan on 3/25/2017.
 */
public class ParserTest {
    private Parser parser = new Parser();

    @Test
    public void testParseLinearEquation() throws Exception {
        Assert.assertEquals(EquationType.LINEAR,parser.parse("-2x + 29 = 0"),"Method Parse can not parse linear equation");
        Assert.assertEquals(EquationType.LINEAR,parser.parse("2x + 52 = 0"),"Method Parse can not parse linear equation");
        Assert.assertEquals(null,parser.parse("2x +52 = 0"),"Method Parse parse non-linear equation");
        Assert.assertEquals(EquationType.LINEAR,parser.parse("-2.0787878x + 52.045 = 0"),"Method Parse can not parse linear equation with double coefficient");
    }

    @Test
    public void testParseQuadraticEquation() throws Exception {
        Assert.assertEquals(EquationType.QUADRATIC,parser.parse("-2x^2 + 29x + 58 = 0"),"Method parse can not parse quadratic equation");
        Assert.assertEquals(EquationType.QUADRATIC,parser.parse("1.11545x^2 - 2.2121x + 4.12121 = 0"),"Method parse can not parse quadratic equation with double value coefficient");
        Assert.assertEquals(null,parser.parse("-2x^2 + 52x+ 58 = 0"),"Method Parse parsed non-quadratic equation");
    }

    @Test
    public void testParseNonValidEquation() throws Exception{
        assertEquals(null, parser.parse("-20x + 455 = 454"));
        assertEquals(null, parser.parse("20x-455 = 0"));
        assertEquals(null, parser.parse("455 = 0 - 5x"));
    }


}