package com.rit.synonym;
import java.util.*;

class Statement{
	private Map<String,String> mapofsyn= new HashMap<String,String>();
	//{"wonderfull,awesome,fabulous"} {wheather, climate,atmosphere} {love, like, adore}
	public void addSynonymList(Set<String> synlist){
		if(synlist==null || synlist.size()==0){
			return;
		}
		LinkedHashSet<String> sortedSet=new LinkedHashSet<String>();
		for(String item:synlist){
			sortedSet.add(item.toLowerCase());
		}
		int i=0;
		String first=null;
		for(String str:sortedSet){
			if(i==0) {
				first=str;
				i++;
			}
			mapofsyn.put(str,first);
		}
	}
	//"I like this wheather"  "I love this climate"
	//"I like the wheather"  " I love the climate "

	
	public boolean checkIfSimilar(String firstline, String secondline){
		
		if(firstline==null  || secondline==null){
			return false;
		}
		String first=firstline.trim();
		first=first.toLowerCase();
		String second=secondline.trim();
		second=second.toLowerCase();
		
		String[] firstarr=first.split(" ");
		String[] secondarr=second.split(" ");
		if (firstarr.length!=secondarr.length){
			return false;
		}
		
		for(int i=0;i<firstarr.length;i++){
			String firstmatch=(mapofsyn.get(firstarr[i])==null?firstarr[i]:mapofsyn.get(firstarr[i]));
			String secondmatch=(mapofsyn.get(secondarr[i])==null?secondarr[i]:mapofsyn.get(secondarr[i]));
			if(!firstmatch.equals(secondmatch)){
				return false;
			}
		}
		return true;
	
	}
	
	public static void main(String args[]){
	
		Statement stmt= new Statement();
		Set<String> set= new HashSet<String>();
		set.add("wonderfull");
		set.add("awesome");
		set.add("fabulous");
		stmt.addSynonymList(set);

		set= new HashSet<String>();
		set.add("wheather");
		set.add("climate");
		set.add("atmosphere");		
		stmt.addSynonymList(set);


		set= new HashSet<String>();
		set.add("love");
		set.add("like");
		set.add("adore");		
		stmt.addSynonymList(set);

		boolean ans=stmt.checkIfSimilar("I like this wheather" , "I love this climate");
		System.out.println(ans);
		ans=stmt.checkIfSimilar("I like the wheather" , " I loved the climate ");
		System.out.println(ans);

	}

}