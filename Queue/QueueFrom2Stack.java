import java.util.Stack;
class QueueFrom2Stack
{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    boolean isEmpty()
    {
        return s1.isEmpty();        // Only Stack 1 should be empty
    }
    
    void add(int data)
    {
        while(!s1.isEmpty())        // 1st Step push all elements of Stack 1 to Stack 2 
        {
            s2.push(s1.pop());      // by popping from Stack 1;
        }
        
        s1.push(data);              // 2nd Step Push the data to the Empty Stack s1
        
        while(!s2.isEmpty())
        {
            s1.push(s2.pop());      //3rd Step push all elements of Stack 2 to Stack 1 
        }                           // We get stack 1 in FIFO style format.
    }
    int remove()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty.");
            return -1;
        }
        return s1.pop();
    }
    int peek()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty.");
            return -1;
        }
        return s1.peek();
    }
}
public class Main
{
	public static void main(String[] args) {
		QueueFrom2Stack q = new QueueFrom2Stack();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.remove();
		q.remove();
		q.add(6);
		while(!q.isEmpty())
		{
		    System.out.print("|"+q.remove()+"|");
		}
	}
}
