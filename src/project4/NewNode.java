package project4;

/**
 * Class is a node for a linked list that points to other linked lists
 * 
 * @author Andrew Olesak
 * @version April 13, 2016
 */
public class NewNode {

	private Letter top;
	private int clipNumber;
	private NewNode next;

	/**
	 * Constructors
	 */
	public NewNode(Letter l, int num) {
		this.setAll(l, num, null);
	}

	public NewNode(Letter l, int num, NewNode n) {
		this.setAll(l, num, n);
	}

	/**
	 * Sets all the values for the instance variables
	 * @param l the Letter
	 * @param num the number of the clipBoard
	 * @param n the clipBoard that the current ClipBoard will point to
	 */
	private void setAll(Letter l, int num, NewNode n) {
		this.top = l;
		this.clipNumber = num;
		this.next = n;
	}

	/**
	 * Gets the next clipBoard
	 * 
	 * @return the next node
	 */
	public NewNode getNext() {
		return this.next;
	}

	/**
	 * Sets the next clipBoard
	 * 
	 * @param next
	 *            the next node
	 */
	public void setNext(NewNode next) {
		this.next = next;
	}

	/**
	 * @return the clipBoard number
	 */
	public int getNumber() {
		return this.clipNumber;
	}

	/**
	 * @return the Letter that the clipBoard points to
	 */
	public Letter getTop() {
		return this.top;
	}
}
