package pavelpadalka.u.gitlab.com.helper;

import pavelpadalka.u.gitlab.com.enums.PartsOfDay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageHelper {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private MessageHelper() {
    }

    public static String getCurrentPartOfDay(Date currentDateTime) throws ParseException {

        Date current  = dateFormat.parse(dateFormat.format(currentDateTime));
        Date morning  = dateFormat.parse(PartsOfDay.MORNING.toString());
        Date day      = dateFormat.parse(PartsOfDay.DAY.toString());
        Date evening  = dateFormat.parse(PartsOfDay.EVENING.toString());
        Date night    = dateFormat.parse(PartsOfDay.NIGHT.toString());

        if(current.after(morning) && current.before(day)){
            return "MORNING";
        }
        else if (current.after(day) && current.before(evening)){
            return "DAY";
        }
        else if (current.after(evening) && current.before(night)){
            return "EVENING";
        }
        else

        return "NIGHT";

    }

}
