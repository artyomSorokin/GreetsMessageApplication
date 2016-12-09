package sorokin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



import java.util.Date;



public class TimeParserTest {

    private TimeParser timeParser;
    private ReadFile readFile;


    @Before
    public void setUp(){
        this.timeParser = new TimeParser();
        this.readFile = new ReadFile();
    }

    @Test()
    public void parseDateInstanceDateTest(){
        timeParser.parseDate(readFile.loadFile());
        Assert.assertTrue(timeParser.morning instanceof Date);
        Assert.assertTrue(timeParser.day instanceof Date);
        Assert.assertTrue(timeParser.evening instanceof Date);
        Assert.assertTrue(timeParser.night instanceof Date);
        Assert.assertTrue(timeParser.currentTime instanceof Date);
    }

    @Test()
    public void parseDateNotNullTest(){
        timeParser.parseDate(readFile.loadFile());
        Assert.assertNotNull(timeParser.morning);
        Assert.assertNotNull(timeParser.day);
        Assert.assertNotNull(timeParser.evening);
        Assert.assertNotNull(timeParser.night);
        Assert.assertNotNull(timeParser.currentTime);
    }

    @Test()
    public void parseDateEqualsTest(){
        timeParser.parseDate(readFile.loadFile());
        String line1[] = timeParser.morning.toString().split(" ");
        Assert.assertEquals(line1[3], "06:00:00");
        String line2[] = timeParser.day.toString().split(" ");
        Assert.assertEquals(line2[3], "09:00:00");
        String line3[] = timeParser.evening.toString().split(" ");
        Assert.assertEquals(line3[3], "19:00:00");
        String line4[] = timeParser.night.toString().split(" ");
        Assert.assertEquals(line4[3], "23:00:00");
    }
}
