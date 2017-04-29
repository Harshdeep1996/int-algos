import java.io.*;
import java.util.*;

// Topological sorting basically means that for 
/*
	A graph, when there is a directed acyclic graph,

	     u
	    / \
	   /   \
	  v     w

	  the sorting should appear from u, v, w

	  why it can't have cycles is because otherwise it can never be 
	  topologically sorted, as u can neva come before v, and v can 
	  neva come before u.
*/
public class HarshdeepTopologicalSorting {

	// This is basically a generic list of Integers array. 
	// An adjacency list of each node - and then apply DFS on it
	private LinkedList<Integer>[] adjacency_list;

	public HarshdeepTopologicalSorting(int vertices) {
		adjacency_list = new LinkedList[vertices];
		for(int i =0; i < vertices; i++){
			adjacency_list[i] = new LinkedList();
		}
	}

	// Build up adjancency list for each node
	public void addEdge(int source, int dest){
		adjacency_list[source].add(dest);
	}

	public void TS(int node, boolean []visited_nodes, Stack sorted_stack) {
		Integer n;
		visited_nodes[node] = true;
		Iterator<Integer> iter = adjacency_list[node].listIterator();

		// Check if there is another element in the adjacency list
		// and look that up, according to DFS rules
		while(iter.hasNext()) {
			n = iter.next();
			if(!visited_nodes[n])
				TS(n, visited_nodes, sorted_stack);
		}

		// and then store it into the stack, when there is nothing in the
		// adjacency list
		System.out.println("Putting element in the stack: " + node);
		sorted_stack.push(node);
	}

	// Helper method which triggers the Topological sort algorithm
	public void applyTS(int nodes){
		Stack sorted_stack = new Stack();
		boolean []visited_nodes = new boolean[nodes];

		for(int i = 0; i < nodes; i++) {
			if(!visited_nodes[i]){
				TS(i, visited_nodes, sorted_stack);
			}
		}

		System.out.println(sorted_stack);

		//while(!sorted_stack.empty()){
      	System.out.println("First element :" + sorted_stack.pop() + " \n");
      	//}
	}

    public static void main(String[] args) {

    	// int vertices = 6;
    	int vertices = 3;
	    HarshdeepTopologicalSorting graph = new HarshdeepTopologicalSorting(
	    	vertices);

        // System.out.println("Number of items : " + list.size());
        // graph.addEdge(5, 2);
        // graph.addEdge(5, 0);
        // graph.addEdge(4, 0);
        // graph.addEdge(4, 1);
        // graph.addEdge(2, 3);
        // graph.addEdge(3, 1);

        graph.addEdge(0, 1);
       	graph.addEdge(0, 2);
        // graph.addEdge(4, 0);

        graph.applyTS(vertices);

        // System.out.println("Linked list is: " + graph.toString());     
    }
}
