
public class BinaryGap {

    public int solution(int N) {
    	Integer n=N;
        int shifts=0;
        int maxBinaGap=0;
        boolean firstskip=true;
        while(shifts<=32) {
        	if (Integer.lowestOneBit(n)==0) {
        		break;
        	}
	    	if((n&1)>0) {
	        	n=n>>1;
	        	shifts++;
	        	firstskip=false;
	        }
	    	else
	    	{
	    		int zeros=Integer.numberOfTrailingZeros(n);
	    		n=n>>zeros;
	    		shifts=shifts+zeros;
	    		
	    		if(firstskip) {
	    			firstskip=false;
	    			continue;
	    		}
	    		maxBinaGap=Math.max(zeros, maxBinaGap);
	    	}
        }
        return maxBinaGap;
    }
}
