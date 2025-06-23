public class Main
{
	static class Queue // Queue Implementation using Array
	{
	    static int arr[];       
	    static int len;
	    static int rear = -1;       // Rear = -1
	    Queue(int len)
	    {
	        arr = new int[len];     // Taking Length of array
	        this.len = len;
	    }
	    
	    static boolean isEmpty()
	    {
	        return rear == -1;
	    }
	    
	    //enqueue O(1)
	    static void add(int data)
	    {
	        if(rear == len - 1)             //  Rear should not exceed last Index of Array
	        {
	            System.out.println("Queue is Full.");
	            return;
	        }
	        rear++;                         //Incrementing Rear
	        arr[rear] = data;               // Adding data to the New rear
	    }
	    
	    //dequeue O(n)
	    static int remove()
	    {
	        if(isEmpty())
	        {
	            System.out.println("Queue is Empty");
	            return -1;
	        }
	        int front = arr[0];             // Front is First Element to be Removed FIFO
	        
	        for(int i=0; i<rear; i++)       // Pushing array back by -1 position
	        {
	            arr[i] = arr[i + 1];
	        }
	        arr[rear] = 0;                  // After pushing back updating rear as 0.
	        rear--;                         // New Rear Index after pushing back
	        return front;
	    }
	    // peek O(1)
	    static int peek()
	    {
	        if(isEmpty())
	        {
	            System.out.println("Queue is Empty");
	            return -1;
	        }
	        int front = arr[0];
	        return front;
	    }
	    
	}
	
	public static void main(String[] args) {
		Queue q = new Queue(10);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.remove();
		while(!q.isEmpty())
		{
		    System.out.println("|"+q.peek()+"|");
		    q.remove();
		}
		
	}
}
