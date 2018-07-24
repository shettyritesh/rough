import static org.junit.Assert.*;

import org.junit.Test;

public class TestRectangleCounter {

	@Test
	public void testPrintRectangleCordinates() {
		
		int[][] arr= {{0,1,1,1,0},{0,1,0,1,0},{0,1,0,1,0},{0,1,1,1,0}};
		
		for(int row=0;row<arr.length;row++){
			for(int col=0;col<arr[0].length;col++){
				System.out.print(arr[row][col]+" ");
			}
		System.out.println();	
		}		
		System.out.println();
		RectagleCounter counter= new RectagleCounter(arr);
		counter.printRectangleCordinates();
	}

}
