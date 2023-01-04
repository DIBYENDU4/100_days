import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
        trie root=new trie();
        build(contact,root);
        ArrayList<ArrayList<String>> A=new ArrayList<>();
        for(int i=1;i<=s.length();i++){
            ArrayList<String> ar=new ArrayList<>();
            find(s.substring(0,i),root,ar,contact);
            Collections.sort(ar);
            A.add(ar);
        }
        return A;
    }
    public static void build(String a[], trie root){
        trie temp=null;
        for(int i = 0;i < a.length;i++){
            temp = root;
            for(int j = 0;j < a[i].length();j++){
                if(temp.ch[a[i].charAt(j)-'a'] == null)
                    temp.ch[a[i].charAt(j)-'a'] = new trie();
                temp = temp.ch[a[i].charAt(j)-'a'];
                temp.arr.add(a[i]);
            }
        }
    }
    public static void find(String s, trie root,ArrayList<String> ar,String contact[]){
        int q=0;
        for(int i = 0;i < s.length();i++){
            if(root.ch[s.charAt(i)-'a'] == null)
            {
                q=1;
                break;
            }
            root = root.ch[s.charAt(i)-'a'];
        }
        if(q==1){
            ar.add("0");
        }else
        for(String i:root.arr){
            ar.add(i);
        }
    }
    public static class trie
    {
        HashSet<String> arr;
        trie ch[];
        public trie()
        {
            arr=new HashSet<>();
            ch=new trie[26];
            for(int i=0;i<26;i++){
                ch[i]=null;
            }
        }
    }
}
