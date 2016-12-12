package sorokin;

import org.apache.log4j.Logger;

public class Main {

    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {      
            ReadFile readFile = new ReadFile();
            TimeParser timeParser = new TimeParser();
            log.info("Read property file and set map of messages");
            timeParser.parseDate(readFile.loadFile());
            log.info("Start define time");
            timeParser.defineTime();       
    }
}
