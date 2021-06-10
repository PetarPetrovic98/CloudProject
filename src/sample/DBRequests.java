package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DBRequests {

    private void bookRequest(String timestamp, String booked_date, String movie_id, String user_id) throws IOException {

        StringBuilder result = new StringBuilder();
        URL url = new URL("https://murmuring-plateau-65295.herokuapp.com/orders?timestamp=A&booked_date=B&movie_id=C&user_id=D&seats=E");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");

        try (var reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }

        System.out.print(result.toString());

    }

    private void recivedReceiptRequest(String order_id, String movie_id, String booked_date, int people, String seat, String username) throws IOException {

        StringBuilder result = new StringBuilder();
        URL url = new URL("https://murmuring-plateau-65295.herokuapp.com/orders?order_id=A&movie_id=B&booked_date=C&people=D&seats=E&userName=F");

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
