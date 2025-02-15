package adts.queue;

/**
 * Thrown when there is an attempt to access the front
 * of an empty queue.
 */
@SuppressWarnings("serial")
public class EmptyQueueException extends RuntimeException {

  public EmptyQueueException() {
    super();
  }

  public EmptyQueueException( String errMsg ) {
    super( " " + errMsg );
  }
}
