
public class MyInteger {
	public int atoi(String str) {
		str=str.trim();
		int multi=1;
		if(str==null || "".equals(str)) {
			return 0;
		}
		if(str.startsWith("-")) {
			multi=-1;
			str=str.substring(1);
		}
		else if(str.startsWith("+")) {
			str=str.substring(1);
		}
		if(str.length()==0) {
			return 0;
		}
		long result=0;
		final String regex="[0-9]+";
		if(!str.matches(regex)) {
			return 0;
		}
		for(int i=str.length()-1;i>=0;i--) {
			int ans=Character.getNumericValue(str.charAt(i));
			
			result=result+ans*(int)Math.pow(10, ((str.length()-1)-i));
			if(multi==1) {
				if(result>Integer.MAX_VALUE) {
					return 0;
				}
			}
			else {
				if(result*multi<Integer.MIN_VALUE) {
					return 0;
				}

			}
			
		}
		return (int)result*multi;
	}
	public static void main(String args[]) {
		
		String str=String.valueOf(Integer.MIN_VALUE);
		//String regex="\\d+";
		MyInteger myint= new MyInteger();
		System.out.println(myint.atoi(str));
		//System.out.println(str.matches(regex));
		
	}
}
