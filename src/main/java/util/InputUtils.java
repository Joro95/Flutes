package util;

import org.apache.commons.lang3.math.NumberUtils;

public class InputUtils {

    private InputUtils() {
        //Static class
    }


    public static InputStatus verifyInput(String flutePrices) {
        String[] schuur = flutePrices.split(" ");
        int requiredLength = 0;
        for (int i = 0; i < schuur.length; i++) {
            if (!NumberUtils.isParsable(schuur[i])) {
                return InputStatus.invalid("Input string cannot be parsed to numbers");
            }
            int input = Integer.parseInt(schuur[i]);
            if (input <= 0) {
                return InputStatus.invalid("Negative numbers are not allowed");
            }
            //at position 0 we have the number of flutes in the schuur
            if (i == 0) {
                requiredLength = input;
            }
        }
        if (requiredLength != schuur.length - 1) {
            return InputStatus.invalid("The first number defines how many numbers have to follow it. You have entered a different amount than the defined quantity");
        }
        return InputStatus.valid();
    }

}
