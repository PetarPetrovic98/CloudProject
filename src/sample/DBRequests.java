package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DBRequests {

    //When a client books a movie this method is called
    private void orderRequest(String timestamp, String booked_date, String movie_id, String user_id, int seat) throws IOException {

        StringBuilder result = new StringBuilder();
        URL url = new URL("https://murmuring-plateau-65295.herokuapp.com/orders?timestamp="+timestamp+"&booked_date="+booked_date+"&movie_id="+movie_id+"&user_id="+user_id+"&seats="+user_id);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");

        try (var reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }

        System.out.print(result.toString());

    }

    //When a client views the orders this method is called
    private void orderRequest(int user_id) throws IOException {

        StringBuilder result = new StringBuilder();
        URL url = new URL("https://murmuring-plateau-65295.herokuapp.com/ORDERS?user_id="+user_id);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (var reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }

        System.out.print(result.toString());

        //TODO: Send the variables to the corresponding UI
    }

    //To be able to see what seats are booked/free, this method is called
    private void returnSeatRequest(int movie_id, String booked_date) throws IOException {

        StringBuilder result = new StringBuilder();
        URL url = new URL("https://murmuring-plateau-65295.herokuapp.com/occupiedSeats?movie_id="+movie_id+"&booked_date="+booked_date);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (var reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }

        System.out.print(result.toString());

        //TODO: Send the variables to the corresponding UI
    }
}
