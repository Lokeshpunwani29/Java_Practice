import java.util.*;
public class ArrayWithSpace
{
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String StringInput = input.nextLine();

		// if input is like {1,2,3,4,5,6,7,8,9,10}
		if(StringInput.startsWith("{") && StringInput.endsWith("}"))
		{
		   StringInput = StringInput.substring(1,StringInput.length()-1); 
		}
		
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
