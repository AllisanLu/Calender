import java.util.ArrayList;

public class Activity {
    private String name;
    private int start;
    private int end;

    public Activity(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public boolean isOverlapped(ArrayList<Activity> activities) {
        for (Activity activity: activities)
            //activity > start > activity or activity > end > activity or start < activity and end > activity
            if((start >= activity.getStart() && start < activity.getEnd()) || (end > activity.getStart() && end < activity.getStart()) || (start < activity.getEnd() && end > activity.getEnd()))
                return true;
        return false;
    }

    public int getStart() { return start; }

    public int getEnd() {
        return end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String toString() {
        return name + " [" + Time.minutesToTimeStamp(start) + " - " + Time.minutesToTimeStamp(end) + "]";
    }
}
