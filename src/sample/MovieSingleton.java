package sample;

public class MovieSingleton {

        private static MovieSingleton single_instance = null;
        private int movieID;
        private String movieTitle;
        private String time;

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    // private constructor restricted to this class itself
        private MovieSingleton()
        {
        }

        // static method to create instance of Singleton class
        public static MovieSingleton getInstance()
        {
            if (single_instance == null)
                single_instance = new MovieSingleton();

            return single_instance;
        }

}
