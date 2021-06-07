package sample;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class films {

    public void userLogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("loginPage.fxml");
    }

    public void backButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("welcomePage.fxml");
    }

    public void viewBookings(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("viewBookingPage.fxml");
    }

    public void viewCruella(MouseEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("cruella.fxml");
    }
}
