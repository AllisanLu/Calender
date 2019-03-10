import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.HashMap;

public class Driver extends Application {
    private TilePane calender;
    private BorderPane root;
    private Text title;
    private Month[] months;
    private int monthAt = 0;
    private Day previouslyClicked;
    private VBox previouslyClicked2;
    private GridPane userInput;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Things to Do");
        root = new BorderPane();
        Scene scene = new Scene(root, 500, 400);
        scene.getStylesheets().add("Testing.css");

        initializeMonths();
        createUserInput();
        setMonth(monthAt);
        root.setCenter(calender);
        //calender.getChildren().add(userInput);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeMonths() {
        months = new Month[12];

        for(int i = 0; i < months.length; i++)
            months[i] = new Month(i);
    }

    private void setMonth(int month) {
        if(0 > month || month > 11)
            return;

        calender = new TilePane(5, 20);
        calender.setPrefRows(6);
        calender.setPrefColumns(6);
        calender.setMaxSize(1200, 500);

        for(Day day : months[month].getDays())
            calender.getChildren().add(createDay(day));

        calender.setVisible(true);

        createTitleBox(month);
    }

    private void createTitleBox(int month) {
        HBox titleBox = new HBox();
        titleBox.autosize();
        titleBox.getChildren().add(previousMonth());
        title = new Text(months[month].getName());
        titleBox.getChildren().add(title);
        titleBox.getChildren().add(nextMonth());
        root.setTop(titleBox);
    }

    private VBox createDay(Day day) {
        VBox dayBox = new VBox(5);

        dayBox.setPrefSize(150, 90);
        dayBox.getStyleClass().add("day");

        Text title = new Text(day.getName() + " "  +day.getDayNumber());
        dayBox.getChildren().add(title);

        VBox activityHolder = new VBox(5);
        //activityHolder.getStyleClass().add("activities"); use this later to add activies

        HBox panel = createDayPanel(day, activityHolder);
        dayBox.setOnMouseEntered(e -> panel.setVisible(true));
        dayBox.setOnMouseExited(e -> panel.setVisible(false));
        dayBox.getChildren().add(panel);

        for(Activity activity : day.getActivities())
            activityHolder.getChildren().add(new Text(activity.toString()));

        dayBox.getChildren().add(activityHolder);
        return dayBox;
    }

    private HBox createDayPanel(Day day, VBox activities) {
        HBox panel = new HBox(5);
        panel.getStyleClass().add("panel");

        Text activity = new Text("Add Activity: ");
        panel.getChildren().add(activity);

        Button addActivity = revealUserInput(day, activities);

        panel.getChildren().add(addActivity);

        panel.setVisible(false);

        return panel;
    }

    private Button revealUserInput(Day day, VBox activities) {
        Button add = new Button("+");
        add.getId();
        add.setOnMouseClicked(e -> {
            Stage popUp = new Stage();
            popUp.setTitle("Add Activity: ");
            popUp.initModality(Modality.NONE);
           // popUp.initOwner(primaryStage);

            BorderPane bg = new BorderPane();
            Scene scene = new Scene(bg, 180, 100);
            scene.getStylesheets().add("Testing.css");
            bg.setCenter(userInput);
            popUp.setScene(scene);
            previouslyClicked = day;
            previouslyClicked2 = activities;
            popUp.show();
        });

        return add;
    }

    private Button nextMonth() {
        Button change = new Button("-->");
        change.setOnMouseClicked(e -> {
            monthAt++;
            setMonth(monthAt);
        });

        return change;
    }

    private Button previousMonth() {
        Button change = new Button("<--");
        change.setOnMouseClicked(e -> {
            monthAt--;
            setMonth(monthAt);
        });

        return change;
    }

    private void createUserInput() {
        userInput = new GridPane();
        userInput.setHgap(10);
        userInput.setHgap(10);

        String[] instructions = {"Activity:", "Start: ", "End: "};
        TextField[] textInput = {new TextField(), new TextField(), new TextField()};

        for(int i = 0; i < instructions.length; i++) {
            userInput.add(new Text(instructions[i]), 0, i);
            userInput.add(textInput[i], 1, i);
        }

        Button submit = new Button("+");
        submit.setOnMouseClicked(e -> {

            addActivity(e);
            userInput.setVisible(false);
        });
        userInput.add(submit, 0,textInput.length + 1);

        //userInput.setVisible(false);
    }

    private void addActivity(MouseEvent e) {
        String[] answers = new String[3];
        int index = 0;
        for(Node node : userInput.getChildren()) {
            if(node instanceof TextField) {
                TextField text = (TextField) node;
                answers[index++] = text.getText();
            }
        }
        Activity act = new Activity(answers[0], Integer.valueOf(answers[1]), Integer.valueOf(answers[2]));

        previouslyClicked.addActivity(act);
        updateDay(previouslyClicked2, act);
    }

    private void updateDay(VBox activites, Activity activity) {
        activites.getChildren().add(new Text(activity.toString()));
    }
}
