import java.util.*;
import java.math.*;
public class LongestSubstring {
	
	static void LSS(String str)
	{
	    int start = 0, end = 0, maxlen = 0;
		String substr = "";
		HashSet<Character> set = new HashSet<>();
		
		while(end < str.length())
		{
		    if(!(set.contains(str.charAt(end))))
		    {
		        set.add(str.charAt(end));
		        if(maxlen < end - start + 1)
		        {
		            maxlen = end - start + 1;
		            substr = str.substring(start, end + 1);
		        }
		        end++;
		    }
		    else
		    {
		        set.remove(Character.valueOf(str.charAt(end)));
		        start++;
		    }
		}
		System.out.println("Longest Substring is: "+substr);
		System.out.println("Length is: "+maxlen);
	}
	
	public static void main(String[] args) {
		String str;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the String: ");
		str = s.nextLine();
		LSS(str);
	}
}
