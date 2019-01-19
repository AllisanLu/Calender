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
                calender.add(createDay(month.getDays()[index++]), j, i);
            }
        }

        Scene scene = new Scene(root, 1980,1080);
        scene.getStylesheets().add("Testing.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createDay(Day day) {
        VBox dayBox = new VBox(5);

        //Background
//        Image background = new Image("Day Design.png");
//        dayBox.setPrefSize(background.getWidth(), background.getHeight());
//        dayBox.setBackground(new Background(new BackgroundImage(background, null, null, null, null)));

        //Title of the Day
        VBox title = new VBox(new Label("\n" + day.getName() + "  " + day.getDayNumber()));
        title.setAlignment(Pos.CENTER);
        dayBox.getChildren().add(title);

        //Panel to add activities.
        HBox hiddenPanel = new HBox(2);
        hiddenPanel.setAlignment(Pos.CENTER);
        hiddenPanel.setAlignment(Pos.CENTER);
        hiddenPanel.getChildren().add(new Text("New Activity: "));
        Button addActivity = new Button("+");
        hiddenPanel.getStyleClass().add("Testing");

        hiddenPanel.getChildren().add(addActivity);
        hiddenPanel.setVisible(false);
        dayBox.getChildren().add(hiddenPanel);

        //the activities
        dayBox.getChildren().add(createActivities(day));

        //Setting up functionality of disappearing and reappearing button.
        dayBox.setOnMouseEntered(e -> hiddenPanel.setVisible(true));
        dayBox.setOnMouseExited(e -> hiddenPanel.setVisible(false));

        return dayBox;
    }

    private VBox createActivities(Day day) {
        VBox activities = new VBox(5);

        for(Activity activity : day.getActivities()) {
            activities.getChildren().add(new Text("  " + activity.toString()));
        }

        return activities;
    }

    /**
     * Adds text to Pane in the order of the array entered.
     * @param pane
     * @param texts
     */
}
