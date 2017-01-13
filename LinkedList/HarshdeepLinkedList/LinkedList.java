import java.util.*;

public class LinkedList {
	Node head;

	public LinkedList(){
		head = null; // Initially the node will be null
	}

	public void add_node(int number){
		Node new_node = new Node(number);

		if(head == null){
			head = new_node;
			return;
		}

		// original_node is basically acting like as a temp node
		Node current_node = head;
		while(current_node.pointer_next_node != null){
			current_node = current_node.pointer_next_node;
		}
		current_node.pointer_next_node = new_node;
	}

	public void show_list(){
		Node current_node = head;
		while(current_node != null){
			System.out.println(current_node.data);
			current_node = current_node.pointer_next_node;
		}
	}

	// Have to add the deletion method
	public static void main(String[] args){
		LinkedList my_linked_list = new LinkedList();
		my_linked_list.add_node(5);
		my_linked_list.add_node(4);
		my_linked_list.add_node(3);

		my_linked_list.show_list();
	}
}
