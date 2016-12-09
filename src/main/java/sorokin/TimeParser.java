package sorokin;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class TimeParser implements Runnable {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    private ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.getDefault());
    protected Map<Enum,String> timeMap;
    protected Date morning;
    protected Date day;
    protected Date evening;
    protected Date night;
    protected Date currentTime;
    protected static Logger log = Logger.getLogger(ReadFile.class);

    public void setTimeMap(Map<Enum, String> timeMap) {
        this.timeMap = timeMap;
    }

    protected void parseDate(Map<Enum,String> timeMap) {
        try {
            log.info("Start convert dates from String to Date");
            morning = simpleDateFormat.parse(timeMap.get(Time.MORNING));
            day = simpleDateFormat.parse(timeMap.get(Time.DAY));
            evening = simpleDateFormat.parse(timeMap.get(Time.EVENING));
            night = simpleDateFormat.parse(timeMap.get(Time.NIGHT));
            currentTime = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
        }catch (Exception e){
            log.info("Problem with convert date");
        }
    }

    protected void defineTime(){
        log.info("Define time, locale and choose message");
        if (currentTime.after(morning) && currentTime.before(day)) {
            ShowTime.show(bundle.getString("morning"));
        } else if (currentTime.after(day) && currentTime.before(evening)) {
            ShowTime.show(bundle.getString("day"));
        } else if (currentTime.after(evening) && currentTime.before(night)) {
            ShowTime.show(bundle.getString("evening"));
        } else {
            ShowTime.show(bundle.getString("night"));
        }
    }


    public void run() {
        log.info("Start date parser");
        parseDate(timeMap);
        log.info("Start define time");
        defineTime();
    }
}
