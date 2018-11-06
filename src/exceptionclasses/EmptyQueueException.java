package exceptionclasses;

/**
 * <p>Title: The EmptyQueueException Class</p>
 *
 * <p>Description: This class defines user-defined exception.</p>
 *
 * @author Hamin Choi
 */
public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException(String m) {
        super(m);
    }
}
