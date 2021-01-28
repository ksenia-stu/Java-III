
package day05travellers;

//InvalidDataException inherits from Exception which is checked (compiler will require us to handle it)
public class InvalidDataException extends Exception {
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
