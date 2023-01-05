import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            long ans = obj.NoOfChicks(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long NoOfChicks(int N)
    {
         long temp=1;
        long ans=1;
        long arr[]=new long[N];
        boolean flag=false;
        arr[0]=ans;
        int ind=0;
        for(int i=1;i<N;i++){
            temp++;
            if(temp%7==0 || flag){
                flag=true;
                ans-=arr[ind++];
            }
            long val=ans*2;
            arr[i]=val;
            ans+=val;
        }
        return ans;
    }
}
