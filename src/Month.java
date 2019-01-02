public class Month {
    int month;          //[0-11] [January - December]
    String name;
    Day[] days;

    public Month(int month) {
        this.month = month;
        days = new Day[getNumberOfDays(month)];
        for (int i = 0; i < days.length; i++)
            days[i] = new Day(i);

        name = getName(month);
    }

    private int getNumberOfDays(int month) {
        int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        return monthDays[month];
    }

    private String getName(int month) {
        String[] names = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return names[month];
    }
}
