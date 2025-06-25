import java.util.LinkedList;
import java.util.Queue;
class Node
{
	int data;
	Node left;
	Node right;
	Node(int data)              // Node Created
	{
		this.data = data;
		left = null;
		right = null;
	}
}
class binaryTree
{
	int idx = -1;                       // Empty Condition
	Node buildTree(int nodes[])         // Building in PreOrder Format
	{
		idx++;                          // Root Created
		if(nodes[idx] == -1)
		{
			return null;                // -1 data is equal to Null
		}
		Node newNode = new Node(nodes[idx]);        // First Root Created
		newNode.left = buildTree(nodes);            // Recursion 1  2  4
		newNode.right = buildTree(nodes);           // 4  -1 -1 -> 4  2 // 5 -1 -1 -> 4 2 5
		return newNode;
	}
	
	void preOrder(Node root)       // Root -> Left Sub-Tree -> Right Sub-Tree (DFS)
	{
	    if(root == null)
	    {
	        //System.out.print("Null__");
	        return;
	    }
	    System.out.print(root.data +"__");
	    preOrder(root.left);
	    preOrder(root.right);
	}
	
	void inOrder(Node root)     // Left Sub-Tree -> Root -> Right Sub-Tree (DFS)
	{
	    if(root == null)
	    {
	        //System.out.print("Null__");
	        return;
	    }
	    inOrder(root.left);
	    System.out.print(root.data + "__");
	    inOrder(root.right);
	}
	
	void postOrder(Node root)      // Left Sub-Tree -> Right Sub-Tree -> Root (DFS)
	{
	    if(root == null)
	    {
	        //System.out.print("Null__");
	        return;
	    }
	    postOrder(root.left);
	    postOrder(root.right);
	    System.out.print(root.data+"__");
	}
	
	void levelOrder(Node root)  // Lev 1-\n2-\n3-\n..n from Left to Right (BFS)
	{
	    if(root == null)
	    {
	        System.out.println("Tree is Empty.");
	        return;
	    }
	    Queue<Node> q = new LinkedList<>();     // Using FIFO Queue
	    q.add(root);
	    q.add(null);                            // Null for Line change
	    while(!q.isEmpty())
	    {
	        Node currentNode = q.remove();
	        if(currentNode == null)
	        {
	            System.out.println();
	            if(q.isEmpty())
	            {
	                break;
	            }
	            else
	            {
	                q.add(null);
	            }
	        }
	        else
	        {
	            System.out.print(currentNode.data+" ");
	            if(currentNode.left != null)
	            {
	                q.add(currentNode.left);
	            }
	            if(currentNode.right != null)
	            {
	                q.add(currentNode.right);
	            }
	        }
	    }
	}
	
	int countOfNodes(Node root)
	{
	    if(root == null)
	    {
	        return 0;
	    }
	    int leftNodeCount = countOfNodes(root.left); //First count of left Sub-Tree is calculated at each root node
	    int rightNodeCount = countOfNodes(root.right);//then count of right Sub-Tree is calculated at each root node
	    return leftNodeCount + rightNodeCount + 1; // At LAst left Count + Right Count + root Node self count
	}
	
	int sumOfNodes(Node root)
	{
	    if(root == null)
	    {
	        return 0;
	    }
	    int leftSum = sumOfNodes(root.left);    // Same as count but understand the recursion working seriously.
	    int rightSum = sumOfNodes(root.right);
	    return leftSum + rightSum + root.data;  // root.data is doing sum in return which is recursively passed to
	}                                           // left sum and right sum
	
	int calcHeight(Node root) // Height of Tree from Root to Leaf Node
	{
	    if(root == null)
	    {
	        return 0;
	    }
	    int leftHeight = calcHeight(root.left);
	    int rightHeight = calcHeight(root.right);
	    int height = Math.max(leftHeight, rightHeight) + 1; // +1 for Level of Root Node which is returning
	    return height;                                      // value in initial phase not leftHeight either rightHeight
	}
}
public class Main
{
	public static void main(String[] args)
	{
		int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}; // It is in form of PreOrder
		binaryTree tree = new binaryTree();
		Node root = tree.buildTree(nodes);
		tree.preOrder(root);
		System.out.println("\n");
		tree.inOrder(root);
		System.out.println("\n");
		tree.postOrder(root);
		System.out.println("\n");
		tree.levelOrder(root);
		System.out.println();
		System.out.println("Count of Nodes is "+tree.countOfNodes(root));
		System.out.println();
		System.out.println("Sum of Nodes is "+tree.sumOfNodes(root));
		System.out.println();
		System.out.println("Height of Tree is "+tree.calcHeight(root));
	}
}
