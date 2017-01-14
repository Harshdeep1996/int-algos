/*
 *author: praveensvsrk
 
 */
package LinkedList.PraveenLinkedList;

import java.util.*;

import com.sun.org.apache.xerces.internal.impl.xs.util.LSInputListImpl;

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


    public void swapNodes(int item1, int item2){
        /* UNIMPLEMENTED - Swaps two nodes in a linked list */
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
    }


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

    //public void merge(Node list1,)

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
        
    }
}

