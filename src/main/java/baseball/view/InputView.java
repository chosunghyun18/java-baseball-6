package baseball.view;
import baseball.validate.InputValidate;
import camp.nextstep.edu.missionutils.Console;
public class InputView {
    private final InputValidate inputValidate;

    public InputView(){
        inputValidate = new InputValidate();
    }
    public String getPlayerGuessNumbers(){
        return Console.readLine();
    }
}
