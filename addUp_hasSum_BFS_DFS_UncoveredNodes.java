package pkg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class Node
{
	int value;
	Node left;
	Node right;
	int visited;

	Node(int value) {
		this.value = value;
		left = null;
		right = null;
		visited = 0;
	}
}

public class Tree_B_D {

	public static int nodeCount = 0;
	static Node root;
	Node temp;
	
	private static void inorder(Node root2) {
		
		if(root2 == null)
			return;
		inorder(root2.left);
		System.out.print(root2.value+ " ");
		nodeCount++;
		inorder(root2.right);		
	}

	public static void main(String[] args) {
		
		root = new Node(50);
		Node n0 = root;
		Node n1 = new Node(20);
		Node n2 = new Node(60);
		Node n3 = new Node(10);
		Node n4 = new Node(40);
		Node n5 = new Node(80);
		Node n6 = new Node(90);
		Node n7 = new Node(30);
		Node n8 = new Node(70);
		
//		Node n9  = new Node(111);
//		Node n10 = new Node(222);
//		Node n11 = new Node(333);
//		n6.left = n9;
//		n9.right = n10;
//		n10.left = n11;

		root.right = n2;
		root.left = n1;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		n4.left = n7;
		n5.right = n8;
		
		//System.out.println("Inorder Display :");
		inorder(root);
		System.out.println("\n---------------------------------");
		//System.out.println("Total number of Nodes: "+ nodeCount);
		//System.out.println("---------------------------------");

		//BFS(root);
		DFS(root);
		//addup(root);
		//hasSum(root,140);
		//uncoveredNodes(root);
		//inorder(root);
	}

	private static void uncoveredNodes(Node root2) {
		LinkedList<Node> uncovered = new LinkedList<Node>();
		Node temp = root2;
		boolean leaf = false;
		uncovered.add(temp);
		while(!leaf)
		{
			while(temp.left!=null)
			{
				temp = temp.left;
				uncovered.add(temp);
			}
			if(temp.right!=null)
				temp = temp.right;
			else
				leaf = true;
		}
		
		leaf = false;
		temp = root2;
		while(!leaf)
		{
			while(temp.right!=null)
			{
				temp = temp.right;
				uncovered.add(temp);
			}
			if(temp.left!=null)
				temp = temp.left;
			else
				leaf = true;
		}
		
		Iterator<Node> itr = uncovered.iterator();
		while(itr.hasNext())
			System.out.print(itr.next().value+ "   ");		
	}


	private static boolean hasSum(Node root2, int sum) {
		if(root2==null) {
			if(sum == 0) {
				System.out.println("Path found from root to LEAF NODE");
				return true;
			}
			else {
				return false;
			}
		}
		else if(root2!=null && sum==0) {
			System.out.println("Path found from root to INTERNAL NODE");
			return true;
		}
		return (hasSum(root2.left,sum-root2.value) || hasSum(root2.right,sum-root2.value));		
	}

	private static void addup(Node root2) {

		if(root2 == null)
			return;
		addup(root2.left);		
		if(root2.left!=null)
			root2.value = root2.value + root2.left.value ;

		addup(root2.right);
		if(root2.right!=null)
			root2.value = root2.value + root2.right.value;

	}

	private static void DFS(Node root2) {
		
		System.out.print(root2.value+ "	");
		if(root2.left!=null)
			DFS(root2.left);
		if(root2.right!=null)
			DFS(root2.right);
		
	}

	private static void BFS(Node root2) {
		
		LinkedList<Node> Q = new LinkedList<Node>();
		Node temp;
		Q.add(root2);
		root2.visited = 1;
		while(!Q.isEmpty())
		{
			temp = Q.removeFirst();
			System.out.print(temp.value+"[L"+getlevel(root, temp.value,1)+"]	");
			if(temp.left!=null && temp.left.visited==0)
			{
				Q.add(temp.left);
				temp.left.visited = 1;
			}
			if(temp.right!=null && temp.right.visited==0)
			{
				Q.add(temp.right);
				temp.right.visited = 1;
			}
		}		
	}

	private static int getlevel(Node root2, int value2, int level) {
		if(root2==null)
			return 0;
		
		if(root2.value == value2)
			return level;
		
		int downlevel = getlevel(root2.left, value2, level+1);
		
		if(downlevel !=0)
			return downlevel;
		
		downlevel = getlevel(root2.right, value2, level+1);
		return downlevel;
	}
}

/*
##########Output for BFS ##########

10 20 30 40 50 80 70 60 90 
---------------------------------
50[L1]	20[L2]	60[L2]	10[L3]	40[L3]	80[L3]	90[L3]	30[L4]	70[L4]	

##########Output for DFS ##########

10 20 30 40 50 80 70 60 90 
---------------------------------
50	20	10	40	30	60	80	70	90

##########Output for addUp ##########

10 20 30 40 50 80 70 60 90 
---------------------------------
10 100 30 70 450 150 70 300 90 

##########Output for hasSum##########

10 20 30 40 50 80 70 60 90 
---------------------------------
Path found from root to LEAF NODE


##########Output for uncovered Nodes##########

10 20 30 40 50 80 70 60 90 
---------------------------------
50   20   10   60   90   

##############################################
*/
