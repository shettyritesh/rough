import java.util.*;
class SearchUtil{

public boolean search(String pattern, String text){
	Map<Character, Integer> mymap=computeBadMatchTable(pattern);

	if(pattern.length()>text.length()){
		return false;
	}
	for(int i=0;i<text.length();){
		for(int j=pattern.length()-1;j>=0;j--){
			Character patternitem=pattern.charAt(j);
			if((i+j)>(text.length()-1)){
				return false;
			}
			char textitem=text.charAt(i+j);
			if(patternitem!=textitem){
				Integer count=mymap.get(textitem);
				if(count==null){
					count=pattern.length();
				}
				i=i+count;
				break;
			}
			if(j==0){
				return true;
			}
		}
		
	}
	return false;


}

private Map<Character, Integer> computeBadMatchTable(String pattern){
	Map<Character, Integer> mymap= new HashMap<Character, Integer>();
	for(int i=0;i<pattern.length()-1;i++){
		Character item=pattern.charAt(i);
		Integer count=pattern.length()-i-1;
		mymap.put(item,count);
		System.out.format("%c %d",item,count);
		System.out.println();
	
	}
	
	return mymap;

}
public static void main(String args[]) {
	
	SearchUtil util = new SearchUtil();
	boolean ans=util.search("fish", "Where bird is the animal");
	System.out.println("Answer is "+ans);
}
}