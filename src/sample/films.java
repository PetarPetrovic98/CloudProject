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

    public void viewKong(MouseEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("kong.fxml");
    }

    public void viewSpiral(MouseEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("spiral.fxml");
    }

    public void vievNobody(MouseEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("nobody.fxml");
    }

    public void viewTove(MouseEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("tove.fxml");
    }
}
