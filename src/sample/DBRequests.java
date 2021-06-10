package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DBRequests {

    private static void connectToCloudBackend() throws IOException
    {
        System.out.println("Cloud backend");

        StringBuilder result = new StringBuilder();
        URL url = new URL("https://murmuring-plateau-65295.herokuapp.com/orders?timestamp=x&booked_date=z&movie_id=y&user_id=p");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");

        try (var reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }

        System.out.print(result.toString());
    }
}
