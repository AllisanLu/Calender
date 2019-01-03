public class Time {

    public static final int MINUTES_IN_DAY = 1440;
    public static final int HOURS_IN_DAY = 24;

    public static int minutesToHours(int minutes) {
        return minutes / 60;
    }

    public static int hoursToMinutes(int hours) {
        return hours * 60;
    }

    public static String minutesToTimeStamp(int minutes) {
        int hours =  minutesToHours(minutes);
        minutes = minutes % 60;
        return hours + ":" + minutes;
    }
}
