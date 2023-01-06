import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            int[] ptr = ob.satisfyEqn(A,N);
            
            System.out.println(ptr[0] + " " + ptr[1] + " " + ptr[2] + " " + ptr[3]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] satisfyEqn(int[] A, int N) {
        // code here
         int len = A.length;
        for (int i=0; i<len; i++) {
            for (int j=0; j<len; j++) {
                for (int k=0; k<len; k++) {
                    for (int l=0; l<len; l++) {
                        int sum1 = A[i]+A[j];
                        int sum2 = A[k]+A[l];
                        if (sum1 == sum2 && i != j && j != k && k != l && i 
                                            != k && i != l && j != l)
                            return new int[]{i, j, k, l};
                    } 
                }
            }
        }
        return new int[]{-1,-1,-1,-1};
    }
};
