package src.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class CalculatorController implements Initializable
{

    double num1;
    double num2;

    String op = "";

    @FXML
    private Button divideButton;

    @FXML
    private Button equalButton;

//    @FXML
//    private VBox frameCalculator;

    @FXML
    private Button clearButton;

    @FXML
    private Button clearOne;

    @FXML
    private Button minusButton;

    @FXML
    private Button multiplyButton;

    @FXML
    private MenuItem newHistory;

    @FXML
    private MenuItem openFile;

    @FXML
    private Button plusButton;

    @FXML
    private MenuItem preferences;

    @FXML
    private MenuItem quit;

    @FXML
    private TextField resultTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        // Add code to handle the events that occur when the user interacts with the GUI components

        clearButton.setOnAction(event -> allClear());
        clearOne.setOnAction(event -> clearOne());
        minusButton.setOnAction(this::Operation);
        plusButton.setOnAction(this::Operation);
        multiplyButton.setOnAction(this::Operation);
        divideButton.setOnAction(this::Operation);
        equalButton.setOnAction(this::Operation);
    }

    public void allClear()
    {
        resultTextField.setText("");
    }

    public void clearOne()
    {
        resultTextField.setText(
                resultTextField.getText().substring(0, resultTextField.getText().length() - 1));
    }

    public void Number(ActionEvent event)
    {
        String no = ((Button) event.getSource()).getText();
        resultTextField.setText(resultTextField.getText() + no);
    }

    public void Operation(ActionEvent event)
    {
        String operation = ((Button) event.getSource()).getText();

        if (! operation.equals("="))
        {

            if (! op.isEmpty())
            {
                return;
            }
            op = operation;
            num1 = Double.parseDouble(resultTextField.getText());
            resultTextField.setText("");

        } else
        {

            if ("".equals(op))
            {
                return;
            }
            num2 = Double.parseDouble(resultTextField.getText());

            try
            {
                double result = onEqualButtonClick(num1, num2, op);
                resultTextField.setText(Double.toString(result));
            } catch (NumberFormatException e)
            {
                // Show error message for invalid number input
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Invalid number input");
                alert.setContentText("Please enter a valid number.");
                alert.show();
            } catch (ArithmeticException e)
            {
                // Show error for divide by zero
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Arithmetic error");
                alert.setContentText(e.getMessage());
                alert.show();
            }

            op = "";
        }
    }

    public double onEqualButtonClick(double num1, double num2, String op)
    {
        // Perform the calculation

        switch (op)
        {
            case "+" ->
            {
                return num1 + num2;
            }
            case "-" ->
            {
                return num1 - num2;
            }
            case "*" ->
            {
                return num1 * num2;
            }
            case "/" ->
            {
                // Check for divide by zero
                if (num2 == 0)
                {
                    throw new ArithmeticException("Divide by zero");
                }
                return num1 / num2;
            }
            default -> // Handle invalid operator
                    throw new IllegalArgumentException("Invalid operator");
        }
    }
}