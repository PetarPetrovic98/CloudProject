package sample;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class DBRequests {

    //When a client books a movie this method is called
    public void createOrders(Order order) throws IOException {

        // create remote connection
        StringBuilder result = new StringBuilder();
        URL url = new URL("https://murmuring-plateau-65295.herokuapp.com/ordersTest");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        // convert order to json string
        Gson gson = new Gson();
        String data = gson.toJson(order);

        // send data to backend
        try(OutputStream os = conn.getOutputStream()) {
            byte[] input = data.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // receive data from backend
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
    }

    //When a client views the orders this method is called
    public String viewOrders(int user_id) throws IOException {

        StringBuilder result = new StringBuilder();
        URL url = new URL(" https://murmuring-plateau-65295.herokuapp.com/getOrder?user_id="+user_id);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (var reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        return result.toString();
    }

    //To be able to see what seats are booked/free, this method is called
    public String returnFreeSeat(int movie_id, String booked_date) throws IOException {

        StringBuilder result = new StringBuilder();
        URL url = new URL("https://murmuring-plateau-65295.herokuapp.com/occupiedSeats?movie_id="+movie_id+"&booked_date="+booked_date);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (var reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        System.out.println("Före");
        return result.toString();

    }
}
