package code.assignment.binarytree;
import java.util.ArrayList; 
import java.util.List; 

class Node { 
	int data; 
	Node left, right; 

	Node(int value) { 
		data = value; 
		left = null;
		right = null; 
	} 
} 

public class BinaryTreeLCA 
{ 

	Node root; 
	private List<Integer> path1 = new ArrayList<>(); 
	private List<Integer> path2 = new ArrayList<>(); 

	List findLowestCommonAncestors(int n1, int n2) { 
		path1.clear(); 
		path2.clear(); 
		return findLowestCommonAncestorsSub(root, n1, n2); 
	} 

	public List findLowestCommonAncestorsSub(Node root, int n1, int n2) { 
		System.out.println("findLowestCommonAncestorsSub");

		if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) { 
			System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing"); 
			System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing"); 
			return null; 
		} 

		
		 List<Integer> lca = new ArrayList<>(); 
		for (int i = 0; i < path1.size() && i < path2.size(); i++) { 
			
			if (!path1.get(i).equals(path2.get(i))) {
				break; 
		}else if(path1.get(i)!=n1 && path1.get(i)!=n2){
			lca.add(path1.get(i));
		}
		}

		return lca; 
	} 
	
	public boolean findPath(Node root, int n, List<Integer> path) 
	{ 
		if (root == null) { 
			return false; 
		} 
		
		path.add(root.data); 
		if (root.data == n) { 
			return true; 
		} 
		if (root.left != null && findPath(root.left, n, path)) { 
			return true; 
		} 
		if (root.right != null && findPath(root.right, n, path)) { 
			return true; 
		} 
		path.remove(path.size()-1); 
		return false; 
	} 

	public static void main(String[] args) 
	{ 
		BinaryTreeLCA tree = new BinaryTreeLCA(); 
		tree.root = new Node(2); 
		tree.root.left = new Node(1); 
		tree.root.right = new Node(3); 
		tree.root.right.left = new Node(4); 
		tree.root.right.right = new Node(5);
		tree.root.right.right.left = new Node(6);

		System.out.println("LCA(5, 6): " + tree.findLowestCommonAncestors(5,6)); 
		System.out.println("LCA(3, 6): " + tree.findLowestCommonAncestors(3,6)); 
		System.out.println("LCA(4, 6): " + tree.findLowestCommonAncestors(4,6)); 
	
	} 
} 

