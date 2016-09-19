package pavelpadalka.u.gitlab.com.helper;

import pavelpadalka.u.gitlab.com.enums.PartsOfDay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageHelper {

    private static DayAndNightFactory dayAndNightFactory = new DayAndNightFactory();

    private MessageHelper() {
    }

    public static String getPartOfDay(Date currentDateTime) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date current  = dateFormat.parse(dateFormat.format(currentDateTime));

        if(current.after(dayAndNightFactory.getTimeLimit(PartsOfDay.MORNING))
                && current.before(dayAndNightFactory.getTimeLimit(PartsOfDay.DAY))){
            return "MORNING";
        }
        else if (current.after(dayAndNightFactory.getTimeLimit(PartsOfDay.DAY))
                && current.before(dayAndNightFactory.getTimeLimit(PartsOfDay.EVENING))){
            return "DAY";
        }
        else if (current.after(dayAndNightFactory.getTimeLimit(PartsOfDay.EVENING))
                && current.before(dayAndNightFactory.getTimeLimit(PartsOfDay.NIGHT))){
            return "EVENING";
        }
        else

        return "NIGHT";

    }

}
