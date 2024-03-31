package org.example.exercise3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    public TextField numberOne;
    @FXML
    public TextField numberTwo;

    @FXML
    private Label resultText;


    @FXML
    protected void onHelloButtonClick() {
        resultText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void onPlusButtonClick() {
        int a = getNumber(numberOne);
        int b = getNumber(numberTwo);
        int res = a + b;
        resultText.setText(a + " plus " + b + " equals: " + res);
    }

    public void onMinusButtonClick() {
        int a = getNumber(numberOne);
        int b = getNumber(numberTwo);
        int res = a - b;
        resultText.setText(a + " minus " + b + " equals: " + res);
    }



    public void onTimesButtonClick() {
        int a = getNumber(numberOne);
        int b = getNumber(numberTwo);
        int res = a * b;
        resultText.setText(a + " times " + b + " equals: " + res);
    }

    public void onDivideButtonClick() {
        int a = getNumber(numberOne);
        int b = getNumber(numberTwo);
        int res = a / b;
        resultText.setText(a + " divide " + b + " equals: " + res);
    }

    public void onClearButtonClick() {
        numberOne.setText("");
        numberTwo.setText("");
        resultText.setText("");
    }

    private int getNumber(TextField number) {
        return Integer.parseInt(number.getText());
    }
}