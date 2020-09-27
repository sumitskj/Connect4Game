package tech.youvsyou.connect4.game.request;

public class StartRequest {
    private String username;
    private String message;

    public StartRequest(){

    }

    public StartRequest(String username, String message) {
        this.username = username;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    @Override
    public String toString() {
        return "StartRequest{" +
                "username1='" + username + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
