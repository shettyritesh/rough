
public class Inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base b= new Derrived();
		System.out.println(b.getMe().name);
		b= new Base();
		System.out.println(b.getMe().name);
		

	}
	
	

}

class Base{
	public K9 getMe(){
		
		return new K9("K9 Family");
	}
}

class Derrived extends Base{
	public Dog getMe()throws RuntimeException{
		
		return new Dog("Rocky","Boxer");
	}
}


class K9{
	String name;
	public K9(String theName) {
		name=theName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof K9) {
			K9 k=(K9)obj;
			return k.name.equals(name);
		}
		return false;
	}
}

class Dog extends K9{
	String type;
	public Dog(String name, String theType) {
		super(name);
		type=theType;
	}
	
}
