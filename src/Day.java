import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Day extends VBox {

    public Day(int dayNumber) {
        this.setAlignment(Pos.BASELINE_LEFT);
        this.setMaxSize(100, 100);
        this.getChildren().add(new Text(dayNumber + ""));
        this.setBorder();
    }
}
