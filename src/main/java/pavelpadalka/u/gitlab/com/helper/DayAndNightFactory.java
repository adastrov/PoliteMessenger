package pavelpadalka.u.gitlab.com.helper;

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

    public DayAndNightFactory() {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("DayAndNightTimeLimits");

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        try {
            this.morningTimeLimit = dateFormat.parse(resourceBundle.getString("timeLimit.morning"));
            this.dayTimeLimit     = dateFormat.parse(resourceBundle.getString("timeLimit.day"));
            this.eveningTimeLimit = dateFormat.parse(resourceBundle.getString("timeLimit.evening"));
            this.nightTimeLimit   = dateFormat.parse(resourceBundle.getString("timeLimit.night"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public Date getTimeLimit(PartsOfDay partsOfDay) {

        if (partsOfDay.equals(PartsOfDay.MORNING)) {
            return this.morningTimeLimit;
        } else if (partsOfDay.equals(PartsOfDay.DAY)) {
            return this.dayTimeLimit;
        } else if (partsOfDay.equals(PartsOfDay.EVENING)) {
            return this.eveningTimeLimit;
        } else if (partsOfDay.equals(PartsOfDay.NIGHT)) {
            return this.nightTimeLimit;
        } else {
            System.out.println("Описать здесь эксепшен параметра");
        }

            return new Date();

    }

}
