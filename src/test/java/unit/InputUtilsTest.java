package unit;

import org.junit.Test;
import util.InputStatus;
import util.InputUtils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputUtilsTest {

    @Test
    public void verifyValidInputTest() {
        String input = "3 1 2 3";
        InputStatus status = InputUtils.verifyInput(input);
        assertTrue(status.isValid());
    }

    @Test
    public void verifyWrongLengthInputTest() {
        String input = "3 1 2 3 5 8";
        InputStatus status = InputUtils.verifyInput(input);
        assertFalse(status.isValid());
    }

    @Test
    public void verifyInvalidCharacterInputTest() {
        String input = "3 1 2 h";
        InputStatus status = InputUtils.verifyInput(input);
        assertFalse(status.isValid());
    }

    @Test
    public void verifyInvalidFormatInputTest() {
        String input = "dfhdfhsdv  asdfw";
        InputStatus status = InputUtils.verifyInput(input);
        assertFalse(status.isValid());
    }

    @Test
    public void verifyNegativeNumberInputTest() {
        String input = "3 1 -2 3";
        InputStatus status = InputUtils.verifyInput(input);
        assertFalse(status.isValid());
    }

}
