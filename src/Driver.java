import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Driver extends Application {
    private GridPane userInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Life Plans");
        BorderPane root = new BorderPane();

        GridPane calender = new GridPane();
        calender.setAlignment(Pos.CENTER);
        root.setCenter(calender);

        userInput = new GridPane();
        userInput.setHgap(15);
        userInput.setVgap(10);
        Text[] define = { new Text("Activity: "), new Text("Start Time: "), new Text("End Time")};
        TextField[] inputers = { new TextField(), new TextField(), new TextField() };
        userInput.add(new Text("New Activity"), 0, 0);
        Button button = new Button("Insert");
        button.setOnMouseClicked(e -> userInput.setVisible(false));
        userInput.add(button, 0, define.length + 1);
        for (int i = 1; i < define.length + 1; i++) {
            userInput.add(define[i - 1], 0, i);
            userInput.add(inputers[i - 1], 1, i);
        }
        userInput.setVisible(false);
        calender.add(userInput, 0 , 0);

        Day day = new Day(1);
        day.addActivity(new Activity("Hello World", 30, 60));
        day.addActivity(new Activity("What you think?", 70, 120));
        calender.add(createDay(day), 10, 10);

        primaryStage.setScene(new Scene(root, 1980,1080));
        primaryStage.show();
    }

    private HBox createDay(Day day) {
        HBox dayBox = new HBox(3);

        //Background
        Image background = new Image("Day Design.png");
        dayBox.setPrefSize(background.getWidth(), background.getHeight());
        dayBox.setBackground(new Background(new BackgroundImage(background, null, null, null, null)));

        //Title of the Day
        Text title = new Text("\n  " + day.getName() + "  " + day.getDayNumber());
        dayBox.getChildren().add(title);

        //Panel to add activities.
        HBox hiddenPanel = new HBox(2);
        hiddenPanel.getChildren().add(new Text("Add Activity:"));
        Button addActivity = new Button("+");
        addActivity.setOnMouseClicked(e -> userInput.setVisible(true));

        hiddenPanel.getChildren().add(addActivity);
        hiddenPanel.setVisible(false);
        dayBox.getChildren().add(hiddenPanel);

        //Setting up functionality of disappearing and reappearing button.
        dayBox.setOnMouseEntered(e -> hiddenPanel.setVisible(true));
        dayBox.setOnMouseExited(e -> hiddenPanel.setVisible(false));

        return dayBox;
    }

    private VBox createActivities(Day day) {
        VBox activities = new VBox(5);

        //Adding activities in a list.
        Text acts = new Text(day.getStringActivities());
        activities.getChildren().add(activities);

        return activities;
    }

}
