import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Day extends VBox {

    public Day(int dayNumber) {
        this.setMaxSize(100, 100);
        this.getChildren().add(new Text(dayNumber + ""));
    }
}
