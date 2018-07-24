import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class DoubleColonComparator {

	public static void main(String[] args) {

		
		Comparator comparator=Comparator.comparing(Textbook::getId);
		List<Textbook> list= new ArrayList<Textbook>();
		Textbook book1=new Textbook(5,"A Amazing book");
		Textbook book2=new Textbook(1,"Beware of the book");
		list.add(book1);
		list.add(book2);
		Collections.sort(list,comparator);
		
		for(Textbook book:list) {
			System.out.println(book.getId() +" "+book.getName());
		}

		comparator=Comparator.comparing(Textbook::getName);
		Collections.sort(list,comparator);
		
		for(Textbook book:list) {
			System.out.println(book.getId() +" "+book.getName());
		}
		

	}

}

class Textbook{
	public Textbook(int no, String thename){
		name=thename;
		id=no;
	}
	int id;
	String name;
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
		
	} 
}
