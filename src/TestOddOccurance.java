import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class TestOddOccurance {

	@Test
	public void testSolution() {
		OddOccurance occur= new OddOccurance();
		int[] arr= {91,3,9,3,91,7,9};
		int actual=occur.solution(arr);
		Assert.assertEquals(7, actual);
	}
	@Test
	public void testSolution1() {
		OddOccurance occur= new OddOccurance();
		int[] arr= {5,6,7,0,5,6,7};
		int actual=occur.solution(arr);
		Assert.assertEquals(0, actual);
	}
	
	@Test
	public void testSolution2() {
		OddOccurance occur= new OddOccurance();
		int[] arr= {5,6,7,3,5,6,7,5,6,7,5,6,7};
		int actual=occur.solution(arr);
		Assert.assertEquals(3, actual);
	}	
}
