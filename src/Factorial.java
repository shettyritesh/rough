import java.math.BigInteger;

public class Factorial {

	public static void main(String[] args) {
		// Lets do (M+N)!/(M! * N!)
		//Choose 5 steps right and 1 steps down means (5+1)!/5!*1! 
		int rows=3;
		int cols=2;
		BigInteger totalDividedByRowSteps=BigInteger.valueOf(1);
		for(int i=(rows+cols-1-1);i>(rows-1);i--) {
			totalDividedByRowSteps=totalDividedByRowSteps.multiply(BigInteger.valueOf(i));
		}
		for(int i=(cols-1);i>0;i--) {
			totalDividedByRowSteps=totalDividedByRowSteps.divide(BigInteger.valueOf(i));
		}
		System.out.println(totalDividedByRowSteps.intValue());
	}

}
