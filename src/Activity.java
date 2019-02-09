import java.util.ArrayList;
import java.util.List;

public class Activity {
    private String name;
    private int start, end;             //Time is based in minutes during the day.

    /**
     * Based on an activity some one would do during the day.
     * Precondition:
     *        0 > start > end > 1440(total minutes in a day)
     */
    public Activity(String name, int start, int end) {
        this.name = name;
        if(0 > start || end > 1440) {
            this.start = 0;
            this.end = 0;
        }
        else {
            this.start = start;
            this.end = end;
        }
    }

    /**
     *
     * @param activities
     * @return true if the activity was added or false if the activity was not.
     */
    public boolean isOverlapped(List<Activity> activities) {
        for (Activity activity: activities)
            //Making sure activities do not overlap.
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
        return name + "[" + minutesToHours(start) + " - " + minutesToHours(end) + "]";

    }

    private String minutesToHours(int minutes) {
        String rtn =  minutes / 60 + ":";
        int leftOver = minutes % 60;
        if(leftOver < 10)
            rtn += "0";
        return rtn + leftOver;
    }
}
