import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Driver extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(new StackPane(), 1980, 1080));
        primaryStage.show();
    }
}
