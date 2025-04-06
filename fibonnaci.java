import java.util.*;
public class fibonacci {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Number: ");
        int num = in.nextInt();
        int result = getFibonnaci(num);
        System.out.println(num+" Fibonnaci is: "+result);
    }
    public static int getFibonnaci(int num)
    {
        if(num==0) return 0;
        if(num==1) return 1;
        
        int [] F = new int[num+1];
        F[0] = 0;
        F[1] = 1;
        for(int i=2; i<=num; i++)
        {
            F[i] = F[i-1] + F[i-2];
        }
        return F[num];
    }
}
