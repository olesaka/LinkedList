package project4;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for the Mix class
 * 
 * @author Andrew Olesak
 * @version April 13, 2016
 */
public class MixTest {

	private Mix mix;

	/**
	 * Constructor
	 */
	public MixTest() {
		this.mix = new Mix();
	}

	@Test
	public void testProcessCommand1() {
		this.mix.setInitialMessage("This is a secret message");
		String message = this.mix.processCommand("a a 0");
		assertEquals("Tahis is a secret message", message);
	}

	@Test
	public void testProcessCommand2() {
		this.mix.setInitialMessage("This is a secret message");
		this.mix.processCommand("a z 0");
		this.mix.processCommand("r s");
		this.mix.processCommand("a p 11");
		this.mix.processCommand("r e");
		String message = this.mix.processCommand("a z 0");
		assertEquals("Tzzhi i a crpt mag", message);
	}

	@Test
	public void testProcessCommand3() {
		this.mix.setInitialMessage("Welcome racecar drivers");
		this.mix.processCommand("a t 40");
		this.mix.processCommand("r z");
		this.mix.processCommand("a a -1");
		String message = this.mix.processCommand("r  ");
		assertEquals("aWelcomeracecardriverst", message);
	}

	@Test
	public void testProcessCommand4() {
		this.mix.setInitialMessage("Training for a marathon");
		String message = this.mix.processCommand("c 3 6 1");
		assertEquals("Trag for a marathon", message);
	}

	@Test
	public void testProcessCommand5() {
		this.mix.setInitialMessage("hello");
		String message = this.mix.processCommand("a f -1");
		assertEquals("fhello", message);
		message = this.mix.processCommand("a d -5");
		assertEquals("fhello", message);
		message = this.mix.processCommand("a p 0");
		assertEquals("fphello", message);
		message = this.mix.processCommand("a f 6");
		assertEquals("fphellof", message);
		message = this.mix.processCommand("a d 16");
		assertEquals("fphellofd", message);
	}

	@Test
	public void testProcessCommand6() {
		this.mix.setInitialMessage("secret message");
		String message = this.mix.processCommand("r s");
		assertEquals("ecret meage", message);
		message = this.mix.processCommand("r z");
		assertEquals("ecret meage", message);
		message = this.mix.processCommand("r e");
		assertEquals("crt mag", message);
	}

	@Test
	public void testProcessCommand7() {
		this.mix.setInitialMessage("This is a secret message");
		String message = this.mix.processCommand("c 3 8 1");
		assertEquals("Thi secret message", message);
		message = this.mix.processCommand("c 0 3 2");
		assertEquals("secret message", message);
		message = this.mix.processCommand("c 10 13 3");
		assertEquals("secret mes", message);
		message = this.mix.processCommand("c -1 1 4");
		assertEquals("cret mes", message);
		message = this.mix.processCommand("c 5 12 5");
		assertEquals("cret ", message);
		message = this.mix.processCommand("c 25 30 7");
		assertEquals("cret ", message);
	}

	@Test
	public void testProcessCommand8() {
		this.mix.setInitialMessage("This is indeed a very secret message");
		this.mix.processCommand("c 22 27 1");
		this.mix.processCommand("c 3 8 2");
		String message = this.mix.processCommand("p 5 2");
		assertEquals("Thinds is ieed a very  message", message);
		message = this.mix.processCommand("p 29 1");
		assertEquals("Thinds is ieed a very  messagsecrete", message);
		message = this.mix.processCommand("p -1 1");
		assertEquals("Thinds is ieed a very  messagsecrete", message);
		message = this.mix.processCommand("p 40 1");
		assertEquals("Thinds is ieed a very  messagsecretesecret", message);
	}

	@Test
	public void testProcessCommand9() {
		this.mix.setInitialMessage("This is a secret message");
		this.mix.processCommand("c 5 9 1");
		this.mix.processCommand("c 12 15 2");
		this.mix.processCommand("p 3 1");
		String message = this.mix.processCommand("p 5 3");
		assertEquals("Thiis a s secret age", message);
		this.mix.processCommand("c 12 14 1");
		message = this.mix.processCommand("p 7 1");
		assertEquals("Thiis acre s set age", message);
	}

	@Test
	public void testProcessCommand10() {
		this.mix.setInitialMessage("This is a secret message");
		this.mix.processCommand("c 7 9 1");
		this.mix.processCommand("a a 6");
		this.mix.processCommand("p 18 1");
		this.mix.processCommand("c 0 4 2");
		this.mix.processCommand("r e");
		this.mix.processCommand("a e 0");
		this.mix.processCommand("p 2 2");
		String message = this.mix.processCommand("p 4 2");
		assertEquals("ieThThis is sascrt ms a sag", message);
	}

	@Test
	public void testProcessCommand11() {
		this.mix.setInitialMessage("Collegiate Waterskiing is fun");
		this.mix.processCommand("r a");
		this.mix.processCommand("c 24 30 1");
		this.mix.processCommand("p 0 1");
		this.mix.processCommand("a z 50");
		this.mix.processCommand("a x -1");
		this.mix.processCommand("a p -2");
		this.mix.processCommand("c 3 7 2");
		this.mix.processCommand("p 0 2");
		String message = this.mix.processCommand("p -1 2");
		assertEquals("nCollxfuegite Wterskiing is z", message);
	}

	@Test
	public void testProcessCommand12() {
		this.mix.setInitialMessage("Collegiate Waterskiing is fun");
		this.mix.processCommand("c 3 10 1");
		this.mix.processCommand("c 8 13 1");
		this.mix.processCommand("p 11 1");
		String message = this.mix.processCommand("p 0 1");
		assertEquals("skiingColWater isskiing fun", message);
	}

	@Test
	public void testProcessCommand13() {
		this.mix.setInitialMessage("Waterskiing");
		this.mix.processCommand("c 2 4 1");
		this.mix.processCommand("p 5 1");
		this.mix.processCommand("c 7 10 1");
		this.mix.processCommand("p 1 1");
		this.mix.processCommand("c 4 6 1");
		String message = this.mix.processCommand("p 9 1");
		assertEquals("Wrinkitegas", message);
	}

	@Test
	public void testProcessCommand14() {
		this.mix.setInitialMessage("This message is long but whatever");
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
		String message = this.mix.processCommand("p 8 2");
		assertEquals("Thisng bvr is ng but wut w mzsThis saglohat", message);
	}

	@Test
	public void testProcessCommand15() {
		this.mix.setInitialMessage("This message should be perfect");
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
		String message = this.mix.processCommand("p 0 2");
		assertEquals("Thi m perpagd b fec houlThi m", message);
	}
}
