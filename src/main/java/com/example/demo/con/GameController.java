package com.example.demo.con;

import com.example.demo.domain.GameState;
import com.example.demo.dto.GameStateDto;
import com.example.demo.service.GameService;
import org.springframework.web.bind.annotation.*;

/**
 * 사용자의 요청을 받는 Controller 클래스.
 *
 * @author chan
 */
@RestController
@RequestMapping("/api")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/state")
    public GameStateDto getState() {
        return gameService.getGameState();
    }

    @PostMapping("/move")
    public GameStateDto move(@RequestParam String direction) {
        return gameService.move(direction);
    }

    @PostMapping("/restart")
    public GameStateDto restart() {
        gameService.resetGame();
        return gameService.getGameState();
    }

    @PostMapping("/reset")
    public void resetGame() {
        gameService.resetGame();
    }
}
