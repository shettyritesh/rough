package toposort;
import java.util.*;


class Job{

	private Set<String> zeroDep= new HashSet<String>();
	private Map<String,Vertex> mapOfVertex= new HashMap<String, Vertex>();
	private Map<String,Integer> mapOfDependentCount= new HashMap<String, Integer>();
	
	public void addDependency(String from, String to){
		Vertex fromVertex = getOrCreateVertex(from);
		Vertex toVertex = getOrCreateVertex(to);
		fromVertex.addDependency(toVertex);
		if(zeroDep.contains(to)){
			zeroDep.remove(to);
		}
		Integer tocount=mapOfDependentCount.get(to);
		if(tocount!=null){
			tocount=tocount+1;			
		}
		else{
			tocount= new Integer(1);
		}
		mapOfDependentCount.put(to,tocount);
		
		Integer count=mapOfDependentCount.get(from);
		if(count ==null &&  !zeroDep.contains(from))
		{
			zeroDep.add(from);	
		}
	
	}

	public void printSequence(){
	
		//A--> B   B-->D   B-->E   D -->E
		Queue<String> queue = new LinkedList<String>();	
		for(String item:zeroDep){
			queue.add(item);
		}
		
		while(!queue.isEmpty()){
		
			String vertex=queue.remove();
			System.out.println(vertex);
			Vertex v= getOrCreateVertex(vertex);
			List<Vertex> listofdep= v.getDependents();
			for(Vertex dependets:listofdep){
				Integer count= mapOfDependentCount.get(dependets.name);
				count=count-1;
				if(count==0){
					queue.add(dependets.name);
					
				}
				mapOfDependentCount.put(dependets.name,count);
				
			}
			
		}

	}
	
	private Vertex getOrCreateVertex(String key){
	
		Vertex vertex=mapOfVertex.get(key);
		if(vertex==null){
			vertex= new Vertex(key);
			mapOfVertex.put(vertex.name,vertex);
			return vertex;
		}
		return vertex;
	}

}

class Vertex{

	String name;
	public boolean equals(Object obj){
		boolean iseq=false;
		Vertex vertex= (Vertex)obj;
		if(name.equals(vertex.name)){
			iseq=true;
		}
		
		return iseq;
	}
	
	public int hashCode(){
	
		return name.hashCode();
	}
	List<Vertex> dependencies= new ArrayList<Vertex>();
	public Vertex(String thatname){
		name= thatname;
	}
	public void addDependency(Vertex vertex){
		dependencies.add(vertex);
	}
	
	public List<Vertex> getDependents(){
		return dependencies;
	}
}