package tech.youvsyou.connect4.game.request;

public class RegisterRequest {
    String username;
    String password;
    String emailId;

    public String getEmailId() {
        return emailId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
