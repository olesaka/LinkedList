package project4;

import org.junit.Assert;
import org.junit.Test;

public class Proj4Test {
 
	@Test
	public void basic() {
		Mix m=new Mix();
		m.setInitialMessage("this is a test");
		String message = m.processCommand("a r 3");
		Assert.assertEquals("thisr is a test", message);
		message = m.processCommand("r i");
		Assert.assertEquals("thsr s a test", message);
	}

	@Test
	public void mixAndUn() {
		Mix m=new Mix();
		m.setInitialMessage("roses are red");
		String message = m.processCommand("a x 0");
		Assert.assertEquals("rxoses are red",message);
		message = m.processCommand("a x 10");
		Assert.assertEquals("rxoses are xred",message);
		message = m.processCommand("a x 20");
		Assert.assertEquals("rxoses are xredx",message);
		message = m.processCommand("r e");
		Assert.assertEquals("rxoss ar xrdx",message);
		String mixMessage = m.processCommand("s unCmd.txt");
		UnMix u=new UnMix();
		String finalMessage = u.UnMixUsingFile("unCmd.txt", mixMessage);
		Assert.assertEquals("roses are red", finalMessage);
	}

	@Test
	public void clipboard() {
		Mix m=new Mix();
		m.setInitialMessage("violets are blue");
		String message = m.processCommand("c 8 10 0");
		Assert.assertEquals("violets  blue",message);
		message = m.processCommand("p 3 0");
		Assert.assertEquals("vioarelets  blue",message);
		String mixMessage = m.processCommand("s unCmd.txt");
		UnMix u=new UnMix();
		String finalMessage = u.UnMixUsingFile("unCmd.txt", mixMessage);
		Assert.assertEquals("violets are blue",finalMessage);
	}

	@Test
	public void clipboard2() {
		Mix m=new Mix();
		m.setInitialMessage("I am a schizophrenic");
		String message = m.processCommand("c 2 3 0");
		Assert.assertEquals("I  a schizophrenic",message);
		message = m.processCommand("c 1 3 1");
		Assert.assertEquals("I schizophrenic",message);
		message = m.processCommand("p 3 0");
		Assert.assertEquals("I samchizophrenic",message);
		message = m.processCommand("p 2 1");
		Assert.assertEquals("I   asamchizophrenic",message);
		String mixMessage = m.processCommand("s unCmd.txt");
		UnMix u=new UnMix();
		String finalMessage = u.UnMixUsingFile("unCmd.txt", mixMessage);
		Assert.assertEquals("I am a schizophrenic",finalMessage);
	}

	@Test
	public void clipboard3() {
		Mix m=new Mix();
		m.setInitialMessage("and so am I");
		String message = m.processCommand("c 0 3 10");
		Assert.assertEquals("so am I",message);
		message = m.processCommand("p 6 10");
		Assert.assertEquals("so am and I",message);
		message = m.processCommand("s unCmd.txt");
		UnMix u=new UnMix();
		String finalMessage = u.UnMixUsingFile("unCmd.txt", message);
		Assert.assertEquals("and so am I",finalMessage);
	}

	@Test
	public void clipboard4() {
		Mix m=new Mix();
		m.setInitialMessage("and so am I");
		String message = m.processCommand("c 7 10 5");
		Assert.assertEquals("and so ",message);
		message = m.processCommand("p 0 5");
		Assert.assertEquals("am Iand so ",message);
		message = m.processCommand("s unCmd.txt");
		UnMix u=new UnMix();
		String finalMessage = u.UnMixUsingFile("unCmd.txt", message);
		Assert.assertEquals("and so am I",finalMessage);
	}

//cut to end
//paste to start
}

