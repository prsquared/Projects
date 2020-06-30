package tictactoe.enums;

public enum ValidationStatus {
    VALID("", true),
    INVALID_INPUT("You should enter numbers!", false),
    OUT_OF_BOUNDS("Coordinates should be from 1 to 3!", false),
    SQUARE_OCCUPIED("This cell is occupied! Choose another one!", false);

    private String error;
    private boolean valid;

    ValidationStatus(String error, boolean valid) {
        this.error = error;
        this.valid = valid;
    }

    public String getError() {
        return this.error;
    }

    public boolean isValid() {
        return valid;
    }
}
