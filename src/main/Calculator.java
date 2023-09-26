package src.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Calculator extends Application {

    private CalculatorController controller;

    @Override
    public void start(Stage stage) throws Exception {
        // Load the FXML file
        Parent root = FXMLLoader.load(getClass().getResource("../resources/calcUi.fxml"));

        // Set the scene and show the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(Calculator.class, args);
    }
}
