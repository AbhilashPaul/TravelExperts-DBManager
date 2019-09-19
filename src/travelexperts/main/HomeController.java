package travelexperts.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btnAgents;

    @FXML
    void onActionBtnAgents(ActionEvent event) throws IOException {
        Stage customerStage = null;
        Parent customerRoot = FXMLLoader.load(getClass().getResource("customer.fxml"));
        Scene customerScene = new Scene(customerRoot, 700, 550);
        customerStage.setScene(customerScene);
        customerStage.showAndWait();
    }

    @FXML
    void onActionBtnCustomers(ActionEvent event) {

    }

    @FXML
    void onActionBtnPackages(ActionEvent event) {

    }

}

