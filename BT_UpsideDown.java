class Node {
	int value;
	Node left;
	Node right;
	Node(int val) {
		this.value = val;
		this.left = null;
		this.right = null;
	}
}

public class P156 {
	static Node rootM;

/*
    1 	               4
   / \                / \
  2   3   ========>  5   2
 / \		        / \
4   5                  3   1
		
*/

		private static Node upsideDownBinaryTree(Node root) {
		if (root == null) 
            return null;
        Node left = root.left;
        Node right = root.right;
        Node newRoot = upsideDownBinaryTree(left);
        if (left != null) {
            left.left = right;
            left.right = root;
        }
        root.left = null;
        root.right = null;
        return newRoot != null ? newRoot : root;
	}


	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		rootM = n1;
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		
		    inorder(rootM);
    		rootM = upsideDownBinaryTree(rootM);
		      System.out.println();
		    inorder(rootM);
	}

	private static void inorder(Node Troot) {
		if(Troot == null)
			return;
		inorder(Troot.left);
		System.out.print(Troot.value+ "   ");
		inorder(Troot.right);		
	}
	
}

/* OutPut ----------------------------------------
4   2   5   1   3   
5   4   3   2   1 

--------------------------------------------------*/

