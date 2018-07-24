import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class TestSolution {

	@Test
	public void testSolution() {
		SmallestPositveInteger a= new SmallestPositveInteger();
		int[] A= {1, 3, 6, 4, 1, 2};
		int ans= a.solution(A);
		Assert.assertEquals(5, ans);
	}
	@Test
	public void testSolution1() {
		SmallestPositveInteger a= new SmallestPositveInteger();
		int[] A= {0};
		int ans= a.solution(A);
		Assert.assertEquals(1, ans);
	}
	
	@Test
	public void testSolution2() {
		SmallestPositveInteger a= new SmallestPositveInteger();
		int[] A= {-1,1, 3, 6, 4, 1, 2};
		int ans= a.solution(A);
		Assert.assertEquals(5, ans);
	}
	
	@Test
	public void testSolution3() {
		SmallestPositveInteger a= new SmallestPositveInteger();
		int[] A= {100,102,103,104,200};
		int ans= a.solution(A);
		Assert.assertEquals(1, ans);
	}	
	
	
}
