package sorokin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalTime;

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
        Assert.assertTrue(timeParser.morning instanceof LocalTime);
        Assert.assertTrue(timeParser.day instanceof LocalTime);
        Assert.assertTrue(timeParser.evening instanceof LocalTime);
        Assert.assertTrue(timeParser.night instanceof LocalTime);
        Assert.assertTrue(timeParser.currentTime instanceof LocalTime);
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
        Assert.assertEquals(timeParser.morning, LocalTime.parse("06:00:00"));
        Assert.assertEquals(timeParser.day, LocalTime.parse("09:00:00"));
        Assert.assertEquals(timeParser.evening, LocalTime.parse("19:00:00"));
        Assert.assertEquals(timeParser.night, LocalTime.parse("23:00:00"));
    }

    @Test()
    public void defineTimeLimitMorningTest(){
        timeParser.parseDate(readFile.loadFile());
        timeParser.currentTime = LocalTime.parse("06:00:00");
        timeParser.defineTime();
        Assert.assertEquals(timeParser.message, "Доброе утро, Мир!");
    }

    @Test()
    public void defineTimeLimitDayTest(){
        timeParser.parseDate(readFile.loadFile());
        timeParser.currentTime = LocalTime.parse("09:00:00");
        timeParser.defineTime();
        Assert.assertEquals(timeParser.message, "Добрый день, Мир!");
    }

    @Test()
    public void defineTimeLimitEveningTest(){
        timeParser.parseDate(readFile.loadFile());
        timeParser.currentTime = LocalTime.parse("19:00:00");
        timeParser.defineTime();
        Assert.assertEquals(timeParser.message, "Добрый вечер, Мир!");
    }

    @Test()
    public void defineTimeLimitNightTest(){
        timeParser.parseDate(readFile.loadFile());
        timeParser.currentTime = LocalTime.parse("23:00:00");
        timeParser.defineTime();
        Assert.assertEquals(timeParser.message, "Спокойной ночи, Мир!");
    }

    @Test()
    public void defineTimeMorningTest(){
        timeParser.parseDate(readFile.loadFile());
        timeParser.currentTime = LocalTime.parse("07:53:00");
        timeParser.defineTime();
        Assert.assertEquals(timeParser.message, "Доброе утро, Мир!");
    }

    @Test()
    public void defineTimeDayTest(){
        timeParser.parseDate(readFile.loadFile());
        timeParser.currentTime = LocalTime.parse("18:54:00");
        timeParser.defineTime();
        Assert.assertEquals(timeParser.message, "Добрый день, Мир!");
    }

    @Test()
    public void defineTimeEveningTest(){
        timeParser.parseDate(readFile.loadFile());
        timeParser.currentTime = LocalTime.parse("22:59:00");
        timeParser.defineTime();
        Assert.assertEquals(timeParser.message, "Добрый вечер, Мир!");
    }

    @Test()
    public void defineTimeNightTest(){
        timeParser.parseDate(readFile.loadFile());
        timeParser.currentTime = LocalTime.parse("05:59:00");
        timeParser.defineTime();
        Assert.assertEquals(timeParser.message, "Спокойной ночи, Мир!");
    }
}
