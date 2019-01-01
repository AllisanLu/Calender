import java.util.ArrayList;

public class Month {
    int month;
    int numberOfDays;
    ArrayList<Day> days = new ArrayList<Day>();

    public Month(int month, int numberOfDays){
        this.month = month;
        this.numberOfDays = numberOfDays;
    }
}
