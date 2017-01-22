import java.util.*;

public class LinkedList {
	Node head;

	public LinkedList(){
		head = null; // Initially the node will be null
	}

	/* Adding node at the end takes O(n) times for obvious reasons */
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

	/* Adding node at the end takes O(1) times for obvious reasons */
	public void add_node_at_front(int number){
		Node new_node = new Node(number);
		if(head == null){
			head = new_node;
			return;
		}

		Node previous_head = head;
		head = new_node;
		head.pointer_next_node = previous_head;

	}

	/* Add a node after some given node in the linked list */
	public void add_node_after(Node previous_node, int number){
		if(previous_node == null){
			System.out.println("Previous node cannot be null");
		}

		Node new_node = new Node(number);
		new_node.pointer_next_node = previous_node.pointer_next_node;
		previous_node.pointer_next_node = new_node;
	}

	public void show_list(){
		Node current_node = head;
		while(current_node != null){
			System.out.print(current_node.data + "  ");
			current_node = current_node.pointer_next_node;
		}
	}

	/* Linked list find length iterative version */
	public int get_length(){
		int length = 0;
		Node current_node = head;
		while (current_node != null){
			length += 1;
			current_node = current_node.pointer_next_node;
		}
		return length;
	}

	public int get_length_recursive(Node node){
		if (node == null){
			return 0;
		}
		return 1 + get_length_recursive(node.pointer_next_node);
	}

	public void delete_node_at_position(int position) {
		Node current_node = head;

		/* If head is null, nothing in the list basically */
		if(head == null){
			System.out.println("The position does not exist in the list.");
			return;
		}

		/* Need to delete the head of the list */
		if(position == 0){
			head = current_node.pointer_next_node;
			return;
		}

		// Finding the previous node
		int i = 0;
		while(current_node != null && i < position - 1){
			current_node = current_node.pointer_next_node;
			i = i + 1;
		}

		// if the user ask to delete a node, which does not exist
		if (current_node == null || current_node.pointer_next_node == null){
			return;
		}

		// Need to make a new variable here, otherwise it will not point to
		// the right node.
		Node new_next = current_node.pointer_next_node.pointer_next_node;
		current_node.pointer_next_node = new_next;
	}

	public int delete_node(int number){
		Node previous_node = null;
		Node current_node = head;

		while(current_node != null) {
			if(current_node.data == number){
				if (current_node == head)
					head = current_node.pointer_next_node;
				else
					previous_node.pointer_next_node = current_node.pointer_next_node;
				return current_node.data;
			}
			else{
				previous_node = current_node;
				current_node = current_node.pointer_next_node;
			}
		}
		return -1;
	}

	// Have to add the deletion method
	public static void main(String[] args){
		LinkedList my_linked_list = new LinkedList();
		my_linked_list.add_node(5);
		my_linked_list.add_node(4);
		my_linked_list.add_node(3);

		System.out.print("The elements in the list : ");
		my_linked_list.show_list();

		// 5  4  3 -- > 5   3
		int number_deleted = my_linked_list.delete_node(4);
		System.out.println("\nNumber which has been deleted is : " + number_deleted);
		System.out.print("The elements in the list after deleting 4 :");
		my_linked_list.show_list();

		// 5  3 -- > 3
		int number_deleted_2 = my_linked_list.delete_node(5);
		System.out.println("\nNumber which has been deleted is : " + number_deleted_2);
		System.out.print("The elements in the list after deleting 5 :");
		my_linked_list.show_list();

		// 3 -- > -1
		int number_deleted_3 = my_linked_list.delete_node(3);
		System.out.println("\nNumber which has been deleted is : " + number_deleted_3);
		System.out.print("The elements in the list after deleting 3 :");
		my_linked_list.show_list();

		/* Add elements at the starting of the linked list */
		LinkedList list_2 = new LinkedList();
		list_2.add_node_at_front(2);
		list_2.add_node_at_front(1);
		list_2.add_node_at_front(0);

		// Test if header position is deleted - for position
		list_2.delete_node_at_position(0);

		// int number_deleted_4 = list_2.delete_node(0);
		// 0   1   2
		System.out.print("\n\n The elements in the list 2 are: ");
		list_2.show_list();

		// Length is 3 for list_2, can be used for delete position
		int length_of_list_2 = list_2.get_length();
		System.out.println("\n\n Length of the list is : " + length_of_list_2);


		/* Add elements at the starting of the linked list */
		LinkedList list_3 = new LinkedList();
		list_3.add_node_at_front(9);
		list_3.add_node_at_front(8);
		list_3.add_node_at_front(7);

		// Test if header any other position is deleted - for position
		list_3.delete_node_at_position(1);

		// int number_deleted_4 = list_2.delete_node(0);
		// 7   8   9 ->    7   9
		System.out.print("\n\n The elements in the list 3 are: ");
		list_3.show_list();

		// For if the head is null and deleting position
		LinkedList list_4 = new LinkedList();
		list_4.delete_node_at_position(9);

		// Length is 2 for list_3, using recursive function
		int length_of_list_3 = list_3.get_length_recursive(list_3.head);
		System.out.println("\n\n Length of the list 3 is : " + length_of_list_3);


	}
}
