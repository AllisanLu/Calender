import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Driver extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("DIS DA TITLE BC ALLI IS SO SMART");
        StackPane root = new StackPane();
        root.getChildren().add(new Day(0));
        primaryStage.setScene(new Scene(root, 1980,1080));
        primaryStage.show();
    }
}
