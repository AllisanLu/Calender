import java.util.Arrays;

public class Month {
    String[] names = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private int month;          //[0-11] [January - December]
    private String name;
    private Day[] days;

    public Month(int month) {
        this.month = month;

        int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        days = new Day[monthDays[month]];

        name = names[month];

        int[] firstDay = {6, 2, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        for(int i = 0; i < days.length; i++)
            days[i] = new Day(i + firstDay[month]);
    }

    public boolean addActivity(int day, Activity activity) {
        if(!activity.isOverlapped(days[day].getActivities())) {
            days[day].getActivities().add(activity);
            return true;
        }
        return false;
    }

    public Day[] getDays() {
        return days;
    }

    public String toString() {
        return name +": " + Arrays.toString(days);
    }
}
