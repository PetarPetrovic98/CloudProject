package sample;

import com.google.gson.Gson;
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

    @FXML private Label totalPriceLabel;

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

    private ArrayList<Button> seats = new ArrayList<>();

    // order variables
    private ArrayList<String> seatsList = new ArrayList<>();
    private LocalDate bookedDate;
    private String timeStamp;
    @FXML private DatePicker datePicker;

    UserSingleton user = UserSingleton.getInstance();
    MovieSingleton movie = MovieSingleton.getInstance();
    private double totalPrice;
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

        // store the information from the UI and sends an order when book now btn is pressed
        timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
        String bookedDateStr = bookedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        movie = MovieSingleton.getInstance();
        int movieID = movie.getMovieID();

        user = UserSingleton.getInstance();
        int userID = user.getUser_id();

        ArrayList<Integer> seatsListNew  = getIntArray(seatsList);

        // create the order
        Order order = new Order(timeStamp, bookedDateStr, movieID, userID, seatsListNew);
        DBRequests dbr = new DBRequests();
        dbr.createOrders(order);

        // clear the list after a order is sent
        seatsList.clear();
    }

    // used for converting string array to int array
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

    // returns the date picked by the user from datePicker
    public void getDate(ActionEvent event){
        for (Button b:seats) {
            b.setDisable(false);
            b.setStyle("-fx-background-color: MediumSeaGreen");
        }
        MovieSingleton movieSingleton = MovieSingleton.getInstance();
        bookedDate = datePicker.getValue();
        System.out.println(bookedDate);

        // reset total price when date is changed
        totalPrice = 0;
        totalPriceLabel.setText(totalPrice + " kr");
        seatsList.clear();

        DBRequests dbRequests = new DBRequests();
        try {
            String occupiedSeats = dbRequests.returnBookedSeats(movieSingleton.getMovieID(), bookedDate.toString());
            System.out.println(occupiedSeats);

            Gson gson = new Gson();

            SeatWrapper[] seatsArray = gson.fromJson(occupiedSeats, SeatWrapper[].class);

            if (seatsArray.length==0) System.out.println("No occupied seats");
            else {
                for (SeatWrapper seat : seatsArray) {
                    System.out.println(seat.seat_number);
                    seats.get(seat.seat_number-1).setDisable(true);
                    seats.get(seat.seat_number-1).setStyle("-fx-background-color: Red");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // adds or removes the clicked seat (seat number) to a list for booking
    public void seatBtnAction(ActionEvent event){
        final Node source = (Node) event.getSource();

        // gets the seat number
        String seatId = source.getId();
        String seatNum = seatId.replaceFirst("btn", "");

        if (seatsList.contains(seatNum)){
            seatsList.remove(seatNum);
            source.setStyle("-fx-background-color: MediumSeaGreen");
            totalPrice -= movie.getSeatPrice();
            totalPriceLabel.setText(totalPrice + " kr");
            return;
        }
        seatsList.add(seatNum);
        source.setStyle("-fx-background-color: Yellow");
        totalPrice += movie.getSeatPrice();
        totalPriceLabel.setText(totalPrice + " kr");
    }

    /* public void displayImage(){ use this later to change the seat into taken maybe
        seatImg.setImage(myImage);
    }*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MovieSingleton movieSingleton = MovieSingleton.getInstance();
        setTimeLabelText(movieSingleton.getTime());
        setMovieLabelText(movieSingleton.getMovieTitle());

        seats.add(seat1);
        seats.add(seat2);
        seats.add(seat3);
        seats.add(seat4);
        seats.add(seat5);
        seats.add(seat6);
        seats.add(seat7);
        seats.add(seat8);
        seats.add(seat9);
        seats.add(seat10);
        seats.add(seat11);
        seats.add(seat12);
        seats.add(seat13);
        seats.add(seat14);
        seats.add(seat15);
        seats.add(seat16);
        seats.add(seat17);
        seats.add(seat18);
        seats.add(seat19);
        seats.add(seat20);

    }

    public class SeatWrapper{
        int seat_number;
    }
}
