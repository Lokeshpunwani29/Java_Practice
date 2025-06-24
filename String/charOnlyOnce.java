import java.util.*;
public class Main
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();
        char[] arr = str.toCharArray();
        StringBuilder result = new StringBuilder();
        char temp;
        int count = 0;
        for(int i=0; i<arr.length; i++)
        {
            count = 0;
            temp = arr[i];
            for(int j=0; j<arr.length; j++)
            {
                if(temp == arr[j])
                {
                    if(count==0)
                    {
                        count++;
                        result.append(arr[j]);
                    }
                    else arr[j]='\0';
                }
            }
        }
        System.out.println(result);
    }
    
}

/* Optimised Way
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveAllDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine(); // Read full input line
        scanner.close();

        Set<Character> seen = new HashSet<>();      // To track characters already added
        StringBuilder result = new StringBuilder(); // Final string without duplicates

        for (char c : str.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);          // Mark character as seen
                result.append(c);     // Add it to result
            }
            // Else skip the character
        }

        System.out.println("Output: " + result.toString());
    }
}
*/
