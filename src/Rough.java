import java.util.ArrayList;
import java.util.List;

public class Rough {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rough r = new Rough();
	///	List<Integer> list = r.grayCode(4);
		int spaces=15;
		System.out.println(String.format("*%"+spaces+"s*"," "));
		 //list.forEach(item->System.out.println(item));

	}

	public List<Integer> grayCode(int n) {
		int i = 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		i = 1 << n;
		for (int j = 0; j < i; j++) {
			int res=j ^ (j >> 1);
			System.out.println(Integer.toBinaryString(res));
			list.add(res);
			
		}
		return list;
	}
}
