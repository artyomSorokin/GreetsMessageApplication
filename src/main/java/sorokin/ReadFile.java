package sorokin;


import org.apache.log4j.Logger;

import java.io.InputStream;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReadFile {

    private InputStream fis;
    private Properties properties;
    private HashMap<Enum, String> timeMap;
    private static Logger log = Logger.getLogger(ReadFile.class);

    public Map<Enum,String> loadFile() {
        try {
            properties = new Properties();
            timeMap = new HashMap<Enum, String>();
            log.info("open our limitTimeDay.properties file");
            fis = getClass().getClassLoader().getResourceAsStream("limitTimeDay.properties");
            properties.load(fis);
            log.info("Start compile our map messages");
            timeMap.put(Time.MORNING, properties.getProperty("Morning"));
            timeMap.put(Time.DAY, properties.getProperty("Day"));
            timeMap.put(Time.EVENING, properties.getProperty("Evening"));
            timeMap.put(Time.NIGHT, properties.getProperty("Night"));
        }
        catch (Exception e){
            log.error("Problem with limitTimeDay.properties file");
        }
        return timeMap;
    }
}
