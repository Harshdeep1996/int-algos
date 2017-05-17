package Trees;

import java.util.*;

class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	int getData(){
		return data;
	}
	
	void setLeftChild(Node node){
		this.left = node;
	}
	
	void setRightChild(Node node){
		this.right = node;
	}
	
	Node getLeftChild(){
		return left != null ? left : null;
	}
	
	Node getRightChild(){
		return right != null ? right : null;
	}
}


public class PraveenBinaryTree{
	Node root;
	
	PraveenBinaryTree(int data){
		root = new Node(data);
	}
	
	PraveenBinaryTree(){
		root = null;
	}
	
	static void printPreOrderRecursive(Node node){
		if(node == null)
			return;
		System.out.print(node.getData() + " ");
		printPreOrderRecursive(node.getLeftChild());
		printPreOrderRecursive(node.getRightChild());
	}
	
	static void printInOrderRecursive(Node node){
		if(node == null)
			return;
		printInOrderRecursive(node.getLeftChild());
		System.out.print(node.getData() + " ");
		printInOrderRecursive(node.getRightChild());
	}
	
	static void printPostOrderRecursive(Node node){
		if(node == null)
			return;
		printPostOrderRecursive(node.getLeftChild());
		printPostOrderRecursive(node.getRightChild());
		System.out.print(node.getData() + " ");
	}
	
	
	
	public static void main(String[] args){
		PraveenBinaryTree tree = new PraveenBinaryTree(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		
		
		System.out.println("Pre order traversal:");
		PraveenBinaryTree.printPreOrderRecursive(tree.root);
		System.out.println("\nIn order traversal:");
		PraveenBinaryTree.printInOrderRecursive(tree.root);
		System.out.println("\nPost order traversal:");
		PraveenBinaryTree.printPostOrderRecursive(tree.root);
	}
	
	
	
}