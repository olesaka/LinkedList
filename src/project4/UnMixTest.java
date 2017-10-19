package project4;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for the UnMix Class
 * 
 * @author Andrew Olesak
 * @Version April 13, 2016
 */
public class UnMixTest {

	private Mix mix;
	private UnMix unMix;

	/**
	 * Constructor
	 */
	public UnMixTest() {
		this.mix = new Mix();
		this.unMix = new UnMix();
	}

	@Test
	public void testUnMix1() {
		String origMessage = "This is a secret message";
		this.mix.setInitialMessage(origMessage);
		this.mix.processCommand("a a 0");
		String message = this.mix.processCommand("s undo.txt");
		String finalMessage = this.unMix.UnMixUsingFile("undo.txt", message);
		assertEquals(finalMessage, origMessage);
	}

	@Test
	public void testUnMix2() {
		String origMessage = "This is a secret message";
		this.mix.setInitialMessage(origMessage);
		this.mix.processCommand("a z 0");
		this.mix.processCommand("r s");
		this.mix.processCommand("a p 11");
		this.mix.processCommand("r e");
		this.mix.processCommand("a z 0");
		String message = this.mix.processCommand("s undo.txt");
		String finalMessage = this.unMix.UnMixUsingFile("undo.txt", message);
		assertEquals(finalMessage, origMessage);
	}

	@Test
	public void testUnMix3() {
		String origMessage = "Welcome racecar drivers";
		this.mix.setInitialMessage(origMessage);
		this.mix.processCommand("a t 40");
		this.mix.processCommand("r z");
		this.mix.processCommand("a a -1");
		this.mix.processCommand("r  ");
		String message = this.mix.processCommand("s undo.txt");
		String finalMessage = this.unMix.UnMixUsingFile("undo.txt", message);
		assertEquals(finalMessage, origMessage);
	}

	@Test
	public void testUnMix4() {
		String origMessage = "Training for a marathon";
		this.mix.setInitialMessage(origMessage);
		this.mix.processCommand("c 3 6 1");
		String message = this.mix.processCommand("s undo.txt");
		String finalMessage = this.unMix.UnMixUsingFile("undo.txt", message);
		assertEquals(finalMessage, origMessage);
	}

	@Test
	public void testUnMix5() {
		String origMessage = "hello";
		this.mix.setInitialMessage(origMessage);
		this.mix.processCommand("a f -1");
		this.mix.processCommand("a d -5");
		this.mix.processCommand("a p 0");
		this.mix.processCommand("a f 6");
		this.mix.processCommand("a d 16");
		String message = this.mix.processCommand("s undo.txt");
		String finalMessage = this.unMix.UnMixUsingFile("undo.txt", message);
		assertEquals(finalMessage, origMessage);
	}

	@Test
	public void testUnMix6() {
		String origMessage = "secret message";
		this.mix.setInitialMessage(origMessage);
		this.mix.processCommand("r s");
		this.mix.processCommand("r z");
		this.mix.processCommand("r e");
		String message = this.mix.processCommand("s undo.txt");
		String finalMessage = this.unMix.UnMixUsingFile("undo.txt", message);
		assertEquals(finalMessage, origMessage);
	}

	@Test
	public void testUnMix7() {
		String origMessage = "This is a secret message";
		this.mix.setInitialMessage(origMessage);
		this.mix.processCommand("c 3 8 1");
		this.mix.processCommand("c 0 3 2");
		this.mix.processCommand("c 10 13 3");
		this.mix.processCommand("c -1 1 4");
		this.mix.processCommand("c 5 12 5");
		this.mix.processCommand("c 25 30 7");
		String message = this.mix.processCommand("s undo.txt");
		String finalMessage = this.unMix.UnMixUsingFile("undo.txt", message);
		assertEquals(finalMessage, origMessage);
	}

	@Test
	public void testUnMix8() {
		String origMessage = "This is indeed a very secret message";
		this.mix.setInitialMessage(origMessage);
		this.mix.processCommand("c 22 27 1");
		this.mix.processCommand("c 3 8 2");
		this.mix.processCommand("p 5 2");
		this.mix.processCommand("p 29 1");
		this.mix.processCommand("p -1 1");
		this.mix.processCommand("p 40 1");
		String message = this.mix.processCommand("s undo.txt");
		String finalMessage = this.unMix.UnMixUsingFile("undo.txt", message);
		assertEquals(finalMessage, origMessage);
	}

	@Test
	public void testUnMix9() {
		String origMessage = "This is a secret message";
		this.mix.setInitialMessage(origMessage);
		this.mix.processCommand("c 5 9 1");
		this.mix.processCommand("c 12 15 2");
		this.mix.processCommand("p 3 1");
		this.mix.processCommand("p 5 3");
		this.mix.processCommand("c 12 14 1");
		this.mix.processCommand("p 7 1");
		String message = this.mix.processCommand("s undo.txt");
		String finalMessage = this.unMix.UnMixUsingFile("undo.txt", message);
		assertEquals(finalMessage, origMessage);
	}

	@Test
	public void testUnMix10() {
		String origMessage = "This is a secret message";
		this.mix.setInitialMessage(origMessage);
		this.mix.processCommand("c 7 9 1");
		this.mix.processCommand("a a 6");
		this.mix.processCommand("p 18 1");
		this.mix.processCommand("c 0 4 2");
		this.mix.processCommand("r e");
		this.mix.processCommand("a e 0");
		this.mix.processCommand("p 2 2");
		this.mix.processCommand("p 4 2");
		String message = this.mix.processCommand("s undo.txt");
		String finalMessage = this.unMix.UnMixUsingFile("undo.txt", message);
		assertEquals(finalMessage, origMessage);
	}

	@Test
	public void testUnMix11() {
		String origMessage = "Collegiate Waterskiing is fun";
		this.mix.setInitialMessage(origMessage);
		this.mix.processCommand("r a");
		this.mix.processCommand("c 24 30 1");
		this.mix.processCommand("p 0 1");
		this.mix.processCommand("a z 50");
		this.mix.processCommand("a x -1");
		this.mix.processCommand("a p -2");
		this.mix.processCommand("c 3 7 2");
		this.mix.processCommand("p 0 2");
		this.mix.processCommand("p -1 2");
		String message = this.mix.processCommand("s undo.txt");
		String finalMessage = this.unMix.UnMixUsingFile("undo.txt", message);
		assertEquals(finalMessage, origMessage);
	}

	@Test
	public void testUnMix12() {
		String origMessage = "Collegiate Waterskiing is fun";
		this.mix.setInitialMessage(origMessage);
		this.mix.processCommand("c 3 10 1");
		this.mix.processCommand("c 8 13 1");
		this.mix.processCommand("p 11 1");
		this.mix.processCommand("p 0 1");
		String message = this.mix.processCommand("s undo.txt");
		String finalMessage = this.unMix.UnMixUsingFile("undo.txt", message);
		assertEquals(finalMessage, origMessage);
	}

	@Test
	public void testUnMix13() {
		String origMessage = "Waterskiing";
		this.mix.setInitialMessage("Waterskiing");
		this.mix.processCommand("c 2 4 1");
		this.mix.processCommand("p 5 1");
		this.mix.processCommand("c 7 10 1");
		this.mix.processCommand("p 1 1");
		this.mix.processCommand("c 4 6 1");
		this.mix.processCommand("p 9 1");
		String message = this.mix.processCommand("s undo.txt");
		String finalMessage = this.unMix.UnMixUsingFile("undo.txt", message);
		assertEquals(finalMessage, origMessage);
	}

	@Test
	public void testUnMix14() {
		String origMessage = "This message is long but whatever";
		this.mix.setInitialMessage(origMessage);
		this.mix.processCommand("c 12 15 1");
		this.mix.processCommand("a z 5");
		this.mix.processCommand("r e");
		this.mix.processCommand("c -2 4 2");
		this.mix.processCommand("p 50 1");
		this.mix.processCommand("p 3 2");
		this.mix.processCommand("c 13 20 1");
		this.mix.processCommand("p 100 1");
		this.mix.processCommand("p 0 2");
		this.mix.processCommand("p 4 1");
		this.mix.processCommand("c 29 50 2");
		this.mix.processCommand("p 8 2");
		String message = this.mix.processCommand("s undo.txt");
		String finalMessage = this.unMix.UnMixUsingFile("undo.txt", message);
		assertEquals(finalMessage, origMessage);
	}

	@Test
	public void testUnMix15() {
		String origMessage = "This message should be perfect";
		this.mix.setInitialMessage(origMessage);
		this.mix.processCommand("c 22 40 1");
		this.mix.processCommand("r s");
		this.mix.processCommand("p 6 1");
		this.mix.processCommand("c -2 4 2");
		this.mix.processCommand("a z 7");
		this.mix.processCommand("r e");
		this.mix.processCommand("p 9 1");
		this.mix.processCommand("c 22 30 1");
		this.mix.processCommand("c 2 5 3");
		this.mix.processCommand("a t 11");
		this.mix.processCommand("p 19 2");
		this.mix.processCommand("c 6 8 3");
		this.mix.processCommand("p 1 3");
		this.mix.processCommand("r t");
		this.mix.processCommand("p 7 1");
		this.mix.processCommand("p 0 2");
		String message = this.mix.processCommand("s undo.txt");
		String finalMessage = this.unMix.UnMixUsingFile("undo.txt", message);
		assertEquals(finalMessage, origMessage);
	}
}
