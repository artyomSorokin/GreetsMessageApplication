package sorokin;


import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Main {

    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) throws ParseException {
        ReadFile readFile = new ReadFile();
        TimeParser timeParser = new TimeParser();
        log.info("Read property file and set map of messages");
        timeParser.setTimeMap(readFile.loadFile());

        log.info("Start executor, which monitoring our program each 60 seconds");
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleWithFixedDelay(timeParser, 0, 60, TimeUnit.SECONDS);
    }
}
