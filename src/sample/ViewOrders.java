package sample;

public class ViewOrders {

    private String order_id = null;
    private String movieTitle = null;
    String booked_date = null;
    String number_of_seats = null;

    public ViewOrders() {
    }

    public ViewOrders(String order_id, String movieTitle, String booked_date, String number_of_seats) {
        this.order_id = order_id;
        this.movieTitle = movieTitle;
        this.booked_date = booked_date;
        this.number_of_seats = number_of_seats;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getBooked_date() {
        return booked_date;
    }

    public void setBooked_date(String booked_date) {
        this.booked_date = booked_date;
    }
    public String getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(String number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

}
