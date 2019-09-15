package exercise6.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("customer.fxml"));
        primaryStage.setTitle("Agent Data Manager");
        primaryStage.setScene(new Scene(root, 700, 550));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
