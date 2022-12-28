import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.fillingBucket(N));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int fillingBucket(int N) {
        // code here
        int[] arr=new int[N+1];
        int mod=100000000;
        arr[0]=1;
        arr[1]=1;
        for(int i=2;i<=N;i++){
           arr[i]=(arr[i-1]%mod+arr[i-2])%mod;
        }
       return arr[N];
    }
}
