package b31_l03_exceptions;

@SuppressWarnings("serial")
public class UnSortedArrayException extends RuntimeException {
	public UnSortedArrayException() {
		super();
	}
	
	public UnSortedArrayException( String errMsg ) {
		super( errMsg );
	}
}
