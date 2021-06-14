package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class cruella {

    @FXML
    private Label movieTitle;

    @FXML
    private Label timeLabel;

    public void userLogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("loginPage.fxml");
    }

    public void backButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("filmsPage.fxml");
    }

    public void bookNow(ActionEvent event) throws IOException {
        Main m = new Main();
        MovieSingleton movieSingleton = MovieSingleton.getInstance();
        movieSingleton.setMovieTitle(movieSingleton.getMovieTitle());
        movieSingleton.setTime(movieSingleton.getTime());
        m.changeScene("cinemaBookingView.fxml");
    }
}
