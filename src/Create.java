import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Create {
    public static VBox createDay(Day day) {
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

        hiddenPanel.getChildren().add(addActivity);
        hiddenPanel.setVisible(false);
        dayBox.getChildren().add(hiddenPanel);
        dayBox.getStyleClass().add("day");

        //the activities
        dayBox.getChildren().add(createActivities(day));

        //Setting up functionality of disappearing and reappearing button.
        dayBox.setOnMouseEntered(e -> hiddenPanel.setVisible(true));
        dayBox.setOnMouseExited(e -> hiddenPanel.setVisible(false));

        return dayBox;
    }

    private static VBox createActivities(Day day) {
        VBox activities = new VBox(5);
        activities.getStyleClass().add("activities");

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
