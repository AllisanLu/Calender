import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Driver extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Life Plans");
        BorderPane root = new BorderPane();

        GridPane calender = new GridPane();
        calender.setAlignment(Pos.CENTER);
        root.setCenter(calender);
        Label labelDay = new Label("day 1          ");

        labelDay.setStyle("-fx-border-color: #7f9ed1; -fx-font: 18;");
        calender.add(labelDay, 0, 0, 1, 1);

        Button add = new Button("+");
        add.setStyle("-fx-base: #7f9ed1");
        calender.add(add, 1, 0, 5, 3);


        primaryStage.setScene(new Scene(root, 1980,1080));
        primaryStage.show();
    }
}
