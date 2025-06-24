import java.util.Stack;
public class Main
{
	public static void pushAtBottom(int data, Stack<Integer> s)
	{
	    if(s.isEmpty())
	    {
	        s.push(data);       // pushed 4 at bottom
	        return;
	    }
	    int top = s.pop();      // pop <- 3 - 2 - 1
	    pushAtBottom(data, s); // Run again and again Till base case not reached
	    s.push(top);           // push -> 1 - 2 - 3 
	    
	}
	
	public static void revStack(Stack<Integer> s)
	{
	    if(s.isEmpty())
	    {
	        return;
	    }
	    int top = s.pop();      //pop <- 3 - 2 - 1 - 4
	    revStack(s);        
	    pushAtBottom(top, s);    //push 4 | 4 1 |  4 1 2 | 4 1 2 3 | 4 is at peek now
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		
		pushAtBottom(4, s);
		
		while(!s.isEmpty())
		{
		    System.out.println("|"+ s.peek() +"|");
		    System.out.println("---");
		    s.pop();
		}
		
		System.out.println("Reversing Existing Stack.");
		
		s.push(4);
		s.push(1);
		s.push(2);
		s.push(3);
		
		revStack(s);
		while(!s.isEmpty())
		{
		    System.out.println("|"+ s.peek() +"|");
		    System.out.println("---");
		    s.pop();
		}
	}
}
