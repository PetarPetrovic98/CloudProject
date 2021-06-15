package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class viewBooking {
    JSONObject jsonObject;

    @FXML
    private TableColumn<JSONObject, Integer> orderIdTableColumn;

    @FXML
    private TableColumn<JSONObject, String> movieTableColumn;

    @FXML
    private TableColumn<JSONObject, String> dateTableColumn;

    @FXML
    private TableColumn<JSONObject, Integer> peopleTableColumn;

    @FXML
    public void viewBookings (ActionEvent event) throws IOException, JSONException {

        //get user_id so we can get values from the current logged in user
        //int userId = jsonObject.getInt("user_id");
        int userId;
        DBRequests viewBookingRequest = new DBRequests();
        String viewBookingInfo = viewBookingRequest.viewOrders(userId);

        //Fetching values from the JSON file
        jsonObject = new JSONObject(viewBookingInfo);
        int orderId = jsonObject.getInt("order_id");
        String movieTitle = jsonObject.getString("title");
        String dateMovieDisplayed = jsonObject.getString("timestamp");
        int peopleBooked = jsonObject.getInt("number_of_seats");

        //Displaying the fetched values on UI
        orderIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        movieTableColumn.setCellValueFactory(new PropertyValueFactory<>("movieTitle"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("dateMovieDisplayed"));
        peopleTableColumn.setCellValueFactory(new PropertyValueFactory<>("peopleBooked"));



    }
   @FXML
    public void userLogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("loginPage.fxml");
    }
    @FXML
    public void viewFilms(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("filmsPage.fxml");
    }
    @FXML
    public void backButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("welcomePage.fxml");
    }

}
