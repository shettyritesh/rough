
public class PaddingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str=String.format("%-5s","45");
		System.out.println("********"+str+"**********");
		str=String.format("%5s","45");		
		System.out.println("********"+str+"**********");
	}

}
