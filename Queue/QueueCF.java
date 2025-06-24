import java.util.*;
public class Main
{
	public static void main(String[] args)
	{
		//Queue<Integer> q = new LinkedList<>(); // Queue is just an interface 
		Queue<Integer> q = new ArrayDeque<>();  // Object cannot be created of an Interface.
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
