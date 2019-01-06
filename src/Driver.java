import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
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
        //calender.setAlignment(Pos.CENTER);
        root.setCenter(calender);
        Day day = new Day(1);
        day.addActivity(new Activity("Hello World", 30, 60));
        day.addActivity(new Activity("What you think?", 70, 120));
        calender.add(createDay(day), 0, 0);
        //addDay(primaryStage, calender);

        primaryStage.setScene(new Scene(root, 1980,1080));
        primaryStage.show();
    }

    public void addDay(Stage primaryStage, GridPane calender) throws Exception {
        ImageView dayDesign = new ImageView(new Image(Driver.class.getResourceAsStream("Day Design.png")));
        calender.add(dayDesign, 0, 0, 2, 4);

        Label labelDay = new Label(" Day 1");
        labelDay.setStyle("-fx-font-size: 16;");
        calender.add(labelDay, 0, 0, 1, 1);

        Button add = new Button("+");
        add.setStyle("-fx-base: #7f9ed1");
        calender.add(add, 5, 0, 5, 3);

        Label labelEvents = new Label("  -Eat food"); //where to add time?
        calender.add(labelEvents, 0, 1, 2, 3);
    }

    private VBox createDay(Day day) {
        VBox dayBox = new VBox();

        Image background = new Image("Day Design.png");
        dayBox.setPrefSize(background.getWidth(), background.getHeight());
        dayBox.setBackground(new Background(new BackgroundImage(background, null, null, null, null)));
        Text title = new Text(day.getName() + "                        " + day.getDayNumber());
        //title.setFont();
        dayBox.getChildren().add(title);
        Text activities = new Text(day.getStingActivities());
        dayBox.getChildren().add(activities);
        return dayBox;
    }
}
