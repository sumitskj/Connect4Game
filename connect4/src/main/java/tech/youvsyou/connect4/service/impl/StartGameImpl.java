package tech.youvsyou.connect4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.youvsyou.connect4.entity.GameInfo;
import tech.youvsyou.connect4.game.PlayerEnum;
import tech.youvsyou.connect4.repository.GameInfoRepository;
import tech.youvsyou.connect4.service.StartGame;

@Service
public class StartGameImpl implements StartGame {

    @Autowired
    GameInfoRepository gameInfoRepository;

    @Override
    public void begin(String token, String user) {
        GameInfo gameInfo = new GameInfo();
        gameInfo.setGame_id(token);
        String state = new String(new char[42]).replace("\0", "x");
        gameInfo.setGame_state(state);
        gameInfo.setName(user);
        gameInfo.setTurn(PlayerEnum.YELLOW);
        gameInfo.setResult(-1);
        gameInfoRepository.save(gameInfo);
    }
}
