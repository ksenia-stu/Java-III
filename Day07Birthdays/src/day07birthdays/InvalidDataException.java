
package day07birthdays;


//InvalidDataException inherits from RuntimeException which is unchecked (compiler will not require us to handle it)
public class InvalidDataException extends RuntimeException {
	public InvalidDataException(String msg, Throwable cause) {
		super(msg, cause);
	}
        //in most of the cases just this one will be used
	public InvalidDataException(String msg) {
		super(msg);
	}
	public InvalidDataException() {
	}
}