import java.util.ArrayList;
import java.util.List;

/**
 * Represents a full day of the year.
 * Has activities to represent task going on during the day.
 */
public class Day {

    private int dayNumber;
    private String name;
    private List<Activity> activities;

    public static final String[] DAYS_OF_WEEK = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    public Day(int dayNumber, String name) {
        this.dayNumber = dayNumber;
        this.name = name;
        activities = new ArrayList<>();
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public String toString() {
        return name + (dayNumber + 1) + ": " + activities;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getStringActivities() {
        String rtn = "";
        for (Activity activity : activities) {
            rtn += activity + "\n";
        }
        return rtn;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    public boolean addActivity(Activity activity) {
        if(!activity.isOverlapped(activities)) {
            activities.add(activity);
            return true;
        }
        return false;
    }
}
