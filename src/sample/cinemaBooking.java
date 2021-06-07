package sample;

import javafx.event.ActionEvent;

import java.io.IOException;

public class cinemaBooking {

    public void userLogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("loginPage.fxml");
    }

    public void backButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("filmsPage.fxml");
    }

}
