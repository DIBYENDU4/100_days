import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.waysToBreakNumber(N));
        }
    }
}
// } Driver Code Ends



class Solution{
    int waysToBreakNumber(int N){
         long val = 0;
        
        if(N%2==0)
        {
            val = N+2;
            val = val/2;
            val = val*(N+1);
        }
        else
        {
            val = N+1;
            val = val/2;
            val = val*(N+2);
        }
        
        val = val%1000000007;
        return (int)val;
    }
}
