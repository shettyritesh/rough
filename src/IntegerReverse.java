class IntegerReverse {
    public int reverse(int x) {
    	
    	if (x==Integer.MIN_VALUE) {
    		return 0;
    	}
        String str=String.valueOf(Math.abs(x));
        StringBuilder sb= new StringBuilder(str);
        int a=(x<0?-1:1);
        long i=Long.parseLong(sb.reverse().toString());
        if(i>Integer.MAX_VALUE) {
        	return 0;
        }
        return (int)i*a;
    }
    public static void main(String args[]) {
    	IntegerReverse s= new IntegerReverse();
    	//s.reverse(9646324351);
    	s.reverse(-2147483648);
    }
}