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

public class LinkedList{
    Node head;

    public LinkedList(){
        head = null;
    }

    public void addNodeAtEnd(int item){
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
        Node node = new Node(item);
        
        if(head == null){
            head = node;
            return;
        }
        node.next = head;
        head = node;

    }


    void deleteNodeAtPos(int pos){
        Node cur = head;
        while((--pos > 0) && cur.hasNext()){
            cur = cur.next;
        }
        if(pos == 0 && cur.hasNext()){
            cur.next = cur.next.next;
        }

    }

    void deleteNode(int item){
        Node cur = head;

        while(cur.hasNext() && cur.next.data != item){
            cur = cur.next;
        }
        if(cur.hasNext()){
            cur.next = cur.next.next;
        }
    }

    public void display(){
        Node cur = head;
        
        while(cur != null){
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public static int length(Praveen){

        return 1 + length()
    }

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
        
    }
}

