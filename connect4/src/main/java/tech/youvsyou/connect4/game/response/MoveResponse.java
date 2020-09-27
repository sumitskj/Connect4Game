package tech.youvsyou.connect4.game.response;

import tech.youvsyou.connect4.game.PlayerEnum;

public class MoveResponse {
    private String result;
    private PlayerEnum turn;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public PlayerEnum getTurn() {
        return turn;
    }

    public void setTurn(PlayerEnum turn) {
        this.turn = turn;
    }

}
