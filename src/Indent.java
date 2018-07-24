import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Indent {
	public static void main(String args[]) {
		String[] arr= {"This", "is", "an", "example", "of", "text", "justification."};
		Indent indent= new Indent();
		List<String> list=indent.fullJustify(arr, 16);
		list.forEach(item->System.out.println(item));
	}
    public List<String> fullJustify(String[] words, int maxWidth) {
        Queue<String> queue= new LinkedList<String>();
        List<String> res= new ArrayList<String>();
        StringBuilder sb= new StringBuilder();
        int totalLength=0;
        int currwords=0;
        for(int i=0;i<words.length;i++){
            ++currwords;
            totalLength=totalLength+words[i].length();
            if((totalLength+currwords)>maxWidth){
                int spaces=0;
                if( i<(words.length-1) && (currwords-2)>0) {
                	spaces=(maxWidth-(totalLength-words[i].length()))/(currwords-2);
                }
                else {
                	spaces=1;
                }
                while(!queue.isEmpty()){
                    String val=queue.remove();    
                    sb.append(val);
                    if(!queue.isEmpty()){
                       sb.append(String.format("%"+spaces+"s"," ")); 
                    }
                }
                int padding;
				addLast(maxWidth, res, sb.toString());
                sb= new StringBuilder();
                totalLength=words[i].length();
                currwords=1;
                if(i==(words.length-1)) {
                	addLast(maxWidth, res, words[i]);
                }
                
                
            }
            queue.add(words[i]);
        }
        return res;
    }
	private void addLast(int maxWidth, List<String> res, String sb) {
		int padding=maxWidth-sb.length();
		if(padding>0) {
			res.add(String.format(sb+"%"+padding+"s", " "));
		}
		else {
			res.add(sb.toString());
		}
	}
}