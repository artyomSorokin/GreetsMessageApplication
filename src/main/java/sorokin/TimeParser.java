package sorokin;

import org.apache.log4j.Logger;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class TimeParser {

    protected ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.getDefault());
    protected String message;
    protected LocalTime morning;
    protected LocalTime day;
    protected LocalTime evening;
    protected LocalTime night;
    protected LocalTime currentTime;
    protected static Logger log = Logger.getLogger(ReadFile.class);

    protected void parseDate(Map<Enum,String> timeMap) {
        try {
            log.info("Start convert dates from String to Date");
            morning = LocalTime.parse(timeMap.get(Time.MORNING));
            day = LocalTime.parse(timeMap.get(Time.DAY));
            evening = LocalTime.parse(timeMap.get(Time.EVENING));
            night = LocalTime.parse(timeMap.get(Time.NIGHT));
            currentTime = LocalTime.now();
        }catch (Exception e){
            log.info("Problem with convert date");
        }
    }

    protected void defineTime(){
        log.info("Define time, locale and choose message");
        if ((currentTime.isAfter(morning) && currentTime.isBefore(day)) || currentTime.equals(LocalTime.parse("06:00:00"))) {
            message = bundle.getString("morning");
        } else if ((currentTime.isAfter(day) && currentTime.isBefore(evening)) || currentTime.equals(LocalTime.parse("09:00:00"))) {
            message = bundle.getString("day");
        } else if ((currentTime.isAfter(evening) && currentTime.isBefore(night)) || currentTime.equals(LocalTime.parse("19:00:00"))) {
            message = bundle.getString("evening");
        } else {
            message = bundle.getString("night");
        }
        show(message);
    }
    
    public void show(String message){
        System.out.println(message);
    }

}
