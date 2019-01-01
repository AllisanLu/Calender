import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
        primaryStage.setTitle("DIS DA TITLE BC ALLI IS SO SMART");
        BorderPane root = new BorderPane();
        GridPane calender = new GridPane();
        calender.setAlignment(Pos.CENTER);
        for (int i = 0; i < 10; i++)
            calender.add(new Day(i), i, i);
        root.setCenter(calender);
        primaryStage.setScene(new Scene(root, 1980,1080));
        primaryStage.show();
    }
}
