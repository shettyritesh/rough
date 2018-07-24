package mutliply;

public class LargeMath {

	public static String multiply(String first, String second) {
		String smaller = (first.length() < second.length() ? first : second);
		String bigger = (first.length() > second.length() ? first : second);
		
		int[] smallerintarr = toIntArray(smaller);
		int[] biggerintarr = toIntArray(bigger);
		int tmpMutiplication=0;
		int carry=0;
		int mutiplier=1;
		String[] resultsarr=new String[smallerintarr.length];
		
		for(int j=smallerintarr.length-1;j>=0;j--){
			StringBuffer tmpresult= new StringBuffer();
			for(int i=biggerintarr.length-1;i>=0;i--){
				tmpMutiplication=smallerintarr[j]*biggerintarr[i]+carry;
				int result=(tmpMutiplication%10);
				tmpresult.insert(0,result);
				carry=(tmpMutiplication/10);
				if(i==0){
					tmpresult.insert(0,carry);	
				}
			}
			resultsarr[j]=rightPadWithZeros(tmpresult.toString(),mutiplier);;
			mutiplier=mutiplier*10;
		}
		
		String result = resultsarr[0];
		for(int k=1;k<resultsarr.length;k++){
			result=add(result,resultsarr[k]);
		}
		
		return result;
	}

	private static String rightPadWithZeros(String tmpresult,int pads) {
		int rightpads=(String.valueOf(pads).length()+tmpresult.length()-1)*-1;
		String shifts=(rightpads==0?"":String.valueOf(rightpads));
		return String.format("%"+shifts+"s", tmpresult).replace(' ', '0');

	}

	private static String leftPadWithZeros(String smaller,int pads){
		smaller = String.format("%" + pads + "s", smaller).replace(' ', '0');
		return smaller;
	}
	
	public static String add(String str1, String str2) {
		String smaller = (str1.length() < str2.length() ? str1 : str2);
		String bigger = (str1.length() > str2.length() ? str1 : str2);
		smaller = leftPadWithZeros(smaller,bigger.length());
		int[] smallerintarr = toIntArray(smaller);
		int[] biggerintarr = toIntArray(bigger);
		int carry = 0;
		StringBuffer resullt = new StringBuffer();
		for (int i = biggerintarr.length-1; i >=0 ; i--) {
			int digitrtmp = biggerintarr[i] + smallerintarr[i] + carry;
			int digitresult = digitrtmp % 10;
			resullt.insert(0, digitresult);
			carry = (digitrtmp / 10 > 0 ? 1 : 0);
			if (i == 0) {
				resullt.insert(0, carry);
			}
		}
		return resullt.toString();
	}

	private static int[] toIntArray(String str) {
		char[] chararr = str.toCharArray();
		int[] result = new int[chararr.length];
		int i = 0;
		for (char mychar : chararr) {
			result[i++] = Character.getNumericValue(mychar);
		}
		return result;
	}
}
