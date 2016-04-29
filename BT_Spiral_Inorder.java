package pkg;
import java.util.*;

class Node {
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


public class BT_Spiral_Inorder {

	static Node root1;
	
	private static void inorder(Node Troot) {
		if(Troot == null)
			return;
		inorder(Troot.left);
		System.out.print(Troot.value+ "   ");
		inorder(Troot.right);		
	}
	
	public static void main(String[] args) {
		root1 = new Node(50);
		Node n0 = root1;
		Node n1 = new Node(20);
		Node n2 = new Node(80);
		Node n3 = new Node(10);
		Node n4 = new Node(40);
		Node n5 = new Node(60);
		Node n6 = new Node(90);
		Node n7 = new Node(30);
		Node n8 = new Node(70);
		root1.right = n2;
		root1.left = n1;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		n4.left = n7;
		n5.right = n8;

		System.out.println("Inorder");
		inorder(root1);
		System.out.println();
		
		System.out.println("Zig-Zag");
		ZigZag(root1,9);
	}

	private static void ZigZag(Node Troot, int nodes) {
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		Node temp = Troot;
		s1.push(Troot);
		int AlternateLevel =1;
		while(nodes>0)
		{
			if(AlternateLevel==1)
			{
				while(!s1.isEmpty())
				{
					Node nodepop = s1.pop();
					System.out.print(nodepop.value+ "   ");
					nodes--;
					if(nodepop.right!=null)
						s2.push(nodepop.right);
					if(nodepop.left!=null)
						s2.push(nodepop.left);
				}
				AlternateLevel=0;
			}
			else
			{
				while(!s2.isEmpty())
				{
					Node nodepop = s2.pop();
					System.out.print(nodepop.value+ "   ");
					nodes--;
					if(nodepop.left!=null)
						s1.push(nodepop.left);
					if(nodepop.right!=null)
						s1.push(nodepop.right);
				}
				AlternateLevel=1;
			}
		}
	}	
}



/*
##########Output for Spiral Inorder ##########
Inorder
10   20   30   40   50   60   70   80   90   
Zig-Zag
50   20   80   90   60   40   10   30   70 
*/
