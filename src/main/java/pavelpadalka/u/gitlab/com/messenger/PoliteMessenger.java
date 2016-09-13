package pavelpadalka.u.gitlab.com.messenger;

import org.apache.log4j.Logger;
import pavelpadalka.u.gitlab.com.helper.MessageHelper;

import java.security.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class PoliteMessenger {

    private Date currentData;
    private static final Logger log = Logger.getLogger(PoliteMessenger.class);

    public PoliteMessenger() {
        setCurrentData(new Date());
    }

    public PoliteMessenger(Date currentData) {
        setCurrentData(currentData);
    }

    public PoliteMessenger(Timestamp currentData) {
        setCurrentData(currentData.getTimestamp());
    }

    public void printHelloAccordingToThePartOfDay() {

        Locale.getDefault();

        ResourceBundle res = ResourceBundle.getBundle("data");

        try {

            String currentPartOfDay = MessageHelper.getCurrentPartOfDay(this.currentData);
            String greeting         = res.getString("greeting." + currentPartOfDay.toLowerCase());

            log.info("Created  -> " + greeting);
            System.out.println(greeting);

        } catch (ParseException e) {
            log.error("Parse exception", e);
        }

    }

    private void setCurrentData(Date currentData) {
        this.currentData = currentData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PoliteMessenger that = (PoliteMessenger) o;

        return currentData.equals(that.currentData);

    }

    @Override
    public int hashCode() {
        return currentData.hashCode();
    }
}

