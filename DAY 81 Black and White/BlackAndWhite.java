
CodingNik91
/
100daysofcodingchallenge
Public
Code
Issues
Pull requests
Actions
Projects
Security
Insights
100daysofcodingchallenge/Day 73: Black and White
@CodingNik91
CodingNik91 Create Day 73: Black and White
 1 contributor
167 lines (99 sloc)  3.17 KB
/*
Black and White

Given the chessboard dimensions. Find out the number of ways we can place a black and a white Knight on this chessboard such that they cannot attack each other.

Note:
The knights have to be placed on different squares. A knight can move two squares horizontally and one square vertically (L shaped), or two squares vertically and one square horizontally (L shaped). The knights attack each other if one can reach the other in one move.

Example 1:

Input:
N = 2, M = 2
Output: 12 
Explanation: There are 12 ways we can place a black and a white Knight on this chessboard such that they cannot attack each other.

Example 2:

Input:
N = 2, M = 3
Output: 26
Explanation: There are 26 ways we can place a black and a white Knight on this chessboard such that they cannot attack each other.
Your Task:
Your task is to complete the function numOfWays() which takes the chessboard dimensions N and M as inputs and returns the number of ways we can place 2 Knights on this chessboard such that they cannot attack each other. Since this number can be very large, return it modulo 109+7.

Expected Time Complexity: O(N*M).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N * M <= 105
*/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Driverclass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(new BlackAndWhite().numOfWays(N, M));
        }
    }
}
// } Driver Code Ends


class BlackAndWhite
{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
     static boolean isValid(int i,int j,int m,int n)

    {

        if(i<0 || i>=m || j>=n || j<0)

        return false;

        return true;

    }

    static long numOfWays(int m, int n)

    {

        // add your code here

        long ans=0;

        int i=0,j=0;

        int count=1;

        int mod=1000_000_007;

        for(i=0;i<m;i++)

        {   

            for(j=0;j<n;j++)

            {

               if(isValid(i+2,j+1,m,n))

               {

                   count++;

               }

               if(isValid(i-2,j+1,m,n))

               {

                   count++;

               }

               if(isValid(i+2,j-1,m,n))

               {

                   count++;

               }

               if(isValid(i-2,j-1,m,n))

               {

                   count++;

               }

 

               if(isValid(i+1,j+2,m,n))

               {

                count++;

               }

               if(isValid(i-1,j+2,m,n))

               {

                count++;

               }

               if(isValid(i-1,j-2,m,n))

               {

                count++;

               }

               if(isValid(i+1,j-2,m,n))

               {

                count++;

               }

               ans=(ans%mod+(n*m)-(count))%mod;

               count=1;

            }

        }

        return ans%mod;

    }
}
