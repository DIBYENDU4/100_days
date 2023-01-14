import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int tmp = sc.nextInt();
            int[][] flights = new int[tmp][3];
            for (int i = 0; i < tmp; i++) {

                int u1 = sc.nextInt();
                int v1 = sc.nextInt();
                int w1 = sc.nextInt();
                flights[i][0] = u1;
                flights[i][1] = v1;
                flights[i][2] = w1;
            }

            Solution ob = new Solution();
            int ans = ob.minimumCost(flights, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {

    int minimumCost(int[][] flights, int n, int k) {
        int adj[][]=new int[n+1][n+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                adj[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<flights.length;i++)
        {
            adj[flights[i][0]][flights[i][1]]=flights[i][2];
            
        }
        int dist[]=new int[n+1];
        int visited[]=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            visited[i]=0;
            dist[i]=adj[k][i];
        }
        dist[k]=0;
        visited[k]=1;
        for(int i=2;i<=n;i++)
        {
            int index=-1,min=Integer.MAX_VALUE;
            for(int j=1;j<=n;j++)
            {
                if(visited[j]==0&&min>dist[j])
                {
                    index=j;
                    min=dist[j];
                }
            }
            if(index!=-1)
            {
            visited[index]=1;
            
            int temp=Integer.MAX_VALUE;
            for(int r=1;r<=n;r++)
            {
                if(temp!=adj[index][r]&&visited[r]==0)
                {
                    if(dist[r]>dist[index]+adj[index][r])
                    {
                        dist[r]=adj[index][r]+dist[index];
                    }
                }
            }
            }
        }
          for(int i=1;i<=n;i++)
          {
              if(dist[i]==Integer.MAX_VALUE)
              {
                  return -1;
              }
          }
          int max=dist[1];
          for(int i=2;i<=n;i++)
          {
              if(dist[i]>max)
              {
                  max=dist[i];
              }
          }
            return max;
    }
}
