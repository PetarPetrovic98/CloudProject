package sample;

public class UserSingleton {

    private static UserSingleton single_instance = null;
    private String username;
    private int user_id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    // private constructor restricted to this class itself
    public UserSingleton()
    {
    }

    // static method to create instance of Singleton class
    public static UserSingleton getInstance()
    {
        if (single_instance == null)
            single_instance = new UserSingleton();

        return single_instance;
    }
}
