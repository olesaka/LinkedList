package project4;

/**
 * Interface for the Mix class
 * 
 * @author Andrew Olesak
 * @version April 2, 2016
 */
public interface IMix {

	/** set the original message into the linked list of characters */
	void setInitialMessage(String message);

	/**
	 * processes the given mix command and returns the current message after
	 * processing the mix command
	 */
	String processCommand(String command);
}
