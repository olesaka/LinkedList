package project4;

import java.lang.*;
import java.util.*;
import java.io.*;

/**
 * Class encrypts a message
 * 
 * @author Andrew Olesak
 * @version March 29, 2016
 */
public class Mix implements IMix {

	private CharacterList list;
	private ArrayList<String> undoCommands;

	/**
	 * Constructor
	 */
	public Mix() {
		this.list = new CharacterList();
		this.undoCommands = new ArrayList<String>();
	}

	/**
	 * Sets the original message into the linked list of characters
	 * 
	 * @param message
	 *            the original message
	 */
	public void setInitialMessage(String message) {
		for (int i = 0; i < message.length(); i++) {
			Letter c = new Letter(message.charAt(i));
			list.addCharacter(c);
		}
	}

	/**
	 * Reacts to the different commands that get entered
	 * 
	 * @param command
	 *            the command
	 */
	public String processCommand(String command) {
		try {
			String[] str = command.split(" ");
			str[0] = str[0].toLowerCase();
			if (str[0].charAt(0) == 'a') {
				Letter c = new Letter(command.charAt(2));
				int pos = Integer.parseInt(str[2]);
				if (pos < -1) {
					System.out.println("That is not a valid position");
					String m = this.list.getMessage();
					this.printMessage(m);
					return m;
				}
				list.insert(c, pos);
				pos++;
				this.undoCommands.add(0, str[0] + "+" + pos);
			} else if (str[0].charAt(0) == 'r') {
				ArrayList<String> removes = list.delete(command.charAt(2));
				for (int i = 0; i < removes.size(); i++) {
					String s = removes.get(i);
					this.undoCommands.add(i, "i+" + s);
				}
			} else if (str[0].charAt(0) == 'q') {
				System.out.print("The final mixed up message: " + list.getMessage());
				System.exit(0);
			} else if (str[0].charAt(0) == 's') {
				this.saveToFile(str[1]);
			} else if (str[0].charAt(0) == 'p') {
				int pos = Integer.parseInt(str[1]);
				int num = this.list.getMessageLength();
				if (pos > num) {
					pos = num + 1;
				}
				int clipNumber = Integer.parseInt(str[2]);
				String message = this.list.getClipBoard(clipNumber);
				if (message.equals("")) {
					System.out.println("That clipboard doesn't exist");
					String m = this.list.getMessage();
					this.printMessage(m);
					return m;
				}
				Letter c = this.list.createMiniMessage(message);
				int endPos = this.list.insert(c, pos - 1);
				if (endPos == -1) {
					System.out.println("The position was not valid");
					String m = this.list.getMessage();
					this.printMessage(m);
					return m;
				}
				endPos += pos;
				this.undoCommands.add(0, "c+" + pos + "+" + endPos);
			} else if (str[0].charAt(0) == 'c') {
				int startPos = Integer.parseInt(str[1]);
				int endPos = Integer.parseInt(str[2]);
				int clipNumber = Integer.parseInt(str[3]);
				if (startPos > endPos || startPos < 0 && endPos < 0) {
					System.out.println("The starting and ending positions weren't entered correctly");
					String m = this.list.getMessage();
					this.printMessage(m);
					return m;
				}
				if (startPos < 0) {
					startPos = 0;
				}
				Letter c = list.cut(startPos, endPos);
				if (c == null) {
					System.out.println("The starting point was beyond the length of the list");
					String m = this.list.getMessage();
					this.printMessage(m);
					return m;
				}
				NewNode clipBoard = new NewNode(c, clipNumber);
				list.addClipBoard(clipBoard);
				String miniMessage = list.getMiniMessage(c);
				this.undoCommands.add(0, "p+" + startPos + "+" + miniMessage);
			} else {
				System.out.println("Command wasn't entered correcty");
			}
		} catch (Exception e) {
			System.out.println("Command wasn't entered correctly");
		}
		String m = list.getMessage();
		this.printMessage(m);
		return m;
	}

	/**
	 * Saves the undo commands to a text file
	 * 
	 * @param filename
	 *            the name of the file
	 */
	public void saveToFile(String filename) {
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(filename));
			for (String s : this.undoCommands) {
				writer.write(s + "/");
			}
			writer.close();
		} catch (FileNotFoundException error1) {
			System.out.println("Failed to read the data file: " + filename);

			// error while reading the file
		} catch (IOException error2) {
			System.out.println("Oops! Error related to: " + filename);
		}

	}

	/**
	 * Prints the current Message
	 * 
	 * @param message
	 *            the message
	 */
	public void printMessage(String message) {
		System.out.println("Message:");
		for (int i = 0; i < 45; i++) {
			System.out.print(i + " ");
		}
		System.out.println("");
		for (int i = 0; i < message.length(); i++) {
			System.out.print(message.charAt(i) + " ");
		}
		System.out.println("");
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter a message: ");
		String message = scnr.nextLine();
		Mix mix = new Mix();
		System.out.println("");
		mix.setInitialMessage(message);
		mix.printMessage(message);

		// loop that listens for commands

		while (true) {
			System.out.println("\nEnter Command: ");
			String command = scnr.nextLine();
			System.out.println("");
			String str = mix.processCommand(command);
		}
	}
}
