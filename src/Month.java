import java.util.Arrays;

public class Month {
    int month;          //[0-11] [January - December]
    String name;
    Day[] days;

    public Month(int month) {
        this.month = month;

        int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        days = new Day[monthDays[month]];

        String[] names = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        name = names[month];

        for (int i = 0; i < days.length; i++)
            days[i] = new Day(i);
    }

    public boolean addActivity(int day, Activity activity) {
        if(!activity.isOverlapped(days[day].getActivities())) {
            days[day].getActivities().add(activity);
            return true;
        }
        return false;
    }

    public String toString() {
        return name +": " + Arrays.toString(days);
    }
}
