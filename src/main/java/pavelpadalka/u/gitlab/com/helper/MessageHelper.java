package pavelpadalka.u.gitlab.com.helper;

import org.apache.log4j.Logger;
import pavelpadalka.u.gitlab.com.enums.PartsOfDay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageHelper {

    private static DayAndNightFactory dayAndNightFactory = new DayAndNightFactory();
    private static final Logger log = Logger.getLogger(MessageHelper.class);

    private MessageHelper() {
    }

    public static String getPartOfDay(Date currentDateTime) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date current  = null;
        String result;

        try {
            current = dateFormat.parse(dateFormat.format(currentDateTime));
        } catch (ParseException e) {
            log.error("Parse of the current date time exception", e);
            System.exit(0);
        }

        if(current.after(dayAndNightFactory.getTimeLimit(PartsOfDay.MORNING))
                && current.before(dayAndNightFactory.getTimeLimit(PartsOfDay.DAY))){
            result = "MORNING";
        }
        else if (current.after(dayAndNightFactory.getTimeLimit(PartsOfDay.DAY))
                && current.before(dayAndNightFactory.getTimeLimit(PartsOfDay.EVENING))){
            result = "DAY";
        }
        else if (current.after(dayAndNightFactory.getTimeLimit(PartsOfDay.EVENING))
                && current.before(dayAndNightFactory.getTimeLimit(PartsOfDay.NIGHT))){
            result = "EVENING";
        }
        else {
            result = "NIGHT";
        }

        return result;

    }

}
