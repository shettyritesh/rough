import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class TestMissingInteger {

	@Test
	public void testSolution() {
		MissingInteger missingutil= new MissingInteger();
		int[] A= {2,3,1,5};
		int actual=missingutil.solution(A);
		Assert.assertEquals(4, actual);
	}
	@Test
	public void testSolution1() {
		MissingInteger missingutil= new MissingInteger();
		int[] A= {1};
		int actual=missingutil.solution(A);
		Assert.assertEquals(2, actual);
	}
	@Test
	public void testSolution3() {
		MissingInteger missingutil= new MissingInteger();
		int[] A= {};
		int actual=missingutil.solution(A);
		Assert.assertEquals(1, actual);
	}	
}
