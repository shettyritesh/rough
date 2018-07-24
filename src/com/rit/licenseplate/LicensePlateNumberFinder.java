package com.rit.licenseplate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
class LicensePlateNumberFinder{
	private Map<Integer,String> dictTable= new HashMap<Integer,String>();
	private Map<String,Set<Integer>> occurrances= new HashMap<String,Set<Integer>>();
	
	//{"CAR","CARS","HELP"}
	//{}
	//{"","","CAR","MAN","AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"}
	public void addDictionaries(Set<String> allstrings){
		Set<String> dics=new TreeSet<String>(Comparator.comparing(String::length));
		dics.addAll(allstrings);
		Integer count=dictTable.size();
		for(String str:dics) {
			dictTable.put(++count,str);
			for(int i=0;i<str.length();i++){
				String item=str.substring(i,i+1);
				Set<Integer> collections= occurrances.get(item);
				if(collections==null){
					collections=new HashSet<Integer>();
					occurrances.put(item,collections);
				}
				collections.add(count);
			}
		}
		System.out.println();

	}

	//"LC45"
	public String getString(String str){
		if(str==null){
			return null;
		}
		Set<Integer> ansSet= null;
		for(int i=0;i<str.length();i++){

			String item=str.substring(i,i+1);
			if(!item.chars().allMatch(Character::isLetter)){
				continue;	
			}
			Set<Integer> cocs=occurrances.get(item);
			if(cocs!=null) {
				if(ansSet==null) {
					ansSet=cocs;
				}
				else {
					ansSet.retainAll(cocs);
				}
			}
		}
		//Set<String> finalstr= new TreeSet<String>(Comparator.comparing(String::length));
		//for(Integer item:ansSet){
			//finalstr.add(dictTable.get(item));
		//}
		Iterator<Integer> iter= ansSet.iterator();
		if(iter.hasNext()) {
			Integer finalindex=iter.next ();
			return dictTable.get(finalindex);
		}
		return "";
		

	}

}