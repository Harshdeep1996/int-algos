/*
 *author: praveensvsrk

 */
package LinkedList.PraveenLinkedList;

import java.util.*;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }

    boolean hasNext(){
        return (next != null ? true : false);
    }
}

public class LinkedList{
    Node head;

    public LinkedList(){
        head = null;
    }

    public LinkedList(Node head){ //Copy Constructor (not deep copy)
        this.head = head;
    }

    public LinkedList(int number){
        this.intToLL(number);
    }

    public void intToLL(int number){
        /*Converts integer to LinkedList*/
        head = null;
        boolean isNegative = false;
        if (number < 0){
            number = -number;
            isNegative = true;
        }
        while(number > 0){
            this.addNodeAtBeg(number % 10);
            number /= 10;
        }
        if(isNegative)
            head.data = -head.data;
    }

    public int LLtoInt(){
        /*
        Converts a Linked List that represents a number into a number
        Works for all types of Integers
        */
        if(head == null)
            return 0;
        Node cur = head;
        boolean isNegative = false;
        int result = 0;

        if(cur.data < 0){
            result = -cur.data;
            isNegative = true;
            cur = cur.next;
        }

        while(cur.hasNext()){
            result *= 10;
            result += cur.data;
            cur = cur.next;
        }

        if(isNegative)
            return -result;
        return result;
    }

    public void addNodeAtEnd(int item){
        /* Adds nodes at the end of linked list */
        Node node = new Node(item);

        if(head == null){
            head = node;
            return;
        }
        Node cur = head;
        while(cur.hasNext()){
            cur = cur.next;
        }
        cur.next = node;
    }


    public void addNodeAtBeg(int item){
        /* Adds nodes at the beginning of linked list */
        Node node = new Node(item);

        if(head == null){
            head = node;
            return;
        }
        node.next = head;
        head = node;

    }


    void deleteNodeAtPos(int pos){
        /* Deletes nodes of linked list at given index position */
        Node cur = head;
        while((--pos > 0) && cur.hasNext()){
            cur = cur.next;
        }
        if(pos == 0 && cur.hasNext()){
            cur.next = cur.next.next;
        }
    }


    void deleteNode(int item){
        /* Deletes nodes of linked list */
        Node cur = head;
        while(cur.hasNext() && cur.next.data != item){
            cur = cur.next;
        }
        if(cur.hasNext()){
            cur.next = cur.next.next;
        }
    }


    public void display(){
        /* Displays linked list */
        Node cur = head;

        while(cur != null){
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }


    public static int length(Node head){
        /* Recursive version of finding length of a liked list */
        if(!head.hasNext()){
            return 1;
        }
        return 1 + length(head.next);
    }


    /*public void swapNodes(int item1, int item2){
        // UNIMPLEMENTED - Swaps two nodes in a linked list
        Node cur = head;
        Node prev = null;
        while(cur != null && cur.data != item1){
            prev = cur;
            cur = cur.next;
        }
        if(cur == null)
            return;
        Node cur2 = head;
        Node prev2 = null;
        while(cur2 != null && cur2.data != item2){
            prev2 = cur2;
            cur2 = cur2.next;
        }
        if(cur2 == null)
            return;

        Node temp = prev.next.next;
        Node temp2 = prev2.next.next;
        prev.next = prev2.next;

        prev2.next = temp;
    }*/


    public static Node reverse(Node list){
        /* Recursive version of linked list reversal */
        if(!list.hasNext()){
            return list;
        }
        reverse(list.next).next = list;
        return list;
    }


    public static void reverse_wrapper(LinkedList list){
        /* Wrapper to the recursive reversal function */
        Node cur = list.head;
        while(cur.hasNext()){
            cur = cur.next;
        }
        reverse(list.head).next = null;
        list.head = cur;

    }

    public void rotate(int count){
        //rotates Linked list. Positive value = left rotation. Negative value = right rotation.
        if(count == 0)
            return;
        Node cur = head;
        int length = LinkedList.length(head);
        if(count < 0){
            count = -count;
            count = count % length;
            count = length - count;
        }
        else
            count = count % length;
        if(count == 0)
            return;
        while(--count > 0){
            cur = cur.next;
        }
        Node temp = cur.next;
        cur.next = null;
        Node cur2 = temp;
        while(cur2.hasNext()){
            cur2 = cur2.next;
        }
        cur2.next = head;
        head = temp;

    }

    /*public void reverse_in_groups(int count){
        // UNIMPLEMENTED
        if(count <= 1)
            return;

    }*/

    public static void main(String[] args){
        LinkedList list = new LinkedList();

        list.addNodeAtEnd(5);
        list.addNodeAtEnd(6);
        list.addNodeAtEnd(7);
        list.addNodeAtEnd(8);
        list.display();

        list.addNodeAtBeg(4);
        list.addNodeAtBeg(3);
        list.addNodeAtBeg(2);
        list.addNodeAtBeg(1);
        list.display();

        list.deleteNodeAtPos(1);
        list.deleteNodeAtPos(3);
        list.display();

        list.deleteNode(6);
        list.deleteNode(7);
        list.display();

        System.out.println("Length: " + LinkedList.length(list.head));
        LinkedList.reverse_wrapper(list);
        list.display();
        list.rotate(1); //rotate once to the left
        list.display();
        list.rotate(3); //rotate thrice to the left
        list.display();
        list.rotate(5);
        list.display();
        list.rotate(-3); //rotate thrice to the right
        list.display();


        LinkedList list2 = new LinkedList(12345); //Integer to LL
        list2.display();
        System.out.println("The integer form of above list: " + list2.LLtoInt()); //LL to integer

        list2 = new LinkedList(-7654345);
        list2.display();
        System.out.println("The integer form of above list: " + list2.LLtoInt());
    }
}
