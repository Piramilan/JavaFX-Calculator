package com.milan.javafx;

import javafx.scene.control.*;

public class Message {

    public void errorMessage(String content,String header) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Error Dialog");
        alert.setContentText(content);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setHeaderText(header);
        dialogPane.setStyle("-fx-background-color: #ef043b;");
        dialogPane.lookup(".content.label").setStyle("-fx-font-size: 14px; "
                + "-fx-font-weight: bold;"+"-fx-text-fill: #ffffff");

        alert.show();
    }


    public void warningMessage(String content,String header) {
        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("Warning");
        alert.setContentText(content);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setHeaderText(header);
        dialogPane.setStyle("-fx-background-color: #ffffff;");
        dialogPane.lookup(".content.label").setStyle("-fx-font-size: 14px; "
                + "-fx-font-weight: bold;"+"-fx-text-fill: #000000");

        alert.show();
    }



}
