import org.testng.Assert;
import org.testng.annotations.*;
import week2.oop.LinearEquation;
import week2.oop.Reader;
import week2.oop.Storage;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by bogdan on 3/26/2017.
 */
public class StorageTest {
    Storage storage = new Storage();

    @Test
    public void testFillEquationList() throws Exception {
        List<String> list = Arrays.asList(new String[] {"25x + 5 = 0","1x - 265 = 0", "26 + 15"});
        storage.fillEquationList(list);
        Assert.assertEquals(2,storage.getEquationList().size());
    }
}