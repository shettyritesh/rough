
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsKnowHow {
	public static void main(String[] args) {
		List<Product> productsList = new ArrayList<Product>();
		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));
		
//		Set<String> productNameSet= productsList.stream().map(x->x.name).collect(Collectors.toSet());
//		System.out.println(productNameSet);
//		List<Float> productPriceList= productsList.stream().map(x->x.price).collect(Collectors.toList());
//		System.out.println(productPriceList);
//		Double sum=productsList.stream().collect(Collectors.summingDouble(x->x.price));
//		System.out.println(sum);
//		Double avg=productsList.stream().collect(Collectors.averagingDouble(x->x.price));
//		System.out.println(avg);
//		productsList.stream().filter(x->x.price>30000).map(xm->xm.price).forEach(System.out::println);
//		
//		productsList.stream().map(x->x.price).forEach(System.out::println);
//		
//		productsList.stream().map(x->x.price).forEach(System.out::println);
//		productsList.parallelStream().map(x->x.name).forEach(System.out::println);
//		
//		Comparator comp= Comparator.comparing(Product::getName);
//		Collections.sort(productsList,comp);
//		System.out.println();
//		productsList.stream().map(x->x.name).forEach(System.out::println);
		List<String> mylist = null;
//		productsList.forEach(x->mylist.add(x.name));
//		mylist.forEach(x->System.out.println(x));
		mylist=productsList.stream().map(x->x.name).collect(Collectors.toList());
		mylist.forEach(x->System.out.println(x));
		
	}
}

class Product {
	int id;
	String name;
	float price;

	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public String getName(){
		return name;
	}
}
