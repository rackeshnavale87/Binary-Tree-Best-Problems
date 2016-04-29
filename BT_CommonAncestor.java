
// Binary tree common ancestor *******************************NOT BST
static boolean v1 = false, v2 = false;
 Node findLCA(int n1, int n2) {
     v1 = false;
     v2 = false;
     Node lca = findLCAUtil(root, n1, n2);
     if (v1 && v2)
        return lca;
     else
     	return null;
 }
 Node findLCAUtil(Node node, int n1, int n2) {
	 if(node == null)
		 return null;
	 if(node.data == n1 && node.data == n2) {
		 v1=true;
		 v2 = true;
		 return node;
	 }
	 if(node.data == n1) {
		 v1 = true;
		 return node;
	 } 
	 if(node.data==n2) {
		 v2 = true;
		 return node;
	 }
	 Node left = findLCAUtil(node.left, n1,n2);
	 Node right = findLCAUtil(node.right,n1,n2);
	 
	 if(left!=null && right !=null)
		 return node;
	 return left!=null ? left : right;
 }
 // Finds lca of n1 and n2 under the subtree rooted with 'node'

// Binary tree common ancestor *******************************
