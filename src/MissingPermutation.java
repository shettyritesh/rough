import java.util.HashMap;
import java.util.Map;

public class MissingPermutation {
    public int solution(int[] A) {
        if(A.length==0) {
        	return 0;
        }
        Map<Integer,Integer> mapofindex= new HashMap<Integer,Integer>();
        
        for(int i=0;i<A.length;i++) {
        	mapofindex.put(A[i], i);

        }
        
        for(int i=A.length;i>0;i--) {
        	Integer item=mapofindex.get(i);
        	if(item==null) {
        		return 0;
        	}
        }
        return 1;
        
    }
    
    
}
