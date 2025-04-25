package src.user;

public abstract class BaseUser {
    protected String username;
    protected String password;

    public BaseUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public abstract void displayMenu();
}
