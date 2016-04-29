package pkg;

class Node {
	int value;
	Node left;
	Node right;

	Node(int value) {
		this.value = value;
		left = null;
		right = null;
	}
}
//--------------------------------------------------
public class TwoBT 
{
	//--------------------------------------------------
	static Node root1, root2;
	//--------------------------------------------------
	private static void inorder(Node Troot) {
		if(Troot == null)
			return;
		inorder(Troot.left);
		System.out.print(Troot.value+ " ");
		inorder(Troot.right);		
	}
	
	
	//-------------------------Important Fucntinality-------------------------		
	private static void print_2BT_AlternateNode_Inorder(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return;

		Node r1l = root1 == null ? null : root1.left;
		Node r2l = root2 == null ? null : root2.left;
		print_2BT_AlternateNode_Inorder(r1l, r2l);
		
		System.out.print( ((root1 != null)? root1.value : "NULL") +" 	");
		System.out.print( ((root2 != null)? root2.value : "NULL") +" 	\n");

		Node r1r = root1 == null ? null : root1.right;
		Node r2r = root2 == null ? null : root2.right;
		print_2BT_AlternateNode_Inorder(r1r, r2r);
	}
	
	
	
	
	//--------------------------------------------------
	public static void main(String[] args) {
		root1 = new Node(50);
		Node n0 = root1;
		Node n1 = new Node(20);
		Node n2 = new Node(80);
		Node n3 = new Node(10);
		Node n4 = new Node(40);
		//Node n5 = new Node(60);
		Node n6 = new Node(90);
		Node n7 = new Node(30);
		//Node n8 = new Node(70);
		root1.right = n2;
		root1.left = n1;
		n1.left = n3;
		n1.right = n4;
		//n2.left = n5;
		n2.right = n6;
		n4.left = n7;
		//n5.right = n8;
		//--------------------------------------------------
		root2 = new Node(5);
		Node n10 = root2;
		Node n11 = new Node(2);
		Node n12 = new Node(8);
		//Node n13 = new Node(1);
		Node n14 = new Node(4);
		Node n15 = new Node(6);
		Node n16 = new Node(9);
		Node n17 = new Node(3);
		Node n18 = new Node(7);
		root2.right = n12;
		root2.left = n11;
		//n11.left = n13;
		n11.right = n14;
		n12.left = n15;
		n12.right = n16;
		n14.left = n17;
		n15.right = n18;
		//--------------------------------------------------
		inorder(root1);
		System.out.println();
		inorder(root2);
		System.out.println();
		System.out.println();
		//--------------------------------------------------
		print_2BT_AlternateNode_Inorder(root1,root2);
		
	//--------------------------------------------------
	}
//--------------------------------------------------
}
/*
##########Output for Two BT alternate ##########

10 20 30 40 50 80 90 
2 3 4 5 6 7 8 9 
    
10 	NULL 	
20 	2 	
30 	3 	
40 	4 	
50 	5 	
NULL 	6 	
NULL 	7 	
80 	8 	
90 	9 

*/

