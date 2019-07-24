package lotto.exception;

import static lotto.model.Number.MAX;
import static lotto.model.Number.MIN;

public class InvalidNumberException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "로또숫자는 %d ~ %d 사이입니다. (입력값: %d)";

    public InvalidNumberException(int inputNumber) {
        super(String.format(ERROR_MESSAGE, MIN, MAX, inputNumber));
    }
}
