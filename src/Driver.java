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
        Day day = new Day(1);
        day.addActivity(new Activity("Hello World", 30, 60));
        day.addActivity(new Activity("What you think?", 70, 120));
        calender.add(createDay(day), 10, 10);

        primaryStage.setScene(new Scene(root, 1980,1080));
        primaryStage.show();
    }

    private VBox createDay(Day day) {
        VBox dayBox = new VBox(5);

        //Panel to add activities.
        HBox hiddenPanel = new HBox(20);
        hiddenPanel.getChildren().add(new Text("Add Activity: "));
        Button addActivity = new Button("+");

        addActivity.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                GridPane input = new GridPane();
                input.setHgap(15);
                input.setVgap(10);

                Text activityTitle = new Text("New Activity");
                Text[] define = { new Text("Activity: "), new Text("Start Time: "), new Text("End Time")} ;
                TextField[] inputers = { new TextField(), new TextField(), new TextField() };
                input.add(activityTitle, 0, 0);

                for (int i = 1; i < define.length + 1; i++) {
                    input.add(define[i - 1], i, 0);
                    input.add(inputers[i - 1], i, i);
                }
                dayBox.getChildren().add(input);
            }
        });

        hiddenPanel.getChildren().add(addActivity);
        hiddenPanel.setVisible(false);
        dayBox.getChildren().add(hiddenPanel);



        //Setting up functionality of disappearing and reappearing button.
        dayBox.setOnMouseEntered(e -> hiddenPanel.setVisible(true));
        dayBox.setOnMouseExited(e -> hiddenPanel.setVisible(false));

        //Background
        Image background = new Image("Day Design.png");
        dayBox.setPrefSize(background.getWidth(), background.getHeight());
        dayBox.setBackground(new Background(new BackgroundImage(background, null, null, null, null)));

        //Title of the Day
        Text title = new Text("\n  " + day.getName() + "\t\t\t\t" + day.getDayNumber());
        dayBox.getChildren().add(title);

        //Adding activities in a list.
        Text activities = new Text(day.getStringActivities());
        dayBox.getChildren().add(activities);

        return dayBox;
    }
}
