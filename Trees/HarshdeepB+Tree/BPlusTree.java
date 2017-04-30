import java.util.*;

public class BPlusTree {

	/* 
		Use of branching factor : (if it is `d`)
		Sees how many keys would be part of the node
		Number of keys part of the node: 2d - 1
		and Number of keys will always be 1 less than Number of references to children nodes.
	*/
	int branching_factor;
	Node root;

	public BPlusTree(int branching_factor) {
		root = null;
		branching_factor = branching_factor;
	}

	public void insert_node(int key) {
		if(root == null) {
			root = new Node(branching_factor);
			root.add_element(key);
			root.current_size += 1;
		}
		else {
			if(root.current_size < (2 * branching_factor - 1)) {
				root.add_element(key);
			}
			// if root has reached the full capacity then
			else {
				// TODO: add functionality here.
			}
		}
	}

	public static void main(String[] args) {
		int branching_factor = 3;
		BPlusTree b_plus_tree = new BPlusTree(branching_factor);
		b_plus_tree.insert_node(10);
	}


}
