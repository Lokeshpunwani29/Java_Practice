public class StackLL        // Stack using Linked List O(1)
{
	static class Node
	{
	    int data;
	    Node next;
	    Node(int data)
	    {
	        this.data = data;
	        this.next = null;
	    }
	}
	static class Stack
	{
	    public static Node head;            // Created Static Only one head exists
	    
	    public static boolean isEmpty()
	    {
	        return head == null;            // Returns True if Head == Null
	    }
	    public static void push(int data)   // Append at last in general but in LinkedList
	    {                                   // Context pushing at head
	        Node newNode = new Node(data);  // New Node created with data
	        if(head == null)
	        {
	            head = newNode;
	            return;
	        }
	        newNode.next = head;
	        head = newNode;
	    }
	    
	    public static int pop()     // Removing from head in Array it is done on nth element
	    {
	        if(isEmpty())
	        {
	            return -1;      
	        }
	        int top = head.data;
	        head = head.next;       // Write it properly otherwise it can refer to itself in vice versa
	        return top;
	    }
	    public static int peek()
	    {
	        if(isEmpty()) return -1;
	        int top = head.data;
	        return head.data;
	    }
	    public static void printStack()
	    {
	        if(isEmpty()) System.out.println("Stack is Empty");
	        Node currNode = head;
	        while(currNode != null)
	        {
	            System.out.println("|"+currNode.data+"|");
	            currNode = currNode.next;
	        }
	        System.out.print("\n -------------------\n");
	    }
	}
	
	
	public static void main(String[] args) {
	    Stack s1 = new Stack();
	    s1.push(1);
	    s1.push(2);
	    s1.push(3);
	    s1.push(4);
	    s1.push(5);
		s1.printStack();
		s1.pop();
		s1.printStack();
		while(!s1.isEmpty())
		{
		    System.out.println(s1.peek());
		    s1.pop();
		}
		
	}
}
