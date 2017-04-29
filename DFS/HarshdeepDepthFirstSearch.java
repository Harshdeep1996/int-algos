import java.io.*;
import java.util.*;

// Continue going through the adjancency list
public class HarshdeepDepthFirstSearch {

	// This is basically a generic list of Integers array. 
	// An adjacency list of each node - and then apply DFS on it
	private LinkedList<Integer>[] adjacency_list;

	public DepthFirstSearch(int vertices) {
		adjacency_list = new LinkedList[vertices];
		for(int i =0; i < vertices; i++){
			adjacency_list[i] = new LinkedList();
		}
	}

	// Build up adjancency list for each node
	public void addEdge(int source, int dest){
		adjacency_list[source].add(dest);
	}

	public void DFS(int node, boolean []visited_nodes) {
		visited_nodes[node] = true;
		System.out.println(node + " \n");
		Iterator<Integer> iter = adjacency_list[node].listIterator();

		// Check if there is another element in the adjacency list
		// and look that up, according to DFS rules
		while(iter.hasNext()) {
			int n = iter.next();
			if(!visited_nodes[n])
				DFS(n, visited_nodes);
		}
	}

	// Helper method which triggers the recursive DFS algorithm
	public void applyDFS(int nodes){
		boolean []visited_nodes = new boolean[nodes];
		for(int i = 0; i < nodes; i++) {
			if(!visited_nodes[i]){
				DFS(i, visited_nodes);
			}
		}
	}

    public static void main(String[] args) {

    	int vertices = 5;
	    DepthFirstSearch graph = new DepthFirstSearch(vertices);

        // System.out.println("Number of items : " + list.size());
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        graph.applyDFS(vertices);

        // System.out.println("Linked list is: " + graph.toString());     
    }
}
