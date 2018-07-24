import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class TestFrogJumps {

	@Test
	public void testSolution() {
		FrogJump jumputil= new FrogJump();
		int actual=jumputil.solution(10, 85, 30);
		Assert.assertEquals(3, actual);
	}
	@Test
	public void testSolution3() {
		FrogJump jumputil= new FrogJump();
		int actual=jumputil.solution(-10, -85, 30);
		Assert.assertEquals(-3, actual);
	}
}
