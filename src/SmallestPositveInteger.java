import java.util.HashSet;

class SmallestPositveInteger {
	public int solution(int[] A) {
		if (A.length == 0) {
			return 1;
		}
		HashSet<Integer> myset= new HashSet<Integer>();
		int smallest=Integer.MAX_VALUE;
		for(int item:A) {
			if(item>=0) {
				myset.add(item);
			}
			smallest=Math.min(smallest, item);
			smallest=Math.max(smallest, 0);
		}
		if(smallest>1 ) {
			return 1;
		}
		int i=0;
		for(;i<A.length;i++) {
			if(!myset.contains(++smallest)) {
				if(smallest==0) {
					continue;
				}
				break;
			}
		}
		if(smallest<=0) {
			return 1;
		}
		if(i==A.length) {
			return ++smallest;
		}
		return smallest;
	}
	
}