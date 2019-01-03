public class TestingClasses {
    public static void main(String[] args) {
        Month january = new Month(0);
        System.out.println(january);
        january.addActivity(0, new Activity("Jumping Jacks", 0, 120));
        System.out.println(january);
    }
}
