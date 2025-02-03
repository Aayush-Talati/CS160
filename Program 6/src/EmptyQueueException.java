public class EmptyQueueException extends Exception {
    public EmptyQueueException() {
        super("Illegal operation on an empty queue.");
    }

    public EmptyQueueException(String message) {
        super(message);
    }
}
