
public interface Arithmetic<E> {
	/**
	 * ARithmetric interface for the types Rational. Complex, and Generic Matrix
	 * @param item fraction, complex number, or matrix to be operated on
	 * @return no return type for these abstract methods
	 */
	public E add(E item);
	public E subtract(E item);
	public E multiply(E item);
	public E divide(E item);
}
