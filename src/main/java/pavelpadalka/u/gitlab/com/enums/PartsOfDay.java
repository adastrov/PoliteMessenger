package pavelpadalka.u.gitlab.com.enums;

public enum PartsOfDay {

    MORNING("06:00:00"),
    DAY("09:00:00"),
    EVENING("19:00:00"),
    NIGHT("23:00:00");

    private final String time;

    PartsOfDay(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return time;
    }

}
