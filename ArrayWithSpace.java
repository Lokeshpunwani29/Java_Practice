import java.util.*;
public class ArrayWithSpace
{
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String StringInput = input.nextLine();
		
		String[] CharArray = StringInput.split(" "); // Split by anything like: "," "-"
		
		ArrayList<Integer> OutputArray = new ArrayList<>();
		
		for(String i: CharArray)
		{
		    int TempInt = Integer.parseInt(i);
		    OutputArray.add(TempInt);
		}
		for(int i: OutputArray)
		{
		    System.out.println(i);
		}
		input.close();
	}
}
