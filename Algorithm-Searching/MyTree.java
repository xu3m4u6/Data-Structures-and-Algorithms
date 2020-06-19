import java.util.*;

public class MyTree {

	private static class Node {
		private int value;
		private Node left;
		private Node right;

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	Node root;

	public MyTree(){
		this.root = null;
	}

	public boolean insert(int value) {
		Node newNode = new Node(value);
		if( root == null){
			root = newNode;
			return true;
		}else{
			Node current = this.root;
			while(true) {
				// Left
				if(value < current.value) {
					if(current.left == null){
						current.left = newNode;
						return true;
					}
					current = current.left;

				}else if (value > current.value){
				// Right
					if(current.right == null){
						current.right = newNode;
						return true;
					}
					current = current.right;

				}else if(value == current.value){
					System.out.println("Duplicate value! Cannot insert " + value + " to the tree.");
					return false;
				}
			}
		}
	}

	public boolean lookup(int value) {
		if(root == null){
			return false;
		}
		Node current = root;
		while(current != null){
			if(value < current.value){
				current = current.left;
			} else if(value > current.value) {
				current = current.right;
			} else if(value == current.value) {
				return true;
			}
		}
		return false;
	}

	public boolean remove(int value) {

	    Node currentNode = this.root;
	    Node parentNode = null;

	    while(currentNode != null){
	    	if(value < currentNode.value){
	    		parentNode = currentNode;
	    		currentNode = currentNode.left;
	    	} else if(value > currentNode.value){
	    		parentNode = currentNode;
	    		currentNode = currentNode.right;
	    	} else if (currentNode.value == value) {
	    	//We have a match, get to work!
	        
	        //Option 1: No right child: 
	        	if (currentNode.right == null) {
	        		if (parentNode == null) {
		        		this.root = currentNode.left;
		        	} else {
		        	//if parent > current value, make current left child a child of parent
		        		if(currentNode.value < parentNode.value) {
		        			parentNode.left = currentNode.left;
		        	
		        	//if parent < current value, make left child a right child of parent
		        		} else if(currentNode.value > parentNode.value) {
		        			parentNode.right = currentNode.left;
		        		}
	        		}
	        
	        //Option 2: Right child which doesnt have a left child
	        	} else if (currentNode.right.left == null) {

		        	currentNode.right.left = currentNode.left;
		        	if(parentNode == null) {
		        		this.root = currentNode.right;
		        	} else {
		        	//if parent > current, make right child of the left the parent
		        		if(currentNode.value < parentNode.value) {
		        			parentNode.left = currentNode.right;
		        	
		        	//if parent < current, make right child a right child of the parent
		        		} else if (currentNode.value > parentNode.value) {
		        			parentNode.right = currentNode.right;
		        		}
		        	}
	        
	        //Option 3: Right child that has a left child
	        	} else {
	        		//find the Right child's left most child
	        		Node leftmost = currentNode.right.left;
	        		Node leftmostParent = currentNode.right;
		        	while(leftmost.left != null) {
		        		leftmostParent = leftmost;
		            	leftmost = leftmost.left;
		            }
	          
	        		//Parent's left subtree is now leftmost's right subtree
		            leftmostParent.left = leftmost.right;
		            leftmost.left = currentNode.left;
		            leftmost.right = currentNode.right;

		            if(parentNode == null) {
		            	this.root = leftmost;
		            } else {
		            	if(currentNode.value < parentNode.value) {
		            		parentNode.left = leftmost;
		            	} else if(currentNode.value > parentNode.value) {
		            		parentNode.right = leftmost;
		            	}
		            }
		        }
	        	return true;
	        }
	    }
	    return false;
	}

	// BFS
	public ArrayList breadthFirstSearch() {
		Node currentNode = this.root;
		ArrayList<Integer> result = new ArrayList<>();
		Queue<Node> memorize = new LinkedList<>();
		memorize.offer(currentNode);

	    while (!memorize.isEmpty()){
	    	currentNode = memorize.poll();
	    	result.add(currentNode.value);

	    	if(currentNode.left != null){
	    		memorize.offer(currentNode.left);
	    	}
	    	if(currentNode.right != null){
	    		memorize.offer(currentNode.right);
	    	}
	    }
	    return result;
	}

	// BFS recursive
	public ArrayList breadthFirstSearchRecursive(Queue<Node> memorize, ArrayList<Integer> result) {
		
		if(memorize.isEmpty())
			return result;

		Node currentNode = memorize.poll();
		result.add(currentNode.value);

    	if(currentNode.left != null){
    		memorize.offer(currentNode.left);
    	}
    	if(currentNode.right != null){
    		memorize.offer(currentNode.right);
    	}
	    
	    return this.breadthFirstSearchRecursive(memorize, result);
	}

	public ArrayList dfsInorder(){
		ArrayList<Integer> result = new ArrayList<>();
		return traverseInorder(this.root, result);
	}

	public ArrayList dfsPreorder(){
		ArrayList<Integer> result = new ArrayList<>();
		return traversePreorder(this.root, result);
	}

	public ArrayList dfsPostorder(){
		ArrayList<Integer> result = new ArrayList<>();
		return traversePostorder(this.root, result);
	}

	public ArrayList traverseInorder(Node node, ArrayList<Integer> result){
		if(node.left != null){
			traverseInorder(node.left, result);
		}
		result.add(node.value);
		if(node.right != null){
			traverseInorder(node.right, result);
		}
		return result;
	}

	public ArrayList traversePreorder(Node node, ArrayList<Integer> result){
		result.add(node.value);
		if(node.left != null){
			traversePreorder(node.left, result);
		}
		if(node.right != null){
			traversePreorder(node.right, result);
		}
		return result;
	}

	public ArrayList traversePostorder(Node node, ArrayList<Integer> result){
		if(node.left != null){
			traversePostorder(node.left, result);
		}
		if(node.right != null){
			traversePostorder(node.right, result);
		}
		result.add(node.value);
		return result;
	}


	public static void main(String[] args) {
		MyTree tree = new MyTree();
		tree.insert(9);
		tree.insert(4);
		tree.insert(6);
		tree.insert(20);
		tree.insert(170);
		tree.insert(15);
		tree.insert(1);

		// BFS iterative
		System.out.println("BFS iterative: " + tree.breadthFirstSearch());

		// BFS recursive
		ArrayList<Integer> result = new ArrayList<>();
		Queue<Node> memorize = new LinkedList<>();
		memorize.offer(tree.root);
		System.out.println("BFS recursive: " + tree.breadthFirstSearchRecursive(memorize, result));

		// DFS Inorder
		System.out.println("DFS Inorder: " + tree.dfsInorder());

		// DFS Preorder
		System.out.println("DFS Preorder: " + tree.dfsPreorder());

		// DFS Postorder
		System.out.println("DFS Postorder: " + tree.dfsPostorder());
	}
}


// Tree Structure
// //     9
// //  4     20
// //1  6  15  170

