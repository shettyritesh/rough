import java.util.Arrays;

public class OddOccurance {

	    public int solution(int[] A) {
	    	int ans=0;
	    	for(int i=0;i<A.length;i++) {
	    		ans=ans^A[i];
	    	}
	    	return ans;
	    }
}
