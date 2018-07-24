import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestMissingPermutation {

	@Test
	public void testSolution() {
		MissingPermutation util= new MissingPermutation();
		int[] A= {1,6};
		int actual=util.solution(A);
		Assert.assertEquals(0, actual);
	}

	@Test
	public void testSolution1() {
		MissingPermutation util= new MissingPermutation();
		int[] A= {1,1};
		int actual=util.solution(A);
		Assert.assertEquals(0, actual);
	}
}
