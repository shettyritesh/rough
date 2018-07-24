
public class LambdaKnowhow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmailUtil util =(String company, String firstname, String lastname)->firstname+"."+lastname+"@"+company+".com";
		System.out.println(util.getEmail("hpe", "ritesh", "shetty"));
	}

}

@FunctionalInterface
interface EmailUtil{
	
	String getEmail(String company, String firstname, String lastname);

}