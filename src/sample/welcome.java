package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button; //Works without this
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;

import java.io.IOException;
import java.util.ResourceBundle;

public class welcome { //implements Initializable {

   /*  @FXML     //and this
    private Button logOutButton; //...

    @FXML
    private ImageView slideShow;

    int count;

    public void slideshow() {
        ArrayList<Image> images = new ArrayList<Image>();
        images.add(new Image("/Images/cruella.jpg"));
        images.add(new Image("/Images/Igodvskong.jpg"));
        images.add(new Image("/Images/godzillavskong.jpg"));
        images.add(new Image("/Images/cruellasmaller.jpg"));


        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> (
                slideShow.setImage(images.get(count));
                count++;
            if (count == 4) {
                count = 0;
            }
        )));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    } */

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

  /*  @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        slideshow();
    } */
}
