import java.util.*;

public class Node{

	int capacity;
	int current_size;
	List<Integer> keys;
	List<Node> references_to_child_node; 

	public Node(int branching_factor){
		capacity = 2 * branching_factor - 1;
		keys = new ArrayList<Integer>(capacity);
		references_to_child_node = new ArrayList<Node>(capacity + 1);
		for(int i = 0; i < capacity; i++) {
			keys.add(0);
			references_to_child_node.add(null);
		}
		current_size = 0;
	}

	public void add_element(int key) {
		keys.add(key);
		merge_sort(keys);
	}

	public void merge_sort(List<Integer> keys) {
		
	}
}
