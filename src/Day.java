import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class Day {
    private int dayNumber;
    private VBox vbox;

    public Day(int dayNumber, Pos Alignment) {
        this.dayNumber = dayNumber;

        vbox.setAlignment(Alignment);
        vbox.getChildren().add(new TextArea(dayNumber + ""));
    }
}
