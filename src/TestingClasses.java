public class TestingClasses {
    public static void main(String[] args) {
        Month January = new Month(0);
        January.addActivity(0, new Activity("Jumping Jacks", 0, 120));
        System.out.println(January);

    }
}
