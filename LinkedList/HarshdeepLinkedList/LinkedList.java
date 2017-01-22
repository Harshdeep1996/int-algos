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

	public int get_length(){
		int length = 0;
		Node current_node = head;
		while (current_node != null){
			length += 1;
			current_node = current_node.pointer_next_node;
		}
		return length;
	}

	public void delete_node_at_position(int position) {
		// Need to implement it in next commit. 
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

		// int number_deleted_4 = list_2.delete_node(0);

		System.out.print("\n\n The elements in the list 2 are: ");
		list_2.show_list();
		int length_of_list_2 = list_2.get_length();
		System.out.println("\n\n Length of the list is : " + length_of_list_2);


	}
}
