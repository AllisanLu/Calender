import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class CustomButton extends Button {

    private Day day;
    private VBox dayContainer;

    public CustomButton(Day day, VBox dayContainer) {
        this.day = day;
        this.dayContainer = dayContainer;
    }

    public Day getDay() {
        return day;
    }

    public VBox getDayContainer() {
        return dayContainer;
    }
}
