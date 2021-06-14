package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class cinemaBooking implements Initializable {

    @FXML
    private Label movieLabel;

    @FXML
    private Label timeLabel;

    public void setMovieLabelText(String text){
        movieLabel.setText(text);
    }


    public void setTimeLabelText(String text){
        timeLabel.setText(text);
    }


    public void userLogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("loginPage.fxml");
    }

    public void backButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("filmsPage.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MovieSingleton movieSingleton = MovieSingleton.getInstance();
        setTimeLabelText(movieSingleton.getTime());
        setMovieLabelText(movieSingleton.getMovieTitle());
    }
}
