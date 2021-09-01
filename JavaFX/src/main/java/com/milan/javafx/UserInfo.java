package com.milan.javafx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class UserInfo {
@FXML
    private TextField name;

    Message message = new Message();
    CalcData calcData = new CalcData();

    public void userInfo(ActionEvent actionEvent) throws IOException {
        String userName = name.getText();
        System.out.println(userName);

        if (userName.trim().length() == 0)
            message.warningMessage("Please Enter Your Name","No UserName Here");
        else {
            calcData.dataInput(userName.toUpperCase());
            ((Stage) (((Button) actionEvent.getSource()).getScene().getWindow())).close();
            String location = "calc-view.fxml";
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(location)));
            Scene scene = new Scene(root);
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void exiteCalc() {
        Platform.exit();
        System.exit(0);
    }
}
