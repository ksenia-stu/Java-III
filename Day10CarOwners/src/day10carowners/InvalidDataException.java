
package day10carowners;

public class InvalidDataException extends Exception {

    public InvalidDataException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public InvalidDataException(String msg) {
        super(msg);
    }

    public InvalidDataException() {
    }

}
