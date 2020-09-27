package tech.youvsyou.connect4.game.request;

import tech.youvsyou.connect4.game.PlayerEnum;

public class MoveRequest {
    private PlayerEnum player;
    private Integer column;
    private String gameId;

    public PlayerEnum getPlayer() {
        return player;
    }

    public void setPlayer(PlayerEnum player) {
        this.player = player;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}
