import java.util.Stack;

//practice tree

public class BinaryTree {
	private static class Node{
		Node left,right,parent;
		int val;
//		build constructor
		public Node(int v, Node parent, Node left, Node right) {
			val = v;
			this.parent = parent;
			this.left = left;
			this.right = right;		
		}
		
		public void inorder() { // the way to output the tree
			if (left != null) {			
				left.inorder();
			}
			System.out.print(val+ " ");
			if(right != null) {
				right.inorder();
			}
		}
		
		public void preorder() {

			System.out.print(val+ " ");
			
			if (left != null) {			
				left.preorder();
			}		
			if(right != null) {
				right.preorder();
			}
					
		}
		
		public void postorder() {
			if (left != null) {			
				left.postorder();
			}

			if(right != null) {
				right.postorder();
			}

			System.out.print(val+ " ");
			
		}
	}
	
	private Node root;
	
	
	
	public BinaryTree() {
		root = null;
	}

	
	public void add(int v) {
		if(root == null) {
			root = new Node(v,null, null, null);
//			System.out.print(v + " ");
			return;		
	     }
		Node p = root;
		while(true) {
			if(v > p.val) {
				if (p.right == null) {
					p.right = new Node(v,p,null,null);
//					System.out.print(v + " ");
					return;
				}
				p = p.right;
			} else {
				if (p.left == null) {
					p.left = new Node(v,p,null,null);
//					System.out.print(v + " ");
					return;
				}
				p = p.left;
			}
		}			
	}
	
////	show the structure of the tree
//	private static void iterateall(Node foo) {
//	    Stack<Node> nodes = new Stack<Node>();
//	    nodes.push(foo);
//	    while (!nodes.isEmpty()) {
//	        Node node = nodes.pop();
//	        if (node == null) {
//	        	System.out.println("null");
//	            continue;
//	        }
//	        System.out.println(node.val);
//	        nodes.push(node.right);
//	        nodes.push(node.left);
//	    }
//	}
//	
	
	
	public void inorder() {
		if(root != null) {
			root.inorder();
		}
	}
	
	public void preorder() {
		if(root != null) {
			root.preorder();
		}
	}
	
	public void postorder() {
		if(root != null) {
			root.postorder();
		}
	}
	
	public static void main(String[] args) {
		BinaryTree b = new BinaryTree();
		int[] vals = {3,5,4,2,6,7,8};
		for (int i = 0; i < vals.length; i++) {
			b.add(vals[i]);
		}
//		BinaryTree.Node node = b.root;
//		while(node != null) {
//			System.out.print(node.val + " ");	
//		}
		
//		BinaryTree.iterateall(b.root);
		System.out.println("inorder: ");
		b.inorder();
		System.out.println();
//		BinaryTree.iterateall(b.root);
		System.out.println("preorder: ");
		b.preorder();
		System.out.println();
		System.out.println("postorder: ");
		b.postorder();
		
	}
	
		
}