import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            str = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            long ans = new Solution().countSubarray(arr, n, k);

            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java


class Solution {

    long getSubArrayCount(long n)
    {
        //long n = num;
        return n * (n + 1) / 2;
    }
    long countSubarray(int arr[], int n, int k) 
    {
        
        long total_subarray = getSubArrayCount(n);
        long rem_subarray=0;
        int curSub = 0;
        for(int i = 0;i < n;i++)
        {
            if(arr[i] <= k) curSub++;
            else
            {
                rem_subarray += getSubArrayCount(curSub);
                curSub = 0;
            }
        }
        rem_subarray += getSubArrayCount(curSub);
       // System.out.println(total_subarray +" -- " + rem_subarray);
        return total_subarray - rem_subarray;
    }
}
