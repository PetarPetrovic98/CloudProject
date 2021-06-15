package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage stg;

    @Override
    public void start(Stage stage) throws Exception{
        stg = stage;
        stage.setResizable(false); //perhaps remove
        Parent root = FXMLLoader.load(getClass().getResource("logInPage.fxml"));
        stage.getIcons().add(new Image("/Images/cinemaicon2.png"));
        stage.setTitle("Cinema");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
