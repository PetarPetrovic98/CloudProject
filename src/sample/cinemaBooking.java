package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    // order variables
    private ArrayList<String> seatsList = new ArrayList<>();
    private LocalDate bookedDate;
    private String timeStamp;
    @FXML private DatePicker datePicker;

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
//        ArrayList<Integer> seats = new ArrayList<>();
//        seats.add(1);
//        seats.add(2);
//        Order order = new Order("2021-06-06 12:24:31", "2021-06-10", 25, 35, seats);
//
//        DBRequests dbr = new DBRequests();
//        dbr.createOrders(order);

        //---------------------------------------------------------------------
        //todo get movieID from singleton

        // store the information from the UI and sends an order when book now btn is pressed
        timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
        String bookedDateStr = bookedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        MovieSingleton movie = MovieSingleton.getInstance();
        int movieID = movie.getMovieID();

        UserSingleton user = UserSingleton.getInstance();
        int userID = user.getUser_id();

        ArrayList<Integer> seatsListNew  = getIntArray(seatsList);

        // create the order
        Order order = new Order(timeStamp, bookedDateStr, movieID, userID, seatsListNew);
        DBRequests dbr = new DBRequests();
        dbr.createOrders(order);

        System.out.println("Timestamp: " + timeStamp + ", BookedDate: " + bookedDateStr + ", MovieID: " + movieID + ", UserID: " + userID + ", Seats: " + seatsListNew);
        seatsList.clear();
    }

    private ArrayList<Integer> getIntArray(ArrayList<String> stringArray){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(String stringValue : stringArray) {
            try {
                //Convert String to Integer, and store it into integer array list.
                result.add(Integer.parseInt(stringValue));
            } catch(NumberFormatException nfe) {
                nfe.printStackTrace();
            }
        }
        return result;
    }

    public void getDate(ActionEvent event){
        bookedDate = datePicker.getValue();
    }

    public void seatBtnAction(ActionEvent event){
        final Node source = (Node) event.getSource();

        String seatId = source.getId();
        String seatNum = seatId.replaceFirst("btn", "");

        if (seatsList.contains(seatNum)){
            seatsList.remove(seatNum);
            System.out.println("removed " + seatNum);
            return;
        }
        seatsList.add(seatNum);
        System.out.println("added " + seatNum);
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
