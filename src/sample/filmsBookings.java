package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    cruella cruella = new cruella();

    @FXML
    private TableView<ViewOrders> tableView;

    @FXML
    private TableColumn<ViewOrders, String> orderIdTableColumn;

    @FXML
    private TableColumn<ViewOrders, String> movieTableColumn;

    @FXML
    private TableColumn<ViewOrders, String> dateTableColumn;

    @FXML
    private TableColumn<ViewOrders, String> peopleTableColumn;

    MovieSingleton movieSingleton;

    @FXML
    public void viewBookings(ActionEvent event) throws IOException {
        Main m = new Main();
        System.out.println("view bookingPage");
         m.changeScene("viewBookingPage.fxml");

    }

    public void fillTableView() throws JSONException, IOException {
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
        String order_id = String.valueOf(jsonObject.getInt("Order ID"));
        String movieTitle = jsonObject.getString("Title");
        String booked_date = jsonObject.getString("Date");
        String number_of_seats = String.valueOf(jsonObject.getInt("Seats"));

        //Print all the values
        System.out.println("Order ID: "+order_id);
        System.out.println("Movie: "+movieTitle);
        System.out.println("Date: "+booked_date);
        System.out.println("Seat Nbr: "+number_of_seats);

        //Construct and set the values so we can display it with TableColumn
        ObservableList<ViewOrders> list = FXCollections.observableArrayList();
        list.add(new ViewOrders(order_id,movieTitle,booked_date,number_of_seats));

        //Displaying the fetched values on UI
        orderIdTableColumn.setCellValueFactory(new PropertyValueFactory<ViewOrders,String>("order_id"));
        movieTableColumn.setCellValueFactory(new PropertyValueFactory<ViewOrders,String>("movieTitle"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<ViewOrders,String>("booked_date"));
        peopleTableColumn.setCellValueFactory(new PropertyValueFactory<ViewOrders,String>("number_of_seats"));

        //Values set to tableView if there is more than 1 list
        tableView.setItems(list);
    }

    @FXML
    public void viewBookings2(ActionEvent event) throws IOException, JSONException {
       fillTableView();
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

    public void getMovieDescription() throws JSONException, IOException {
        DBRequests dbRequests = new DBRequests();
        MovieSingleton movieSingleton = MovieSingleton.getInstance();
        String movieInfoResult = dbRequests.returnMovieInfo(movieSingleton.getMovieID());
        String VBHR_hotfix = (movieInfoResult.length() >0 ) ? movieInfoResult.substring(1, movieInfoResult.length()-1) : "{}";

        jsonObject = new JSONObject(VBHR_hotfix);
        String descriptionOfMovie = jsonObject.getString("description");
        System.out.println("Movie Description: "+descriptionOfMovie);
        cruella.movieInformation(descriptionOfMovie);
    }

    public void viewCruella(MouseEvent event) throws IOException, JSONException {
        Main m = new Main();
        movieSingleton.setMovieTitle("Cruella");
        movieSingleton.setTime("20:30");
        movieSingleton.setSeatPrice(130);
        movieSingleton.setMovieID(25);
        m.changeScene("cruella.fxml");
        getMovieDescription();
    }

    public void viewKong(MouseEvent event) throws IOException, JSONException {
        Main m = new Main();
        movieSingleton.setMovieTitle("Kong");
        movieSingleton.setTime("13:30");
        movieSingleton.setSeatPrice(150);
        movieSingleton.setMovieID(35);
        m.changeScene("kong.fxml");
        getMovieDescription();
    }

    public void viewSpiral(MouseEvent event) throws IOException, JSONException {
        Main m = new Main();
        movieSingleton.setMovieTitle("Spiral");
        movieSingleton.setTime("15:30");
        movieSingleton.setSeatPrice(120);
        movieSingleton.setMovieID(45);
        m.changeScene("spiral.fxml");
        getMovieDescription();
    }

    public void vievNobody(MouseEvent event) throws IOException, JSONException {
        Main m = new Main();
        movieSingleton.setMovieTitle("Nobody");
        movieSingleton.setTime("17:30");
        movieSingleton.setSeatPrice(120);
        movieSingleton.setMovieID(55);
        m.changeScene("nobody.fxml");
        getMovieDescription();
    }

    public void viewTove(MouseEvent event) throws IOException, JSONException {
        Main m = new Main();
        movieSingleton.setMovieTitle("Tove");
        movieSingleton.setTime("19:30");
        movieSingleton.setSeatPrice(150);
        movieSingleton.setMovieID(65);
        m.changeScene("tove.fxml");
        getMovieDescription();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        movieSingleton = MovieSingleton.getInstance();
        //if the tableview is not null it means that we are currently on the viewBookingPage.fxml
        if (tableView != null){
        try {
            fillTableView();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
           }

    }
}
