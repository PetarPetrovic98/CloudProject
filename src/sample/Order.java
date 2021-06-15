package sample;

import java.util.ArrayList;

public class Order {
    private String timestamp;
    private String booked_date;
    private int movie_id;
    private int user_id;
    private ArrayList<Integer> seats;

    public Order(String timestamp, String bookedDate, int movieID, int userID, ArrayList<Integer> seats) {
        this.timestamp = timestamp;
        this.booked_date = bookedDate;
        this.movie_id = movieID;
        this.user_id = userID;
        this.seats = seats;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBooked_date() {
        return booked_date;
    }

    public void setBooked_date(String booked_date) {
        this.booked_date = booked_date;
    }

    public int getMovieID() {
        return movie_id;
    }

    public void setMovieID(int movieID) {
        this.movie_id = movieID;
    }

    public int getUserID() {
        return user_id;
    }

    public void setUserID(int userID) {
        this.user_id = userID;
    }

    public ArrayList<Integer> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Integer> seats) {
        this.seats = seats;
    }
}
