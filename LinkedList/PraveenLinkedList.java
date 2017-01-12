/*
 *author: praveensvsrk
 
 */
package LinkedList;

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

public class PraveenLinkedList{
    Node head;

    public PraveenLinkedList(){
        head = null;
    }

    public void addNodeAtTheEnd(int item){
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

    public void display(){
        Node cur = head;
        
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    public static void main(String[] args){
        PraveenLinkedList list = new PraveenLinkedList();
        list.addNodeAtTheEnd(5);
        list.addNodeAtTheEnd(6);
        list.addNodeAtTheEnd(7);
        list.addNodeAtTheEnd(8);
        list.display();
    }
}

