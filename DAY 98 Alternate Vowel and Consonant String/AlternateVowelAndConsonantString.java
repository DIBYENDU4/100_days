import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.rearrange(S, N);
            
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Pair{
    int cnt;
    char ch;
    Pair(char ch,int cnt){
        this.ch = ch;
        this.cnt = cnt;
    }
}
class Solution{
    public String rearrange(String S, int N){
        int[] hmap = new int[26];
        Arrays.fill(hmap,0);
        int vowelCnt = 0, constCnt = 0;
        for(int i=0; i<N; ++i){
            char ch = S.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vowelCnt += 1;
            }
            else{
                constCnt += 1;
            }
            hmap[(int)(ch-'a')] += 1;
        }
        // System.out.println(vowelCnt+" "+constCnt);
        if(Math.abs(vowelCnt - constCnt) > 1){
            return "-1";
        }
        StringBuilder ans = new StringBuilder("");
        // char[] vowels = {'a','e','i','o','u'};
        ArrayList<Pair> vowels = new ArrayList<>();
        ArrayList<Pair> consonants = new ArrayList<>();
        for(int i=0; i<26; ++i){
            char ch = (char)(i+'a');
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                if(hmap[i] != 0)
                    vowels.add(new Pair(ch,hmap[i]));
            }
            else{
                if(hmap[i] != 0)
                    consonants.add(new Pair(ch,hmap[i]));
            }
        }
        int i = 0, j = 0;
        int n = vowels.size();
        int m = consonants.size();
        boolean flag = true;
        // System.out.println(n+" "+m);
        if(vowelCnt < constCnt){
            flag = false; // start with conosnant
        }
        while(i<n || j<m){
            if(flag){
                if(i<n){
                    ans.append(vowels.get(i).ch);
                    vowels.get(i).cnt -= 1;
                    if(vowels.get(i).cnt == 0){
                        i += 1;
                    }
                }
                flag = false;
            }
            else{
                if(j<m){
                    ans.append(consonants.get(j).ch);
                    consonants.get(j).cnt -= 1;
                    if(consonants.get(j).cnt == 0){
                        j += 1;
                    }
                }
                flag = true;
            }
        }
        return ans.toString();
    }
}
