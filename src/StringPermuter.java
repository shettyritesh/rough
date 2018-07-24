import java.util.List;
import java.util.ArrayList;

public class StringPermuter{

	public List<String> getPermutations(String str){
		List<String> list= new ArrayList<String>();
		if( str!=null && str.length()>0){
			permute(str, 0, str.length(), list);		
		}		
		return list;
	}
	
	private void permute(String str, int start, int end, List<String> list){
		if(start==end){
			list.add(str);
			return;
		}
		for(int i=start;i<end;i++){
			str= swap(str,start,i);
			permute(str,start+1,end,list);
		}
		
	
	}
	
	private String swap(String str, int i, int j){
	
		char[] chararr=str.toCharArray();
		char tmp=chararr[i];
		chararr[i]=chararr[j];
		chararr[j]=tmp;
		return String.valueOf(chararr);
	}
	
	public static void main(String[] args){
	
		StringPermuter util= new StringPermuter();
		List<String> list=util.getPermutations("ABC");
		for(String str:list){
			System.out.println(str);
		}
	}
}