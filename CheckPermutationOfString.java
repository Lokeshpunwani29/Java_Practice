import java.util.*;
public class Main
{
	static boolean isFreqSame(int[] freq, int[] windFreq)
	{
	    for(int i=0; i<26; i++)
	    {
	        if(freq[i] != windFreq[i]) return false;
	    }
	    return true;
	}
	
	static boolean checkInclusion(String s1, String s2)
	{
	    int[] freq = new int[26];   // Stores frequency of each lowercase char
	    for(int i=0; i<s1.length(); i++)
	    {
	        freq[s1.charAt(i) - 'a']++; // 'a' = 97 - 97 = 0 which is freq[0] of a itself 
	    }
	    int windSize = s1.length();
	    for(int i=0; i<s2.length(); i++)
	    {
	        int windCount = 0, windIdx = i; // windCount how much times loop will run
	        int[] windFreq = new int[26];
	        while( windCount < windSize && windIdx < s2.length() ) // windIdx iterates over char in a window size
	        {
	            windFreq[s2.charAt(windIdx) - 'a']++;
	            windCount++; windIdx++;
	        }
	        
	        if(isFreqSame(freq,windFreq)) return true;
	    }
	    return false;
	}
	
	public static void main(String[] args) {
		String str1, str2;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the String to be searched: ");
		str1 = s.nextLine();
		System.out.print("Enter the String in which searched: ");
		str2 = s.nextLine();
		boolean res = checkInclusion(str1, str2);
		if(res) System.out.println("Found Permutation :)");
		else System.out.println("Not found :(");
	}
}
