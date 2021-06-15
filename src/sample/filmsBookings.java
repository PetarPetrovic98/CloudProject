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
    public void viewBookings(ActionEvent event) throws IOException, JSONException {
        Main m = new Main();
        m.changeScene("viewBookingPage.fxml");
        System.out.println("Hello");

        //get user_id so we can get values from the current logged in user
        int userId = 1;

        DBRequests viewBookingRequest = new DBRequests();
        String viewBookingInfoResult = viewBookingRequest.viewOrders(userId);
        System.out.println("ViewBooking classen: "+viewBookingInfoResult);

        //Fetching values from the JSON file
        jsonObject = new JSONObject(viewBookingInfoResult);
        int orderId = jsonObject.getInt("order_id");
        String movieTitle = jsonObject.getString("title");
        String dateMovieDisplayed = jsonObject.getString("timestamp");
        int peopleBooked = jsonObject.getInt("number_of_seats");

        ObservableList<JSONObject> list = FXCollections.observableArrayList(new JSONObject(jsonObject));

        //Displaying the fetched values on UI
        orderIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        movieTableColumn.setCellValueFactory(new PropertyValueFactory<>("movieTitle"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("dateMovieDisplayed"));
        peopleTableColumn.setCellValueFactory(new PropertyValueFactory<>("peopleBooked"));

        tableView.setItems(list);
    }

    @FXML
    public void viewFilms(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("filmsPage.fxml");
    }

    public void viewCruella(MouseEvent event) throws IOException {
        Main m = new Main();
        movieSingleton.setMovieTitle("Cruella");
        movieSingleton.setTime("17:50");
        m.changeScene("cruella.fxml");
    }

    public void viewKong(MouseEvent event) throws IOException {
        Main m = new Main();
        movieSingleton.setMovieTitle("Kong");
        movieSingleton.setTime("17:50");
        m.changeScene("kong.fxml");
    }

    public void viewSpiral(MouseEvent event) throws IOException {
        Main m = new Main();
        movieSingleton.setMovieTitle("Spiral");
        movieSingleton.setTime("17:50");
        m.changeScene("spiral.fxml");
    }

    public void vievNobody(MouseEvent event) throws IOException {
        Main m = new Main();
        movieSingleton.setMovieTitle("Nobody");
        movieSingleton.setTime("17:50");
        m.changeScene("nobody.fxml");
    }

    public void viewTove(MouseEvent event) throws IOException {
        Main m = new Main();
        movieSingleton.setMovieTitle("Tove");
        movieSingleton.setTime("17:50");
        m.changeScene("tove.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        movieSingleton = MovieSingleton.getInstance();
    }
}
