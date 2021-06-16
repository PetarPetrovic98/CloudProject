package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class cinemaBooking implements Initializable {

    @FXML private Label movieLabel;
    @FXML private Label timeLabel;

    @FXML private ImageView seatImg;

    @FXML private Button seat1;
    @FXML private Button seat2;
    @FXML private Button seat3;
    @FXML private Button seat4;
    @FXML private Button seat5;
    @FXML private Button seat6;
    @FXML private Button seat7;
    @FXML private Button seat8;
    @FXML private Button seat9;
    @FXML private Button seat10;
    @FXML private Button seat11;
    @FXML private Button seat12;
    @FXML private Button seat13;
    @FXML private Button seat14;
    @FXML private Button seat15;
    @FXML private Button seat16;
    @FXML private Button seat17;
    @FXML private Button seat18;
    @FXML private Button seat19;
    @FXML private Button seat20;

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

    public void bookNowBtnAction(ActionEvent event) throws IOException {

        // order is only for testing
        ArrayList<Integer> seats = new ArrayList<>();
        seats.add(1);
        seats.add(2);
        Order order = new Order("2021-06-06 12:24:31", "2021-06-10", 25, 35, seats);

        DBRequests dbr = new DBRequests();
        dbr.createOrders(order);
    }

    public void seatBtnAction(ActionEvent event){
        System.out.println("seat btn pressed");
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
