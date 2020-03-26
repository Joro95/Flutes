package util;

public class InputStatus {

    private boolean isValid;
    private String errorMessage;

    private InputStatus(boolean isValid, String errorMessage) {
        this.isValid = isValid;
        this.errorMessage = errorMessage;
    }

    public static InputStatus valid() {
        return new InputStatus(true, "");
    }

    public static InputStatus invalid(String message) {
        return new InputStatus(false, message);
    }

    public boolean isValid() {
        return isValid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
