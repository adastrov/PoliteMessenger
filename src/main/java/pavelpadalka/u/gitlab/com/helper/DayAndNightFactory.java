package pavelpadalka.u.gitlab.com.helper;

import org.apache.log4j.Logger;
import pavelpadalka.u.gitlab.com.enums.PartsOfDay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class DayAndNightFactory {

    private Date morningTimeLimit;
    private Date dayTimeLimit;
    private Date eveningTimeLimit;
    private Date nightTimeLimit;
    private static final Logger log = Logger.getLogger(DayAndNightFactory.class);

    public DayAndNightFactory() {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("DayAndNightTimeLimits");

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        try {
            this.morningTimeLimit = dateFormat.parse(resourceBundle.getString("timeLimit.morning"));
            this.dayTimeLimit     = dateFormat.parse(resourceBundle.getString("timeLimit.day"));
            this.eveningTimeLimit = dateFormat.parse(resourceBundle.getString("timeLimit.evening"));
            this.nightTimeLimit   = dateFormat.parse(resourceBundle.getString("timeLimit.night"));
        } catch (ParseException e) {
            log.error("Parse of the time limit exception", e);
            System.exit(0);
        }

    }

    public Date getTimeLimit(PartsOfDay partsOfDay) {

        Date result = null;

        if (partsOfDay.equals(PartsOfDay.MORNING)) {
            result = this.morningTimeLimit;
        } else if (partsOfDay.equals(PartsOfDay.DAY)) {
            result = this.dayTimeLimit;
        } else if (partsOfDay.equals(PartsOfDay.EVENING)) {
            result = this.eveningTimeLimit;
        } else if (partsOfDay.equals(PartsOfDay.NIGHT)) {
            result = this.nightTimeLimit;
        }

            return result;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DayAndNightFactory that = (DayAndNightFactory) o;

        if (!morningTimeLimit.equals(that.morningTimeLimit)) return false;
        if (!dayTimeLimit.equals(that.dayTimeLimit)) return false;
        if (!eveningTimeLimit.equals(that.eveningTimeLimit)) return false;
        return nightTimeLimit.equals(that.nightTimeLimit);

    }

    @Override
    public int hashCode() {
        int result = morningTimeLimit.hashCode();
        result = 31 * result + dayTimeLimit.hashCode();
        result = 31 * result + eveningTimeLimit.hashCode();
        result = 31 * result + nightTimeLimit.hashCode();
        return result;
    }
}
