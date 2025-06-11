import java.util.*;
public class Main
{
	static String removeDuplicate(String s1){
	    if(s1==null || s1.isEmpty()) return "Error";
	    
	    char[] charArr = s1.toCharArray();
	    HashSet<Character> charSet = new HashSet<>();
	    StringBuilder res = new StringBuilder();
	    
	    for(char c:charArr)
	    {
	        if(charSet.add(c))
	        {
	            res.append(c);
	        }
	    }
	    return res.toString();
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String s1 = s.nextLine();
		System.out.println(removeDuplicate(s1));
	}
}
