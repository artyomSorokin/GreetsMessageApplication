package sorokin;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class ReadFileTest {

    private ReadFile readFile;

    @Before
    public void setUp(){
        this.readFile = new ReadFile();
    }

    @Test
    public void loadFileNotNullTest(){
        Assert.assertNotNull(readFile.loadFile());
    }

    @Test
    public void loadFileEqualsMapTest(){
        Assert.assertTrue(readFile.loadFile() instanceof Map);
    }

    @Test
    public void loadFileMapEqualsStringTest(){
        Map<Enum, String> map= readFile.loadFile();
        Assert.assertTrue(map.get(Time.MORNING) instanceof String);
        Assert.assertTrue(map.get(Time.DAY) instanceof String);
        Assert.assertTrue(map.get(Time.EVENING) instanceof String);
        Assert.assertTrue(map.get(Time.NIGHT) instanceof String);
    }
}
