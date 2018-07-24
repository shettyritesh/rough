package mutliply;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestMutiply {

	@Test
	public void testAdd() {
		String ans=LargeMath.add("921", "64470");
		assertEquals("065391", ans);
	}
	@Test
	public void testMutiply() {
		String ans=LargeMath.multiply("921", "71");
		assertEquals("065391", ans);
	}
}
