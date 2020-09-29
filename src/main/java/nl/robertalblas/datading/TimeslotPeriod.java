package nl.robertalblas.datading;

import java.time.LocalTime;

public class TimeslotPeriod {

    private final LocalTime startTime;
    private final LocalTime endTime;

    private final LocalTime MIDNIGHT = LocalTime.of(0,0);

    public TimeslotPeriod(LocalTime startTime, LocalTime endTime) {
        if (endTime.isBefore(startTime) && startTime.equals(MIDNIGHT)) {
            throw new IllegalArgumentException("endTime is before startTime");
        }

        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TimeslotPeriod(String startTime, String endTime) {
        this(parseString(startTime), parseString(endTime));
    }

    private static LocalTime parseString(String stringTime) {
        String[] timeParts = stringTime.split(":");

        return LocalTime.of(Integer.parseInt(timeParts[0]), Integer.parseInt(timeParts[1]));
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndtime() {
        return endTime;
    }

}
