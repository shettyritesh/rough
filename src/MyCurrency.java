import java.util.Currency;
import java.util.Set;

public class MyCurrency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		BigDecimal a = new BigDecimal(2.0);
//		BigDecimal b = new BigDecimal(2.0);
//		
//		System.out.println(1/2.0);
//		
//		List<List<String>> list= new ArrayList<List<String>>();
//		List<String> mylist= new ArrayList<String>();
//		mylist.add("AA");
//		mylist.add("BB");
//		mylist.add("CC");
//		list.add(mylist);
//		String[] mylist1= {"AAA","BBB"};
		Currency curr= Currency.getInstance("GBP");
		System.out.println(curr.getSymbol());
		System.out.println(curr.getNumericCode());
		Set<Currency>  all=Currency.getAvailableCurrencies();
		for(Currency item:all) {
			System.out.println(item.getSymbol());
		}
	}

}
