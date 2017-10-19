package project4;

/**
 * Class points to other objects in the linked list
 * 
 * @author Andrew Olesak
 * @version March 29, 2016
 */
public class Letter {

	private char Letter;
	private Letter next;
	private Letter prev;

	/**
	 * Constructors
	 */
	public Letter() {
		this.setAll(' ', null, null);
	}

	public Letter(char l) {
		this.setAll(l, null, null);
	}

	public Letter(char l, Letter h, Letter t) {
		this.setAll(l, h, t);
	}

	/**
	 * Helper method that sets values for the constructor
	 * 
	 * @param l
	 *            a Letter
	 * @param h
	 *            the head that the object points to
	 * @param t
	 *            the tail that the object points to
	 */
	private void setAll(char l, Letter n, Letter p) {
		this.Letter = l;
		this.next = n;
		this.prev = p;
	}

	/**
	 * @return the next Letter in the linked list
	 */
	public Letter getNext() {
		return this.next;
	}

	/**
	 * @return the previous Letter in the the linked list
	 */
	public Letter getPrev() {
		return this.prev;
	}

	/**
	 * @return the current Letter of the current object
	 */
	public char getLetter() {
		return this.Letter;
	}

	/**
	 * Sets the Letter of the current object
	 * 
	 * @param l
	 *            the Letter
	 */
	public void setLetter(char l) {
		this.Letter = l;
	}

	/**
	 * Sets the next letter object
	 * 
	 * @param a
	 *            Letter
	 */
	public void setNext(Letter n) {
		this.next = n;
	}

	/**
	 * Sets the previous object
	 * 
	 * @param a
	 *            the Letter
	 */
	public void setPrev(Letter p) {
		this.prev = p;
	}
}