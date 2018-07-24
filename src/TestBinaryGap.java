import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class TestBinaryGap {

	@Test
	public void testSolution() {
		BinaryGap util= new BinaryGap();
		int ans=util.solution(9);
		Assert.assertEquals(2, ans);
	}
	@Test
	public void testSolution1() {
		BinaryGap util= new BinaryGap();
		int ans=util.solution(16);
		Assert.assertEquals(0, ans);
	}
}
