package com.milan.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.EmptyStackException;

public class HelloController {
    @FXML
    private Label calculation,answer;

    private boolean isOperatorClicked;
    private double ans;

    Message message = new Message();
    CheckDivide check = new CheckDivide();
    CalcData calcData = new CalcData();


    public void insertNumber(String number){
        if (answer.getText().length() > 11)
            message.warningMessage("You Can't Insert More Number","Insert Limited Numbers Only");
        answer.setText(answer.getText() + number);
    }
    public void insertOperator(String operator){
        if (isOperatorClicked)
            answer.setText(answer.getText() + " " + operator + " ");
            isOperatorClicked = false;
    }
    public void numberClicked(ActionEvent numberEvent) {
        Button button = (Button) numberEvent.getSource();
        String number = button.getText();
        isOperatorClicked = true;
        insertNumber(number);
    }

    public void operationClicked(ActionEvent optEvent) {
        Button button = (Button) optEvent.getSource();
        String oparation = button.getText();
        insertOperator(oparation);
    }

    public void btnEqual() {
        DecimalFormat df = new DecimalFormat("#.####");
        calculation.setText(answer.getText());
        String[] values = answer.getText().split(" ");

        try{

            if (values.length == 3){
                try {
                    double num1 = Double.parseDouble(values[0]);
                    double num2 = Double.parseDouble(values[2]);
                    switch (values[1]){
                        case "+":
                            ans = num1 + num2;
                            break;
                        case "-":
                            ans = num1 - num2;
                            break;
                        case "/":
                            ans = check.zeroDivide(num1, num2);
                            break;
                        case "*":
                            ans = num1 * num2;
                            break;
                        case "%":
                            if (num1 > num2)
                                ans = num1 % num2;
                            else
                                ans = 0;
                            break;
                    }
                }catch (Exception e){
                    answer.setText("Error" + e);//Alert
                }

            }
            else if (values.length < 3)
                return;
            else{
                try {
                    ans = EvaluateString.evaluate(answer.getText());
                }catch (EmptyStackException e){
                    message.errorMessage("Exception "+e,"Input Error");
                    answer.setText("");
                    calculation.setText("");
                    return;
                }
            }
            String finalAnswer = String.valueOf(df.format(ans));
            answer.setText(finalAnswer);
            String information = calculation.getText() + " = " + finalAnswer;
            calcData.dataWrite(information);

        }catch (IllegalArgumentException | IOException e){
            message.errorMessage("Error" , "Ex - " + e);//Alert
        }


    }

    public void btnAC() {
        answer.setText("");
        calculation.setText("");
    }

    public void btnDelete() {
        int len = answer.getText().length();
        if (len != 0)
            answer.setText(answer.getText().substring(0, len - 1));
        else
            message.errorMessage("Empty","No Character Here To Delete");//Alert
    }

    public void dotClicked(){
        String[] values = answer.getText().split(" ");
        String num = values[values.length - 1];
        if (num.contains(".")) {
            message.errorMessage("Error","You Can't Put Dot Continuously");//Alert
        }
        else
            answer.setText(answer.getText() + ".");
    }

}