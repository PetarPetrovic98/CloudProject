package sample;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class filmsBookings implements Initializable {
    @FXML
    private Label userNameLabel;
    UserSingleton userSingleton;

    JSONArray jsonArray;
    ObservableList<ViewOrders> list = FXCollections.observableArrayList();
    cruella cruella = new cruella();

    String orderID;
    String movieTitle;
    String booked_date;
    String number_of_seats;
    String fetchUserName;

    @FXML
    private Button viewBookings;

    @FXML
    private Button viewFilmButton;

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
        viewFilmButton.setDisable(true);
        Main m = new Main();
         m.changeScene("viewBookingPage.fxml");

    }

    public void fillTableView() throws JSONException, IOException, ParseException {
        viewBookings.setDisable(true);

        UserSingleton userSingleton = UserSingleton.getInstance();

        //get user_id so we can get values from the current logged in user
        int userId = userSingleton.getUser_id();

        DBRequests viewBookingRequest = new DBRequests();
        String viewBookingInfoResult = viewBookingRequest.viewOrders(userId);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        //Fetching values from the JSON file
        jsonArray = new JSONArray(viewBookingInfoResult);


        for (int i = 0; i < jsonArray.length(); i++){
            System.out.println("Orders of user id: "+userId+" is following "+jsonArray.get(i));

            JSONObject json_obj = jsonArray.getJSONObject(i);

            orderID = String.valueOf(json_obj.getInt("Order ID"));
            movieTitle = json_obj.getString("Title");
            booked_date = json_obj.getString("Date");
            number_of_seats = String.valueOf(json_obj.getInt("Seats"));

            Date date = format.parse(booked_date);

            System.out.println("------------------------------");
            System.out.println("ID: " + orderID);
            System.out.println("Title: " + movieTitle);
            System.out.println("Date: " + format.format(date));
            System.out.println("Seat: " + number_of_seats);

/*

            for (int k = i+1; k < jsonArray.length(); k++){
                JSONObject checkJsonObj = jsonArray.getJSONObject(k);
                String checkOrderID = String.valueOf(checkJsonObj.getInt("Order ID"));

                if (orderID.equals(checkOrderID)){
                    System.out.println("THERE IS MORE THAN ONE ORDER ID: "+ checkOrderID);

                    //Displaying the fetched values on UI
                    orderIdTableColumn.setCellValueFactory(new PropertyValueFactory<ViewOrders,String>("order_id"));
                    movieTableColumn.setCellValueFactory(new PropertyValueFactory<ViewOrders,String>("movieTitle"));
                    dateTableColumn.setCellValueFactory(new PropertyValueFactory<ViewOrders,String>("booked_date"));
                    peopleTableColumn.setCellValueFactory(cellData -> Bindings.createStringBinding(() -> cellData.getValue().getNumber_of_seats()+ ", " + cellData.getValue().getNumber_of_seats()));
                }else {

                    //Displaying the fetched values on UI
                    orderIdTableColumn.setCellValueFactory(new PropertyValueFactory<ViewOrders,String>("order_id"));
                    movieTableColumn.setCellValueFactory(new PropertyValueFactory<ViewOrders,String>("movieTitle"));
                    dateTableColumn.setCellValueFactory(new PropertyValueFactory<ViewOrders,String>("booked_date"));
                    peopleTableColumn.setCellValueFactory(new PropertyValueFactory<ViewOrders,String>("number_of_seats"));
                }

            }
*/
            System.out.println("------------------------------");

            list.add(new ViewOrders(orderID,movieTitle,format.format(date),number_of_seats));

            //Displaying the fetched values on UI
            orderIdTableColumn.setCellValueFactory(new PropertyValueFactory<ViewOrders,String>("order_id"));
            movieTableColumn.setCellValueFactory(new PropertyValueFactory<ViewOrders,String>("movieTitle"));
            dateTableColumn.setCellValueFactory(new PropertyValueFactory<ViewOrders,String>("booked_date"));
            peopleTableColumn.setCellValueFactory(new PropertyValueFactory<ViewOrders,String>("number_of_seats"));

        }
        //peopleTableColumn.setCellValueFactory(cellData -> Bindings.createStringBinding(() -> cellData.getValue().getNumber_of_seats()+ ", " + cellData.getValue().getNumber_of_seats()));

        //Values set to tableView if there is more than 1 list
        tableView.setItems(list);

    }

    @FXML
    public void viewBookings2(ActionEvent event) throws IOException, JSONException, ParseException {
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
        UserSingleton userSingleton = UserSingleton.getInstance();
        String userName = userSingleton.getUsername();
        userNameLabel.setText("Current user: "+userName);
    }
/*
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

 */

    public void viewCruella(MouseEvent event) throws IOException, JSONException {
        //Main m = new Main();
        movieSingleton.setMovieTitle("Cruella");
        movieSingleton.setTime("20:30");
        movieSingleton.setSeatPrice(130);
        movieSingleton.setMovieID(25);
        Main.getStage().setScene(Main.creatScene("cruella.fxml"));
                //.changeScene("cruella.fxml");
    }

    public void viewKong(MouseEvent event) throws IOException, JSONException {
        Main m = new Main();
        movieSingleton.setMovieTitle("Kong");
        movieSingleton.setTime("13:30");
        movieSingleton.setSeatPrice(150);
        movieSingleton.setMovieID(35);
        m.changeScene("kong.fxml");
    }

    public void viewSpiral(MouseEvent event) throws IOException, JSONException {
        Main m = new Main();
        movieSingleton.setMovieTitle("Spiral");
        movieSingleton.setTime("15:30");
        movieSingleton.setSeatPrice(120);
        movieSingleton.setMovieID(45);
        m.changeScene("spiral.fxml");
    }

    public void vievNobody(MouseEvent event) throws IOException, JSONException {
        Main m = new Main();
        movieSingleton.setMovieTitle("Nobody");
        movieSingleton.setTime("17:30");
        movieSingleton.setSeatPrice(120);
        movieSingleton.setMovieID(55);
        m.changeScene("nobody.fxml");
    }

    public void viewTove(MouseEvent event) throws IOException, JSONException {
        Main m = new Main();
        movieSingleton.setMovieTitle("Tove");
        movieSingleton.setTime("19:30");
        movieSingleton.setSeatPrice(150);
        movieSingleton.setMovieID(65);
        m.changeScene("tove.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userSingleton = UserSingleton.getInstance();
        fetchUserName = userSingleton.getUsername();
        String name = fetchUserName.substring(0, 1).toUpperCase() + fetchUserName.substring(1);
        userNameLabel.setText("Current user: "+name);

        movieSingleton = MovieSingleton.getInstance();
        //if the tableview is not null it means that we are currently on the viewBookingPage.fxml
        if (tableView != null){
        try {
            fillTableView();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        }

    }
}
