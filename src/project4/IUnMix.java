package project4;

/**
 * Interface for the UnMix class
 * 
 * @author Andrew Olesak
 * @version April 2, 2016
 */
public interface IUnMix {

	
	/** Use the parameter miedMessage as the string point, that is, the mix message from
	 * the previous step.  The second parameter is the file where the list of undo commands 
	 * is found.  The returned string should be the original message. 
	 */
	String UnMixUsingFile(String filename, String mixedMessage);
}
