import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
public class GraphTraversals {

	public static void main(String[] args) {
		Graph graph= new Graph();
		graph.addRelation("A", "B");
		graph.addRelation("A", "C");
		graph.addRelation("B", "C");
		graph.addRelation("B", "D");
		graph.addRelation("C", "F");
		graph.addRelation("D", "E");
		System.out.println("Printing BFS...");
		graph.printBFS("A");
		System.out.println("Printing DFS...");
		graph.printDFS("A");

	}
}


	class Vertex{

		String name;
		Set<String> neigbours;
		Set<String> getNeighbours(){
			return neigbours;
		}
		public Vertex(String nameN){
			name=nameN;
			neigbours=new HashSet<String>();
		}

		public void addNeighbour(String neigh){
			neigbours.add(neigh);
		}
	}

	class Graph{

	Map<String, Vertex> mapOfVertices= new HashMap<String, Vertex>();
	public void addRelation(String from, String to){
		Vertex fromvertex=getOrAddVertex(from);
		Vertex tovertex=getOrAddVertex(to);
		fromvertex.addNeighbour(to);
	}

	Vertex getOrAddVertex(String nodename){
		Vertex vertex=mapOfVertices.get(nodename);
			if(vertex==null){
				vertex= new Vertex(nodename);
				mapOfVertices.put(nodename,vertex);
			}
		return vertex;
	}


	void printDFS(String start){
		Stack<String> stack = new Stack<String>();
		if(mapOfVertices.get(start)==null) {
			throw new RuntimeException();
		}
		stack.push(start);
		Set<String> visited= new HashSet<String>();
		while(!stack.isEmpty()){

			String vertex=stack.pop();
			System.out.println(vertex);
			Vertex Vertexobj= getOrAddVertex(vertex);
			Set<String> neighbours=Vertexobj.getNeighbours();
			for(String curr:neighbours){
				if(!visited.contains(curr)){
					stack.push(curr);
					visited.add(curr);
				}
			}
		}

	}
	void printBFS(String start){
		Queue<String> stack = new LinkedList<String>();
		if(mapOfVertices.get(start)==null) {
			throw new RuntimeException();
		}
		stack.add(start);
		Set<String> visited= new HashSet<String>();
		while(!stack.isEmpty()){

			String vertex=stack.remove();
			System.out.println(vertex);
			Vertex Vertexobj= getOrAddVertex(vertex);
			Set<String> neighbours=Vertexobj.getNeighbours();
			for(String curr:neighbours){
				if(!visited.contains(curr)){
					stack.add(curr);
					visited.add(curr);
				}
			}
		}

	}

	}
