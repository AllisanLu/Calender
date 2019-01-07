import java.util.ArrayList;

/**
 * Represents a full day of the year.
 * Has activities to represent task going on during the day.
 */
public class Day {

    private int dayNumber;
    private String name;
    private ArrayList<Activity> activities;

    public Day(int dayNumber) {
        this.dayNumber = dayNumber;
        String[] days = {"Monday, Tuesday, Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        name = days[dayNumber % days.length];
        activities = new ArrayList<>();
    }

    public ArrayList<Activity> getActivities() {
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
            rtn += "    " + activity + "\n";
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
