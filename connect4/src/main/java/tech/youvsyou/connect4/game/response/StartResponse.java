package tech.youvsyou.connect4.game.response;

public class StartResponse {
    String status;
    String token;
    String turn;

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public StartResponse(){

    }

    public StartResponse(String status, String token, String turn) {
        this.status = status;
        this.token = token;
        this.turn = turn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "StartResponse{" +
                "status='" + status + '\'' +
                ", token='" + token + '\'' +
                ", turn='" + turn + '\'' +
                '}';
    }
}
