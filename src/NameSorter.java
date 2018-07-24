import java.util.Arrays;
import java.util.Scanner;

public class NameSorter {
	public static void main(String args[]) {
		Scanner scan= new Scanner(System.in);
		System.out.println("How many names");
		int numberofnames= scan.nextInt();
		String[] arr= new String[numberofnames];
		for(int i=0;i<numberofnames;i++) {
			System.out.println("Enter the name");
			String name=scan.next();
			arr[i]=name;
		}
		Arrays.sort(arr);
		for(int i=0;i<numberofnames;i++) {
			System.out.println(arr[i]);
		}
		scan.close();
	}
}
