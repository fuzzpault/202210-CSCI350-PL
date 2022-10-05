package CSCI350;
/*
 * bst.java
 * Paul Talaga
 * Oct 5, 2022
 * 
 * A simple implementation of a binary search tree (bst) in Java.
 * 
 */


class Node2{  	// Named Node2 because node is defined in another file!
	public Node2 left;
	public Node2 right;
	public int data;
	public Node2(int d, Node2 r, Node2 l) {
		data = d;
		right = r;
		left = l;
	}
	public int numNodes() {
		if(left == null && right == null)return 1;
		int counter = 0;
		if(left != null)counter += left.numNodes();
		if(right != null)counter += right.numNodes();
		return counter + 1;
	}
}

public class bst {
	private Node2 root;
	public bst() {
		root = null;
	}
	
	public void insert(int d) {
		if(root == null) {
			root = new Node2(d, null, null);
		}else{
			insert(root, d);
		}
	}
	
	private void insert(Node2 cur, int d) {
		if(cur == null) {
			System.out.println("How did this happen?");
			return;
		}
		if( d < cur.data) {
			if(cur.left == null) {
				cur.left = new Node2(d, null, null);
			}else {
				insert(cur.left, d);
			}
		}else {
			if(cur.right == null) {
				cur.right = new Node2(d, null, null);
			}else {
				insert(cur.right, d);
			}
		}
	}
	
	public void print() {
		System.out.println("[" + print(root) + "]");
	}
	
	public String print(Node2 cur) {
		if(cur == null) return "";
		return print(cur.left)  + cur.data + ", " + print(cur.right);
	}
	
	public int numNodes() {
		//return numNodes(root);
		if(root == null)return 0;
		return root.numNodes();
	}
	
	/*private int numNodes(Node2 cur) {
		if(cur == null)return 0;
		return 1 + numNodes(cur.left) + numNodes(cur.right);
	}*/
	
	public Boolean find(int d) {
		return find(root, d);
	}
	
	private Boolean find(Node2 cur, int d) {
		if(cur == null)return false;
		if(cur.data == d)return true;
		if(d < cur.data) {
			return find(cur.left, d);
		}else {
			return find(cur.right, d);
		}
	}


	public static void main(String[] args) {
		bst tree = new bst();
		tree.insert(5);
		tree.insert(10);
		tree.insert(2);
		tree.insert(78);
		tree.insert(5);
		
		tree.print();
		System.out.println("There are " + tree.numNodes() + " Node2s.");

		 
		if(tree.find(78)){
			System.out.println("3 there");
		}else {
			System.out.println("3 NOT there");
		}
		
	}

}


