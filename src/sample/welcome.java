package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button; //Works without this
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;

import java.io.IOException;
import java.util.ResourceBundle;

public class welcome implements Initializable{ //implements Initializable {
    @FXML
    private Label userNameLabel;
    UserSingleton userSingleton;
    String fetchUserName;


    public void userLogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("loginPage.fxml");
    }

    public void viewFilms(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("filmsPage.fxml");
    }

    public void viewBookings(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("viewBookingPage.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        userSingleton = UserSingleton.getInstance();
        fetchUserName = userSingleton.getUsername();
        String name = fetchUserName.substring(0, 1).toUpperCase() + fetchUserName.substring(1);
        userNameLabel.setText("Welcome, "+name+"!");
    }
}
