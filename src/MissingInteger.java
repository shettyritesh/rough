import java.math.BigInteger;

public class MissingInteger {
    public int solution(int[] A) {
        BigInteger sum=BigInteger.valueOf(0);
        if(A.length==0) {
        	return 1;
        }
        for(int item:A) {

        	sum=sum.add(BigInteger.valueOf(item));
        }
        BigInteger a=BigInteger.valueOf(A.length+1);
        BigInteger b=BigInteger.valueOf(A.length+2);
        BigInteger sumofnintegers=a.multiply(b).divide(BigInteger.valueOf(2));
        BigInteger missing =sumofnintegers.subtract(sum);
        return missing.intValue();
    }
}
