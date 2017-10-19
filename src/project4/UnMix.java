package project4;

import java.io.*;
import java.util.*;

/**
 * Class decrypts a message
 * 
 * @author Andrew Olesak
 * @version March 29, 2016
 */
public class UnMix implements IUnMix {

	private CharacterList list;
	private Mix mix;

	/**
	 * Constructor sets values to instance variables
	 */
	public UnMix() {
		this.list = new CharacterList();
		this.mix = new Mix();
	}

	/**
	 * Reads a file and uses it to unmix the given message
	 * 
	 * @param filename
	 *            the name of the file that contains the unmix commands
	 * @param mixedMessage
	 *            the mixed up message to be unmixed
	 * @return the unmixed message
	 */
	public String UnMixUsingFile(String filename, String mixedMessage) {

		for (int i = 0; i < mixedMessage.length(); i++) {
			Letter c = new Letter(mixedMessage.charAt(i));
			list.addCharacter(c);
		}
		Scanner inFS = null;
		FileInputStream fileByteStream = null;

		try {
			// open the File and set delimiters
			fileByteStream = new FileInputStream(filename);
			inFS = new Scanner(fileByteStream);
			inFS.useDelimiter("/");

			// continue while there is more data to read
			while (inFS.hasNext()) {

				String command = inFS.next();
				String[] str = command.split("\\+");
				if (str[0].equals("a")) {
					int pos = Integer.parseInt(str[1]);
					list.remove(pos);
				}
				if (str[0].equals("i")) {
					Letter c = new Letter(str[1].charAt(0));
					int pos = Integer.parseInt(str[2]);
					list.insert(c, pos);
				}
				if (str[0].equals("p")) {
					 int pos = Integer.parseInt(str[1]);
					 String message = str[2];
					 Letter c = list.createMiniMessage(message);
					 list.insert(c, pos-1);
				}
				if (str[0].equals("c")) {
					 int startPos = Integer.parseInt(str[1]);
					 int endPos = Integer.parseInt(str[2]);
					 Letter c = list.cut(startPos, endPos-1);
				}
			}
			fileByteStream.close();

			// Could not find file
		} catch (FileNotFoundException error1) {
			System.out.println("Failed to read the data file: " + filename);

			// error while reading the file
		} catch (IOException error2) {
			System.out.println("Oops! Error related to: " + filename);
		}
		String m = list.getMessage();
		return m;
	}

	/**
	 * Main Method
	 */
	public static void main(String[] args) {
		UnMix unMix = new UnMix();
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter the encrypted message: ");
		String message = scnr.nextLine();
		System.out.println("\nEnter the filename: ");
		String fileName = scnr.nextLine();
		String finalMessage = unMix.UnMixUsingFile(fileName, message);
		System.out.println("\nThe final message is: ");
		System.out.print(finalMessage);
	}

}
