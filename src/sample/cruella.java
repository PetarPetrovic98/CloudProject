package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class cruella {
    JSONObject jsonObject;

    @FXML
    private Label infoLabel;


    public void userLogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("loginPage.fxml");
    }

    public void backButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("filmsPage.fxml");
    }

    public void bookNow(ActionEvent event) throws IOException, JSONException {
        Main m = new Main();
        MovieSingleton movieSingleton = MovieSingleton.getInstance();
        movieSingleton.setMovieTitle(movieSingleton.getMovieTitle());
        movieSingleton.setTime(movieSingleton.getTime());
        m.changeScene("cinemaBookingView.fxml");
    }
    public void movieInformation(String text){
       infoLabel.setText(text);
    }

    /*

    public void displayText() throws IOException, JSONException {
        DBRequests dbRequests = new DBRequests();
        MovieSingleton movieSingleton = MovieSingleton.getInstance();
        String movieInfoResult = dbRequests.returnMovieInfo(movieSingleton.getMovieID());
        String VBHR_hotfix = (movieInfoResult.length() >0 ) ? movieInfoResult.substring(1, movieInfoResult.length()-1) : "{}";

        jsonObject = new JSONObject(VBHR_hotfix);
        String descriptionOfMovie = jsonObject.getString("description");
        System.out.println("Movie Description: "+descriptionOfMovie);

    }

     */
}
