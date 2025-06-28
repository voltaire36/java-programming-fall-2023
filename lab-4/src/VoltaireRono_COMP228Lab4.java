import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VoltaireRono_COMP228Lab4 extends Application {

    private ComboBox<String> coursesComboBox;
    private ListView<String> coursesListView;
    private TextArea infoArea;
    private TextField nameField, addressField, cityField, provinceField, postalCodeField, phoneField, emailField;
    private RadioButton csMajor, businessMajor;
    private CheckBox studentCouncil, volunteerWork;

    @Override
    public void start(Stage primaryStage) {
        // Initialize components
        coursesComboBox = new ComboBox<>();
        coursesListView = new ListView<>();
        infoArea = new TextArea();
        nameField = new TextField();
        addressField = new TextField();
        cityField = new TextField();
        provinceField = new TextField();
        postalCodeField = new TextField();
        phoneField = new TextField();
        emailField = new TextField();
        studentCouncil = new CheckBox("Student Council");
        volunteerWork = new CheckBox("Volunteer Work");


        // Create layout
        BorderPane root = new BorderPane();
        GridPane grid = createGridPane();

        // Radio buttons
        setupMajorSelection();


        HBox csHBox = new HBox(10, csMajor, studentCouncil);
        HBox businessHBox = new HBox(10, businessMajor, volunteerWork);

        // Course Selection ComboBox
        setupCourseSelection();

        Button displayButton = new Button("Display");
        displayButton.setOnAction(event -> displayStudentInfo());
        grid.add(displayButton, 1, 7);


        VBox rightSideVBox = new VBox(10);
        rightSideVBox.getChildren().addAll(csHBox, businessHBox, coursesComboBox, new Label("Courses:"), coursesListView);
        rightSideVBox.setPadding(new Insets(10));

        // Add components to the layout
        root.setCenter(grid);
        root.setRight(rightSideVBox);
        root.setTop(infoArea);

        // Finalize and show the stage
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Student Information System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createGridPane() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(5);
        grid.setHgap(5);

        // Add input fields to the grid
        grid.add(new Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Address:"), 0, 1);
        grid.add(addressField, 1, 1);
        grid.add(new Label("City:"), 0, 2);
        grid.add(cityField, 1, 2);
        grid.add(new Label("Province:"), 0, 3);
        grid.add(provinceField, 1, 3);
        grid.add(new Label("Postal Code:"), 0, 4);
        grid.add(postalCodeField, 1, 4);
        grid.add(new Label("Phone Number:"), 0, 5);
        grid.add(phoneField, 1, 5);
        grid.add(new Label("Email:"), 0, 6);
        grid.add(emailField, 1, 6);

        return grid;
    }


    private void setupMajorSelection() {
        csMajor = new RadioButton("Computer Science");
        businessMajor = new RadioButton("Business");
        ToggleGroup majorGroup = new ToggleGroup();
        csMajor.setToggleGroup(majorGroup);
        businessMajor.setToggleGroup(majorGroup);

        majorGroup.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
            updateCourseList((RadioButton) newVal);
        });
    }

    private void setupCourseSelection() {
        coursesComboBox.setOnAction(event -> {
            String selectedCourse = coursesComboBox.getSelectionModel().getSelectedItem();
            if (selectedCourse != null && !coursesListView.getItems().contains(selectedCourse)) {
                coursesListView.getItems().add(selectedCourse);
            }
        });
    }

    private void updateCourseList(RadioButton selectedMajor) {
        if ("Computer Science".equals(selectedMajor.getText())) {
            coursesComboBox.setItems(FXCollections.observableArrayList("Java", "C#", "Python"));
        } else if ("Business".equals(selectedMajor.getText())) {
            coursesComboBox.setItems(FXCollections.observableArrayList("Economics", "Accounting", "Management"));
        }
    }

    private void displayStudentInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Name: ").append(nameField.getText()).append("\n");
        info.append("Address: ").append(addressField.getText()).append("\n");
        info.append("City: ").append(cityField.getText()).append("\n");
        info.append("Province: ").append(provinceField.getText()).append("\n");
        info.append("Postal Code: ").append(postalCodeField.getText()).append("\n");
        info.append("Phone Number: ").append(phoneField.getText()).append("\n");
        info.append("Email: ").append(emailField.getText()).append("\n");

        if (csMajor.isSelected()) {
            info.append("Major: Computer Science\n");
        } else if (businessMajor.isSelected()) {
            info.append("Major: Business\n");
        }

        if (!coursesListView.getItems().isEmpty()) {
            info.append("Courses: ");
            for (String course : coursesListView.getItems()) {
                info.append(course).append(", ");
            }
            info.setLength(info.length() - 2); // Remove the trailing comma and space
            info.append("\n");
        }

        if (studentCouncil.isSelected()) {
            info.append("Involved in: Student Council\n");
        }
        if (volunteerWork.isSelected()) {
            info.append("Involved in: Volunteer Work\n");
        }

        // Set the text of infoArea
        infoArea.setText(info.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
