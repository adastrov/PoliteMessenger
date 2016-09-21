package pavelpadalka.u.gitlab.com.messenger;

import pavelpadalka.u.gitlab.com.helper.MessageHelper;

import java.security.Timestamp;
import java.util.Date;
import java.util.ResourceBundle;

public class PoliteMessenger {

    private Date currentDate;

    public PoliteMessenger() {
        setCurrentDate(new Date());
    }

    public PoliteMessenger(Date currentDate) {
        setCurrentDate(currentDate);
    }

    public PoliteMessenger(Timestamp currentDate) {
        setCurrentDate(currentDate.getTimestamp());
    }

    public void printHelloAccordingToThePartOfDay() {

        ResourceBundle res = ResourceBundle.getBundle("data");

        String currentPartOfDay = MessageHelper.getPartOfDay(this.currentDate);
        String greeting         = res.getString("greeting." + currentPartOfDay.toLowerCase());

        System.out.println(greeting);

    }

    private void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
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
