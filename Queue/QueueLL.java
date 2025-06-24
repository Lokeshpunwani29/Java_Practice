class Node                  // Node Class
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}

class Queue   // Using Linked List
{
    Node head = null;
    Node tail = null;
    
    
    boolean isEmpty()
    {
        return head == null && tail == null;        // If both are null together then list is empty.
    }
    void add(int data)
    {
        Node newNode = new Node(data);
        if(isEmpty())                            //Case to add first Node
        {
            tail = head = newNode;
            return;
        }                               // When one node exists initially tail = First Node.next = New Node
        tail.next = newNode;            // Head remains at first Node while Tail change it's position
        tail = newNode;                 // Same like front and rear
    }                                   // Remember Head and Tails are just references like newNode in Java    
    int remove()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty.");
            return -1;
        }
        int front = head.data;          // Front Element
        if(head == tail)                // Case where only when one Element Exists only.
        {
            tail = null;                
        }
        head = head.next;           // head.next = null automatically head = null If only one element removed
        return front;
    }
    int peek()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty.");
            return -1;
        }
        int front = head.data;
        return front;
    }
}   

public class Main
{
	public static void main(String[] args)
	{
		Queue q = new Queue();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.remove();
		q.remove();
		q.add(6);
		q.add(7);
		while(!q.isEmpty())
		{
		    System.out.print("|"+q.peek()+"|");
		    q.remove();
		}
	}
}
