package tech.youvsyou.connect4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tech.youvsyou.connect4.entity.GameInfo;
import tech.youvsyou.connect4.exceptions.CustomException;
import tech.youvsyou.connect4.game.PlayerEnum;
import tech.youvsyou.connect4.repository.GameInfoRepository;
import tech.youvsyou.connect4.service.MakeMove;

import java.util.Optional;

@Service
public class MakeMoveImpl implements MakeMove {

    @Autowired
    private GameInfoRepository gameInfoRepository;

    static char[][] board = new char[6][7];

    @Override
    public GameInfo doMove(Integer column, String gameId, PlayerEnum player) throws CustomException {
        Integer playerNum = player.ordinal();
        String state = validateGame(gameId, playerNum);
        if(column<1 || column>7)
            throw new CustomException("Invalid move.", HttpStatus.BAD_REQUEST, "Select a correct column.\n You can only enter in columns from 1 to 7.");
        int cnt=0;
        for(int i=0;i<7;i++){
            for(int j=0;j<6;j++){
                board[j][i]=state.charAt(cnt);
                cnt++;
            }
        }
        if(board[0][column-1] != 'x'){
            throw new CustomException("Invalid move.", HttpStatus.BAD_REQUEST, "The column is filled completely. Choose other column.");
        }
        int pos =(column)*6;
        for(int i=5;i>=0;i--){
            if(board[i][column-1] == 'x'){
                board[i][column-1]=String.valueOf(playerNum).charAt(0);
                break;
            }
            pos--;
        }

        StringBuilder newState = new StringBuilder(state);
        newState.setCharAt(pos-1, String.valueOf(playerNum).charAt(0));

        boolean reaction = checkMove(String.valueOf(playerNum).charAt(0), (pos%6)-1, column-1);
        GameInfo gameInfo = gameInfoRepository.findById(gameId).get();
        if(reaction){
            gameInfo.setResult(playerNum);
        }
        if(player==PlayerEnum.YELLOW){
            String playerMove = gameInfo.getPlayer1();
            gameInfo.setPlayer1(playerMove+column.toString()+" ");
        }else{
            String playerMove = gameInfo.getPlayer2();
            gameInfo.setPlayer2(playerMove+column.toString()+" ");
        }
        gameInfo.setGame_state(newState.toString());
        gameInfo.setTurn(playerNum==1?PlayerEnum.YELLOW:PlayerEnum.RED);
        gameInfoRepository.save(gameInfo);
        return gameInfo;
    }

    @Override
    public GameInfo getMoves(String gameId) throws CustomException {
        return gameInfoRepository.findById(gameId).orElseGet(null);
    }

    private boolean checkMove(char type, int row, int col){
        return checkLine(type,row,col,0,1)+1+checkLine(type,row,col,0,-1)>=4
                || checkLine(type,row,col,1,0)+1+checkLine(type,row,col,-1,0)>=4
                || checkLine(type,row,col,1,1)+1+checkLine(type,row,col,-1,-1)>=4
                || checkLine(type,row,col,-1,1)+1+checkLine(type,row,col,1,-1)>=4;
    }

    private int checkLine(char type, int x, int y, int dx, int dy){
        int count=0;
        x+=dx;
        y+=dy;
        while(x>=0 && x<6 && y>=0 && y<7 && board[x][y]==type){
            count++;
            x+=dx;
            y+=dy;
        }
        return count;
    }
    private String validateGame(String gameId, Integer player) throws CustomException{
        Optional<GameInfo> gameInfo = gameInfoRepository.findById(gameId);
        if(gameInfo.isPresent()) {
            GameInfo game = gameInfo.get();
            if (game.getResult() != -1) {
                throw new CustomException("Invalid Move", HttpStatus.BAD_REQUEST, "Game already finished.");
            }
            if (game.getTurn().ordinal() != player) {
                throw new CustomException("Invalid Move.", HttpStatus.BAD_REQUEST, "Its not your turn.");
            }
            return game.getGame_state();
        }
        throw new CustomException("User unauthorised.", HttpStatus.UNAUTHORIZED, "Please enter a valid gameId.");
    }

}
