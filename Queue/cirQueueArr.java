class CircularQueue   // Using Array
{
    int arr[];
    int size;
    int rear = -1;
    int front = -1;             //front is also initialised as -1
    CircularQueue(int size)
    {
        arr = new int[size];    // Queue Created of given size
        this.size = size;
    }
    
    boolean isEmpty()           // if both rear and front together = -1 queue is Empty
    {
        return front == -1 && rear == -1;
    }
    
    boolean isFull()    // rear+1%size is used to reach starting
    {
        return front == (rear + 1)%size; // index again after array size crosses
    }                                       // front == rear + 1 is normal concept
    
    void add(int data)
    {
        if(isFull())
        {
            System.out.println("Queue is Full.");
            return;
        }
        if(front == -1) 
        {
            front = 0;  // initialised front for adding first element
        }
        rear = (rear+1) % size; // 2%5 = 2 but 6%5 = 1 , 5%5 = 0
        arr[rear] = data;
    }
    int remove()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty.");
            return -1;
        }
        int result = arr[front];    // Temp variable to send peek or front value which is removed
        if(front == rear)   // Base Case 0==0 when only one element exists 
        {
            arr[front] = 0; // Safety Precaution assigning 0 as Empty value.
            front = rear = -1;
        }
        else{
            arr[front] = 0;     // Safety Precaution assigning 0 as Empty value.
            front = (front+1) % size;   //Same concept for increasing front also.
        }
        return result;
    }
    int peek()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty.");
            return -1;
        }
        int result = arr[front];
        return result;
    }
    void printQueue()       // Print in Queue View.
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty.");
            return;
        }
        int current = front;        // Taken temp variable to don not tamper original front
        System.out.println("Circular Queue Print:");
        for(int i=0; i < size; i++)
        {
            //if(arr[i] == 0) continue;       // Skipping Empty Values Marked as 0
            System.out.print("|"+ arr[current]+"|");
            current = (current + 1) % size;
        }
        System.out.println("\n");
    }
    
    void printArray()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty.");
            return;
        }
        System.out.println("Array View Print:");
        for(int i=0; i < size; i++)
        {
            System.out.print("|"+ arr[i]+"|");
        }
        System.out.println("\n");
    }
}

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Note: 0 represents Empty value.\n");
		CircularQueue cq = new CircularQueue(5);
		cq.add(1);
		cq.add(2);
		cq.add(3);
		cq.add(4);
		cq.add(5);
		cq.printArray();
		cq.printQueue();
		cq.remove();
		cq.remove();
		cq.printArray();
		cq.printQueue();
		cq.add(6);
		cq.add(7);
		cq.printArray();
		cq.printQueue();
	}
}
