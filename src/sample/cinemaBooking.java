package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class cinemaBooking implements Initializable {

    @FXML
    private Label movieLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private ImageView seatImg;

    //Image myImage = new Image(getClass().getResourceAsStream("/Images/seat1inverted.png"));

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

    /* public void displayImage(){ use this later to change the seat into taken maybe
        seatImg.setImage(myImage);
    }*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MovieSingleton movieSingleton = MovieSingleton.getInstance();
        setTimeLabelText(movieSingleton.getTime());
        setMovieLabelText(movieSingleton.getMovieTitle());
    }
}
