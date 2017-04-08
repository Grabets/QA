package week4.xpathbuilder;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by bogdan on 4/9/2017.
 */
public class StringXPathTest {

    @Test
    public void testByTag(){
        Assert.assertEquals("div",(new StringXPath.XPathBuilder().byTag("div").build().getExpression()));
    }

    @Test
    public void testBuild(){
        StringXPath stringXPath = new StringXPath.XPathBuilder().descOrSelf().byTag("book")
                .byContentEqStrVal("genre","Computer").build();
        Assert.assertEquals("//book[genre='Computer']",(stringXPath.getExpression()));
    }

}