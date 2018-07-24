import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class SolutionTest {

	@Test
	public void testSolution() {
		Solution1 util= new Solution1();
		int[] A= {1,1,2,3,3};
		boolean actual= util.solution(A, 3);
		Assert.assertEquals(actual, true);
	}
	@Test
	public void testSolution1() {
		Solution1 util= new Solution1();
		int[] A= {1,2,3,3};
		boolean actual= util.solution(A, 3);
		Assert.assertEquals(actual, true);
	}
	
	@Test
	public void testSolution3() {
		Solution1 util= new Solution1();
		int[] A= {1,2,4};
		boolean actual= util.solution(A, 3);
		Assert.assertEquals(actual, false);
	}
	
	@Test
	public void testSolution4() {
		Solution1 util= new Solution1();
		int[] A= {1};
		boolean actual= util.solution(A, 1);
		Assert.assertEquals(actual, true);
	}
	@Test
	public void testSolution5() {
		Solution1 util= new Solution1();
		int[] A= {};
		boolean actual= util.solution(A, 3);
		Assert.assertEquals(actual, false);
	}	
	@Test
	public void testSolution6() {
		Solution1 util= new Solution1();
		int[] A= {1,2,2,3};
		boolean actual= util.solution(A, 4);
		Assert.assertEquals(actual, false);
	}	
	@Test
	public void testSolution7() {
		Solution1 util= new Solution1();
		int[] A= {1,2,3,1000000000};
		boolean actual= util.solution(A, 300000);
		Assert.assertEquals(actual, false);
	}		
}
