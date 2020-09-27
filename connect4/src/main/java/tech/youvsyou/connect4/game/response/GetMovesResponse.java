package tech.youvsyou.connect4.game.response;

public class GetMovesResponse {
    private String Yellow_player;
    private String Red_player;

    public GetMovesResponse(String Yellow_player, String Red_player) {
        this.Yellow_player = Yellow_player;
        this.Red_player = Red_player;
    }

    public String getRed_player() {
        return Red_player;
    }

    public void setRed_player(String red_player) {
        this.Red_player = red_player;
    }

    public String getYellow_player() {
        return Yellow_player;
    }

    public void setYellow_player(String yellow_player) {
        this.Yellow_player = yellow_player;
    }
}
