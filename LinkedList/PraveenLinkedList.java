/*
 *author: praveensvsrk
 
 */
import java.util.*;

public class PraveenLinkedList{
    List<Node> head = null;

    public void addNodeAtTheEnd(int item){
        Node node = new Node(item);

        if(head == null){
            head = node;
            return;
        }
        Node cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
        
    }

    public void display(){
        Node cur = head;
        while(cur != null){
            System.out.println(cur.data);
        }
    }

    public static void main(String[] args){
        addNodeAtTheEnd(5);
        addNodeAtTheEnd(6);
        addNodeAtTheEnd(7);
        addNodeAtTheEnd(8);
        display();
    }
}

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