import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String,Integer> mapofmax= new HashMap<String,Integer>();
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        
        int count=0;
        int i=0;
        int j=0;
        int prevmax=Integer.MIN_VALUE;
        while( i<A.length){
        		
                int max=max=Math.max(prevmax, j);        
                if(max>=L && max<=R){
                  count++;                
                  j++;
                  if(j>=A.length){
                      i++;j=i;
                      prevmax=Integer.MIN_VALUE;
                  }
                }
                else if(max>R){
                    i++;
                    prevmax=Integer.MIN_VALUE;
                    j=i;
                }
                else{
                    j++;
                  if(j>=A.length){
                      i++;j=i;
                      prevmax=Integer.MIN_VALUE;
                  }

                }
            
        }
        return count;
    }
}