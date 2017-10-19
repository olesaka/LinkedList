package project4;

import java.util.*;

/**
 * Class makes adjustments to the linked list
 * 
 * @author Andrew Olesak
 * @version March 29, 2016
 */
public class CharacterList {

	private Letter head, tail;
	private NewNode clipBoardHead;

	/**
	 * Constructor sets values to the instance variables
	 */
	public CharacterList() {
		this.head = null;
		this.tail = null;
		this.clipBoardHead = null;
	}

	/**
	 * Adds a character to the end of the linked list
	 * 
	 * @param c
	 *            the character to be added
	 */
	public void addCharacter(Letter c) {
		Letter next = head, prev = head;
		if (next == null) {
			this.head = c;
			return;
		}
		while (next.getNext() != null) {
			prev = next;
			next = next.getNext();
		}
		next.setNext(c);
		c.setPrev(next);
		this.tail = c;
	}

	/**
	 * Inserts a character at a certain position in the linked list
	 * 
	 * @param c
	 *            the character to be added
	 * @param pos
	 *            the position in which the character will be added
	 * @return an integer for the length of the linked list that was added
	 */
	public int insert(Letter c, int pos) {
		Letter next = head, prev = head;
		int counter = 1;
		if (pos < -1) {
			return -1;
		}
		for (int i = -1; i < pos && next != null; i++) {
			prev = next;
			next = next.getNext();
		}
		if (pos < -1) {
			return -1;
		}
		if (pos == -1) {
			this.head = c;
		} else {
			prev.setNext(c);
			c.setPrev(prev);
		}
		while (c.getNext() != null) {
			c = c.getNext();
			counter++;
		}
		if (next != null) {
			c.setNext(next);
			next.setPrev(c);
		} else {
			this.tail = c;
		}
		return counter;
	}

	/**
	 * Removes a character at a given position
	 * 
	 * @param pos
	 *            the position
	 */
	public void remove(int pos) {
		Letter next = head, prev = head;
		for (int i = 0; i < pos && next != null; i++) {
			prev = next;
			next = next.getNext();
		}
		if (pos == 0) {
			this.head = next.getNext();
			this.head.setPrev(null);
		} else if (next == null) {
			prev = prev.getPrev();
			prev.setNext(null);
			this.tail = prev;
		} else if (next.getNext() == null) {
			this.tail = prev;
			this.tail.setNext(null);
		} else {
			prev.setNext(next.getNext());
			next.getNext().setPrev(prev);
		}
	}

	/**
	 * Removes all the occurrences of a character from the linked list
	 * 
	 * @param c
	 *            the character to be removed
	 * @return an arrayList of strings with the character and position
	 */
	public ArrayList<String> delete(char c) {
		Letter next = head, prev = head;
		ArrayList<String> commands = new ArrayList<String>();
		int counter = -1;
		while (next != null) {
			if (next.getLetter() == c) {
				commands.add(c + "+" + counter);
				if (next == this.head) {
					this.head = next.getNext();
					this.head.setPrev(null);
				} else if (next.getNext() == null) {
					this.tail = prev;
					this.tail.setNext(null);
				} else {
					prev.setNext(next.getNext());
					next.getNext().setPrev(prev);
					next = next.getPrev();
				}
			}
			counter++;
			prev = next;
			next = next.getNext();
		}
		return commands;
	}

	/**
	 * Finds the clipBoard and returns the start of its linked list
	 * 
	 * @param pos
	 *            the position of the clipBoard
	 * @return a string of the clipBoard
	 */
	public String getClipBoard(int pos) {
		NewNode next = this.clipBoardHead;
		while (next != null) {
			if (next.getNumber() == pos) {
				Letter c = next.getTop();
				String str = this.getMiniMessage(c);
				return str;
			}
			next = next.getNext();
		}
		return "";
	}

	/**
	 * Adds a clipBoard to the linked list of clipBoards
	 * 
	 * @param clipBoard
	 *            the clipBoard to be added
	 */
	public void addClipBoard(NewNode clipBoard) {
		int clipNumber = clipBoard.getNumber();
		NewNode next = this.clipBoardHead, prev = this.clipBoardHead;
		while (next != null) {
			if (next.getNumber() == clipNumber) {
				if (next == this.clipBoardHead) {
					next = next.getNext();
					this.clipBoardHead = clipBoard;
					this.clipBoardHead.setNext(next);
					return;
				} else if (next.getNext() == null) {
					prev.setNext(clipBoard);
					return;
				} else {
					prev.setNext(clipBoard);
					clipBoard.setNext(next.getNext());
				}
				return;
			}
			prev = next;
			next = next.getNext();
		}
		if (prev == null) {
			this.clipBoardHead = clipBoard;
		} else {
			prev.setNext(clipBoard);
		}
	}

	/**
	 * Cuts a section of the message
	 * 
	 * @param startPos
	 *            the starting position to cut
	 * @param endPos
	 *            the ending position of the cut
	 * @return the starting letter of the cut linked list
	 */
	public Letter cut(int startPos, int endPos) {
		Letter nextStart = this.head, prevStart = this.head, nextEnd = this.head, prevEnd = this.head;
		for (int i = 0; i < startPos && nextStart != null; i++) {
			prevStart = nextStart;
			nextStart = nextStart.getNext();
		}
		if (nextStart == null) {
			return null;
		}
		for (int i = -1; i < endPos && nextEnd != null; i++) {
			prevEnd = nextEnd;
			nextEnd = nextEnd.getNext();
		}
		if (startPos == 0) {
			prevEnd.setNext(null);
			this.head = nextEnd;
			this.head.setPrev(null);
			return nextStart;
		} else if (nextEnd == null) {
			prevStart.setNext(null);
			this.tail = prevStart;
			nextStart.setPrev(null);
			return nextStart;
		} else {
			prevStart.setNext(nextEnd);
			nextEnd.setPrev(prevStart);
			prevEnd.setNext(null);
			return nextStart;
		}
	}

	/**
	 * Creates a mini linked list message
	 * 
	 * @param message
	 *            the message to be linked
	 * @return the starting letter of the linked list
	 */
	public Letter createMiniMessage(String message) {
		Letter start = new Letter(message.charAt(0));
		Letter next = start, prev = start;
		for (int i = 1; i < message.length(); i++) {
			next = new Letter(message.charAt(i));
			prev.setNext(next);
			next.setPrev(prev);
			prev = next;
		}
		return start;
	}

	/**
	 * Method gets the clipBoard message
	 * 
	 * @param c
	 *            the starting letter of the linked list
	 * @return the message for that clipBoard
	 */
	public String getMiniMessage(Letter c) {
		Letter next = c;
		String message = "";
		while (next != null) {
			message += next.getLetter();
			next = next.getNext();
		}
		return message;
	}

	/**
	 * @return the length of the current message
	 */
	public int getMessageLength() {
		Letter next = this.head;
		int counter = -1;
		while (next != null) {
			counter++;
			next = next.getNext();
		}
		return counter;
	}

	/**
	 * @return the current message
	 */
	public String getMessage() {
		Letter next = head;
		String message = "";
		while (next != null) {
			message += next.getLetter();
			next = next.getNext();
		}
		return message;
	}
}
