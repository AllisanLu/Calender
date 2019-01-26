import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Driver extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Life Plans");
        VBox root = new VBox(200);

        GridPane calender = new GridPane();
        calender.setAlignment(Pos.CENTER_LEFT);
        root.getChildren().add(calender);

//        userInput = new GridPane();
//        userInput.setHgap(15);
//        userInput.setVgap(10);
//        Text[] define = { new Text("Activity: "), new Text("Start Time: "), new Text("End Time")};
//        TextField[] inputers = { new TextField(), new TextField(), new TextField() };
//        userInput.add(new Text("New Activity"), 0, 0);
//        Button button = new Button("Insert");
//        button.setOnMouseClicked(e -> userInput.setVisible(false));
//        userInput.add(button, 0, define.length + 1);
//        for (int i = 1; i < define.length + 1; i++) {
//            userInput.add(define[i - 1], 0, i);
//            userInput.add(inputers[i - 1], 1, i);
//        }
//
        Month month = new Month(0);
        month.getDays()[0].addActivity(new Activity("Hello", 10, 30));

        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                calender.add(Create.createDay(month.getDays()[index++]), j, i); //wtf are j and i
            }
        }

        Scene scene = new Scene(root, 1980,1080);
        scene.getStylesheets().add("Testing.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
