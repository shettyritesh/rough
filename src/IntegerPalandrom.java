
public class IntegerPalandrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
   public boolean isPalindrome(int x) {
	   if(x<0) {
		   return false;
	   }
	   String strval= String.valueOf(x);
	   String revstring=new StringBuilder(strval).reverse().toString();
	   if(strval.equals(revstring)) {
		   return true;
	   }
	   return false;
    }	

}
