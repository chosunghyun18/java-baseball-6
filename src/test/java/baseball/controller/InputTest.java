package baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest extends NsTest {
    @Test
    @DisplayName("플레이어의 3자리 수를 화면에서 입력받는다.")
    public void inputThreeNumberTest(){
        String inputNumbers = "123";
        InputController inputController = new InputController();

        run(inputNumbers);
        List<Integer> targetNumbers = Arrays.asList(1,2,3);

        assertThat(inputController.getPlayerGuessNumber()).isEqualTo(targetNumbers);
    }
    @Test
    @DisplayName("플레이어의 4자리 수를 화면에서 입력받는다.")
    public void inputFourNumberTest(){
        String inputNumbers = "1234";
        InputController inputController = new InputController();
        run(inputNumbers);
        assertThatThrownBy(inputController::getPlayerGuessNumber).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("플레이어의 문자열 apple을 화면에서 입력받는다.")
    public void inputThreeNumberViewTest(){
        String inputNumbers = "apple";
        run(inputNumbers);
        assertThatThrownBy(InputView::getPlayerRestartNumber).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("플레이어의 숫자 1234을 화면에서 입력받는다.")
    public void inputFourNumbersViewTest(){
        String inputNumbers = "1234";
        run(inputNumbers);
        List<Integer> targetNumbers = Arrays.stream(inputNumbers.split("")).map(Integer::parseInt).toList();
        assertThat(InputView.getPlayerRestartNumber()).isEqualTo(targetNumbers);
    }
    @Test
    @DisplayName("플레이어가 1 자리의 수를 화면에 입력한다.")
    public void inputSingleNumberViewTest(){
        String inputNumber = "1";
        run(inputNumber);
        assertThat(InputView.getPlayerRestartNumber()).isEqualTo(1);
    }
    @Test
    @DisplayName("플레이어의 1 자리의 입력수를 화면에서 받는다.")
    public void inputSingleNumberControllerTest(){

    }
    @Override
    protected void runMain() {

    }
}
