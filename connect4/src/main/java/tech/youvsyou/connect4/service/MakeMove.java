package tech.youvsyou.connect4.service;

import tech.youvsyou.connect4.entity.GameInfo;
import tech.youvsyou.connect4.exceptions.CustomException;
import tech.youvsyou.connect4.game.PlayerEnum;

public interface MakeMove {
    GameInfo doMove(Integer column, String gameId, PlayerEnum player) throws CustomException;
    GameInfo getMoves(String gameId) throws CustomException;
}
