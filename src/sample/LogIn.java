package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LogIn {

    public LogIn() {

    }
    @FXML
    private Button submitButton;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;


    public void userLogIn(ActionEvent event) throws IOException {
        login();
    }

    private void login() throws IOException{
        StringBuilder result = new StringBuilder();
        URL url = new URL("https://murmuring-plateau-65295.herokuapp.com/login?username=" + username.getText() + "&password=" + password.getText());

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (var reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
                System.out.println(result);
            }
        }catch (IOException e){
            if (username.getText().isEmpty() || password.getText().isEmpty())
                wrongLogIn.setText("Please enter your data.");
            else
                wrongLogIn.setText("Wrong username or password!");

            return;
        }

        Main m = new Main();
        m.changeScene("welcomePage.fxml");
    }
}
