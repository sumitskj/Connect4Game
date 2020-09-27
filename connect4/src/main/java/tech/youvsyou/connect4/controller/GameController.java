package tech.youvsyou.connect4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.youvsyou.connect4.entity.GameInfo;
import tech.youvsyou.connect4.exceptions.CustomException;
import tech.youvsyou.connect4.game.request.MoveRequest;
import tech.youvsyou.connect4.game.request.StartRequest;
import tech.youvsyou.connect4.game.response.GetMovesResponse;
import tech.youvsyou.connect4.game.response.MoveResponse;
import tech.youvsyou.connect4.game.response.StartResponse;
import tech.youvsyou.connect4.service.MakeMove;
import tech.youvsyou.connect4.service.StartGame;
import tech.youvsyou.connect4.service.TokenGeneratorService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/connect4/")
public class GameController {

    @Autowired
    MakeMove mMove;

    @Autowired
    StartGame startGame;

    @Autowired
    TokenGeneratorService tokenGeneratorService;

    @PostMapping(value = "/start")
    public ResponseEntity<StartResponse> startGame(@RequestBody StartRequest startRequest) throws CustomException {
        String token = tokenGeneratorService.getToken();
        startGame.begin(token, startRequest.getUsername());
        if(startRequest.getMessage()!=null && startRequest.getMessage().equals("START")) {
            StartResponse startResponse = new StartResponse("READY", token, "YELLOW Player turn");
            return new ResponseEntity<>(startResponse, HttpStatus.OK);
        }
        throw new CustomException("Bad Request", HttpStatus.BAD_REQUEST, "Request body does not have START message.");
    }

    @PostMapping(value = "/game/move")
    public ResponseEntity<MoveResponse> makeMove(@RequestBody MoveRequest moveRequest) throws CustomException{
        GameInfo gameInfo = mMove.doMove(moveRequest.getColumn(), moveRequest.getGameId(), moveRequest.getPlayer());
        MoveResponse moveResponse = new MoveResponse();
        moveResponse.setResult(gameInfo.getResult()==-1 ? "No winner" : (gameInfo.getResult()==0 ? "YELLOW is winner" : "RED is winner"));
        moveResponse.setTurn(gameInfo.getTurn());
        return new ResponseEntity<>(moveResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/game/move")
    public ResponseEntity<GetMovesResponse> getMoves(@RequestParam String gameId) throws CustomException{
        GameInfo gameInfo = mMove.getMoves(gameId);
        if(gameInfo!=null) {
            GetMovesResponse getMovesResponse = new GetMovesResponse(gameInfo.getPlayer1(), gameInfo.getPlayer2());
            return new ResponseEntity<>(getMovesResponse, HttpStatus.OK);
        }
        throw new CustomException("User unauthorised.", HttpStatus.UNAUTHORIZED, "Please enter a valid gameId.");
    }

}
