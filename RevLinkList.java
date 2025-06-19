import java.util.LinkedList;
public class LinkList
{
	Node head;                 // Head refers to First Element of List
	private int size;           // Variable to track Size of List
	
	LinkList()
	{
	    this.size = 0;          // Constructor of List this.size means size variable of this object.
	}
	
	class Node
	{
	    int data;           // Data part of a node.
	    Node next;          // Node type variable which store next Node.
	    Node(int data)
	    {
	        this.data = data;
	        this.next = null;   // It is important to point node next at null at time intializing
	        size++;             // Whenever New Node is created size increases
	    }
	}
	
	public void addFirst(int data)
	{
	    if(head == null)        // Case to be checked everytime
	    {
	       Node newNode = new Node(data);
	       head = newNode;                  // Creating Node if no node exists which is list head.
	       return;
	    }
	    Node newNode = new Node(data);
	    newNode.next = head;                // New Node next is refering to head (After it becomes 2nd Element)
	    head = newNode;                     // Now New Node is head
	}
	
	public void addLast(int data)
	{
	    if(head == null)
	    {
	       Node newNode = new Node(data);
	       head = newNode;
	       return;
	    }
	    Node currNode = head;       // Loop for traversing through List.
	    while(currNode.next != null)    // It not traverse through Last node.
	    {
	        currNode = currNode.next;       // currNode becomes the Last Node at the end.
	    }
	    Node newNode = new Node(data);
	    currNode.next = newNode;            // Added New Node at next of last node (Now last Node is Second Last)
	    
	}
	
	public void printList()
	{
	    if(head == null)
	    {
	        System.out.println("List is Empty.");
	        return;
	    }
	    
	    Node currNode = head;
	    while(currNode != null) // It traverse through whole list.
	    {
	        System.out.print( currNode.data +" --> ");
	        currNode = currNode.next;           // currNode becomes null at the end
	    }
	    System.out.print("NULL");
	}
	
	public void deleteFirst()
	{
	    if(head == null)        // No Elements Check
	    {
	        System.out.println("List is Empty.");
	    }
	    size--;                 // Decreasing Size
	    head = head.next;       // Simple Logic Head Becomes 2nd Node first gets Automatically Delocated Garbage Collector
	}
	
	public void deleteLast()
	{
	    if(head == null)
	    {
	        System.out.println("List is Empty.");
	    }
	    
	    size--;     // Decreasing Size if do it after corner case it will ignore that case.
	    
	    if(head.next == null) // Corner Case where List have only one Element.
	    {
	        head = null;
	    }
	    
	    
	    Node lastNode = head.next;      // Smartly using two variables . Last Node = 2nd Node
	    Node secondLastNode = head;     // secondLastNode = 1st Node
	    while(lastNode.next!= null)
	    {
	        lastNode = lastNode.next;       // At the end Last
	        secondLastNode = secondLastNode.next;   // At the end Second Last
	    }
	    secondLastNode.next = null;     // Simply Put next null of secondLastNode.
	}
	
	public void printSize()
	{
	   System.out.println("\n \nSize of list is "+ size); // Just print the Size.
	}
	
	public void revIterator()
	{
	    if(head == null || head.next == null)   // Empty or Only One Element Exists
	    {
	        return;
	    }
	    Node prevNode = head;           // First is Previous of Current
	    Node currNode = head.next;      // Current is 2nd Node.
	    while(currNode != null)
	    {
	        Node nextNode = currNode.next;      // Initially it is Third Node.
	        currNode.next = prevNode;           // Reverse Order: prevNode <-- currNode 
	        
	        prevNode = currNode;            // Updating Values, Moving +1 Node Step further
	        currNode = nextNode;            // Now Next is Current
	    }
	    head.next = null;       // IMP If we don't do it preserves the chain in normal order like 1 -> 2 and 2 <- both
	                            // are happening same time, We have to break this chain
	    head = prevNode;        // Our Element before null that is previous is now Our First Element in Reverse Order.
	}
	
	public Node revRecursive(Node head)
	{
	    if(head == null || head.next == null)   // Base Case to stop recursion.
	    return head;
	    
	    Node newHead = revRecursive(head.next);     //  At this Instance Head remains 4 but new head will be 5
	    head.next.next = head;  // 4->5->Null = 4->5->4
	    head.next = null;       // 5 -> 4 -> Null
	    return newHead;         // After Recursion Head 4-3-2-1 stops gets new head i.e 5
	}
	
	public static void main(String[] args) {
		System.out.println("Linked List Using Manual Code.");
		LinkList list = new LinkList();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		//list.revIterator();
		list.head = list.revRecursive(list.head);   // Taken Current head of the list as argument
		list.printList();
		System.out.println("\nUsing Linked List Collection Framework.");
		LinkedList<String> strList = new LinkedList<>(); // intializing
		strList.add("A");
		strList.add("B");
		strList.add("C");                   // By Default Append New Node at last. = = addLast
		strList.add("D");
		strList.add("E");
		strList.add("F");
		for(String x: strList)
		{
		    System.out.print(x + " --> ");
		}
		System.out.println("NULL\n");
		for(int i = strList.size() - 1; i >= 0; i--)
		{
		    strList.add(strList.get(i)); // taken elements starting from end and added that Element at last itself. 
		    strList.remove(i);          // Remove that Element which retrieved from its position.
		    for(String x: strList)
		{
		    System.out.print(x + " --> ");
		}
		System.out.println("NULL\n");
		}
	}
}
