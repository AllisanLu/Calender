import java.util.ArrayList;

public class Day {

    private int dayNumber;
    private String name;
    private ArrayList<Activity> activities;

    public Day(int dayNumber) {
        this.dayNumber = dayNumber;
        String[] days = {"Monday, Tuesday, Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        name = days[dayNumber];

        activities = new ArrayList<>();
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public String toString() {
        return name +": " + activities;
    }
}
