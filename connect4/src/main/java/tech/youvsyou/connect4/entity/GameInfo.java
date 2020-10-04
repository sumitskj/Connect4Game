package tech.youvsyou.connect4.entity;

import tech.youvsyou.connect4.game.PlayerEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "game_info")
public class GameInfo implements Serializable {
    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "game_id")
    private String game_id;

    @Column(name = "turn")
    private PlayerEnum turn;

    @Column(name = "game_state")
    private String game_state;

    @Column(name = "result")
    private Integer result;

    @Column(name  = "player1")
    private String player1;

    @Column(name = "player2")
    private String player2;

    public String getPlayer1() {
        return player1;
    }

    public GameInfo() {
        this.player1 = "";
        this.player2 = "";
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public PlayerEnum getTurn() {
        return turn;
    }

    public void setTurn(PlayerEnum turn) {
        this.turn = turn;
    }

    public String getGame_state() {
        return game_state;
    }

    public void setGame_state(String game_state) {
        this.game_state = game_state;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
