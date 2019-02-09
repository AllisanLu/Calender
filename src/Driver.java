import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Driver extends Application {
    private TilePane calender;
    private Text title;
    private Month[] months;
    private Day previouslyClicked;
    private GridPane userInput;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello, World");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 400);

        initializeMonths();
        createUserInput();
        setMonth(0);
        root.setCenter(calender);
        calender.getChildren().add(userInput);
        root.setTop(title);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeMonths() {
        months = new Month[12];

        for(int i = 0; i < months.length; i++)
            months[i] = new Month(i);
    }

    private void setMonth(int month) {
        if(0 > month || month > 12)
            return;

        calender = new TilePane(5, 20);
        calender.setPrefRows(7);
        calender.setPrefColumns(5);
        calender.setMaxSize(900, 500);

        for(Day day : months[month].getDays())
            calender.getChildren().add(createDay(day));

        calender.setVisible(true);

        title = new Text(months[month].getName());
    }

    private VBox createDay(Day day) {
        VBox dayBox = new VBox(5);

        dayBox.setPrefSize(150, 100);

        Text title = new Text(day.getName() + " "  +day.getDayNumber());
        title.setTextAlignment(TextAlignment.CENTER);
        dayBox.getChildren().add(title);

        HBox panel = createDayPanel(day);
        dayBox.setOnMouseEntered(e -> panel.setVisible(true));
        dayBox.setOnMouseExited(e -> panel.setVisible(false));
        dayBox.getChildren().add(panel);

        VBox activityHolder = new VBox(5);
        for(Activity activity : day.getActivities())
            activityHolder.getChildren().add(new Text(activity.toString()));

        dayBox.getChildren().add(activityHolder);
        return dayBox;
    }

    private HBox createDayPanel(Day day) {
        HBox panel = new HBox(5);

        Text activity = new Text("Add Activity: ");
        panel.getChildren().add(activity);

        Button addActivity = revealUserInput(day);

        panel.getChildren().add(addActivity);

        panel.setVisible(false);

        return panel;
    }

    private Button revealUserInput(Day day) {
        Button add = new Button("+");
        add.setOnMouseClicked(e -> {
            userInput.setVisible(true);
            previouslyClicked = day;
        });

        return add;
    }

    private void createUserInput() {
        userInput = new GridPane();
        userInput.setHgap(10);
        userInput.setHgap(10);

        String[] instructions = {"Activity:", "Start: ", "End: "};
        TextField[] textInput = { new TextField(), new TextField(), new TextField()};

        for(int i = 0; i < instructions.length; i++) {
            userInput.add(new Text(instructions[i]), 0, i);
            userInput.add(textInput[i], 1, i);
        }

        Button submit = new Button("+");
        submit.setOnMouseClicked(e -> {
            addActivity();
            userInput.setVisible(false);
        });
        userInput.add(submit, 0,textInput.length + 1);

        userInput.setVisible(false);
    }

    private void addActivity() {
        String[] answers = new String[3];
        int index = 0;
        for(Node node : userInput.getChildren()) {
            if(node instanceof TextField) {
                TextField text = (TextField) node;
                answers[index++] = text.getText();
            }
        }
        previouslyClicked.addActivity(new Activity(answers[0], Integer.valueOf(answers[1]), Integer.valueOf(answers[2])));
    }
}
