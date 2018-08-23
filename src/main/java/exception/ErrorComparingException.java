package exception;

public class ErrorComparingException extends Exception {
    public ErrorComparingException(String message) {
        super( message );
    }

    public ErrorComparingException(String message, Throwable cause) {
        super( message, cause );
    }
}
