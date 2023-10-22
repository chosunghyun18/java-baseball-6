package baseball.controller;

import baseball.model.BaseBallGameComputer;
import baseball.model.Hint;
import baseball.model.Player;
import java.util.List;

public class GameController {
    private final OutputController outputController;
    private final InputController inputController;
    private final BaseBallGameComputer computer;

    private GameController() {
        this.outputController = new OutputController();
        this.inputController = new InputController();
        this.computer = new BaseBallGameComputer();
    }

    public static GameController StartBaseballGame() {
        return new GameController();
    }

    public void startNewGame() {
        boolean gameProcess = true;
        while (gameProcess) {
            outputController.showIntroMessage();
            computer.initComputerNumbers();
            playGame();
            outputController.showGameRestartInputMessage();
            gameProcess = inputController.isRestartGame();
        }
    }

    public void playGame() {
        boolean isGameClear = false;
        while (!isGameClear) {
            outputController.showGameInputMessage();
            List<Integer> input = inputController.getPlayerGuessNumber();
            Hint result = Player.swingBat(computer, input);
            isGameClear = outputController.displayHint(result);
        }
    }
}
