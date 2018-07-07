package com.appdevelopment.john.fuelbuyapp.Exceptions;

public class EmptyStringException extends Exception {

}
    public EmptyStringException() {
        super();
    }

    /**
     * A method to pass a exception message to the user
     * @param message
     */
    public EmptyStringException(String message) {
        super(message);
}
