package pavelpadalka.u.gitlab.com.messenger;

import org.apache.log4j.Logger;
import pavelpadalka.u.gitlab.com.helper.MessageHelper;

import java.security.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class PoliteMessenger {

    private Date currentDate;
    private static final Logger log = Logger.getLogger(PoliteMessenger.class);

    public PoliteMessenger() {
        setCurrentDate(new Date());
    }

    public PoliteMessenger(Date currentData) {
        setCurrentDate(currentData);
    }

    public PoliteMessenger(Timestamp currentData) {
        setCurrentDate(currentData.getTimestamp());
    }

    public void printHelloAccordingToThePartOfDay() {

        Locale.getDefault();

        ResourceBundle res = ResourceBundle.getBundle("data");

        try {

            String currentPartOfDay = MessageHelper.getCurrentPartOfDay(this.currentDate);
            String greeting         = res.getString("greeting." + currentPartOfDay.toLowerCase());

            log.info("Created  -> " + greeting);
            System.out.println(greeting);

        } catch (ParseException e) {
            log.error("Parse exception", e);
        }

    }

    private void setCurrentDate(Date currentData) {
        this.currentDate = currentData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PoliteMessenger that = (PoliteMessenger) o;

        return currentDate.equals(that.currentDate);

    }

    @Override
    public int hashCode() {
        return currentDate.hashCode();
    }
}
