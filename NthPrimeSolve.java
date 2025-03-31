import java.util.*;
public class NthPrimeSolve{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int X = input.nextInt();
        int Y = input.nextInt();
        input.close();
        
        int A = getPrime(X);
        int B = getPrime(Y);
        
        int C = (A*B) - 1;
        
        System.out.println("C = AxB-1 = "+C+" = "+A+"x"+B+"- 1");
    }
    
    public static int getPrime(int n)
    {
        int count = 0, num = 1;
        while(count<n)
        {
            num++;
            if(checkPrime(num)) count++;
            
        }
        return num;
    }
    
    public static boolean checkPrime(int num)
    {
        if(num<2) return false;
        if(num==2) return true;
        if(num%2==0) return false;
        
        for(int i = 3; i*i<=num; i+=2)
        {
            if(num%i==0) return false;
        }
        return true;
    }
}
