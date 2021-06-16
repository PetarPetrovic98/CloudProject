package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class filmsBookings implements Initializable {
    JSONObject jsonObject;

    @FXML
    private TableView<JSONObject> tableView;

    @FXML
    private TableColumn<JSONObject, Integer> orderIdTableColumn;

    @FXML
    private TableColumn<JSONObject, String> movieTableColumn;

    @FXML
    private TableColumn<JSONObject, String> dateTableColumn;

    @FXML
    private TableColumn<JSONObject, Integer> peopleTableColumn;

    MovieSingleton movieSingleton;

    @FXML
    public void viewBookings(ActionEvent event) throws IOException, JSONException {
        Main m = new Main();
        m.changeScene("viewBookingPage.fxml");

        UserSingleton userSingleton = UserSingleton.getInstance();

        //get user_id so we can get values from the current logged in user
        int userId = userSingleton.getUser_id();

        DBRequests viewBookingRequest = new DBRequests();
        String viewBookingInfoResult = viewBookingRequest.viewOrders(userId);
        String VBHR_hotfix = (viewBookingInfoResult.length() >0 ) ? viewBookingInfoResult.substring(1, viewBookingInfoResult.length()-1) : "{}";

        //Printing info about user
        System.out.println("Userid: "+userId);
        System.out.println("User booking content: "+VBHR_hotfix);

        //Fetching values from the JSON file
        jsonObject = new JSONObject(VBHR_hotfix);
        int order_id = jsonObject.getInt("Order ID");
        String movieTitle = jsonObject.getString("Title");
        String booked_date = jsonObject.getString("Date");
        int number_of_seats = jsonObject.getInt("Seats");

        //Print all the values
        System.out.println(order_id);
        System.out.println(movieTitle);
        System.out.println(booked_date);
        System.out.println(number_of_seats);


        ObservableList<JSONObject> list = FXCollections.observableArrayList();
        list.add(jsonObject);

        //Displaying the fetched values on UI
        orderIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        movieTableColumn.setCellValueFactory(new PropertyValueFactory<>("movieTitle"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("booked_date"));
        peopleTableColumn.setCellValueFactory(new PropertyValueFactory<>("number_of_seats"));

        tableView.setItems(list);
    }

    @FXML
    public void userLogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("loginPage.fxml");
    }

    @FXML
    public void backButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("welcomePage.fxml");
    }

    @FXML
    public void viewFilms(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("filmsPage.fxml");
    }

    public void viewCruella(MouseEvent event) throws IOException {
        Main m = new Main();
        movieSingleton.setMovieTitle("Cruella");
        movieSingleton.setTime("20:30");
        movieSingleton.setSeatPrice(130);
        movieSingleton.setMovieID(25);
        m.changeScene("cruella.fxml");
    }

    public void viewKong(MouseEvent event) throws IOException {
        Main m = new Main();
        movieSingleton.setMovieTitle("Kong");
        movieSingleton.setTime("13:30");
        movieSingleton.setSeatPrice(150);
        movieSingleton.setMovieID(35);
        m.changeScene("kong.fxml");
    }

    public void viewSpiral(MouseEvent event) throws IOException {
        Main m = new Main();
        movieSingleton.setMovieTitle("Spiral");
        movieSingleton.setTime("15:30");
        movieSingleton.setSeatPrice(120);
        movieSingleton.setMovieID(45);
        m.changeScene("spiral.fxml");
    }

    public void vievNobody(MouseEvent event) throws IOException {
        Main m = new Main();
        movieSingleton.setMovieTitle("Nobody");
        movieSingleton.setTime("17:30");
        movieSingleton.setSeatPrice(120);
        movieSingleton.setMovieID(55);
        m.changeScene("nobody.fxml");
    }

    public void viewTove(MouseEvent event) throws IOException {
        Main m = new Main();
        movieSingleton.setMovieTitle("Tove");
        movieSingleton.setTime("19:30");
        movieSingleton.setSeatPrice(150);
        movieSingleton.setMovieID(65);
        m.changeScene("tove.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        movieSingleton = MovieSingleton.getInstance();
    }
}
